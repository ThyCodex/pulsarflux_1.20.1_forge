package net.codex.pulsarflux;

import net.codex.pulsarflux.config.PulsarFluxConfig;
import net.codex.pulsarflux.flux.food.FoodItems;
import net.codex.pulsarflux.flux.sword.Sword;
import net.codex.pulsarflux.flux.trinket.Trinket;
import net.minecraftforge.fml.config.ModConfig;
import net.codex.pulsarflux.flux.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.ModLoadingContext;

import net.codex.pulsarflux.flux.MobItemDrops;
import net.minecraftforge.common.MinecraftForge;

@Mod(PulsarFlux.MOD_ID)
public class PulsarFlux {
    public static final String MOD_ID = "pulsarflux";

    public PulsarFlux() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register all DeferredRegisters
        FoodItems.register(bus);
        MaterialItems.register(bus);
        Sword.register(bus);
        ToolItems.register(bus);
        BlockItems.register(bus);
        CreativeTabFlux.TABS.register(bus);
        Trinket.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(new MobItemDrops());


        // Register mob tier events - currently disabled till fixed
        ///MobTierEvents.register();

        // ---- REGISTER CONFIG ----
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PulsarFluxConfig.COMMON_SPEC);
    }
}
