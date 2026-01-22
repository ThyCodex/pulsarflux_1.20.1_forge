package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.codex.pulsarflux.flux.utilitiesFlux.tierFlux;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemFlux {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PulsarFlux.MOD_ID);

    //-----Food
    public static final RegistryObject<Item> STEEL_APPLE = ITEMS.register("steel_apple",
            () -> new Item(new Item.Properties()
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.3f)
                            .alwaysEat()
                            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 1), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 0), 1.0f)
                            .build())
                    .rarity(Rarity.EPIC)
            ));
    //-----Weapons p_43269=rarity p_43270=damage p_43271=atk.speed

    public static final RegistryObject<SwordItem> ALUMINUM_SWORD = ITEMS.register("aluminum_sword",
            () -> new SwordItem(tierFlux.ALUMINUM, 5, -2.2f, new Item.Properties()));
    public static final RegistryObject<SwordItem> BRONZE_SWORD = ITEMS.register("bronze_sword",
            () -> new SwordItem(tierFlux.BRONZE, 5, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> CONSTANT_SWORD = ITEMS.register("constant_sword",
            () -> new SwordItem(tierFlux.CONSTANT, 5, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> ELECTRUM_SWORD = ITEMS.register("electrum_sword",
            () -> new SwordItem(tierFlux.ELECTRUM, 5, -2.5f, new Item.Properties()));
    public static final RegistryObject<SwordItem> INVAR_SWORD = ITEMS.register("invar_sword",
            () -> new SwordItem(tierFlux.INVAR, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> LEAD_SWORD = ITEMS.register("lead_sword",
            () -> new SwordItem(tierFlux.LEAD, 6, -2.9f, new Item.Properties()));
    public static final RegistryObject<SwordItem> NICKEL_SWORD = ITEMS.register("nickel_sword",
            () -> new SwordItem(tierFlux.NICKEL, 5, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> PLATINUM_SWORD = ITEMS.register("platinum_sword",
            () -> new SwordItem(tierFlux.PLATINUM, 8, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> SILVER_SWORD = ITEMS.register("silver_sword",
            () -> new SwordItem(tierFlux.SILVER, 4, -2.2f, new Item.Properties()));
    public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(tierFlux.STEEL, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> TIN_SWORD = ITEMS.register("tin_sword",
            () -> new SwordItem(tierFlux.TIN, 4, -2.4f, new Item.Properties()));

    //-----Tools p_43269=rarity p_43270=damage p_43271=atk.speed

    //public static final RegistryObject<PickaxeItem> TIN_PICKAXE = ITEMS.register("tin_pickaxe",
            //() -> new PickaxeItem(tierFlux.TIN, 7, 2.0f, new Item.Properties()));

    //public static final RegistryObject<AxeItem> TIN_AXE = ITEMS.register("tin_axe",
            //() -> new AxeItem(tierFlux.TIN, 7, 2.0f, new Item.Properties()));

    //public static final RegistryObject<ShovelItem> TIN_SHOVEL = ITEMS.register("tin_shovel",
            //() -> new ShovelItem(tierFlux.TIN, 7, 2.0f, new Item.Properties()));

    //public static final RegistryObject<HoeItem> TIN_HOE = ITEMS.register("tin_hoe",
            //() -> new HoeItem(tierFlux.TIN, 7, 2.0f, new Item.Properties()));

    //-----Ore_Ingots

    public static final RegistryObject<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ELECTRUM = ITEMS.register("raw_electrum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_NICKEL = ITEMS.register("raw_nickel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PLATINUM = ITEMS.register("raw_platinum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CONSTANT_INGOT = ITEMS.register("constant_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INVAR_INGOT = ITEMS.register("invar_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));

    //-----Block Item
    public static final RegistryObject<BlockItem> ALUMINUM_ORE_ITEM = ITEMS.register("aluminum_ore",
            () -> new BlockItem(BlockFlux.ALUMINUM_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> ELECTRUM_ORE_ITEM = ITEMS.register("electrum_ore",
            () -> new BlockItem(BlockFlux.ELECTRUM_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> LEAD_ORE_ITEM = ITEMS.register("lead_ore",
            () -> new BlockItem(BlockFlux.LEAD_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> NICKEL_ORE_ITEM = ITEMS.register("nickel_ore",
            () -> new BlockItem(BlockFlux.NICKEL_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> PLATINUM_ORE_ITEM = ITEMS.register("platinum_ore",
            () -> new BlockItem(BlockFlux.PLATINUM_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> SILVER_ORE_ITEM = ITEMS.register("silver_ore",
            () -> new BlockItem(BlockFlux.SILVER_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> TIN_ORE_ITEM = ITEMS.register("tin_ore",
            () -> new BlockItem(BlockFlux.TIN_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<BlockItem> RAW_ALUMINUM_BLOCK_ITEM = ITEMS.register("raw_aluminum_block",
            () -> new BlockItem(BlockFlux.RAW_ALUMINUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> RAW_ELECTRUM_BLOCK_ITEM = ITEMS.register("raw_electrum_block",
            () -> new BlockItem(BlockFlux.RAW_ELECTRUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> RAW_LEAD_BLOCK_ITEM = ITEMS.register("raw_lead_block",
            () -> new BlockItem(BlockFlux.RAW_LEAD_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> RAW_NICKEL_BLOCK_ITEM = ITEMS.register("raw_nickel_block",
            () -> new BlockItem(BlockFlux.RAW_NICKEL_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> RAW_PLATINUM_BLOCK_ITEM = ITEMS.register("raw_platinum_block",
            () -> new BlockItem(BlockFlux.RAW_PLATINUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> RAW_SILVER_BLOCK_ITEM = ITEMS.register("raw_silver_block",
            () -> new BlockItem(BlockFlux.RAW_SILVER_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> RAW_TIN_BLOCK_ITEM = ITEMS.register("raw_tin_block",
            () -> new BlockItem(BlockFlux.RAW_TIN_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<BlockItem> ALUMINUM_BLOCK_ITEM = ITEMS.register("aluminum_block",
            () -> new BlockItem(BlockFlux.ALUMINUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> BRONZE_BLOCK_ITEM = ITEMS.register("bronze_block",
            () -> new BlockItem(BlockFlux.BRONZE_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> CONSTANT_BLOCK_ITEM = ITEMS.register("constant_block",
            () -> new BlockItem(BlockFlux.CONSTANT_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> ELECTRUM_BLOCK_ITEM = ITEMS.register("electrum_block",
            () -> new BlockItem(BlockFlux.ELECTRUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> INVAR_BLOCK_ITEM = ITEMS.register("invar_block",
            () -> new BlockItem(BlockFlux.INVAR_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> LEAD_BLOCK_ITEM = ITEMS.register("lead_block",
            () -> new BlockItem(BlockFlux.LEAD_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> NICKEL_BLOCK_ITEM = ITEMS.register("nickel_block",
            () -> new BlockItem(BlockFlux.NICKEL_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> PLATINUM_BLOCK_ITEM = ITEMS.register("platinum_block",
            () -> new BlockItem(BlockFlux.PLATINUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> SILVER_BLOCK_ITEM = ITEMS.register("silver_block",
            () -> new BlockItem(BlockFlux.SILVER_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> STEEL_BLOCK_ITEM = ITEMS.register("steel_block",
            () -> new BlockItem(BlockFlux.STEEL_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<BlockItem> TIN_BLOCK_ITEM = ITEMS.register("tin_block",
            () -> new BlockItem(BlockFlux.TIN_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
}
