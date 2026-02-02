package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockFlux {

    // ----- BLOCK REGISTRIES -----
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PulsarFlux.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PulsarFlux.MOD_ID);

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    // ----- ORES -----
    public static final RegistryObject<Block> ALUMINUM_ORE = registerBlock("aluminum_ore", Blocks.COPPER_ORE, 3f);
    public static final RegistryObject<Block> ELECTRUM_ORE = registerBlock("electrum_ore", Blocks.COPPER_ORE, 3f);
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore", Blocks.COPPER_ORE, 3f);
    public static final RegistryObject<Block> LONSDALEITE_ORE = registerBlock("lonsdaleite_ore", Blocks.COPPER_ORE, 3f);
    public static final RegistryObject<Block> NICKEL_ORE = registerBlock("nickel_ore", Blocks.COPPER_ORE, 3f);
    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock("platinum_ore", Blocks.COPPER_ORE, 3f);
    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore", Blocks.COPPER_ORE, 3f);
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore", Blocks.COPPER_ORE, 3f);

    // ----- RAW BLOCKS -----
    public static final RegistryObject<Block> RAW_ALUMINUM_BLOCK = registerBlock("raw_aluminum_block", Blocks.RAW_IRON_BLOCK);
    public static final RegistryObject<Block> RAW_ELECTRUM_BLOCK = registerBlock("raw_electrum_block", Blocks.RAW_IRON_BLOCK);
    public static final RegistryObject<Block> RAW_LEAD_BLOCK = registerBlock("raw_lead_block", Blocks.RAW_IRON_BLOCK);
    public static final RegistryObject<Block> RAW_LONSDALEITE_BLOCK = registerBlock("raw_lonsdaleite_block", Blocks.RAW_IRON_BLOCK);
    public static final RegistryObject<Block> RAW_NICKEL_BLOCK = registerBlock("raw_nickel_block", Blocks.RAW_IRON_BLOCK);
    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block", Blocks.RAW_IRON_BLOCK);
    public static final RegistryObject<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block", Blocks.RAW_IRON_BLOCK);
    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block", Blocks.RAW_IRON_BLOCK);

    // ----- INGOT BLOCKS -----
    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block", Blocks.COPPER_BLOCK);
    public static final RegistryObject<Block> BRONZE_BLOCK = registerBlock("bronze_block", Blocks.COPPER_BLOCK);
    public static final RegistryObject<Block> CONSTANTAN_BLOCK = registerBlock("constantan_block", Blocks.COPPER_BLOCK);
    public static final RegistryObject<Block> ELECTRUM_BLOCK = registerBlock("electrum_block", Blocks.COPPER_BLOCK);
    public static final RegistryObject<Block> INVAR_BLOCK = registerBlock("invar_block", Blocks.COPPER_BLOCK);
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block", Blocks.COPPER_BLOCK);
    public static final RegistryObject<Block> LONSDALEITE_BLOCK = registerBlock("lonsdaleite_block", Blocks.COPPER_BLOCK);
    public static final RegistryObject<Block> NICKEL_BLOCK = registerBlock("nickel_block", Blocks.COPPER_BLOCK);
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block", Blocks.COPPER_BLOCK);
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block", Blocks.COPPER_BLOCK);
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block", Blocks.COPPER_BLOCK);
    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block", Blocks.COPPER_BLOCK);

    // ----- HELPER METHODS -----
    private static RegistryObject<Block> registerBlock(String name, Block template) {
        return registerBlock(name, template, -1f); // default strength uses template
    }

    private static RegistryObject<Block> registerBlock(String name, Block template, float strength) {
        RegistryObject<Block> block = BLOCKS.register(name,
                () -> {
                    if (strength > 0) {
                        return new Block(BlockBehaviour.Properties.copy(template).strength(strength).requiresCorrectToolForDrops());
                    } else {
                        return new Block(BlockBehaviour.Properties.copy(template));
                    }
                });

        // Register the BlockItem
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));

        return block;
    }
}
