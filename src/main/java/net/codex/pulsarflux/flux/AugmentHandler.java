package net.codex.pulsarflux.flux;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;

public class AugmentHandler extends Item {

    private final MobEffectInstance effect;

    public AugmentHandler(MobEffectInstance effect, Properties properties) {
        super(properties);
        this.effect = effect;
    }

    public MobEffectInstance getEffect() {
        return effect;
    }
}
