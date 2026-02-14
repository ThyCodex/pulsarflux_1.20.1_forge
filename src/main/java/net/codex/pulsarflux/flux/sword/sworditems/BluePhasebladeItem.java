package net.codex.pulsarflux.flux.sword.sworditems;

import net.codex.pulsarflux.flux.sword.SwordTier;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;
import java.util.List;

public class BluePhasebladeItem extends EffectSwordItem {

    public BluePhasebladeItem() {
        super(SwordTier.PHASEBLADE, 7, -2.4f, new Properties());
    }

    @Override
    public void onHit(Player player, LivingEntity target) {
        Level world = target.level();

        // --- Always spawn snow particles ---
        spawnParticles(target, ParticleTypes.ITEM_SNOWBALL, 20, 0.2, 0.5, 0.2, 0.1);

        // --- 15% chance to freeze ---
        if (player.getRandom().nextFloat() < 0.15f) {
            // Cancel horizontal knockback
            target.setDeltaMovement(0, target.getDeltaMovement().y, 0);

            // --- Apply extreme slowness for 3 seconds ---
            applyEffect(target, new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 255, false, false));

            // --- Force the shivering/freeze animation ---
            target.setTicksFrozen(60); // 60 ticks = 3 seconds

            // --- Place powdered snow at feet ---
            BlockPos feetPos = target.blockPosition();
            if (world.getBlockState(feetPos).isAir()) {
                world.setBlock(feetPos, Blocks.POWDER_SNOW.defaultBlockState(), 3);
            }

            // --- Place powdered snow at head ---
            BlockPos headPos = feetPos.above((int) Math.floor(target.getBbHeight()));
            if (world.getBlockState(headPos).isAir()) {
                world.setBlock(headPos, Blocks.POWDER_SNOW.defaultBlockState(), 3);
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {

        tooltip.add(Component.translatable("tooltip.pulsarflux.blue_phaseblade")
                .withStyle(ChatFormatting.LIGHT_PURPLE));

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
