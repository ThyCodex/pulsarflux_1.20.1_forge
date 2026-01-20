package net.codex.pulsarflux;

import net.codex.pulsarflux.flux.BlockFlux;
import net.codex.pulsarflux.flux.CreativeTabFlux;
import net.codex.pulsarflux.flux.ItemFlux;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PulsarFlux.MOD_ID)
public class PulsarFlux {
    public static final String MOD_ID = "pulsarflux";

    public PulsarFlux() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemFlux.ITEMS.register(bus);
        BlockFlux.BLOCKS.register(bus);
        CreativeTabFlux.TABS.register(bus);
    }
}

