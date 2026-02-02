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
                    .icon(FoodFlux.STEEL_APPLE.get()::getDefaultInstance) // steel apple as icon
                    .displayItems((displayParameters, output) -> {

                        //-----Food
                        output.accept(FoodFlux.ALUMINUM_APPLE.get());
                        output.accept(FoodFlux.BRONZE_APPLE.get());
                        output.accept(FoodFlux.CONSTANTAN_APPLE.get());
                        output.accept(FoodFlux.ELECTRUM_APPLE.get());
                        output.accept(FoodFlux.INVAR_APPLE.get());
                        output.accept(FoodFlux.LEAD_APPLE.get());
                        output.accept(FoodFlux.LONSDALEITE_APPLE.get());
                        output.accept(FoodFlux.NICKEL_APPLE.get());
                        output.accept(FoodFlux.PLATINUM_APPLE.get());
                        output.accept(FoodFlux.SILVER_APPLE.get());
                        output.accept(FoodFlux.STEEL_APPLE.get());
                        output.accept(FoodFlux.TIN_APPLE.get());

                        //-----Materials / Ingots
                        output.accept(MaterialFlux.RAW_ALUMINUM.get());
                        output.accept(MaterialFlux.RAW_ELECTRUM.get());
                        output.accept(MaterialFlux.RAW_LEAD.get());
                        output.accept(MaterialFlux.RAW_LONSDALEITE.get());
                        output.accept(MaterialFlux.RAW_NICKEL.get());
                        output.accept(MaterialFlux.RAW_PLATINUM.get());
                        output.accept(MaterialFlux.RAW_SILVER.get());
                        output.accept(MaterialFlux.RAW_TIN.get());

                        output.accept(MaterialFlux.ALUMINUM_INGOT.get());
                        output.accept(MaterialFlux.BRONZE_INGOT.get());
                        output.accept(MaterialFlux.CONSTANTAN_INGOT.get());
                        output.accept(MaterialFlux.ELECTRUM_INGOT.get());
                        output.accept(MaterialFlux.INVAR_INGOT.get());
                        output.accept(MaterialFlux.LEAD_INGOT.get());
                        output.accept(MaterialFlux.LONSDALEITE_INGOT.get());
                        output.accept(MaterialFlux.NICKEL_INGOT.get());
                        output.accept(MaterialFlux.PLATINUM_INGOT.get());
                        output.accept(MaterialFlux.SILVER_INGOT.get());
                        output.accept(MaterialFlux.STEEL_INGOT.get());
                        output.accept(MaterialFlux.TIN_INGOT.get());

                        //-----Weapons
                        output.accept(SwordFlux.ALUMINUM_SWORD.get());
                        output.accept(SwordFlux.BRONZE_SWORD.get());
                        output.accept(SwordFlux.CONSTANTAN_SWORD.get());
                        output.accept(SwordFlux.ELECTRUM_SWORD.get());
                        output.accept(SwordFlux.INVAR_SWORD.get());
                        output.accept(SwordFlux.LEAD_SWORD.get());
                        output.accept(SwordFlux.NICKEL_SWORD.get());
                        output.accept(SwordFlux.PLATINUM_SWORD.get());
                        output.accept(SwordFlux.SILVER_SWORD.get());
                        output.accept(SwordFlux.STEEL_SWORD.get());
                        output.accept(SwordFlux.TIN_SWORD.get());
                        output.accept(SwordFlux.BLUE_PHASEBLADE.get());
                        output.accept(SwordFlux.GREEN_PHASEBLADE.get());
                        output.accept(SwordFlux.PURPLE_PHASEBLADE.get());
                        output.accept(SwordFlux.RED_PHASEBLADE.get());
                        output.accept(SwordFlux.WHITE_PHASEBLADE.get());
                        output.accept(SwordFlux.YELLOW_PHASEBLADE.get());

                        //-----Tools
                        output.accept(ToolFlux.BRONZE_AXE.get());
                        output.accept(ToolFlux.BRONZE_HOE.get());
                        output.accept(ToolFlux.BRONZE_PICKAXE.get());
                        output.accept(ToolFlux.BRONZE_SHOVEL.get());
                        output.accept(ToolFlux.PLATINUM_AXE.get());
                        output.accept(ToolFlux.PLATINUM_HOE.get());
                        output.accept(ToolFlux.PLATINUM_PICKAXE.get());
                        output.accept(ToolFlux.PLATINUM_SHOVEL.get());
                        output.accept(ToolFlux.STEEL_AXE.get());
                        output.accept(ToolFlux.STEEL_HOE.get());
                        output.accept(ToolFlux.STEEL_PICKAXE.get());
                        output.accept(ToolFlux.STEEL_SHOVEL.get());

                        //-----Augments
                        output.accept(Augment.AGLET_AUGMENT.get());

                        //-----Ingot Blocks
                        output.accept(BlockFlux.ALUMINUM_BLOCK.get());
                        output.accept(BlockFlux.BRONZE_BLOCK.get());
                        output.accept(BlockFlux.CONSTANTAN_BLOCK.get());
                        output.accept(BlockFlux.ELECTRUM_BLOCK.get());
                        output.accept(BlockFlux.INVAR_BLOCK.get());
                        output.accept(BlockFlux.LEAD_BLOCK.get());
                        output.accept(BlockFlux.LONSDALEITE_BLOCK.get());
                        output.accept(BlockFlux.NICKEL_BLOCK.get());
                        output.accept(BlockFlux.PLATINUM_BLOCK.get());
                        output.accept(BlockFlux.SILVER_BLOCK.get());
                        output.accept(BlockFlux.STEEL_BLOCK.get());
                        output.accept(BlockFlux.TIN_BLOCK.get());

                        //-----Ore Blocks
                        output.accept(BlockFlux.ALUMINUM_ORE.get());
                        output.accept(BlockFlux.ELECTRUM_ORE.get());
                        output.accept(BlockFlux.LEAD_ORE.get());
                        output.accept(BlockFlux.LONSDALEITE_ORE.get());
                        output.accept(BlockFlux.NICKEL_ORE.get());
                        output.accept(BlockFlux.PLATINUM_ORE.get());
                        output.accept(BlockFlux.SILVER_ORE.get());
                        output.accept(BlockFlux.TIN_ORE.get());

                        //-----Raw Blocks
                        output.accept(BlockFlux.RAW_ALUMINUM_BLOCK.get());
                        output.accept(BlockFlux.RAW_ALUMINUM_BLOCK.get());
                        output.accept(BlockFlux.RAW_LEAD_BLOCK.get());
                        output.accept(BlockFlux.RAW_LONSDALEITE_BLOCK.get());
                        output.accept(BlockFlux.RAW_NICKEL_BLOCK.get());
                        output.accept(BlockFlux.RAW_PLATINUM_BLOCK.get());
                        output.accept(BlockFlux.RAW_SILVER_BLOCK.get());
                        output.accept(BlockFlux.RAW_TIN_BLOCK.get());


                    })
                    .build()
    );

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        // Optional: Add steel apple to vanilla food tab
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(FoodFlux.STEEL_APPLE);
        }
    }
}
