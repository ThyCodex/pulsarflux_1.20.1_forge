package net.codex.pulsarflux.flux;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;

import java.util.Set;

public class AugmentHandler extends Item {

    private final MobEffectInstance effect;
    private final boolean showParticles;
    private final Set<String> validSlots;

    public AugmentHandler(MobEffectInstance effect, boolean showParticles, Set<String> validSlots, Properties properties) {
        super(properties.stacksTo(1)); // max stack 1
        this.effect = effect;
        this.showParticles = showParticles;
        this.validSlots = validSlots;
    }

    public MobEffectInstance getEffect() {
        return effect;
    }

    public boolean shouldShowParticles() {
        return showParticles;
    }

    public boolean isSlotValid(String slot) {
        return validSlots.contains(slot);
    }
}
