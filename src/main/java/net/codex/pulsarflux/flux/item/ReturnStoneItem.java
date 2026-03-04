package net.codex.pulsarflux.flux.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class ReturnStoneItem extends Item {

    private static final int TELEPORT_TICKS = 60; // 3 seconds

    public ReturnStoneItem(Properties properties) {
        super(properties);
    }

    /* ==========================
       BIND LOCATION
     ========================== */

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        BlockPos pos = context.getClickedPos();

        if (player == null || level.isClientSide())
            return InteractionResult.SUCCESS;

        CompoundTag tag = stack.getOrCreateTag();

        // 🔒 Already bound → block rebinding
        if (tag.contains("posX")) {
            player.displayClientMessage(
                    Component.literal("This stone is permanently bound.")
                            .withStyle(ChatFormatting.RED),
                    true
            );

            level.playSound(null, pos,
                    SoundEvents.ANVIL_LAND,
                    SoundSource.PLAYERS,
                    0.6f,
                    0.8f);

            return InteractionResult.FAIL;
        }

        // ✅ First-time bind
        tag.putInt("posX", pos.getX());
        tag.putInt("posY", pos.getY() + 1);
        tag.putInt("posZ", pos.getZ());
        tag.putString("dimension", level.dimension().location().toString());

        player.displayClientMessage(
                Component.literal("Location Bound!")
                        .withStyle(ChatFormatting.AQUA),
                true
        );

        level.playSound(null, pos,
                SoundEvents.RESPAWN_ANCHOR_SET_SPAWN,
                SoundSource.PLAYERS,
                1f,
                1f);

        return InteractionResult.SUCCESS;
    }

    /* ==========================
       CHANNEL TELEPORT
     ========================== */

    @Override
    public void onUseTick(@NotNull Level level,
                          @NotNull LivingEntity entity,
                          @NotNull ItemStack stack,
                          int count) {

        int ticksHeld = getUseDuration(stack) - count;

        // Must be bound
        if (!stack.hasTag() || !Objects.requireNonNull(stack.getTag()).contains("posX"))
            return;

        /* ==========================
           CLIENT PARTICLES
         ========================== */
        if (level.isClientSide()) {

            double progress = Math.min(1.0, (double) ticksHeld / TELEPORT_TICKS);
            int particleCount = (int) (15 + 25 * progress);

            for (int i = 0; i < particleCount; i++) {

                double angle = 2 * Math.PI * i / particleCount + entity.tickCount * 0.1;
                double radius = 1.0 + 0.5 * progress;

                double x = entity.getX() + Math.cos(angle) * radius;
                double y = entity.getY() + 0.5 + progress;
                double z = entity.getZ() + Math.sin(angle) * radius;

                level.addParticle(
                        ParticleTypes.END_ROD,
                        x, y, z,
                        0, 0.02 + 0.05 * progress, 0
                );

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

        /* ==========================
           SERVER LOGIC
         ========================== */
        if (!level.isClientSide() && entity instanceof ServerPlayer player) {

            // Channeling sound every 10 ticks
            if (ticksHeld % 10 == 0) {
                level.playSound(null,
                        player.blockPosition(),
                        SoundEvents.BEACON_ACTIVATE,
                        SoundSource.PLAYERS,
                        0.5f,
                        1f);
            }

            // Teleport after channel completes
            if (ticksHeld >= TELEPORT_TICKS) {

                teleportToSavedLocation(player, stack);

                stack.hurtAndBreak(1, player,
                        p -> p.broadcastBreakEvent(player.getUsedItemHand()));

                player.stopUsingItem();
            }
        }
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
        return 72000;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level,
                                                           Player player,
                                                           @NotNull InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);

        if (!stack.hasTag() || !Objects.requireNonNull(stack.getTag()).contains("posX")) {
            player.displayClientMessage(
                    Component.literal("No location bound!")
                            .withStyle(ChatFormatting.RED),
                    true
            );
            return InteractionResultHolder.fail(stack);
        }

        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }

    /* ==========================
       TELEPORT LOGIC
     ========================== */

    private void teleportToSavedLocation(ServerPlayer player, ItemStack stack) {

        CompoundTag tag = stack.getTag();
        if (tag == null) return;

        int x = tag.getInt("posX");
        int y = tag.getInt("posY");
        int z = tag.getInt("posZ");

        ResourceKey<Level> dimension =
                ResourceKey.create(net.minecraft.core.registries.Registries.DIMENSION,
                        new ResourceLocation(tag.getString("dimension")));

        ServerLevel targetLevel = player.server.getLevel(dimension);
        if (targetLevel == null) return;

        player.teleportTo(targetLevel,
                x + 0.5, y, z + 0.5,
                player.getYRot(), player.getXRot());

        targetLevel.playSound(null,
                x, y, z,
                SoundEvents.ENDERMAN_TELEPORT,
                SoundSource.PLAYERS,
                1f,
                1f);
    }

    /* ==========================
       TOOLTIP
     ========================== */

    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                @Nullable Level level,
                                @NotNull List<Component> tooltip,
                                @NotNull TooltipFlag flag) {

        if (stack.hasTag() && Objects.requireNonNull(stack.getTag()).contains("posX")) {

            tooltip.add(Component.literal("Bound Location:")
                    .withStyle(ChatFormatting.LIGHT_PURPLE));

            tooltip.add(Component.literal(
                            stack.getTag().getInt("posX") + ", " +
                                    stack.getTag().getInt("posY") + ", " +
                                    stack.getTag().getInt("posZ"))
                    .withStyle(ChatFormatting.GRAY));

        } else {
            tooltip.add(Component.literal("Right-click a block to bind location")
                    .withStyle(ChatFormatting.DARK_GRAY));
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }
}