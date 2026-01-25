package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PulsarFlux.MOD_ID)
public class SwordEffects {

    // ----- PLAYER HOLDING -----
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (player.level().isClientSide()) return;

        ItemStack held = player.getMainHandItem();

        if (held.is(ToolTags.LEAD_TOOLS)){player.addEffect(new MobEffectInstance(
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

        if (held.is(ToolTags.SILVER_TOOLS)) {
            target.addEffect(new MobEffectInstance(
                    MobEffects.WEAKNESS,
                    60,
                    0,
                    true,
                    false
            ));
        }
        if (held.is(ToolTags.PLATINUM_TOOLS)) {
            if (player.getRandom().nextFloat() < 0.15f) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.REGENERATION,
                        60,
                        1,
                        true,
                        false
                ));
            }
        }
    }
}
