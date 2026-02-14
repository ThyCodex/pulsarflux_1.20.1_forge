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

public class PurplePhasebladeItem extends EffectSwordItem {

    public PurplePhasebladeItem() {
        super(SwordTier.PHASEBLADE, 7, -2.4f, new Properties());
    }

    @Override
    public void onHit(Player player, LivingEntity target) {
        spawnParticles(target, ParticleTypes.PORTAL, 12, 0.3, 0.5, 0.3, 0.15);
        if (player.getRandom().nextFloat() < 0.15f) {
            applyEffect(target, new MobEffectInstance(MobEffects.CONFUSION, 60, 0, true, true));
        }
        if (player.getRandom().nextFloat() < 0.10f) {
            double newX = target.getX() + (player.getRandom().nextDouble() - 0.5) * 10;
            double newY = target.getY();
            double newZ = target.getZ() + (player.getRandom().nextDouble() - 0.5) * 10;
            target.teleportTo(newX, newY, newZ);
        }
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {

        tooltip.add(Component.translatable("tooltip.pulsarflux.purple_phaseblade")
                .withStyle(ChatFormatting.LIGHT_PURPLE));

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
