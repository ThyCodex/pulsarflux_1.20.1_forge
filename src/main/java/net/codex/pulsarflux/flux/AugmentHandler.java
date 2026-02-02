package net.codex.pulsarflux.flux;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;

public class AugmentHandler extends Item {

    private final MobEffectInstance effect;
    private final boolean showParticles;

    /**
     * @param effect The MobEffectInstance to apply
     * @param showParticles Whether the effect should show particles
     * @param properties Item properties
     */
    public AugmentHandler(MobEffectInstance effect, boolean showParticles, Properties properties) {
        super(properties);
        this.effect = effect;
        this.showParticles = showParticles;
    }

    public MobEffectInstance getEffect() {
        return effect;
    }

    public boolean shouldShowParticles() {
        return showParticles;
    }
}
