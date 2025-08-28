package com.gregtechceu.gtceu.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static com.gregtechceu.gtceu.config.ConfigUtil.createConfigValue;

public class GameplayConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> MATERIAL_HAZARDS_ENABLED;
    public static final ForgeConfigSpec.ConfigValue<Boolean> UNIVERSAL_HAZARDS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ENVIRONMENTAL_HAZARDS;
    public static final ForgeConfigSpec.ConfigValue<Float> ENVIRONMENTAL_HAZARD_DECAY_RATE;

    static {
        BUILDER.push("gameplay");

        MATERIAL_HAZARDS_ENABLED = createConfigValue(BUILDER, "material_hazards_enabled", true,
                "Enable hazardous materials");
        UNIVERSAL_HAZARDS = createConfigValue(BUILDER, "universal_hazards", true,
                "Whether hazards are applied to all valid items, or just GT's.",
                "true = all, false = GT only.");
        ENVIRONMENTAL_HAZARDS = createConfigValue(BUILDER, "environmental_hazards", false,
                "Whether environmental hazards like pollution or radiation are active");
        ENVIRONMENTAL_HAZARD_DECAY_RATE = createConfigValue(BUILDER, "environmental_hazard_decay_rate", 0.001f,
                "How much environmental hazards decay per chunk, per tick.");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
