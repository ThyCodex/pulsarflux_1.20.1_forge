package net.codex.pulsarflux.flux.items;

import net.codex.pulsarflux.flux.TrinketItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class TreasureMagnetTrinketItem extends TrinketItem {

    private static final double RADIUS = 5.0; // radius in blocks to attract items
    private static final double SPEED = 0.3;  // speed at which items move towards player

    public TreasureMagnetTrinketItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(LivingEntity entity, ItemStack stack) {
        if (entity.level().isClientSide()) return;

        double radius = 5.0;
        double maxSpeed = 0.5;

        AABB area = new AABB(
                entity.getX() - radius, entity.getY() - radius, entity.getZ() - radius,
                entity.getX() + radius, entity.getY() + radius, entity.getZ() + radius
        );

        List<ItemEntity> items = entity.level().getEntitiesOfClass(ItemEntity.class, area);

        for (ItemEntity item : items) {
            double dx = entity.getX() - item.getX();
            double dy = entity.getY() + entity.getEyeHeight() / 2 - item.getY();
            double dz = entity.getZ() - item.getZ();

            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
            if (distance < 0.1) continue; // avoid crazy small distances

            // compute target velocity
            double speed = Math.min(maxSpeed, 0.3 * distance); // farther items move faster
            double vx = dx / distance * speed;
            double vy = dy / distance * speed;
            double vz = dz / distance * speed;

            item.setDeltaMovement(vx, vy, vz); // overwrite, don't add
            item.hasImpulse = true;
        }
    }
}
