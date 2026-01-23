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
                        output.accept(FoodFlux.STEEL_APPLE.get());

                        //-----Materials / Ingots
                        output.accept(MaterialFlux.RAW_ALUMINUM.get());
                        output.accept(MaterialFlux.RAW_ELECTRUM.get());
                        output.accept(MaterialFlux.RAW_LEAD.get());
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
                        output.accept(MaterialFlux.NICKEL_INGOT.get());
                        output.accept(MaterialFlux.PLATINUM_INGOT.get());
                        output.accept(MaterialFlux.SILVER_INGOT.get());
                        output.accept(MaterialFlux.STEEL_INGOT.get());
                        output.accept(MaterialFlux.TIN_INGOT.get());

                        //-----Swords
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

                        //-----Blocks
                        output.accept(BlockFluxItems.ALUMINUM_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.BRONZE_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.CONSTANTAN_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.ELECTRUM_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.INVAR_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.LEAD_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.NICKEL_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.PLATINUM_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.SILVER_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.STEEL_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.TIN_BLOCK_ITEM.get());

                        //-----Ore Blocks
                        output.accept(BlockFluxItems.ALUMINUM_ORE_ITEM.get());
                        output.accept(BlockFluxItems.ELECTRUM_ORE_ITEM.get());
                        output.accept(BlockFluxItems.LEAD_ORE_ITEM.get());
                        output.accept(BlockFluxItems.NICKEL_ORE_ITEM.get());
                        output.accept(BlockFluxItems.PLATINUM_ORE_ITEM.get());
                        output.accept(BlockFluxItems.SILVER_ORE_ITEM.get());
                        output.accept(BlockFluxItems.TIN_ORE_ITEM.get());

                        //-----Raw Blocks
                        output.accept(BlockFluxItems.RAW_ALUMINUM_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.RAW_ELECTRUM_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.RAW_LEAD_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.RAW_NICKEL_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.RAW_PLATINUM_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.RAW_SILVER_BLOCK_ITEM.get());
                        output.accept(BlockFluxItems.RAW_TIN_BLOCK_ITEM.get());

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
