package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SwordItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PulsarFlux.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    //-----sword
    public static final RegistryObject<SwordItem> ALUMINUM_SWORD = ITEMS.register("aluminum_sword",
            () -> new SwordItem(SwordTier.ALUMINUM, 5, -2.2f, new Item.Properties()));
    public static final RegistryObject<SwordItem> BRONZE_SWORD = ITEMS.register("bronze_sword",
            () -> new SwordItem(SwordTier.BRONZE, 5, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> CONSTANTAN_SWORD = ITEMS.register("constantan_sword",
            () -> new SwordItem(SwordTier.CONSTANTAN, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> ELECTRUM_SWORD = ITEMS.register("electrum_sword",
            () -> new SwordItem(SwordTier.ELECTRUM, 5, -2.5f, new Item.Properties()));
    public static final RegistryObject<SwordItem> INVAR_SWORD = ITEMS.register("invar_sword",
            () -> new SwordItem(SwordTier.INVAR, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> LEAD_SWORD = ITEMS.register("lead_sword",
            () -> new SwordToolTips(SwordTier.LEAD, 6, -2.9f, new Item.Properties()));
    public static final RegistryObject<SwordItem> NICKEL_SWORD = ITEMS.register("nickel_sword",
            () -> new SwordItem(SwordTier.NICKEL, 5, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> PLATINUM_SWORD = ITEMS.register("platinum_sword",
            () -> new SwordToolTips(SwordTier.PLATINUM, 7, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> SILVER_SWORD = ITEMS.register("silver_sword",
            () -> new SwordToolTips(SwordTier.SILVER, 4, -2.2f, new Item.Properties()));
    public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(SwordTier.STEEL, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> TIN_SWORD = ITEMS.register("tin_sword",
            () -> new SwordItem(SwordTier.TIN, 4, -2.4f, new Item.Properties()));

    //-----phaseblade
    public static final RegistryObject<SwordItem> BLUE_PHASEBLADE = ITEMS.register("blue_phaseblade",
            () -> new SwordToolTips(SwordTier.PHASEBLADE, 7, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> GREEN_PHASEBLADE = ITEMS.register("green_phaseblade",
            () -> new SwordToolTips(SwordTier.PHASEBLADE, 7, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> PURPLE_PHASEBLADE = ITEMS.register("purple_phaseblade",
            () -> new SwordToolTips(SwordTier.PHASEBLADE, 7, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> RED_PHASEBLADE = ITEMS.register("red_phaseblade",
            () -> new SwordToolTips(SwordTier.PHASEBLADE, 7, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> WHITE_PHASEBLADE = ITEMS.register("white_phaseblade",
            () -> new SwordToolTips(SwordTier.PHASEBLADE, 7, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> YELLOW_PHASEBLADE = ITEMS.register("yellow_phaseblade",
            () -> new SwordToolTips(SwordTier.PHASEBLADE, 7, -2.4f, new Item.Properties()));

}

