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

public class LeadSwordItem extends EffectSwordItem {

    public LeadSwordItem() {
        super(SwordTier.LEAD, 6, -2.9f, new Properties());
    }

    @Override
    public void onHit(Player player, LivingEntity target) {
        applyEffect(target, new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false));
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {

        tooltip.add(Component.translatable("tooltip.pulsarflux.lead_sword")
                .withStyle(ChatFormatting.LIGHT_PURPLE));

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
