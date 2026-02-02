package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;

@Mod.EventBusSubscriber(modid = PulsarFlux.MOD_ID)
public class AugmentTickHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (player.level().isClientSide()) return;

        // 1️⃣ Offhand slot
        applyAugmentEffect(player, player.getOffhandItem(), "offhand");

        // 2️⃣ Belt slot via Curios (optional)
        if (isCuriosLoaded()) {
            for (ItemStack stack : getCuriosBelt(player)) {
                applyAugmentEffect(player, stack, "augment");
            }
        }
    }

    private static void applyAugmentEffect(Player player, ItemStack stack, String slot) {
        if (stack.getItem() instanceof AugmentHandler augment) {
            if (!augment.isSlotValid(slot)) return; // skip if not allowed in this slot

            MobEffectInstance effect = augment.getEffect();
            if (effect != null) {
                player.addEffect(new MobEffectInstance(
                        effect.getEffect(),
                        20, // refresh every tick
                        effect.getAmplifier(),
                        effect.isAmbient(),
                        augment.shouldShowParticles()
                ));
            }
        }
    }

    // Check if Curios is installed
    private static boolean isCuriosLoaded() {
        try {
            Class.forName("top.theillusivec4.curios.api.CuriosApi");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    // Get augment stacks via reflection
    @SuppressWarnings("unchecked")
    private static Iterable<ItemStack> getCuriosBelt(Player player) {
        try {
            Class<?> curiosApi = Class.forName("top.theillusivec4.curios.api.CuriosApi");
            Object handler = curiosApi.getMethod("getCuriosInventory", Player.class).invoke(null, player);
            if (handler == null) return Collections.emptyList();

            Object equipped = handler.getClass().getMethod("getEquippedCurios").invoke(handler);

            // get augment slot wrappers
            Object augmentWrappers = equipped.getClass().getMethod("getStacks", String.class).invoke(equipped, "augment");

            // unwrap each Curio stack to ItemStack
            java.util.List<ItemStack> result = new java.util.ArrayList<>();
            for (Object wrapper : (Iterable<?>) augmentWrappers) {
                ItemStack stack = (ItemStack) wrapper.getClass().getMethod("getStack").invoke(wrapper);
                result.add(stack);
            }
            return result;

        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
