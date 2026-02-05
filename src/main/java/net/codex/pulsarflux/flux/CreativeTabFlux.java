package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = PulsarFlux.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabFlux {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PulsarFlux.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PULSARFLUX = TABS.register("pulsarflux",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.pulsarflux"))
                    .icon(FoodItems.STEEL_APPLE.get()::getDefaultInstance) // steel apple as icon
                    .displayItems((displayParameters, output) -> {

                        //-----Food
                        output.accept(FoodItems.ALUMINUM_APPLE.get());
                        output.accept(FoodItems.BRONZE_APPLE.get());
                        output.accept(FoodItems.CONSTANTAN_APPLE.get());
                        output.accept(FoodItems.ELECTRUM_APPLE.get());
                        output.accept(FoodItems.INVAR_APPLE.get());
                        output.accept(FoodItems.LEAD_APPLE.get());
                        output.accept(FoodItems.LONSDALEITE_APPLE.get());
                        output.accept(FoodItems.NICKEL_APPLE.get());
                        output.accept(FoodItems.PLATINUM_APPLE.get());
                        output.accept(FoodItems.SILVER_APPLE.get());
                        output.accept(FoodItems.STEEL_APPLE.get());
                        output.accept(FoodItems.TIN_APPLE.get());

                        //-----Materials / Ingots
                        output.accept(MaterialItems.RAW_ALUMINUM.get());
                        output.accept(MaterialItems.RAW_ELECTRUM.get());
                        output.accept(MaterialItems.RAW_LEAD.get());
                        output.accept(MaterialItems.RAW_LONSDALEITE.get());
                        output.accept(MaterialItems.RAW_NICKEL.get());
                        output.accept(MaterialItems.RAW_PLATINUM.get());
                        output.accept(MaterialItems.RAW_SILVER.get());
                        output.accept(MaterialItems.RAW_TIN.get());

                        output.accept(MaterialItems.ALUMINUM_INGOT.get());
                        output.accept(MaterialItems.BRONZE_INGOT.get());
                        output.accept(MaterialItems.CONSTANTAN_INGOT.get());
                        output.accept(MaterialItems.ELECTRUM_INGOT.get());
                        output.accept(MaterialItems.INVAR_INGOT.get());
                        output.accept(MaterialItems.LEAD_INGOT.get());
                        output.accept(MaterialItems.LONSDALEITE_INGOT.get());
                        output.accept(MaterialItems.NICKEL_INGOT.get());
                        output.accept(MaterialItems.PLATINUM_INGOT.get());
                        output.accept(MaterialItems.SILVER_INGOT.get());
                        output.accept(MaterialItems.STEEL_INGOT.get());
                        output.accept(MaterialItems.TIN_INGOT.get());

                        //-----Weapons
                        output.accept(SwordItems.ALUMINUM_SWORD.get());
                        output.accept(SwordItems.BRONZE_SWORD.get());
                        output.accept(SwordItems.CONSTANTAN_SWORD.get());
                        output.accept(SwordItems.ELECTRUM_SWORD.get());
                        output.accept(SwordItems.INVAR_SWORD.get());
                        output.accept(SwordItems.LEAD_SWORD.get());
                        output.accept(SwordItems.NICKEL_SWORD.get());
                        output.accept(SwordItems.PLATINUM_SWORD.get());
                        output.accept(SwordItems.SILVER_SWORD.get());
                        output.accept(SwordItems.STEEL_SWORD.get());
                        output.accept(SwordItems.TIN_SWORD.get());
                        output.accept(SwordItems.BLUE_PHASEBLADE.get());
                        output.accept(SwordItems.GREEN_PHASEBLADE.get());
                        output.accept(SwordItems.PURPLE_PHASEBLADE.get());
                        output.accept(SwordItems.RED_PHASEBLADE.get());
                        output.accept(SwordItems.WHITE_PHASEBLADE.get());
                        output.accept(SwordItems.YELLOW_PHASEBLADE.get());

                        //-----Tools
                        output.accept(ToolItems.BRONZE_AXE.get());
                        output.accept(ToolItems.BRONZE_HOE.get());
                        output.accept(ToolItems.BRONZE_PICKAXE.get());
                        output.accept(ToolItems.BRONZE_SHOVEL.get());
                        output.accept(ToolItems.PLATINUM_AXE.get());
                        output.accept(ToolItems.PLATINUM_HOE.get());
                        output.accept(ToolItems.PLATINUM_PICKAXE.get());
                        output.accept(ToolItems.PLATINUM_SHOVEL.get());
                        output.accept(ToolItems.STEEL_AXE.get());
                        output.accept(ToolItems.STEEL_HOE.get());
                        output.accept(ToolItems.STEEL_PICKAXE.get());
                        output.accept(ToolItems.STEEL_SHOVEL.get());

                        //-----Trinkets
                        output.accept(Trinket.AGLET_TRINKET.get());
                        output.accept(Trinket.DIVING_GEAR_TRINKET.get());
                        output.accept(Trinket.LUCKY_HORSESHOE_TRINKET.get());
                        output.accept(Trinket.TREASURE_MAGNET_TRINKET.get());
                        output.accept(Trinket.SUPER_MUSHROOM_TRINKET.get());
                        output.accept(Trinket.MINI_MUSHROOM_TRINKET.get());

                        //-----Ingot Blocks
                        output.accept(BlockItems.ALUMINUM_BLOCK.get());
                        output.accept(BlockItems.BRONZE_BLOCK.get());
                        output.accept(BlockItems.CONSTANTAN_BLOCK.get());
                        output.accept(BlockItems.ELECTRUM_BLOCK.get());
                        output.accept(BlockItems.INVAR_BLOCK.get());
                        output.accept(BlockItems.LEAD_BLOCK.get());
                        output.accept(BlockItems.LONSDALEITE_BLOCK.get());
                        output.accept(BlockItems.NICKEL_BLOCK.get());
                        output.accept(BlockItems.PLATINUM_BLOCK.get());
                        output.accept(BlockItems.SILVER_BLOCK.get());
                        output.accept(BlockItems.STEEL_BLOCK.get());
                        output.accept(BlockItems.TIN_BLOCK.get());

                        //-----Ore Blocks
                        output.accept(BlockItems.ALUMINUM_ORE.get());
                        output.accept(BlockItems.ELECTRUM_ORE.get());
                        output.accept(BlockItems.LEAD_ORE.get());
                        output.accept(BlockItems.LONSDALEITE_ORE.get());
                        output.accept(BlockItems.NICKEL_ORE.get());
                        output.accept(BlockItems.PLATINUM_ORE.get());
                        output.accept(BlockItems.SILVER_ORE.get());
                        output.accept(BlockItems.TIN_ORE.get());

                        //-----Raw Blocks
                        output.accept(BlockItems.RAW_ALUMINUM_BLOCK.get());
                        output.accept(BlockItems.RAW_ALUMINUM_BLOCK.get());
                        output.accept(BlockItems.RAW_LEAD_BLOCK.get());
                        output.accept(BlockItems.RAW_LONSDALEITE_BLOCK.get());
                        output.accept(BlockItems.RAW_NICKEL_BLOCK.get());
                        output.accept(BlockItems.RAW_PLATINUM_BLOCK.get());
                        output.accept(BlockItems.RAW_SILVER_BLOCK.get());
                        output.accept(BlockItems.RAW_TIN_BLOCK.get());


                    })
                    .build()
    );

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        // Optional: Add steel apple to vanilla food tab
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(FoodItems.STEEL_APPLE);
        }
    }
}
