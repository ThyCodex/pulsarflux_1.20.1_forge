package net.codex.pulsarflux.flux.sword;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class CommonSwordItem extends SwordItem {
    public CommonSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }
}
