package com.gregtechceu.gtceu.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static com.gregtechceu.gtceu.config.ConfigUtil.createConfigValue;
import static com.gregtechceu.gtceu.config.ConfigUtil.createConfigValueExtraDefault;
import static com.gregtechceu.gtceu.config.client.ArmorHudConfig.*;
import static com.gregtechceu.gtceu.config.client.RendererConfig.*;

public class ClientConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> MACHINES_HAVE_BERS_BY_DEFAULT;

    public static final ForgeConfigSpec.ConfigValue<Boolean> TOOL_USE_SOUNDS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOOL_CRAFTING_SOUNDS;

    public static final ForgeConfigSpec.ConfigValue<String> DEFAULT_PAINTING_COLOR;
    public static final ForgeConfigSpec.ConfigValue<String> DEFAULT_UI_COLOR;

    public static final ForgeConfigSpec.ConfigValue<Boolean> USE_VBO;

    public static final ForgeConfigSpec.ConfigValue<Integer> IN_WORLD_PREVIEW_DURATION;

    public static final ForgeConfigSpec.ConfigValue<Integer> ANIMATION_TIME;

    static {
        BUILDER.push("client");

        MACHINES_HAVE_BERS_BY_DEFAULT = createConfigValue(BUILDER, "machines_have_bers_by_default", true,
                "Whether most machines will have block entity renderers, mainly used for rendering certain covers. (Restart required)",
                "Disable if experiencing performance issues.");

        TOOL_USE_SOUNDS = createConfigValue(BUILDER, "tool_use_sounds", true,
                "Whether or not sounds should be played when using tools outside of crafting.");
        TOOL_CRAFTING_SOUNDS = createConfigValue(BUILDER, "tool_crafting_sounds", true,
                "Whether or not sounds should be played when crafting with tools.");

        DEFAULT_PAINTING_COLOR = createConfigValueExtraDefault(BUILDER, "default_painting_color", "#FFFFFF",
                "(equivalent to no coloring (like GTCE))", "The default color to overlay onto machines.",
                "#D2DCFF is the classic blue from GT5.");
        DEFAULT_UI_COLOR = createConfigValueExtraDefault(BUILDER, "default_ui_color", "#FFFFFF",
                "(equivalent to no coloring (like GTCE))", "The default color to overlay onto Machine (and other) UIs.",
                "#D2DCFF is the classic blue from GT5.");

        USE_VBO = createConfigValue(BUILDER, "use_vbo", true, "Use VBO cache for multiblock preview.",
                "Disable if you have issues with rendering multiblocks.");

        IN_WORLD_PREVIEW_DURATION = createConfigValue(BUILDER, "in_world_preview_duration", 10,
                "Duration of the multiblock in-world preview in seconds");

        ANIMATION_TIME = createConfigValue(BUILDER, "animation_time", 300, 1, Integer.MAX_VALUE,
                "Duration of UI animations in milliseconds");

        {
            BUILDER.push("armor_hud");

            HUD_LOCATION = createConfigValue(BUILDER, "hud_location", 1, 1, 4, "Sets HUD location",
                    "1 - left-upper corner", "2 - right-upper corner",
                    "3 - left-bottom corner", "4 - right-bottom corner");
            HUD_OFFSET_X = createConfigValue(BUILDER, "hud_offset_x", 0, 0, 100, "Horizontal offset of HUD.");
            HUD_OFFSET_Y = createConfigValue(BUILDER, "hud_offset_y", 0, 0, 100, "Vertical offset of HUD.");

            BUILDER.pop();
        }

        {
            BUILDER.push("renderer");

            RENDER_FLUIDS = createConfigValue(BUILDER, "render_fluids", true,
                    "Render fluids in multiblocks that support them?");
            COLORED_TIERED_MACHINE_OUTLINE = createConfigValue(BUILDER, "colored_tiered_machine_outline", true,
                    "Whether or not to color tiered machine highlights in the tier color");
            COLORED_WIRE_OUTLINE = createConfigValue(BUILDER, "colored_wire_outline", true,
                    "Whether or not to color wire/cable highlights based on voltage tier");

            BUILDER.pop();
        }

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static int getDefaultPaintingColor() {
        // OR to differentiate from painted white
        return Long.decode(DEFAULT_PAINTING_COLOR.get()).intValue() | 0xff000000;
    }

    public static int getDefaultUIColor() {
        // OR to differentiate from a white coloring
        return Long.decode(DEFAULT_UI_COLOR.get()).intValue() | 0xff000000;
    }
}
