package net.codex.pulsarflux.flux.sword;

import net.codex.pulsarflux.PulsarFlux;
import net.codex.pulsarflux.flux.ToolTags;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;



@Mod.EventBusSubscriber(modid = PulsarFlux.MOD_ID)
public class SwordEffects {

    // ----- PLAYER HOLDING -----
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (player.level().isClientSide()) return;

        ItemStack held = player.getMainHandItem();

        if (held.is(ToolTags.LEAD_TOOLS)) {
            player.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SLOWDOWN,
                    20,
                    0,
                    true,
                    false
            ));
        }

        // add more effects here
    }

    // ----- ON-HIT MOB  -----
    @SubscribeEvent
    public static void onEntityHit(LivingHurtEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;

        ItemStack held = player.getMainHandItem();
        LivingEntity target = event.getEntity();

        // ----- TOOL EFFECTS -----
        if (held.is(ToolTags.SILVER_TOOLS)) {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 0, true, false));
        }

        if (held.is(ToolTags.PLATINUM_TOOLS)) {
            if (player.getRandom().nextFloat() < 0.15f) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, true, false));
            }
        }

        // ----- PHASEBLADE EFFECTS -----
        if (held.is(ToolTags.PHASEBLADE)) {
            ResourceLocation id = ForgeRegistries.ITEMS.getKey(held.getItem());
            if (id == null) return;
            String path = id.getPath();
            ServerLevel serverLevel = null;
            if (target.level() instanceof ServerLevel sLevel) {
                serverLevel = sLevel;
            }

            switch (path) {
                case "blue_phaseblade" -> {
                    if (serverLevel != null) {
                        serverLevel.sendParticles(
                                ParticleTypes.CLOUD,
                                target.getX(), target.getY() + 1.0, target.getZ(),
                                15, 0.4, 0.8, 0.4, 0.15
                        );
                    }
                    if (player.getRandom().nextFloat() < 0.3f) {
                        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 3, true, true));
                        target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 1, true, true));
                    }
                }
                case "green_phaseblade" -> {
                    if (serverLevel != null) {
                        serverLevel.sendParticles(
                                ParticleTypes.HAPPY_VILLAGER,
                                target.getX(), target.getY() + 1.0, target.getZ(),
                                10, 0.1, 0.2, 0.1, 0.05
                        );
                    }
                    if (player.getRandom().nextFloat() < 0.15f) target.spawnAtLocation(Items.EMERALD, 1);
                    if (player.getRandom().nextFloat() < 0.15f)
                        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 0, true, true));
                }
                case "red_phaseblade" -> {
                    if (serverLevel != null) {
                        serverLevel.sendParticles(
                                ParticleTypes.FLAME,
                                target.getX(), target.getY() + 1.0, target.getZ(),
                                12, 0.2, 0.4, 0.2, 0.1
                        );
                    }
                    if (player.getRandom().nextFloat() < 0.2f) target.setSecondsOnFire(3);
                }
                case "purple_phaseblade" -> {
                    if (serverLevel != null) {
                        serverLevel.sendParticles(
                                ParticleTypes.PORTAL,
                                target.getX(), target.getY() + 1.0, target.getZ(),
                                12, 0.3, 0.5, 0.3, 0.15
                        );
                    }
                    if (player.getRandom().nextFloat() < 0.15f) {
                        target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 0, true, true));
                    }
                    if (player.getRandom().nextFloat() < 0.10f) {
                        double newX = target.getX() + (player.getRandom().nextDouble() - 0.5) * 10; // ±5 blocks
                        double newY = target.getY();
                        double newZ = target.getZ() + (player.getRandom().nextDouble() - 0.5) * 10;
                        target.teleportTo(newX, newY, newZ);
                    }
                }
                case "white_phaseblade" -> {
                    if (serverLevel != null) {
                        serverLevel.sendParticles(
                                ParticleTypes.END_ROD,
                                target.getX(), target.getY() + 1.0, target.getZ(),
                                12, 0.2, 0.3, 0.2, 0.1
                        );
                    }
                    if (player.getRandom().nextFloat() < 0.2f) {
                        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 5, true, true));
                    }
                }
                case "yellow_phaseblade" -> {
                    if (serverLevel != null) {
                        serverLevel.sendParticles(
                                ParticleTypes.ELECTRIC_SPARK,
                                target.getX(), target.getY() + 1.0, target.getZ(),
                                10, 0.2, 0.3, 0.2, 0.1
                        );
                    }
                    if (player.getRandom().nextFloat() < 0.25f)
                        target.hurt(player.damageSources().lightningBolt(), 2.0F);
                }
            }
        }
    }
}

