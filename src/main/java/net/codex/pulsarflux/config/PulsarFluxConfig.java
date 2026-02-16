package net.codex.pulsarflux.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class PulsarFluxConfig {

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        COMMON = new Common(builder);
        COMMON_SPEC = builder.build();
    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue enableMobTiers;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("mob_tiers"); // Section name
            enableMobTiers = builder
                    .comment("Enable the star tier system for mobs. Set to false to disable completely.")
                    .define("enableMobTiers", true);
            builder.pop();
        }
    }
}
