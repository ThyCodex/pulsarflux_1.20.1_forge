package net.codex.pulsarflux.flux.sword.sworditems;

import net.codex.pulsarflux.flux.sword.SwordTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class RedPhasebladeItem extends EffectSwordItem {

    public RedPhasebladeItem() {
        super(SwordTier.PHASEBLADE, 7, -2.4f, new Properties());
    }

    @Override
    public void onHit(Player player, LivingEntity target) {
        spawnParticles(target, ParticleTypes.FLAME, 12, 0.2, 0.4, 0.2, 0.1);
        if (player.getRandom().nextFloat() < 0.2f) target.setSecondsOnFire(3);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {

        tooltip.add(Component.translatable("tooltip.pulsarflux.red_phaseblade")
                .withStyle(ChatFormatting.LIGHT_PURPLE));

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
