package net.codex.pulsarflux.flux.sword;

import net.codex.pulsarflux.PulsarFlux;
import net.codex.pulsarflux.flux.sword.sworditems.*;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sword {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PulsarFlux.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    //-----common swords
    public static final RegistryObject<SwordItem> ALUMINUM_SWORD = ITEMS.register("aluminum_sword",
            () -> new CommonSwordItem(SwordTier.ALUMINUM, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> BRONZE_SWORD = ITEMS.register("bronze_sword",
            () -> new CommonSwordItem(SwordTier.BRONZE, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> CONSTANTAN_SWORD = ITEMS.register("constantan_sword",
            () -> new CommonSwordItem(SwordTier.CONSTANTAN, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> ELECTRUM_SWORD = ITEMS.register("electrum_sword",
            () -> new CommonSwordItem(SwordTier.ELECTRUM, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> INVAR_SWORD = ITEMS.register("invar_sword",
            () -> new CommonSwordItem(SwordTier.INVAR, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> NICKEL_SWORD = ITEMS.register("nickel_sword",
            () -> new CommonSwordItem(SwordTier.NICKEL, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new CommonSwordItem(SwordTier.STEEL, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<SwordItem> TIN_SWORD = ITEMS.register("tin_sword",
            () -> new CommonSwordItem(SwordTier.TIN, 6, -2.4f, new Item.Properties()));

    //-----special swords
    public static final RegistryObject<SwordItem> LEAD_SWORD =
            ITEMS.register("lead_sword", LeadSwordItem::new);
    public static final RegistryObject<SwordItem> SILVER_SWORD =
            ITEMS.register("silver_sword", SilverSwordItem::new);
    public static final RegistryObject<SwordItem> PLATINUM_SWORD =
            ITEMS.register("platinum_sword", PlatinumSwordItem::new);
    public static final RegistryObject<SwordItem> BLUE_PHASEBLADE =
            ITEMS.register("blue_phaseblade", BluePhasebladeItem::new);
    public static final RegistryObject<SwordItem> PURPLE_PHASEBLADE =
            ITEMS.register("purple_phaseblade", PurplePhasebladeItem::new);
    public static final RegistryObject<SwordItem> RED_PHASEBLADE =
            ITEMS.register("red_phaseblade", RedPhasebladeItem::new);






}

