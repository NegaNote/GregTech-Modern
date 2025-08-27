package com.gregtechceu.gtceu.config.worldgen;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreVeinConfig {

    public static ForgeConfigSpec.ConfigValue<Integer> ORE_VEIN_GRID_SIZE;
    public static ForgeConfigSpec.ConfigValue<Integer> ORE_VEIN_RANDOM_OFFSET;
    public static ForgeConfigSpec.BooleanValue REMOVE_VANILLA_ORE_GEN;
    public static ForgeConfigSpec.BooleanValue REMOVE_VANILLA_LARGE_ORE_VEINS;
    public static ForgeConfigSpec.ConfigValue<Integer> BEDROCK_ORE_DISTANCE;
    public static ForgeConfigSpec.BooleanValue INFINITE_BEDROCK_ORES_FLUIDS;
    public static ForgeConfigSpec.BooleanValue ORE_INDICATORS;
    public static ForgeConfigSpec.ConfigValue<Integer> ORE_GENERATION_CHUNK_CACHE_SIZE;
    public static ForgeConfigSpec.ConfigValue<Integer> ORE_INDICATOR_CHUNK_CACHE_SIZE;
}
