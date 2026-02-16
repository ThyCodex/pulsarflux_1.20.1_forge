package net.codex.pulsarflux.flux.food;

import net.codex.pulsarflux.PulsarFlux;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FoodItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PulsarFlux.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    public static final RegistryObject<Item> TIN_APPLE = ITEMS.register("tin_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.JUMP, 300, 0), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.tin_apple"
            ));
    public static final RegistryObject<Item> ALUMINUM_APPLE = ITEMS.register("aluminum_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.aluminum_apple"
            ));
    public static final RegistryObject<Item> BRONZE_APPLE = ITEMS.register("bronze_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.bronze_apple"
            ));
    public static final RegistryObject<Item> LEAD_APPLE = ITEMS.register("lead_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.lead_apple"
            ));
    public static final RegistryObject<Item> NICKEL_APPLE = ITEMS.register("nickel_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.nickel_apple"
            ));
    public static final RegistryObject<Item> INVAR_APPLE = ITEMS.register("invar_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.invar_apple"
            ));
    public static final RegistryObject<Item> CONSTANTAN_APPLE = ITEMS.register("constantan_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.constantan_apple"
            ));
    public static final RegistryObject<Item> ELECTRUM_APPLE = ITEMS.register("electrum_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.LUCK, 300, 0), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.electrum_apple"
            ));
    public static final RegistryObject<Item> SILVER_APPLE = ITEMS.register("silver_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.silver_apple"
            ));
    public static final RegistryObject<Item> STEEL_APPLE = ITEMS.register("steel_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.steel_apple"
            ));
    public static final RegistryObject<Item> PLATINUM_APPLE = ITEMS.register("platinum_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.JUMP, 300, 1), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.platinum_apple"
            ));
    public static final RegistryObject<Item> LONSDALEITE_APPLE = ITEMS.register("lonsdaleite_apple",
            () -> new FoodTooltipItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.LUCK, 300, 1), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1), 1.0f)
                    .build()).rarity(Rarity.EPIC),"tooltip.pulsarflux.lonsdaleite_apple"
            ));
}
