package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.codex.pulsarflux.flux.utilitiesFlux.TierFlux;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ToolFlux {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PulsarFlux.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }


    //Bronze Tools

    public static final RegistryObject<AxeItem> BRONZE_AXE = ITEMS.register("bronze_axe",
            () -> new AxeItem(TierFlux.BRONZE,6,-3.0f, new Item.Properties()));
    public static final RegistryObject<HoeItem> BRONZE_HOE = ITEMS.register("bronze_hoe",
            () -> new HoeItem(TierFlux.BRONZE, 0, -3.0f, new Item.Properties()));
    public static final RegistryObject<PickaxeItem> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe",
            () -> new PickaxeItem(TierFlux.BRONZE, 2, -2.8f, new Item.Properties()));
    public static final RegistryObject<ShovelItem> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",
            () -> new ShovelItem(TierFlux.BRONZE, 1, -3.0f, new Item.Properties()));

    //Platinum Tools

    public static final RegistryObject<AxeItem> PLATINUM_AXE = ITEMS.register("platinum_axe",
            () -> new AxeItem(TierFlux.PLATINUM, 7, -3.0f, new Item.Properties()));
    public static final RegistryObject<HoeItem> PLATINUM_HOE = ITEMS.register("platinum_hoe",
            () -> new HoeItem(TierFlux.PLATINUM, 0, -0.0f, new Item.Properties()));
    public static final RegistryObject<PickaxeItem> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(TierFlux.PLATINUM, 4, -2.8f, new Item.Properties()));
    public static final RegistryObject<ShovelItem> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel",
            () -> new ShovelItem(TierFlux.PLATINUM, 4, -3.0f, new Item.Properties()));

    //Steel Tools

    public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(TierFlux.STEEL, 7, -3.0f, new Item.Properties()));
    public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(TierFlux.STEEL, 0, 0.0f, new Item.Properties()));
    public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(TierFlux.STEEL, 4, -2.8f, new Item.Properties()));
    public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(TierFlux.STEEL, 4, -3.0f, new Item.Properties()));

    public static final RegistryObject<Item> FLUX_STABILIZER = ITEMS.register("flux_stabilizer",
            () -> new Item(new Item.Properties().stacksTo(1)));
}