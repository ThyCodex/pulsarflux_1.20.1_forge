package net.codex.pulsarflux;

import net.codex.pulsarflux.flux.BlockFlux;
import net.codex.pulsarflux.flux.BlockFluxItems;
import net.codex.pulsarflux.flux.CreativeTabFlux;
import net.codex.pulsarflux.flux.FoodFlux;
import net.codex.pulsarflux.flux.MaterialFlux;
import net.codex.pulsarflux.flux.SwordFlux;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PulsarFlux.MOD_ID)
public class PulsarFlux {
    public static final String MOD_ID = "pulsarflux";

    public PulsarFlux() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register all DeferredRegisters
        FoodFlux.register(bus);
        MaterialFlux.register(bus);
        SwordFlux.register(bus);
        BlockFlux.BLOCKS.register(bus);
        BlockFluxItems.register(bus);
        CreativeTabFlux.TABS.register(bus);
    }
}
