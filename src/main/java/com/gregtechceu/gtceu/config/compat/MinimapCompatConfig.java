package com.gregtechceu.gtceu.config.compat;

import net.minecraftforge.common.ForgeConfigSpec;

public class MinimapCompatConfig {

    public static ForgeConfigSpec.ConfigValue<Integer> SURFACE_ROCK_PROSPECT_RANGE;
    public static ForgeConfigSpec.ConfigValue<Integer> ORE_BLOCK_PROSPECT_RANGE;

    public static ForgeConfigSpec.ConfigValue<Float> ORE_SCALE_STOP;

    public static ForgeConfigSpec.ConfigValue<Integer> ORE_ICON_SIZE;

    public static ForgeConfigSpec.ConfigValue<String> ORE_NAME_PREFIX;

    public static ForgeConfigSpec.ConfigValue<String> BORDER_COLOR;

    public static ForgeConfigSpec.ConfigValue<Anchor> BUTTON_ANCHOR;

    public static ForgeConfigSpec.ConfigValue<Direction> DIRECTION;

    public static ForgeConfigSpec.ConfigValue<Integer> X_OFFSET;
    public static ForgeConfigSpec.ConfigValue<Integer> Y_OFFSET;

    public static ForgeConfigSpec.BooleanValue FTB_CHUNKS_INTEGRATION;
    public static ForgeConfigSpec.BooleanValue JOURNEY_MAP_INTEGRATION;
    public static ForgeConfigSpec.BooleanValue XAEROS_MAP_INTEGRATION;

    public enum Anchor {

        TOP_LEFT,
        TOP_CENTER,
        TOP_RIGHT,
        RIGHT_CENTER,
        BOTTOM_RIGHT,
        BOTTOM_CENTER,
        BOTTOM_LEFT,
        LEFT_CENTER;

        public boolean isCentered() {
            return this == TOP_CENTER || this == RIGHT_CENTER || this == BOTTOM_CENTER || this == LEFT_CENTER;
        }

        public Direction usualDirection() {
            return switch (this) {
                case TOP_CENTER, BOTTOM_CENTER -> Direction.HORIZONTAL;
                case RIGHT_CENTER, LEFT_CENTER -> Direction.VERTICAL;
                default -> null;
            };
        }
    }

    public enum Direction {
        VERTICAL,
        HORIZONTAL
    }

    public static int getBorderColor(int materialColor) {
        var borderColor = BORDER_COLOR.get();
        if (BORDER_COLOR.get().equals("material")) {
            return materialColor;
        }
        // please java may I have an unsigned int
        try {
            long tmp = Long.decode(BORDER_COLOR.get());
            if (tmp > 0x7FFFFFFF) {
                tmp -= 0x100000000L;
            }
            return (int) tmp;
        } catch (NumberFormatException e) {
            return 0x00000000;
        }
    }
}
