package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.PulsarFlux;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class Augment {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PulsarFlux.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    //---place holder
    public static final RegistryObject<Item> EMPTY_AUGMENT_SLOT = ITEMS.register("empty_augment_slot",
            () -> new Item(new Item.Properties().stacksTo(1))
    );


    // Example aglet augment
    public static final RegistryObject<Item> AGLET_AUGMENT = ITEMS.register("aglet_augment",
            () -> new AugmentHandler(
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 0, false, false),
                    false, // show particles
                    Set.of("offhand", "augment"), // only works in offhand or augment
                    new Item.Properties().stacksTo(1)
            )
    );

}


