package com.gregtechceu.gtceu.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static com.gregtechceu.gtceu.config.ConfigUtil.*;

public class RecipesConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue GENERATE_LOW_QUALITY_GEMS;
    public static final ForgeConfigSpec.BooleanValue DISABLE_MANUAL_COMPRESSION;
    public static final ForgeConfigSpec.BooleanValue HARDER_RODS;
    public static final ForgeConfigSpec.BooleanValue HARDER_BRICK_RECIPES;
    public static final ForgeConfigSpec.BooleanValue NERF_WOOD_CRAFTING;
    public static final ForgeConfigSpec.BooleanValue HARD_WOOD_RECIPES;
    public static final ForgeConfigSpec.BooleanValue HARD_IRON_RECIPES;
    public static final ForgeConfigSpec.BooleanValue HARD_REDSTONE_RECIPES;
    public static final ForgeConfigSpec.BooleanValue HARD_TOOL_ARMOR_RECIPES;
    public static final ForgeConfigSpec.BooleanValue HARD_MISC_RECIPES;
    public static final ForgeConfigSpec.BooleanValue HARD_GLASS_RECIPES;
    public static final ForgeConfigSpec.BooleanValue NERF_PAPER_CRAFTING;
    public static final ForgeConfigSpec.BooleanValue HARD_ADVANCED_IRON_RECIPES;
    public static final ForgeConfigSpec.BooleanValue HARD_DYE_RECIPES;
    public static final ForgeConfigSpec.BooleanValue HARDER_CHARCOAL_RECIPE;
    public static final ForgeConfigSpec.BooleanValue FLINT_AND_STEEL_REQUIRE_STEEL;
    public static final ForgeConfigSpec.BooleanValue REMOVE_VANILLA_BLOCK_RECIPES;
    public static final ForgeConfigSpec.BooleanValue REMOVE_VANILLA_TNT_RECIPE;
    public static final ForgeConfigSpec.IntValue CASINGS_PER_CRAFT;
    public static final ForgeConfigSpec.BooleanValue HARDER_CIRCUIT_RECIPES;
    public static final ForgeConfigSpec.BooleanValue HARD_MULTI_RECIPES;
    public static final ForgeConfigSpec.BooleanValue ENCHANTED_TOOLS;
    public static final ForgeConfigSpec.BooleanValue ENABLE_MACERATOR_RECYCLING;
    public static final ForgeConfigSpec.ConfigValue<Float> MACERATOR_RECYCLING_YIELD;
    public static final ForgeConfigSpec.BooleanValue ENABLE_ARC_RECYCLING;
    public static final ForgeConfigSpec.ConfigValue<Float> ARC_RECYCLING_YIELD;
    public static final ForgeConfigSpec.BooleanValue ENABLE_EXTRACTOR_RECYCLING;
    public static final ForgeConfigSpec.ConfigValue<Float> EXTRACTOR_RECYCLING_YIELD;

    static {
        BUILDER.push("recipes");

        GENERATE_LOW_QUALITY_GEMS = createConfigValue(BUILDER, "generate_low_quality_gems", false,
                "Whether to generate Flawed and Chipped Gems for materials and recipes involving them.",
                "Useful for mods like TerraFirmaCraft.");

        DISABLE_MANUAL_COMPRESSION = createConfigValue(BUILDER, "disable_manual_compression", true,
                "Whether to remove Block/Ingot compression and decompression in the Crafting Table.");

        HARDER_RODS = createConfigValue(BUILDER, "harder_rods", true,
                "Change the recipe of Rods in the Lathe to 1 Rod and 2 Small Piles of Dust, instead of 2 Rods.");

        HARDER_BRICK_RECIPES = createConfigValue(BUILDER, "harder_brick_recipes", false,
                "Whether to make crafting recipes for Bricks, Firebricks, Nether Bricks, and Coke Bricks harder.");

        NERF_WOOD_CRAFTING = createConfigValue(BUILDER, "nerf_wood_crafting", false,
                "Whether to nerf Wood crafting to 2 Planks from 1 Log, and 2 Sticks from 2 Planks.");

        HARD_WOOD_RECIPES = createConfigValue(BUILDER, "hard_wood_recipes", false,
                "Whether to make Wood related recipes harder.", "Excludes sticks and planks.");

        HARD_IRON_RECIPES = createConfigValue(BUILDER, "hard_iron_recipes", true,
                "Recipes for Buckets, Cauldrons, Hoppers, and Iron Bars require Iron Plates, Rods, and more.");

        HARD_REDSTONE_RECIPES = createConfigValue(BUILDER, "hard_redstone_recipes", false,
                "Whether to make Redstone related recipes harder.");

        HARD_TOOL_ARMOR_RECIPES = createConfigValue(BUILDER, "hard_tool_armor_recipes", false,
                "Whether to make Vanilla Tools and Armor recipes harder.", "Excludes Flint and Steel, and Buckets.");

        HARD_MISC_RECIPES = createConfigValue(BUILDER, "hard_misc_recipes", false,
                "Whether to make miscellaneous recipes harder.");

        HARD_GLASS_RECIPES = createConfigValue(BUILDER, "hard_glass_recipes", true,
                "Whether to make Glass related recipes harder.");

        NERF_PAPER_CRAFTING = createConfigValue(BUILDER, "nerf_paper_crafting", true,
                "Whether to nerf the Paper crafting recipe.");

        HARD_ADVANCED_IRON_RECIPES = createConfigValue(BUILDER, "hard_advanced_iron_recipes", true,
                "Recipes for items like Iron Doors, Trapdoors, Anvil require Iron Plates, Rods, and more.");

        HARD_DYE_RECIPES = createConfigValue(BUILDER, "hard_dye_recipes", false,
                "Whether to make coloring blocks like Concrete or Glass harder.");

        HARDER_CHARCOAL_RECIPE = createConfigValue(BUILDER, "harder_charcoal_recipe", true,
                "Whether to remove charcoal smelting recipes from the vanilla furnace.");

        FLINT_AND_STEEL_REQUIRE_STEEL = createConfigValue(BUILDER, "flint_and_steel_require_steel", true,
                "Whether to make the Flint and Steel recipe require steel parts.");

        REMOVE_VANILLA_BLOCK_RECIPES = createConfigValue(BUILDER, "remove_vanilla_block_recipes", false,
                "Whether to remove Vanilla Block Recipes from the Crafting Table.");

        REMOVE_VANILLA_TNT_RECIPE = createConfigValue(BUILDER, "remove_vanilla_tnt_recipe", true,
                "Whether to remove Vanilla TNT Recipe from the Crafting Table.");

        CASINGS_PER_CRAFT = createConfigValue(BUILDER, "casings_per_craft", 2, 1, 3,
                "How many Multiblock Casings to make per craft.");

        HARDER_CIRCUIT_RECIPES = createConfigValue(BUILDER, "harder_circuit_recipes", false,
                "Whether to nerf the output amounts of the first circuit in a set to 1 (from 2) and SoC to 2 (from 4).");

        HARD_MULTI_RECIPES = createConfigValue(BUILDER, "hard_multi_recipes", false,
                "Whether to nerf machine controller recipes.");

        ENCHANTED_TOOLS = createConfigValue(BUILDER, "enchanted_tools", false,
                "Whether tools should have enchants or not, e.g. the flint sword getting fire aspect.");

        ENABLE_MACERATOR_RECYCLING = createConfigValue(BUILDER, "enable_macerator_recycling", true,
                "Whether to enable macerator decomposition recycling");

        MACERATOR_RECYCLING_YIELD = createConfigValue(BUILDER, "macerator_recycling_yield", 1.0f, 0.0f, 1.0f,
                "Percentage yield of macerator decomposition recycling outputs, 1.0 means 100%");

        ENABLE_ARC_RECYCLING = createConfigValue(BUILDER, "enable_arc_recycling", true,
                "Whether to enable arc furnace decomposition recycling");

        ARC_RECYCLING_YIELD = createConfigValue(BUILDER, "arc_recycling_yield", 1.0f, 0.0f, 1.0f,
                "Percentage yield of arc furnace decomposition recycling outputs, 1.0 means 100%");

        ENABLE_EXTRACTOR_RECYCLING = createConfigValue(BUILDER, "enable_extractor_recycling", true,
                "Whether to enable extractor decomposition recycling");

        EXTRACTOR_RECYCLING_YIELD = createConfigValue(BUILDER, "extractor_recycling_yield", 1.0f, 0.0f, 1.0f,
                "Percentage yield of extractor decomposition recycling outputs, 1.0 means 100%");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
