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

public class MiniMushroomTrinketItem extends TrinketItem {

    private static final UUID HEALTH_UUID = UUID.fromString("b4c1f7e2-0000-4d63-9c4b-8d44c8a6f101");
    private static final UUID SPEED_UUID = UUID.fromString("b4c1f7e2-0000-4d63-9c4b-8d44c8a6f102");

    public MiniMushroomTrinketItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(LivingEntity entity, ItemStack stack) {
        // Heavy fall damage reduction
        entity.fallDistance = 0;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create();

        // Max health ↓
        map.put(Attributes.MAX_HEALTH, new AttributeModifier(HEALTH_UUID, "Mini Mushroom Health", -8.0D, AttributeModifier.Operation.ADDITION));
        // Movement speed ↑
        map.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(SPEED_UUID, "Mini Mushroom Speed", 0.25D, AttributeModifier.Operation.MULTIPLY_TOTAL));

        return map;
    }
}
