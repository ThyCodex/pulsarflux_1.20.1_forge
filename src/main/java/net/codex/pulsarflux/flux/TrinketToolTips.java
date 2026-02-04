package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.flux.items.*;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class TrinketToolTips {

    public static void append(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("When worn as charm:"));

        if (stack.getItem() instanceof AgletTrinketItem) {
            tooltip.add(Component.literal("+5% Speed").withStyle(ChatFormatting.GREEN));
        } else if (stack.getItem() instanceof DivingGearTrinketItem) {
            tooltip.add(Component.literal("Breathe underwater").withStyle(ChatFormatting.AQUA));
        } else if (stack.getItem() instanceof LuckyHorseshoeTrinketItem) {
            tooltip.add(Component.literal("No fall damage").withStyle(ChatFormatting.YELLOW));
        } else if (stack.getItem() instanceof TreasureMagnetTrinketItem) {
            tooltip.add(Component.literal("Attracts nearby items").withStyle(ChatFormatting.GOLD));
        }
    }
}
