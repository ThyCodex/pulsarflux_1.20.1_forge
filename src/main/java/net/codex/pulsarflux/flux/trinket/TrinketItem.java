package net.codex.pulsarflux.flux.trinket;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.sounds.SoundEvents;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import java.util.List;

public abstract class TrinketItem extends Item implements ICurioItem {

    protected TrinketItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    // -------------------
    // CURIO SLOT LOGIC
    // -------------------
    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return slotContext.identifier().equals("charm");
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (!slotContext.entity().level().isClientSide()) {
            applyEffect(slotContext.entity(), stack);
        }
    }

    // -------------------
    // AUTO-EQUIP ON RIGHT CLICK
    // -------------------
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack inHand = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            CuriosApi.getCuriosInventory(player).ifPresent(curios -> {
                curios.getStacksHandler("charm").ifPresent(stackHandler -> {
                    IDynamicStackHandler dynamicHandler = stackHandler.getStacks();

                    boolean equipped = false;

                    for (int i = 0; i < dynamicHandler.getSlots(); i++) {
                        ItemStack current = dynamicHandler.getStackInSlot(i);

                        if (current.isEmpty()) {
                            // Slot empty → equip new trinket
                            dynamicHandler.setStackInSlot(i, inHand.copy());
                            inHand.shrink(1);
                            player.playSound(SoundEvents.ARMOR_EQUIP_GENERIC, 1f, 1f);
                            equipped = true;
                            break;
                        }
                    }

                    if (!equipped && dynamicHandler.getSlots() > 0) {
                        // No empty slots → swap with first slot
                        ItemStack current = dynamicHandler.getStackInSlot(0);
                        dynamicHandler.setStackInSlot(0, inHand.copy());
                        player.setItemInHand(hand, current); // put the old trinket back in hand
                        player.playSound(SoundEvents.ARMOR_EQUIP_GENERIC, 1f, 1f);
                    }
                });
            });
        }

        return InteractionResultHolder.sidedSuccess(inHand, level.isClientSide());
    }








    // -------------------
    // EFFECTS
    // -------------------
    protected abstract void applyEffect(LivingEntity entity, ItemStack stack);

    // -------------------
    // TOOLTIP
    // -------------------
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        TrinketToolTip.append(stack, level, tooltip, flag);
    }
}
