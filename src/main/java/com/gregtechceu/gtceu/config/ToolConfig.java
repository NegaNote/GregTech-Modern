package com.gregtechceu.gtceu.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static com.gregtechceu.gtceu.config.ConfigUtil.createConfigValue;
import static com.gregtechceu.gtceu.config.ConfigUtil.createConfigValueExtraDefault;
import static com.gregtechceu.gtceu.config.tools.NanoSaberConfig.*;

public class ToolConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> RNG_DAMAGE_ELECTRIC_TOOLS;

    public static final ForgeConfigSpec.ConfigValue<Integer> SPRAY_CAN_CHAIN_LENGTH;

    public static final ForgeConfigSpec.ConfigValue<Integer> TREE_FELLING_DELAY;

    public static final ForgeConfigSpec.ConfigValue<Integer> VOLTAGE_TIER_NIGHT_VISION;
    public static final ForgeConfigSpec.ConfigValue<Integer> VOLTAGE_TIER_NANO_SUIT;
    public static final ForgeConfigSpec.ConfigValue<Integer> VOLTAGE_TIER_ADVANCED_NANO_SUIT;
    public static final ForgeConfigSpec.ConfigValue<Integer> VOLTAGE_TIER_QUARKTECH;
    public static final ForgeConfigSpec.ConfigValue<Integer> VOLTAGE_TIER_ADVANCED_QUARKTECH;
    public static final ForgeConfigSpec.ConfigValue<Integer> VOLTAGE_TIER_IMPELLER;
    public static final ForgeConfigSpec.ConfigValue<Integer> VOLTAGE_TIER_ADVANCED_IMPELLER;

    static {
        BUILDER.push("tools");

        RNG_DAMAGE_ELECTRIC_TOOLS = createConfigValue(BUILDER, "rng_damage_electric_tools", 10, 0, 100,
                "Chance for electric tools to take actual damage, as a percentage");

        SPRAY_CAN_CHAIN_LENGTH = createConfigValue(BUILDER, "spray_can_chain_length", 16, 1, 512,
                "Amount of blocks that can be spray painted at once");

        TREE_FELLING_DELAY = createConfigValue(BUILDER, "tree_felling_delay", 2, 1, 400,
                "Delay in ticks between each log being broken when tree felling");

        VOLTAGE_TIER_NIGHT_VISION = createConfigValueExtraDefault(BUILDER, "voltage_tier_night_vision", 1, 0, 14,
                "(LV)", "NightVision Goggles Voltage Tier.");
        VOLTAGE_TIER_NANO_SUIT = createConfigValueExtraDefault(BUILDER, "voltage_tier_nano_suit", 3, 0, 14, "(HV)",
                "anoSuit Voltage Tier.");
        VOLTAGE_TIER_ADVANCED_NANO_SUIT = createConfigValueExtraDefault(BUILDER, "voltage_tier_advanced_nano_suit", 3,
                0, 14, "(HV)", "Advanced NanoSuit Chestplate Voltage Tier.");
        VOLTAGE_TIER_QUARKTECH = createConfigValueExtraDefault(BUILDER, "voltage_tier_quarktech", 5, 0, 14, "(IV)",
                "QuarkTech Suit Voltage Tier.");
        VOLTAGE_TIER_ADVANCED_QUARKTECH = createConfigValueExtraDefault(BUILDER, "voltage_tier_advanced_quarktech", 6,
                0, 14, "(LuV)", "Advanced QuarkTech Suit Chestplate Voltage Tier.");
        VOLTAGE_TIER_IMPELLER = createConfigValueExtraDefault(BUILDER, "voltage_tier_impeller", 2, 0, 14, "(MV)",
                "Electric Impeller Jetpack Voltage Tier.");
        VOLTAGE_TIER_ADVANCED_IMPELLER = createConfigValueExtraDefault(BUILDER, "voltage_tier_advanced_impeller", 3, 0,
                14, "(HV)", "Advanced Electric Jetpack Voltage Tier.");

        {
            BUILDER.push("nano_saber");

            NANO_SABER_DAMAGE_BOOST = createConfigValue(BUILDER, "nano_saber_damage_boost", 20.0, 0.0, 100.0,
                    "The additional damage added when the NanoSaber is powered.");
            NANO_SABER_BASE_DAMAGE = createConfigValue(BUILDER, "nano_saber_base_damage", 5.0, 0.0, 100.0,
                    "The base damage of the NanoSaber.");

            ZOMBIES_SPAWN_WITH_SABERS = createConfigValue(BUILDER, "zombies_spawn_with_sabers", true,
                    "Should Zombies spawn with charged, active NanoSabers on hard difficulty?");

            NANO_SABER_ENERGY_CONSUMPTION = createConfigValue(BUILDER, "nano_saber_energy_consumption", 64, 1, 512,
                    "The EU/t consumption of the NanoSaber.");

            BUILDER.pop();
        }

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
