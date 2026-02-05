package net.codex.pulsarflux.flux.sword;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class SwordToolTips extends SwordItem {

    public SwordToolTips(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        // ---- Standard Swords ----
        if (stack.getItem() == Sword.LEAD_SWORD.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.lead_sword")
                    .withStyle(ChatFormatting.WHITE));
        }
        if (stack.getItem() == Sword.SILVER_SWORD.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.silver_sword")
                    .withStyle(ChatFormatting.WHITE));
        }
        if (stack.getItem() == Sword.PLATINUM_SWORD.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.platinum_sword")
                    .withStyle(ChatFormatting.WHITE));
        }

        // ---- Phaseblades ----
        if (stack.getItem() == Sword.BLUE_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.blue_phaseblade")
                    .withStyle(ChatFormatting.AQUA));
        }
        if (stack.getItem() == Sword.GREEN_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.green_phaseblade")
                    .withStyle(ChatFormatting.GREEN));
        }
        if (stack.getItem() == Sword.RED_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.red_phaseblade")
                    .withStyle(ChatFormatting.RED));
        }
        if (stack.getItem() == Sword.PURPLE_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.purple_phaseblade")
                    .withStyle(ChatFormatting.DARK_PURPLE));
        }
        if (stack.getItem() == Sword.WHITE_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.white_phaseblade")
                    .withStyle(ChatFormatting.WHITE));
        }
        if (stack.getItem() == Sword.YELLOW_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.yellow_phaseblade")
                    .withStyle(ChatFormatting.YELLOW));
        }
    }
}

