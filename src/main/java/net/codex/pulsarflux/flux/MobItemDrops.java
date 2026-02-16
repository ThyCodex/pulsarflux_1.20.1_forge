package net.codex.pulsarflux.flux;

import net.codex.pulsarflux.flux.food.FoodItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = "pulsarflux")
public class MobItemDrops {

    private static final Random RANDOM = new Random();

    /*
     * Specific mob drops (per EntityType)
     */
    private static final Map<EntityType<?>, List<Pair<Supplier<ItemStack>, Double>>> MOB_DROPS = Map.of(
            EntityType.ZOMBIE, List.of(
                    Pair.of(() -> new ItemStack(FoodItems.TIN_APPLE.get()), 0.05)
            )
    );

    /*
     * Category-based drops (ex: ALL hostile mobs)
     */
    private static final Map<MobCategory, List<Pair<Supplier<ItemStack>, Double>>> CATEGORY_DROPS = Map.of(
            MobCategory.MONSTER, List.of(
                    Pair.of(() -> new ItemStack(MaterialItems.SCRAP_TRINKET.get()), 0.03)
            )
    );

    @SubscribeEvent
    public static void onMobDrop(LivingDropsEvent event) {
        var entity = event.getEntity();

        // 🔥 Category drops (like all hostile mobs)
        List<Pair<Supplier<ItemStack>, Double>> categoryDrops =
                CATEGORY_DROPS.get(entity.getType().getCategory());

        if (categoryDrops != null) {
            for (Pair<Supplier<ItemStack>, Double> pair : categoryDrops) {
                if (RANDOM.nextDouble() < pair.getRight()) {
                    event.getDrops().add(new ItemEntity(
                            entity.level(),
                            entity.getX(),
                            entity.getY(),
                            entity.getZ(),
                            pair.getLeft().get()
                    ));
                }
            }
        }

        // 🎯 Specific mob drops
        List<Pair<Supplier<ItemStack>, Double>> drops =
                MOB_DROPS.get(entity.getType());

        if (drops != null) {
            for (Pair<Supplier<ItemStack>, Double> pair : drops) {
                if (RANDOM.nextDouble() < pair.getRight()) {
                    event.getDrops().add(new ItemEntity(
                            entity.level(),
                            entity.getX(),
                            entity.getY(),
                            entity.getZ(),
                            pair.getLeft().get()
                    ));
                }
            }
        }
    }

    /*
     * Simple immutable pair record
     */
    private record Pair<L, R>(L left, R right) {
        static <L, R> Pair<L, R> of(L left, R right) {
            return new Pair<>(left, right);
        }

        L getLeft() {
            return left;
        }

        R getRight() {
            return right;
        }
    }
}
