package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.codex.pulsarflux.flux.ToolConfigs.LeadSwordItem;
import net.codex.pulsarflux.flux.utilitiesFlux.tierFlux;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SwordFlux {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PulsarFlux.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    //-----Swords
    public static final RegistryObject<SwordItem> ALUMINUM_SWORD = ITEMS.register("aluminum_sword",
            () -> new SwordItem(tierFlux.ALUMINUM, 5, -2.2f, new Item.Properties()));
    public static final RegistryObject<SwordItem> BRONZE_SWORD = ITEMS.register("bronze_sword",
            () -> new SwordItem(tierFlux.BRONZE, 5, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> CONSTANTAN_SWORD = ITEMS.register("constantan_sword",
            () -> new SwordItem(tierFlux.CONSTANTAN, 5, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> ELECTRUM_SWORD = ITEMS.register("electrum_sword",
            () -> new SwordItem(tierFlux.ELECTRUM, 5, -2.5f, new Item.Properties()));
    public static final RegistryObject<SwordItem> INVAR_SWORD = ITEMS.register("invar_sword",
            () -> new SwordItem(tierFlux.INVAR, 6, -2.4f, new Item.Properties()));

    // Special Sword with Effect
    public static final RegistryObject<SwordItem> LEAD_SWORD = ITEMS.register("lead_sword",
            () -> new LeadSwordItem(tierFlux.LEAD, 6, -2.9f, new Item.Properties()));

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

    // Mining tools


}
