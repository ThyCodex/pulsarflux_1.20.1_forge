package net.codex.pulsarflux.flux;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.network.chat.Component;
import net.minecraftforge.registries.ForgeRegistries;

public class MobTierManager {

    // Star colors for each tier
    private static final String STAR_COLOR_1 = "§e"; // Yellow
    private static final String STAR_COLOR_2 = "§6"; // Orange
    private static final String STAR_COLOR_3 = "§c"; // Red

    private static String getStarColor(int tier) {
        return switch (tier) {
            case 2 -> STAR_COLOR_2;
            case 3 -> STAR_COLOR_3;
            default -> STAR_COLOR_1; // 1-star default
        };
    }

    // Assign star tier to a mob
    public static void assignStarTier(Mob mob) {
        // Only assign to monsters (hostile mobs)
        if (!(mob instanceof Monster)) return;

        // Check if mob already has a tier
        if (mob.getPersistentData().contains("starTier")) return;

        // ---- Determine tier ----
        int tier = 1; // default 1-star
        double roll = Math.random(); // random number between 0.0 and 1.0
        if (roll < 0.20) tier = 3;      // 20% chance for 3-star
        else if (roll < 0.50) tier = 2; // 30% chance for 2-star
        // rest remain 1-star

        mob.getPersistentData().putInt("starTier", tier);
        mob.getPersistentData().putBoolean("applyStatsNextTick", true);

        // ---- Get mob name safely ----
        String mobName = mob.getDisplayName().getString(); // never null
        if (mobName.isEmpty()) {
            var typeKey = ForgeRegistries.ENTITY_TYPES.getKey(mob.getType());
            mobName = typeKey != null ? typeKey.getPath().replace("_", " ") : "Unknown";
        }

        // ---- Set custom name with stars ----
        String color = getStarColor(tier);
        String stars = "★".repeat(tier);
        mob.setCustomName(Component.literal(color + stars + " " + mobName));
        mob.setCustomNameVisible(false);

    }

    // Apply enhanced stats based on star tier
    public static void applyTierStats(Mob mob) {
        // Only apply if flagged
        if (!mob.getPersistentData().getBoolean("applyStatsNextTick")) return;

        int tier = mob.getPersistentData().getInt("starTier");
        mob.getPersistentData().remove("applyStatsNextTick");

        // ---- Health ----
        var healthAttr = mob.getAttribute(Attributes.MAX_HEALTH);
        if (healthAttr != null) {
            double base = healthAttr.getBaseValue();
            switch (tier) {
                case 2 -> healthAttr.setBaseValue(base * 1.4);
                case 3 -> healthAttr.setBaseValue(base * 2.0);
            }
            mob.setHealth((float) healthAttr.getBaseValue());
        }

        // ---- Damage ----
        var dmgAttr = mob.getAttribute(Attributes.ATTACK_DAMAGE);
        if (dmgAttr != null) {
            double base = dmgAttr.getBaseValue();
            switch (tier) {
                case 2 -> dmgAttr.setBaseValue(base * 1.5);
                case 3 -> dmgAttr.setBaseValue(base * 2.2);
            }
        }

        // ---- Speed ----
        var speedAttr = mob.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speedAttr != null) {
            double base = speedAttr.getBaseValue();
            switch (tier) {
                case 2 -> speedAttr.setBaseValue(base * 1.15);
                case 3 -> speedAttr.setBaseValue(base * 1.35);
            }
        }
    }
}
