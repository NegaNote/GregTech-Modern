package com.gregtechceu.gtceu.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static com.gregtechceu.gtceu.config.ConfigUtil.createConfigValue;
import static com.gregtechceu.gtceu.config.ConfigUtil.createConfigValueExtraDefault;
import static com.gregtechceu.gtceu.config.worldgen.OreVeinConfig.*;

public class WorldgenConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Float> RUBBER_TREE_SPAWN_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ALL_UNIQUE_STONE_TYPES;
    public static final ForgeConfigSpec.ConfigValue<Boolean> SAND_ORES_FALL;
    public static final ForgeConfigSpec.ConfigValue<Boolean> INCREASE_DUNGEON_LOOT;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ADD_LOOT;

    static {
        BUILDER.push("worldgen");

        RUBBER_TREE_SPAWN_CHANCE = createConfigValue(BUILDER, "rubber_tree_spawn_chance", 0.5f, 0f, 1f,
                "Rubber Tree spawn chance (decimal % per chunk)");
        ALL_UNIQUE_STONE_TYPES = createConfigValueExtraDefault(BUILDER, "all_unique_stone_types", false,
                "(meaning only Stone, Netherrack, and Endstone)",
                "Should all Stone Types drop unique Ore Item Blocks?");
        SAND_ORES_FALL = createConfigValue(BUILDER, "sand_ores_fall", false,
                "Should Sand-like ores fall?", "This includes gravel, sand, and red sand ores.");
        INCREASE_DUNGEON_LOOT = createConfigValue(BUILDER, "increase_dungeon_loot", true,
                "Whether to increase number of rolls for dungeon chests. Increases dungeon loot drastically.");
        ADD_LOOT = createConfigValue(BUILDER, "add_loot", true,
                "Allow GregTech to add additional GregTech Items as loot in various structures.");

        {
            BUILDER.comment("Ore vein configs");
            BUILDER.push("ore_veins");

            ORE_VEIN_GRID_SIZE = createConfigValue(BUILDER, "ore_vein_grid_size", 3, 1, 32,
                    "The grid size (in chunks) for ore vein generation");
            ORE_VEIN_RANDOM_OFFSET = createConfigValue(BUILDER, "ore_vein_random_offset", 12, 0, 32 * 16,
                    "The maximum random offset (in blocks) from the grid for generating an ore vein.");
            REMOVE_VANILLA_ORE_GEN = createConfigValue(BUILDER, "remove_vanilla_ore_gen", true,
                    "Prevents regular vanilla ores from being generated outside GregTech ore veins");
            REMOVE_VANILLA_LARGE_ORE_VEINS = createConfigValue(BUILDER, "remove_vanilla_large_ore_veins",
                    true, "Prevents vanilla's large ore veins from being generated");
            BEDROCK_ORE_DISTANCE = createConfigValue(BUILDER, "bedrock_ore_distance", 16,
                    "Distance between bedrock ore veins in chunks, if enabled.");
            INFINITE_BEDROCK_ORES_FLUIDS = createConfigValue(BUILDER, "infinite_bedrock_ores_fluids",
                    false, "Make bedrock ore/fluid veins infinite?");
            ORE_INDICATORS = createConfigValue(BUILDER, "ore_indicators", true,
                    "Generate ores indicators above ore veins");
            ORE_GENERATION_CHUNK_CACHE_SIZE = createConfigValueExtraDefault(BUILDER,
                    "ore_generation_chunk_cache_size", 512,
                    "(requires restarting the server / re-opening the world)",
                    "Sets the maximum number of chunks that may be cached for ore vein generation.",
                    "Higher values may improve world generation performance, but at the cost of more RAM usage.",
                    "If you substantially increase the ore vein grid size, random vein offset, or have very large (custom) veins, you may need to increase this value as well.");
            ORE_INDICATOR_CHUNK_CACHE_SIZE = createConfigValueExtraDefault(BUILDER,
                    "ore_indicator_chunk_cache_size", 2048,
                    "(requires restarting the server / re-opening the world)",
                    "Sets the maximum number of chunks for which ore indicators may be cached.",
                    "If you register any custom veins with very large indicator ranges (or modify existing ones that way), you may need to increase this value.");

            BUILDER.pop();
        }

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
