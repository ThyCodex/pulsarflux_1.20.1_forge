package net.codex.pulsarflux.flux.sword.sworditems;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.particles.ParticleOptions;

public abstract class EffectSwordItem extends SwordItem {

    protected EffectSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    /** Called when sword hits an entity */
    public abstract void onHit(Player player, LivingEntity target);

    /** Particle helper */
    protected void spawnParticles(LivingEntity target, ParticleOptions type, int count, double xOff, double yOff, double zOff, double speed) {
        if (target.level() instanceof ServerLevel sLevel) {
            sLevel.sendParticles(type, target.getX(), target.getY() + 1.0, target.getZ(), count, xOff, yOff, zOff, speed);
        }
    }

    /** Effect helper */
    protected void applyEffect(LivingEntity entity, MobEffectInstance effect) {
        entity.addEffect(effect);
    }

    /** This is the missing piece: calls onHit whenever the sword hits */
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player player) {
            onHit(player, target);
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
