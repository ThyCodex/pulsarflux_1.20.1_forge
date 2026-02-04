package net.codex.pulsarflux.flux.items;

import net.codex.pulsarflux.flux.TrinketItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class LuckyHorseshoeTrinketItem extends TrinketItem {

    public LuckyHorseshoeTrinketItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(LivingEntity entity, ItemStack stack) {
        // Reset fall distance so entity takes no fall damage
        entity.fallDistance = 0;
    }
}