package net.codex.pulsarflux.flux;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ToolTags {
    public static final TagKey<Item> LEAD_TOOLS = ItemTags.create(
            new ResourceLocation("pulsarflux", "lead_tools")
    );

    public static final TagKey<Item> SILVER_TOOLS = ItemTags.create(
            new ResourceLocation("pulsarflux", "silver_tools")
    );

    public static final TagKey<Item> ELECTRUM_TOOLS = ItemTags.create(
            new ResourceLocation("pulsarflux", "electrum_tools")
    );

    public static final TagKey<Item> PLATINUM_TOOLS = ItemTags.create(
            new ResourceLocation("pulsarflux", "platinum_tools")
    );

    public static final TagKey<Item> PHASEBLADE = ItemTags.create(
            new ResourceLocation("pulsarflux", "phaseblade")
    );
}
