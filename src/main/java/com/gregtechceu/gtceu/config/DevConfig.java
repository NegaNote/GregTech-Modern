package com.gregtechceu.gtceu.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static com.gregtechceu.gtceu.config.ConfigUtil.createConfigValue;

public class DevConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> DEBUG;

    public static final ForgeConfigSpec.ConfigValue<Boolean> DEBUG_WORLDGEN;

    public static final ForgeConfigSpec.ConfigValue<Boolean> DO_SUPERFLAT_ORES;

    public static final ForgeConfigSpec.ConfigValue<Boolean> DUMP_RECIPES;
    public static final ForgeConfigSpec.ConfigValue<Boolean> DUMP_ASSETS;

    static {
        BUILDER.push("dev");

        DEBUG = createConfigValue(BUILDER, "debug", false,
                "Debug general events? (will print recipe conficts etc. to server's debug.log)");

        DEBUG_WORLDGEN = createConfigValue(BUILDER, "debug_worldgen", false,
                "Debug ore vein placement? (will print placed veins to server's debug.log)");

        DO_SUPERFLAT_ORES = createConfigValue(BUILDER, "do_superflat_ores", false,
                "Generate ores in superflat worlds?");

        DUMP_RECIPES = createConfigValue(BUILDER, "dump_recipes", false,
                "Dump all registered GT recipes?");
        DUMP_ASSETS = createConfigValue(BUILDER, "dump_assets", false,
                "Dump all registered GT models/blockstates/etc?");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
