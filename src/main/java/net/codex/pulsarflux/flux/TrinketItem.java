package net.codex.pulsarflux.flux;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;

public abstract class TrinketItem extends Item implements ICurioItem {

    protected TrinketItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return slotContext.identifier().equals("charm");
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (!slotContext.entity().level().isClientSide()) {
            applyEffect(slotContext.entity(), stack);
        }
    }

    protected abstract void applyEffect(LivingEntity entity, ItemStack stack);

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        TrinketToolTips.append(stack, level, tooltip, flag);
    }
}
