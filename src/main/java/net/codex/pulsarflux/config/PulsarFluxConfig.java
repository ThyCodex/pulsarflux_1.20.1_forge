package net.codex.pulsarflux.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class PulsarFluxConfig {

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        Common.Builder builder = new Common.Builder();
        COMMON_SPEC = builder.build();
        COMMON = builder.common;
    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue enableMobTiers;

        private final Builder builder;

        public Common(Builder builder, ForgeConfigSpec.Builder forgeBuilder) {
            this.builder = builder;

            forgeBuilder.push("mob_tiers");
            enableMobTiers = forgeBuilder
                    .comment("Enable the star tier system for mobs. Set to false to disable completely.")
                    .define("enableMobTiers", true);
            forgeBuilder.pop();
        }

        public static class Builder {
            private Common common;
            public ForgeConfigSpec build() {
                ForgeConfigSpec.Builder forgeBuilder = new ForgeConfigSpec.Builder();
                common = new Common(this, forgeBuilder);
                return forgeBuilder.build();
            }
        }
    }
}
