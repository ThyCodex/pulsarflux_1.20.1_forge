package net.codex.pulsarflux.flux.sword.sworditems;

import net.codex.pulsarflux.flux.sword.SwordTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class PlatinumSwordItem extends EffectSwordItem {

    public PlatinumSwordItem() {
        super(SwordTier.PLATINUM, 7, -2.4f, new Properties());
    }

    @Override
    public void onHit(Player player, LivingEntity target) {
        if (player.getRandom().nextFloat() < 0.15f) {
            applyEffect(player, new MobEffectInstance(MobEffects.REGENERATION, 60, 1, true, false));
        }
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {

        tooltip.add(Component.translatable("tooltip.pulsarflux.platinum_sword")
                .withStyle(ChatFormatting.LIGHT_PURPLE));

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
