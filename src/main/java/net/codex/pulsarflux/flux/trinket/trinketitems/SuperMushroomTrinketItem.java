package net.codex.pulsarflux.flux.trinket.trinketitems;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.codex.pulsarflux.flux.trinket.TrinketItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class SuperMushroomTrinketItem extends TrinketItem {
    private static final UUID HEALTH_UUID =
            UUID.fromString("a4b1f7e2-0000-4d63-9c4b-8d44c8a6f001");
    private static final UUID DAMAGE_UUID =
            UUID.fromString("a4b1f7e2-0000-4d63-9c4b-8d44c8a6f002");
    private static final UUID KNOCKBACK_UUID =
            UUID.fromString("a4b1f7e2-0000-4d63-9c4b-8d44c8a6f003");
    private static final UUID SPEED_UUID =
            UUID.fromString("a4b1f7e2-0000-4d63-9c4b-8d44c8a6f004");

    public SuperMushroomTrinketItem(Properties properties) {
        super(properties);
    }
    @Override
    protected void applyEffect(LivingEntity entity, ItemStack stack) {
        // intentionally empty
    }
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(
            SlotContext slotContext,
            UUID uuid,
            ItemStack stack
    ) {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create();

        // Max health ↑
        map.put(
                Attributes.MAX_HEALTH,
                new AttributeModifier(
                        HEALTH_UUID,
                        "pulsarflux.super_mushroom.health",
                        10.0D,
                        AttributeModifier.Operation.ADDITION
                )
        );

        // Attack damage ↑
        map.put(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(
                        DAMAGE_UUID,
                        "pulsarflux.super_mushroom.damage",
                        2.0D,
                        AttributeModifier.Operation.ADDITION
                )
        );

        // Knockback resistance ↑
        map.put(
                Attributes.KNOCKBACK_RESISTANCE,
                new AttributeModifier(
                        KNOCKBACK_UUID,
                        "pulsarflux.super_mushroom.knockback",
                        0.25D,
                        AttributeModifier.Operation.ADDITION
                )
        );

        // Movement speed ↓
        map.put(
                Attributes.MOVEMENT_SPEED,
                new AttributeModifier(
                        SPEED_UUID,
                        "pulsarflux.super_mushroom.speed",
                        -0.10D,
                        AttributeModifier.Operation.MULTIPLY_TOTAL
                )
        );

        return map;
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        if (!slotContext.entity().level().isClientSide()) {
            LivingEntity entity = slotContext.entity();
            entity.setHealth(entity.getMaxHealth());
        }
    }
    @Override
    public void onUnequip(SlotContext slotContext, ItemStack stack, ItemStack newStack) {
        if (!slotContext.entity().level().isClientSide()) {
            LivingEntity entity = slotContext.entity();
            if (entity.getHealth() > entity.getMaxHealth()) {
                entity.setHealth(entity.getMaxHealth());
            }
        }
    }
}
