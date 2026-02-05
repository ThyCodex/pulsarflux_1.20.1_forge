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

public class AgletTrinketItem extends TrinketItem {

    public AgletTrinketItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(LivingEntity entity, ItemStack stack) {

    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(
            SlotContext slotContext,
            UUID uuid,
            ItemStack stack
    ) {
        Multimap<Attribute, AttributeModifier> modifiers = HashMultimap.create();

        modifiers.put(
                Attributes.MOVEMENT_SPEED,
                new AttributeModifier(
                        uuid,
                        "pulsarflux:aglet_speed",
                        0.05D, // +5% movement speed
                        AttributeModifier.Operation.MULTIPLY_TOTAL
                )
        );

        return modifiers;
    }
}
