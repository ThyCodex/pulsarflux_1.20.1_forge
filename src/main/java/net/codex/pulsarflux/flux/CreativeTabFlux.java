package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = PulsarFlux.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabFlux {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PulsarFlux.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PULSARFLUX = TABS.register("pulsarflux",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.pulsarflux"))
                    .icon(ItemFlux.STEEL_APPLE.get()::getDefaultInstance)
                    .displayItems((displayParameters, output) -> {
                        //-----Food Creative Tab
                        output.accept(ItemFlux.STEEL_APPLE.get());

                        //-----Item Creative Tab
                        output.accept(ItemFlux.RAW_ALUMINUM.get());
                        output.accept(ItemFlux.RAW_ELECTRUM.get());
                        output.accept(ItemFlux.RAW_LEAD.get());
                        output.accept(ItemFlux.RAW_NICKEL.get());
                        output.accept(ItemFlux.RAW_PLATINUM.get());
                        output.accept(ItemFlux.RAW_SILVER.get());
                        output.accept(ItemFlux.RAW_TIN.get());

                        output.accept(ItemFlux.ALUMINUM_INGOT.get());
                        output.accept(ItemFlux.BRONZE_INGOT.get());
                        output.accept(ItemFlux.CONSTANT_INGOT.get());
                        output.accept(ItemFlux.ELECTRUM_INGOT.get());
                        output.accept(ItemFlux.INVAR_INGOT.get());
                        output.accept(ItemFlux.LEAD_INGOT.get());
                        output.accept(ItemFlux.NICKEL_INGOT.get());
                        output.accept(ItemFlux.PLATINUM_INGOT.get());
                        output.accept(ItemFlux.SILVER_INGOT.get());
                        output.accept(ItemFlux.STEEL_INGOT.get());
                        output.accept(ItemFlux.TIN_INGOT.get());

                        //-----Block Creative Tab

                        output.accept(ItemFlux.ALUMINUM_ORE_ITEM.get());
                        output.accept(ItemFlux.ELECTRUM_ORE_ITEM.get());
                        output.accept(ItemFlux.LEAD_ORE_ITEM.get());
                        output.accept(ItemFlux.NICKEL_ORE_ITEM.get());
                        output.accept(ItemFlux.PLATINUM_ORE_ITEM.get());
                        output.accept(ItemFlux.SILVER_ORE_ITEM.get());
                        output.accept(ItemFlux.TIN_ORE_ITEM.get());

                        output.accept(ItemFlux.RAW_ALUMINUM_BLOCK_ITEM.get());
                        output.accept(ItemFlux.RAW_ELECTRUM_BLOCK_ITEM.get());
                        output.accept(ItemFlux.RAW_LEAD_BLOCK_ITEM.get());
                        output.accept(ItemFlux.RAW_NICKEL_BLOCK_ITEM.get());
                        output.accept(ItemFlux.RAW_PLATINUM_BLOCK_ITEM.get());
                        output.accept(ItemFlux.RAW_SILVER_BLOCK_ITEM.get());
                        output.accept(ItemFlux.RAW_TIN_BLOCK_ITEM.get());

                        output.accept(ItemFlux.ALUMINUM_BLOCK_ITEM.get());
                        output.accept(ItemFlux.BRONZE_BLOCK_ITEM.get());
                        output.accept(ItemFlux.CONSTANT_BLOCK_ITEM.get());
                        output.accept(ItemFlux.ELECTRUM_BLOCK_ITEM.get());
                        output.accept(ItemFlux.INVAR_BLOCK_ITEM.get());
                        output.accept(ItemFlux.LEAD_BLOCK_ITEM.get());
                        output.accept(ItemFlux.NICKEL_BLOCK_ITEM.get());
                        output.accept(ItemFlux.PLATINUM_BLOCK_ITEM.get());
                        output.accept(ItemFlux.SILVER_BLOCK_ITEM.get());
                        output.accept(ItemFlux.STEEL_BLOCK_ITEM.get());
                        output.accept(ItemFlux.TIN_BLOCK_ITEM.get());
                    })
                    .build()
                    );
    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ItemFlux.STEEL_APPLE);
        }
    }
}
