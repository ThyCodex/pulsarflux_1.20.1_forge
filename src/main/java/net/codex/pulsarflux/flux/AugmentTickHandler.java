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

        // Always allow offhand usage
        applyAugmentEffect(player, player.getOffhandItem());

        // Optional Curios support
        if (isCuriosLoaded()) {
            for (ItemStack stack : getCurios(player)) {
                applyAugmentEffect(player, stack);
            }
        }
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
    private static boolean isCuriosLoaded() {
        try {
            Class.forName("top.theillusivec4.curios.api.CuriosApi");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
    @SuppressWarnings("unchecked")
    private static Iterable<ItemStack> getCurios(Player player) {
        try {
            Class<?> curiosApi = Class.forName("top.theillusivec4.curios.api.CuriosApi");
            Object handler = curiosApi
                    .getMethod("getCuriosInventory", Player.class)
                    .invoke(null, player);

            if (handler == null) return java.util.Collections.emptyList();

            Object curios = handler.getClass()
                    .getMethod("getEquippedCurios")
                    .invoke(handler);

            return (Iterable<ItemStack>) curios.getClass()
                    .getMethod("getStacks")
                    .invoke(curios);

        } catch (Exception e) {
            return java.util.Collections.emptyList();
        }
    }
}
