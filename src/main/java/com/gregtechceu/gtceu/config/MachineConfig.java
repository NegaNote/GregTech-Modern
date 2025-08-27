package com.gregtechceu.gtceu.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MachineConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("machines");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
