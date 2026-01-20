package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockFlux {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PulsarFlux.MOD_ID);

    public static final RegistryObject<Block> ALUMINUM_ORE = BLOCKS.register("aluminum_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ELECTRUM_ORE = BLOCKS.register("electrum_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKEL_ORE = BLOCKS.register("nickel_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PLATINUM_ORE = BLOCKS.register("platinum_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_ALUMINUM_BLOCK = BLOCKS.register("raw_aluminum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK)));
    public static final RegistryObject<Block> RAW_ELECTRUM_BLOCK = BLOCKS.register("raw_electrum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK)));
    public static final RegistryObject<Block> RAW_LEAD_BLOCK = BLOCKS.register("raw_lead_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK)));
    public static final RegistryObject<Block> RAW_NICKEL_BLOCK = BLOCKS.register("raw_nickel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK)));
    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = BLOCKS.register("raw_platinum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK)));
    public static final RegistryObject<Block> RAW_SILVER_BLOCK = BLOCKS.register("raw_silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK)));
    public static final RegistryObject<Block> RAW_TIN_BLOCK = BLOCKS.register("raw_tin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK)));

    public static final RegistryObject<Block> ALUMINUM_BLOCK = BLOCKS.register("aluminum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> ELECTRUM_BLOCK = BLOCKS.register("electrum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> LEAD_BLOCK = BLOCKS.register("lead_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> NICKEL_BLOCK = BLOCKS.register("nickel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> TIN_BLOCK = BLOCKS.register("tin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));

}
