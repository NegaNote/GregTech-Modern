package com.gregtechceu.gtceu.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;

public class ConfigUtil {

    public static <T> String defaultValueText(T value) {
        return "Default: %s".formatted(value);
    }

    public static ForgeConfigSpec.BooleanValue createConfigValue(ForgeConfigSpec.Builder builder, String path,
                                                                 boolean defaultValue, String... comments) {
        String[] commentsPlusDefaultText = Arrays.copyOf(comments, comments.length + 1);
        commentsPlusDefaultText[comments.length] = defaultValueText(defaultValue);
        return builder.comment(commentsPlusDefaultText).define(path, defaultValue);
    }

    public static ForgeConfigSpec.IntValue createConfigValue(ForgeConfigSpec.Builder builder, String path,
                                                             int defaultValue, int min, int max, String... comments) {
        String[] commentsPlusDefaultText = Arrays.copyOf(comments, comments.length + 1);
        commentsPlusDefaultText[comments.length] = defaultValueText(defaultValue);
        return builder.comment(commentsPlusDefaultText).defineInRange(path, defaultValue, min, max);
    }

    public static ForgeConfigSpec.ConfigValue<Float> createConfigValue(ForgeConfigSpec.Builder builder, String path,
                                                                       float defaultValue, float min, float max,
                                                                       String... comments) {
        String[] commentsPlusDefaultText = Arrays.copyOf(comments, comments.length + 1);
        commentsPlusDefaultText[comments.length] = defaultValueText(defaultValue);
        return builder.comment(commentsPlusDefaultText).defineInRange(path, defaultValue, min, max, Float.class);
    }
}
