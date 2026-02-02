package net.codex.pulsarflux.flux;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class FluxToolTips extends SwordItem {

    public FluxToolTips(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        // ---- Standard Swords ----
        if (stack.getItem() == SwordFlux.LEAD_SWORD.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.lead_sword")
                    .withStyle(ChatFormatting.WHITE));
        }
        if (stack.getItem() == SwordFlux.SILVER_SWORD.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.silver_sword")
                    .withStyle(ChatFormatting.WHITE));
        }
        if (stack.getItem() == SwordFlux.PLATINUM_SWORD.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.platinum_sword")
                    .withStyle(ChatFormatting.WHITE));
        }

        // ---- Phaseblades ----
        if (stack.getItem() == SwordFlux.BLUE_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.blue_phaseblade")
                    .withStyle(ChatFormatting.AQUA));
        }
        if (stack.getItem() == SwordFlux.GREEN_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.green_phaseblade")
                    .withStyle(ChatFormatting.GREEN));
        }
        if (stack.getItem() == SwordFlux.RED_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.red_phaseblade")
                    .withStyle(ChatFormatting.RED));
        }
        if (stack.getItem() == SwordFlux.PURPLE_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.purple_phaseblade")
                    .withStyle(ChatFormatting.DARK_PURPLE));
        }
        if (stack.getItem() == SwordFlux.WHITE_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.white_phaseblade")
                    .withStyle(ChatFormatting.WHITE));
        }
        if (stack.getItem() == SwordFlux.YELLOW_PHASEBLADE.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.yellow_phaseblade")
                    .withStyle(ChatFormatting.YELLOW));
        }
        // ---- Augments ----
        if (stack.getItem() == Augment.AGLET_AUGMENT.get()) {
            tooltip.add(Component.translatable("tooltip.pulsarflux.yellow_phaseblade")
                    .withStyle(ChatFormatting.WHITE));

            super.appendHoverText(stack, level, tooltip, flag);
        }
    }
}
