package com.gregtechceu.gtceu.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;

public class ConfigUtil {

    public static <T> String defaultValueText(T value) {
        return "Default: %s".formatted(value);
    }

    public static ForgeConfigSpec.ConfigValue<Integer> createConfigValue(ForgeConfigSpec.Builder builder, String path,
                                                                         int defaultValue, int min, int max,
                                                                         String... comments) {
        String[] commentsPlusDefaultText = Arrays.copyOf(comments, comments.length + 1);
        commentsPlusDefaultText[comments.length] = defaultValueText(defaultValue);
        return builder.comment(commentsPlusDefaultText).defineInRange(path, defaultValue, min, max);
    }

    public static ForgeConfigSpec.ConfigValue<Integer> createConfigValueExtraDefault(ForgeConfigSpec.Builder builder,
                                                                                     String path,
                                                                                     int defaultValue, int min, int max,
                                                                                     String extraDefaultText,
                                                                                     String... comments) {
        String[] commentsPlusDefaultText = Arrays.copyOf(comments, comments.length + 1);
        commentsPlusDefaultText[comments.length] = defaultValueText(defaultValue) + " " + extraDefaultText;
        return builder.comment(commentsPlusDefaultText).defineInRange(path, defaultValue, min, max);
    }

    public static <T> ForgeConfigSpec.ConfigValue<T> createConfigValue(ForgeConfigSpec.Builder builder, String path,
                                                                       T defaultValue, String... comments) {
        String[] commentsPlusDefaultText = Arrays.copyOf(comments, comments.length + 1);
        commentsPlusDefaultText[comments.length] = defaultValueText(defaultValue);
        return builder.comment(commentsPlusDefaultText).define(path, defaultValue);
    }

    public static <T> ForgeConfigSpec.ConfigValue<T> createConfigValueExtraDefault(ForgeConfigSpec.Builder builder,
                                                                                   String path,
                                                                                   T defaultValue,
                                                                                   String extraDefaultText,
                                                                                   String... comments) {
        String[] commentsPlusDefaultText = Arrays.copyOf(comments, comments.length + 1);
        commentsPlusDefaultText[comments.length] = defaultValueText(defaultValue) + " " + extraDefaultText;
        return builder.comment(commentsPlusDefaultText).define(path, defaultValue);
    }

    public static ForgeConfigSpec.ConfigValue<Float> createConfigValue(ForgeConfigSpec.Builder builder, String path,
                                                                       float defaultValue, float min, float max,
                                                                       String... comments) {
        String[] commentsPlusDefaultText = Arrays.copyOf(comments, comments.length + 1);
        commentsPlusDefaultText[comments.length] = defaultValueText(defaultValue);
        return builder.comment(commentsPlusDefaultText).defineInRange(path, defaultValue, min, max, Float.class);
    }

    public static ForgeConfigSpec.ConfigValue<Double> createConfigValue(ForgeConfigSpec.Builder builder, String path,
                                                                        double defaultValue, double min, double max,
                                                                        String... comments) {
        String[] commentsPlusDefaultText = Arrays.copyOf(comments, comments.length + 1);
        commentsPlusDefaultText[comments.length] = defaultValueText(defaultValue);
        return builder.comment(commentsPlusDefaultText).defineInRange(path, defaultValue, min, max);
    }
}
