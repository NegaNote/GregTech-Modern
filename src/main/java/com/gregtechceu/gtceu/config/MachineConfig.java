package com.gregtechceu.gtceu.config;

import com.gregtechceu.gtceu.api.GTCEuAPI;

import net.minecraftforge.common.ForgeConfigSpec;

import static com.gregtechceu.gtceu.config.ConfigUtil.createConfigValue;

public class MachineConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue REQUIRE_GT_TOOLS_FOR_BLOCKS;
    public static final ForgeConfigSpec.BooleanValue SHOULD_WEATHER_OR_TERRAIN_CAUSE_EXPLOSIONS;
    public static final ForgeConfigSpec.ConfigValue<Integer> ENERGY_USAGE_MULTIPLIER;
    public static final ForgeConfigSpec.ConfigValue<Integer> PROSPECTOR_ENERGY_USAGE_MULTIPLIER;

    public static final ForgeConfigSpec.BooleanValue EXPLOSIONS_DAMAGE_TERRAIN;
    public static final ForgeConfigSpec.BooleanValue HARMLESS_ACTIVE_TRANSFORMERS;
    public static final ForgeConfigSpec.BooleanValue MACHINE_SOUNDS;
    public static final ForgeConfigSpec.ConfigValue<Integer> BATCH_DURATION;

    public static final ForgeConfigSpec.BooleanValue STEEL_STEAM_MULTIBLOCKS;
    public static final ForgeConfigSpec.ConfigValue<Integer> STEAM_MULTI_PARALLEL_AMOUNT;

    public static final ForgeConfigSpec.BooleanValue ENABLE_CLEANROOM;
    public static final ForgeConfigSpec.BooleanValue CLEAN_MULTIBLOCKS;

    public static final ForgeConfigSpec.ConfigValue<String> REPLACE_MINED_BLOCKS_WITH;

    public static final ForgeConfigSpec.BooleanValue ENABLE_RESEARCH;
    public static final ForgeConfigSpec.BooleanValue ENABLE_MAINTENANCE;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAINTENANCE_TIME;

    public static final ForgeConfigSpec.BooleanValue ENABLE_WORLD_ACCELERATORS;
    public static final ForgeConfigSpec.ConfigValue<String[]> WORLD_ACCELERATOR_BLACKLIST;

    public static final ForgeConfigSpec.BooleanValue GT6_STYLE_PIPES_CABLES;
    public static final ForgeConfigSpec.BooleanValue GHOST_CIRCUIT;

    public static final ForgeConfigSpec.BooleanValue DO_BEDROCK_ORES;
    public static final ForgeConfigSpec.ConfigValue<String> BEDROCK_ORE_DROP_TAG_PREFIX;
    public static final ForgeConfigSpec.ConfigValue<Integer> MINER_SPEED;

    public static final ForgeConfigSpec.ConfigValue<Integer> LONG_DISTANCE_ITEM_PIPE_MIN_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Integer> LONG_DISTANCE_FLUID_PIPE_MIN_DISTANCE;

    /**
     * <strong>Addons mods should not reference this config directly.</strong>
     * Use {@link GTCEuAPI#isHighTier()} instead.
     */
    public static final ForgeConfigSpec.BooleanValue HIGH_TIER_CONTENT;

    public static final ForgeConfigSpec.BooleanValue ORDERED_ASSEMBLY_LINE_ITEMS;
    public static final ForgeConfigSpec.BooleanValue ORDERED_ASSEMBLY_LINE_FLUIDS;

    static {
        BUILDER.push("machines");

        REQUIRE_GT_TOOLS_FOR_BLOCKS = createConfigValue(BUILDER, "require_gt_tools_for_blocks", true,
                "Whether to require a Wrench, Wirecutter, or other GregTech tools to break machines, casings, wires, and more.");
        SHOULD_WEATHER_OR_TERRAIN_CAUSE_EXPLOSIONS = createConfigValue(BUILDER,
                "should_weather_or_terrain_cause_explosions", false,
                "Whether machines explode in rainy weather or when placed next to certain terrain, such as fire or lava");
        ENERGY_USAGE_MULTIPLIER = createConfigValue(BUILDER, "energy_usage_multiplier", 100,
                "Energy use multiplier for electric items.");
        PROSPECTOR_ENERGY_USAGE_MULTIPLIER = createConfigValue(BUILDER, "prospector_energy_usage_multiplier", 100,
                "Energy use multiplier for prospectors.");

        EXPLOSIONS_DAMAGE_TERRAIN = createConfigValue(BUILDER, "explosions_damage_terrain", true,
                "Whether machines or boilers damage the terrain when they explode.",
                "Note machines and boilers always explode when overloaded with power or met with special conditions, regardless of this config.");
        HARMLESS_ACTIVE_TRANSFORMERS = createConfigValue(BUILDER, "harmless_active_transformers", false,
                "Enables Safe Active Transformers, removing their ability to explode if unformed while transmitting/receiving power.");
        MACHINE_SOUNDS = createConfigValue(BUILDER, "machine_sounds", true,
                "Whether to play machine sounds while machines are active.");
        BATCH_DURATION = createConfigValue(BUILDER, "batch_duration", 100,
                "Duration in ticks that batching will try to reach.");

        STEEL_STEAM_MULTIBLOCKS = createConfigValue(BUILDER, "steel_steam_multiblocks", false,
                "Whether Steam Multiblocks should use Steel instead of Bronze.");
        STEAM_MULTI_PARALLEL_AMOUNT = createConfigValue(BUILDER, "steam_multi_parallel_amount", 8,
                "Default maximum parallel of steam multiblocks");

        ENABLE_CLEANROOM = createConfigValue(BUILDER, "enable_cleanroom", true,
                "Whether to enable the cleanroom, required for various recipes.");
        CLEAN_MULTIBLOCKS = createConfigValue(BUILDER, "clean_multiblocks", false,
                "Whether multiblocks should ignore all cleanroom requirements.",
                "This does nothing if enableCleanroom is false.");

        REPLACE_MINED_BLOCKS_WITH = createConfigValue(BUILDER, "replace_mined_blocks_with", "minecraft:cobblestone",
                "Block to replace mined ores with in the miner and multiblock miner.");

        ENABLE_RESEARCH = createConfigValue(BUILDER, "enable_research", true,
                "Whether to enable Assembly Line research for recipes.");
        ENABLE_MAINTENANCE = createConfigValue(BUILDER, "enable_maintenance", true,
                "Whether to enable the Maintenance Hatch, required for Multiblocks.");
        MAINTENANCE_TIME = createConfigValue(BUILDER, "maintenance_time", 3_456_000,
                "Time in ticks between when Multiblocks can require Maintenance. By default, 48 hours.");

        ENABLE_WORLD_ACCELERATORS = createConfigValue(BUILDER, "enable_world_accelerators", true,
                "Whether to enable World Accelerators, which accelerate ticks for surrounding Tile Entities, Crops, etc.");
        WORLD_ACCELERATOR_BLACKLIST = createConfigValue(BUILDER, "world_accelerator_blacklist", new String[0],
                "List of BlockEntities that the World Accelerator should not accelerate.",
                "GregTech TileEntities are always blocked.",
                "Entries must be in a fully qualified format. For example: appeng.tile.networking.TileController");

        GT6_STYLE_PIPES_CABLES = createConfigValue(BUILDER, "gt6_style_pipes_cables", true,
                "Whether to use GT6-style pipe and cable connections, meaning they will not auto-connect " +
                        "unless placed directly onto another pipe or cable.");
        GHOST_CIRCUIT = createConfigValue(BUILDER, "ghost_circuit", true,
                "Whether the circuit slot in machine inventories is fake.");

        DO_BEDROCK_ORES = createConfigValue(BUILDER, "do_bedrock_ores", false,
                "Whether to add a \"Bedrock Ore Miner\" (also enables bedrock ore generation)");
        BEDROCK_ORE_DROP_TAG_PREFIX = createConfigValue(BUILDER, "bedrock_ore_drop_tag_prefix", "raw",
                "What Kind of material should the bedrock ore miner output?");
        MINER_SPEED = createConfigValue(BUILDER, "miner_speed", 320, 120, 800,
                "The base amount of ticks per block for electric singleblock ore miners");

        LONG_DISTANCE_ITEM_PIPE_MIN_DISTANCE = createConfigValue(BUILDER, "long_distance_item_pipe_min_distance", 50,
                "Minimum distance between Long Distance Item Pipe Endpoints");
        LONG_DISTANCE_FLUID_PIPE_MIN_DISTANCE = createConfigValue(BUILDER, "long_distance_fluid_pipe_min_distance", 50,
                "Minimum distance between Long Distance Fluid Pipe Endpoints");

        HIGH_TIER_CONTENT = createConfigValue(BUILDER, "high_tier_content", false,
                "If High Tier (>UV-tier) GT content should be registered.",
                "Items and Machines enabled with this config will have missing recipes by default.",
                "This is intended for modpack developers only, and is not playable without custom tweaks or addons.",
                "Other mods can override this to true, regardless of the config file.");

        ORDERED_ASSEMBLY_LINE_ITEMS = createConfigValue(BUILDER, "ordered_assembly_line_items", true,
                "Whether the Assembly Line should require the item inputs to be in order.");
        ORDERED_ASSEMBLY_LINE_FLUIDS = createConfigValue(BUILDER, "ordered_assembly_line_fluids", true,
                "Whether the Assembly Line should require the fluid inputs to be in order.",
                "(Requires Ordered Assembly Line Item Inputs to be enabled.)");

        {
            BUILDER.push("small_boilers");

            BUILDER.pop();
        }

        {
            BUILDER.push("large_boilers");

            BUILDER.pop();
        }

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
