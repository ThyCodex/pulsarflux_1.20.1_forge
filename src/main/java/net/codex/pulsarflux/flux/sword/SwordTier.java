package net.codex.pulsarflux.flux.sword;

import net.codex.pulsarflux.flux.MaterialItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class SwordTier {

    /*
     * Tier reference:
     * 0 = wood
     * 1 = stone
     * 2 = iron
     * 3 = diamond
     * 4 = netherite
     */

    public static final ForgeTier TIN = new ForgeTier(1, 180, 4.0f, 0.5f, 8,
            BlockTags.NEEDS_STONE_TOOL,() -> Ingredient.of(MaterialItems.TIN_INGOT.get()));
    public static final ForgeTier ALUMINUM = new ForgeTier(2, 360, 6.0f, 0.5f, 14,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(MaterialItems.ALUMINUM_INGOT.get()));
    public static final ForgeTier LEAD = new ForgeTier(2, 240, 6.0f, 0.5f, 6,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(MaterialItems.LEAD_INGOT.get()));
    public static final ForgeTier NICKEL = new ForgeTier(2, 220, 6.0f, 0.3f, 16,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(MaterialItems.NICKEL_INGOT.get()));
    public static final ForgeTier ELECTRUM = new ForgeTier(2, 180, 6.0f, 0.8f, 22,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(MaterialItems.ELECTRUM_INGOT.get()));
    public static final ForgeTier BRONZE = new ForgeTier(2, 300, 7.0f, 0.6f, 12,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(MaterialItems.BRONZE_INGOT.get()));
    public static final ForgeTier CONSTANTAN = new ForgeTier(3, 360, 8.0f, 0.3f, 10,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(MaterialItems.CONSTANTAN_INGOT.get()));
    public static final ForgeTier STEEL = new ForgeTier(3, 500, 8.0f, 0.4f, 10,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(MaterialItems.STEEL_INGOT.get()));
    public static final ForgeTier INVAR = new ForgeTier(3, 420, 8.0f, 0.6f, 14,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(MaterialItems.INVAR_INGOT.get()));
    public static final ForgeTier SILVER = new ForgeTier(2, 48, 6.0f, 0.0f, 20,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(MaterialItems.SILVER_INGOT.get()));
    public static final ForgeTier PLATINUM = new ForgeTier(3, 720, 8.5f, 0.4f, 18,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(MaterialItems.PLATINUM_INGOT.get()));

    public static final ForgeTier PHASEBLADE = new ForgeTier(4, 2000, 8.5f, 0.5f, 18,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(MaterialItems.PLATINUM_INGOT.get()));

}
