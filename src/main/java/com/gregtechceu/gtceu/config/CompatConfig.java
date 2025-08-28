package com.gregtechceu.gtceu.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static com.gregtechceu.gtceu.config.ConfigUtil.createConfigValue;
import static com.gregtechceu.gtceu.config.compat.AE2CompatConfig.*;
import static com.gregtechceu.gtceu.config.compat.EnergyCompatConfig.*;
import static com.gregtechceu.gtceu.config.compat.MinimapCompatConfig.*;

public class CompatConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue HIDE_FACADES_IN_RECIPE_VIEWER;
    public static final ForgeConfigSpec.BooleanValue HIDE_FILLED_CELLS_IN_RECIPE_VIEWER;

    public static final ForgeConfigSpec.BooleanValue HIDE_ORE_PROCESSING_DIAGRAMS;

    public static final ForgeConfigSpec.BooleanValue REMOVE_SMELTING_FOR_EBF_METALS;

    public static final ForgeConfigSpec.BooleanValue SHOW_DIMENSION_TIER;

    static {
        BUILDER.push("compat");

        HIDE_FACADES_IN_RECIPE_VIEWER = createConfigValue(BUILDER, "hide_facades_in_recipe_viewer", true,
                "Whether to hide facades of all blocks in JEI and creative search menu.");
        HIDE_FILLED_CELLS_IN_RECIPE_VIEWER = createConfigValue(BUILDER, "hide_filled_cells_in_recipe_viewer", true,
                "Whether to hide filled cells in JEI and creative search menu.");

        HIDE_ORE_PROCESSING_DIAGRAMS = createConfigValue(BUILDER, "hide_ore_processing_diagrams", false,
                "Whether to hide the ore processing diagrams in JEI/REI/EMI");

        REMOVE_SMELTING_FOR_EBF_METALS = createConfigValue(BUILDER, "remove_smelting_for_ebf_metals", true,
                "Whether Gregtech should remove smelting recipes from the vanilla furnace for ingots requiring the Electric Blast Furnace.");

        SHOW_DIMENSION_TIER = createConfigValue(BUILDER, "show_dimension_tier", false,
                "Whether dimension markers should show the dimension tier value.");

        {
            BUILDER.comment("Config options regarding GTEU compatibility with other energy systems");
            BUILDER.push("energy_compat");

            NATIVE_EU_TO_FE = createConfigValue(BUILDER, "native_eu_to_fe", true,
                    "Enable Native GTEU to Forge Energy (RF and alike) on GT Cables and Wires.");
            ENABLE_FE_CONVERTERS = createConfigValue(BUILDER, "enable_fe_converters", false,
                    "Enable GTEU to FE (and vice versa) Converters.");
            FE_USED_TO_MAKE_EU = createConfigValue(BUILDER, "fe_used_to_make_eu", 4,
                    "Conversion factor when making EU from FE, in the form of the amount of FE used to make 1 EU.",
                    "Only affects converters.");
            FE_MADE_FROM_EU = createConfigValue(BUILDER, "fe_made_from_eu", 4,
                    "Conversion factor when making FE from EU, in the form of the amount of FE you get from 1 EU.",
                    "Affects native conversion and Converters.");

            BUILDER.pop();
        }

        {
            BUILDER.comment("Config options regarding GTCEu compatibility with AE2");
            BUILDER.push("ae2_compat");

            UPDATE_INTERVALS = createConfigValue(BUILDER, "update_intervals", 40, 1, Integer.MAX_VALUE,
                    "The interval between when the times ME Hatches/Buses interact with the ME network, in ticks.");
            ME_HATCH_ENERGY_USAGE = createConfigValue(BUILDER, "me_hatch_energy_usage", 4.0f, 0f, Integer.MAX_VALUE,
                    "The energy consumption of ME Hatches/Buses, in AE/t.");

            BUILDER.pop();
        }

        {
            BUILDER.comment("Config options regarding GTCEu compatibility with minimap mods");
            BUILDER.push("minimap_compat");

            SURFACE_ROCK_PROSPECT_RANGE = createConfigValue(BUILDER, "surface_rock_prospect_range", 24, -1,
                    Integer.MAX_VALUE,
                    "The radius, in blocks, that picking up a surface rock will search for veins in.",
                    "-1 to disable.");
            ORE_BLOCK_PROSPECT_RANGE = createConfigValue(BUILDER, "ore_block_prospect_range", 24, -1, Integer.MAX_VALUE,
                    "The radius, in blocks, that clicking an ore block will search for veins in.",
                    "-1 to disable");

            ORE_SCALE_STOP = createConfigValue(BUILDER, "ore_scale_stop", 1f, 0.1f, 16f,
                    "The map scale at which displayed ores will stop scaling.");

            ORE_ICON_SIZE = createConfigValue(BUILDER, "ore_icon_size", 32, 4, Integer.MAX_VALUE,
                    "The size, in pixels, of ore icons on the map");

            ORE_NAME_PREFIX = createConfigValue(BUILDER, "ore_name_prefix", "- ",
                    "The string prepending ore names in the ore vein tooltip");

            BORDER_COLOR = createConfigValue(BUILDER, "border_color", "#00000000",
                    "The color to draw a box around the ore icon with.",
                    "Accepts either an ARGB hex color prefixed with # or the string 'material' to use the ore's material color");

            BUTTON_ANCHOR = createConfigValue(BUILDER, "button_anchor", Anchor.BOTTOM_LEFT,
                    "Which part of the screen to anchor buttons to");

            DIRECTION = createConfigValue(BUILDER, "direction", Direction.VERTICAL,
                    "Which direction the buttons will go");

            X_OFFSET = createConfigValue(BUILDER, "x_offset", 20,
                    "How horizontally far away from the anchor to place the buttons");
            Y_OFFSET = createConfigValue(BUILDER, "y_offset", 0,
                    "How vertically far away from the anchor to place the buttons");

            {
                BUILDER.comment("Toggle specific map mod integration on/off (need to restart for this to take effect)");
                BUILDER.push("toggle");

                FTB_CHUNKS_INTEGRATION = createConfigValue(BUILDER, "ftb_chunks_integration", false,
                        "FTB Chunks integration enabled");
                JOURNEY_MAP_INTEGRATION = createConfigValue(BUILDER, "journey_map_integration", true,
                        "Journey Map integration enabled");
                XAEROS_MAP_INTEGRATION = createConfigValue(BUILDER, "xaeros_map_integration", true,
                        "Xaero's map integration enabled");

                BUILDER.pop();
            }
            BUILDER.pop();
        }

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
