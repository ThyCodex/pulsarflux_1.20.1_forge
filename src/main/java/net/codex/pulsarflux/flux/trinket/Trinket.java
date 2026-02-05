package net.codex.pulsarflux.flux.trinket;

import net.codex.pulsarflux.PulsarFlux;
import net.codex.pulsarflux.flux.trinket.trinketitems.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;

public class Trinket {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PulsarFlux.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    // -------------------
    // REGISTER TRINKETS
    // -------------------

    public static final RegistryObject<Item> AGLET_TRINKET =
            ITEMS.register("aglet_trinket", () -> new AgletTrinketItem(new Item.Properties()));

    public static final RegistryObject<Item> DIVING_GEAR_TRINKET =
            ITEMS.register("diving_gear_trinket", () -> new DivingGearTrinketItem(new Item.Properties()));

    public static final RegistryObject<Item> LUCKY_HORSESHOE_TRINKET =
            ITEMS.register("lucky_horseshoe_trinket", () -> new LuckyHorseshoeTrinketItem(new Item.Properties()));

    public static final RegistryObject<Item> TREASURE_MAGNET_TRINKET =
            ITEMS.register("treasure_magnet_trinket", () -> new TreasureMagnetTrinketItem(new Item.Properties()));

    public static final RegistryObject<Item> MINI_MUSHROOM_TRINKET =
            ITEMS.register("mini_mushroom_trinket", () -> new MiniMushroomTrinketItem(new Item.Properties()));

    public static final RegistryObject<Item> SUPER_MUSHROOM_TRINKET =
            ITEMS.register("super_mushroom_trinket", () -> new SuperMushroomTrinketItem(new Item.Properties()));
}
