package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BlockFluxItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(net.minecraftforge.registries.ForgeRegistries.ITEMS, PulsarFlux.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    //-----Normal Blocks
    public static final RegistryObject<Item> ALUMINUM_BLOCK_ITEM = ITEMS.register("aluminum_block",
            () -> new BlockItem(BlockFlux.ALUMINUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BRONZE_BLOCK_ITEM = ITEMS.register("bronze_block",
            () -> new BlockItem(BlockFlux.BRONZE_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CONSTANTAN_BLOCK_ITEM = ITEMS.register("constantan_block",
            () -> new BlockItem(BlockFlux.CONSTANTAN_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ELECTRUM_BLOCK_ITEM = ITEMS.register("electrum_block",
            () -> new BlockItem(BlockFlux.ELECTRUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> INVAR_BLOCK_ITEM = ITEMS.register("invar_block",
            () -> new BlockItem(BlockFlux.INVAR_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> LEAD_BLOCK_ITEM = ITEMS.register("lead_block",
            () -> new BlockItem(BlockFlux.LEAD_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> LONSDALEITE_BLOCK_ITEM = ITEMS.register("lonsdaleite_block",
            () -> new BlockItem(BlockFlux.LONSDALEITE_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> NICKEL_BLOCK_ITEM = ITEMS.register("nickel_block",
            () -> new BlockItem(BlockFlux.NICKEL_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PLATINUM_BLOCK_ITEM = ITEMS.register("platinum_block",
            () -> new BlockItem(BlockFlux.PLATINUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SILVER_BLOCK_ITEM = ITEMS.register("silver_block",
            () -> new BlockItem(BlockFlux.SILVER_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> STEEL_BLOCK_ITEM = ITEMS.register("steel_block",
            () -> new BlockItem(BlockFlux.STEEL_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> TIN_BLOCK_ITEM = ITEMS.register("tin_block",
            () -> new BlockItem(BlockFlux.TIN_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));

    //-----Ore Blocks
    public static final RegistryObject<Item> ALUMINUM_ORE_ITEM = ITEMS.register("aluminum_ore",
            () -> new BlockItem(BlockFlux.ALUMINUM_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ELECTRUM_ORE_ITEM = ITEMS.register("electrum_ore",
            () -> new BlockItem(BlockFlux.ELECTRUM_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> LEAD_ORE_ITEM = ITEMS.register("lead_ore",
            () -> new BlockItem(BlockFlux.LEAD_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> LONSDALEITE_ORE_ITEM = ITEMS.register("lonsdaleite_ore",
            () -> new BlockItem(BlockFlux.LONSDALEITE_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> NICKEL_ORE_ITEM = ITEMS.register("nickel_ore",
            () -> new BlockItem(BlockFlux.NICKEL_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PLATINUM_ORE_ITEM = ITEMS.register("platinum_ore",
            () -> new BlockItem(BlockFlux.PLATINUM_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SILVER_ORE_ITEM = ITEMS.register("silver_ore",
            () -> new BlockItem(BlockFlux.SILVER_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> TIN_ORE_ITEM = ITEMS.register("tin_ore",
            () -> new BlockItem(BlockFlux.TIN_ORE.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));

    //-----Raw Blocks
    public static final RegistryObject<Item> RAW_ALUMINUM_BLOCK_ITEM = ITEMS.register("raw_aluminum_block",
            () -> new BlockItem(BlockFlux.RAW_ALUMINUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RAW_ELECTRUM_BLOCK_ITEM = ITEMS.register("raw_electrum_block",
            () -> new BlockItem(BlockFlux.RAW_ELECTRUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RAW_LEAD_BLOCK_ITEM = ITEMS.register("raw_lead_block",
            () -> new BlockItem(BlockFlux.RAW_LEAD_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RAW_LONSDALEITE_BLOCK_ITEM = ITEMS.register("raw_lonsdaleite_block",
            () -> new BlockItem(BlockFlux.RAW_LONSDALEITE_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RAW_NICKEL_BLOCK_ITEM = ITEMS.register("raw_nickel_block",
            () -> new BlockItem(BlockFlux.RAW_NICKEL_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RAW_PLATINUM_BLOCK_ITEM = ITEMS.register("raw_platinum_block",
            () -> new BlockItem(BlockFlux.RAW_PLATINUM_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RAW_SILVER_BLOCK_ITEM = ITEMS.register("raw_silver_block",
            () -> new BlockItem(BlockFlux.RAW_SILVER_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RAW_TIN_BLOCK_ITEM = ITEMS.register("raw_tin_block",
            () -> new BlockItem(BlockFlux.RAW_TIN_BLOCK.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));


}

