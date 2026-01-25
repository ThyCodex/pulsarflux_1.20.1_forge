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

public class FluxSwordItem extends SwordItem {

    public FluxSwordItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void appendHoverText(
            ItemStack stack,
            @Nullable Level level,
            List<Component> tooltip,
            TooltipFlag flag
    ) {

        if (stack.is(ToolTags.LEAD_TOOLS)) {
            tooltip.add(
                    Component.literal("Slows you while held")
                            .withStyle(ChatFormatting.LIGHT_PURPLE)
            );
        }

        if (stack.is(ToolTags.SILVER_TOOLS)) {
            tooltip.add(
                    Component.literal("Applies Weakness on hit")
                            .withStyle(ChatFormatting.LIGHT_PURPLE)
            );
        }

        if (stack.is(ToolTags.PLATINUM_TOOLS)) {
            tooltip.add(
                    Component.literal("15% Chance to Leech Life")
                            .withStyle(ChatFormatting.LIGHT_PURPLE)
            );
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
