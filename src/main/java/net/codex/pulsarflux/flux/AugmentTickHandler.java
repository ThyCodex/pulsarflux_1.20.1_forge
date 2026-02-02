package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PulsarFlux.MOD_ID)
public class AugmentTickHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (player.level().isClientSide()) return;

        //applyAugmentEffect(player, player.getMainHandItem());
        applyAugmentEffect(player, player.getOffhandItem());
    }

    private static void applyAugmentEffect(Player player, ItemStack stack) {
        if (stack.getItem() instanceof AugmentHandler augment) {
            MobEffectInstance effect = augment.getEffect();
            if (effect != null) {
                // Apply effect, always refresh duration
                player.addEffect(new MobEffectInstance(
                        effect.getEffect(),
                        20, // 1 second
                        effect.getAmplifier(),
                        effect.isAmbient(),
                        augment.shouldShowParticles() // particle visibility
                ));
            }
        }
    }
}
