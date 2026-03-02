package net.codex.pulsarflux.flux.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class HomeStoneItem extends Item {

    private static final int TELEPORT_TICKS = 60; // 3 seconds

    public HomeStoneItem(Properties properties) {
        super(properties.durability(3));
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public boolean isBookEnchantable(@NotNull ItemStack stack, @NotNull ItemStack book) {
        return false;
    }

    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity entity, @NotNull ItemStack stack, int count) {
        int ticksHeld = getUseDuration(stack) - count;

        // Client-side visual effects
        if (level.isClientSide()) {
            double progress = Math.min(1.0, (double) ticksHeld / TELEPORT_TICKS);

            int particleCount = (int) (15 + 25 * progress);
            for (int i = 0; i < particleCount; i++) {
                double angle = 2 * Math.PI * i / particleCount + entity.tickCount * 0.1;
                double radius = 1.0 + 0.5 * progress;
                double x = entity.getX() + Math.cos(angle) * radius;
                double y = entity.getY() + 0.5 + progress;
                double z = entity.getZ() + Math.sin(angle) * radius;

                level.addParticle(ParticleTypes.END_ROD, x, y, z, 0, 0.02 + 0.05 * progress, 0);

                if (entity.getRandom().nextFloat() < 0.15 * progress) {
                    level.addParticle(
                            ParticleTypes.PORTAL,
                            entity.getX() + (entity.getRandom().nextDouble() - 0.5),
                            entity.getY() + 1.0 + entity.getRandom().nextDouble(),
                            entity.getZ() + (entity.getRandom().nextDouble() - 0.5),
                            0, 0.05 * progress, 0
                    );
                }
            }
        }

        // Server-side channeling sound
        if (!level.isClientSide() && entity instanceof ServerPlayer player) {
            if (ticksHeld % 10 == 0) {
                level.playSound(null, player.blockPosition(), SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, 0.5f, 1f);
            }
        }

        // Server-side teleport logic
        if (entity instanceof ServerPlayer player && ticksHeld >= TELEPORT_TICKS) {
            teleportPlayer(player, level);
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));
            player.stopUsingItem();
        }
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
        return 72000;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    private void teleportPlayer(ServerPlayer player, Level level) {

        ServerLevel targetLevel;
        double targetX, targetY, targetZ;

        BlockPos respawnPos = player.getRespawnPosition();
        Optional<Vec3> respawnVec = Optional.empty();

        if (respawnPos != null) {

            // ✅ Get correct dimension of the bed
            ServerLevel respawnLevel = player.server.getLevel(player.getRespawnDimension());

            if (respawnLevel != null) {
                respawnVec = Player.findRespawnPositionAndUseSpawnBlock(
                        respawnLevel,
                        respawnPos,
                        0f,
                        false,
                        true
                );

                if (respawnVec.isPresent()) {
                    targetLevel = respawnLevel;
                    targetX = respawnVec.get().x;
                    targetY = respawnVec.get().y;
                    targetZ = respawnVec.get().z;

                    player.teleportTo(targetLevel, targetX, targetY, targetZ,
                            player.getYRot(), player.getXRot());

                    targetLevel.playSound(null, targetX, targetY, targetZ,
                            SoundEvents.ENDERMAN_TELEPORT,
                            SoundSource.PLAYERS, 1f, 1f);

                    return; // stop here
                }
            }
        }

        // 🔁 Fallback to Overworld spawn
        targetLevel = player.server.getLevel(Level.OVERWORLD);
        assert targetLevel != null;

        BlockPos spawn = targetLevel.getSharedSpawnPos();
        targetX = spawn.getX() + 0.5;
        targetY = spawn.getY() + 1;
        targetZ = spawn.getZ() + 0.5;

        player.teleportTo(targetLevel, targetX, targetY, targetZ,
                player.getYRot(), player.getXRot());

        targetLevel.playSound(null, targetX, targetY, targetZ,
                SoundEvents.ENDERMAN_TELEPORT,
                SoundSource.PLAYERS, 1f, 1f);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, @NotNull TooltipFlag flag) {

        tooltip.add(Component.translatable("tooltip.pulsarflux.home_stone")
                .withStyle(ChatFormatting.LIGHT_PURPLE));

        super.appendHoverText(stack, level, tooltip, flag);
    }
}