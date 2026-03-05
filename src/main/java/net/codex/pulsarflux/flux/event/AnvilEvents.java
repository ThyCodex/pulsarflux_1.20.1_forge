package net.codex.pulsarflux.flux.event;

import net.codex.pulsarflux.flux.MaterialItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "pulsarflux")
public class AnvilEvents {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {

        ItemStack left = event.getLeft();   // Item being repaired
        ItemStack right = event.getRight(); // Repair material

        if ((left.is(MaterialItems.RETURN_STONE.get())
                || left.is(MaterialItems.HOME_STONE.get())
        )
                && right.is(Items.EMERALD)) {

            if (left.getDamageValue() > 0) {

                ItemStack output = left.copy();
                output.setDamageValue(Math.max(0,
                        left.getDamageValue() - 1)); // 1 use per emerald

                event.setOutput(output);
                event.setCost(1); // XP cost
                event.setMaterialCost(1); // Emerald cost
            }
        }
    }
}