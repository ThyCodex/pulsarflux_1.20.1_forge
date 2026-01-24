package net.codex.pulsarflux.flux;

import net.minecraft.world.entity.Mob;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.codex.pulsarflux.config.PulsarFluxConfig;

public class MobTierEvents {

    // Register this class to listen to Forge events
    public static void register() {
        MinecraftForge.EVENT_BUS.register(new MobTierEvents());
    }

    // ---- 1: When a mob spawns ----
    @SubscribeEvent
    public void onMobSpawn(EntityJoinLevelEvent event) {
        if (!PulsarFluxConfig.COMMON.enableMobTiers.get()) return; // <-- CHECK CONFIG
        if (event.getEntity() instanceof Mob mob) {
            MobTierManager.assignStarTier(mob);
        }
    }

    // ---- 2: Each server tick, apply tier stats ----
    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (!PulsarFluxConfig.COMMON.enableMobTiers.get()) return; // <-- CHECK CONFIG
        if (event.phase != TickEvent.Phase.END) return; // only run once per tick

        // Get the overworld safely
        var overworld = event.getServer().getLevel(net.minecraft.world.level.Level.OVERWORLD);
        if (overworld == null) return;

        // Loop through entities safely
        for (var entity : overworld.getEntities().getAll()) {
            if (entity instanceof Mob mob) {
                MobTierManager.applyTierStats(mob);
            }
        }
    }
}
