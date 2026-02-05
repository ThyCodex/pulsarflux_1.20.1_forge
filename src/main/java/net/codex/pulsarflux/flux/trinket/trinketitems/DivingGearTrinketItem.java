package net.codex.pulsarflux.flux.trinket.trinketitems;

import net.codex.pulsarflux.flux.trinket.TrinketItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class DivingGearTrinketItem extends TrinketItem {

    public DivingGearTrinketItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(LivingEntity entity, ItemStack stack) {
        // Only apply to players
        if (entity instanceof Player player) {
            // Keep air supply full for infinite underwater breathing
            player.setAirSupply(player.getMaxAirSupply());
        }
    }
}
