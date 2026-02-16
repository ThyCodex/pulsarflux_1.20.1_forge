package net.codex.pulsarflux.flux.trinket;

import net.codex.pulsarflux.flux.trinket.trinketitems.*;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class TrinketToolTip {

    public static void append(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("When worn as charm:"));

        if (stack.getItem() instanceof AgletTrinketItem) {
            tooltip.add(Component.literal("Terraria:Speed Boost").withStyle(ChatFormatting.GREEN));
        } else if (stack.getItem() instanceof DivingGearTrinketItem) {
            tooltip.add(Component.literal("Terraria:Breathe underwater").withStyle(ChatFormatting.GREEN));
        } else if (stack.getItem() instanceof LuckyHorseshoeTrinketItem) {
            tooltip.add(Component.literal("Terraria:No fall damage").withStyle(ChatFormatting.GREEN));
        } else if (stack.getItem() instanceof TreasureMagnetTrinketItem) {
            tooltip.add(Component.literal("Terraria:Attracts nearby items").withStyle(ChatFormatting.GREEN));
        }
    }
}
