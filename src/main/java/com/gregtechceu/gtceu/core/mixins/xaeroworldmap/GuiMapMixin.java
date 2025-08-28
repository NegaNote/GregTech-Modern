package com.gregtechceu.gtceu.core.mixins.xaeroworldmap;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.config.compat.MinimapCompatConfig;
import com.gregtechceu.gtceu.integration.map.ButtonState;
import com.gregtechceu.gtceu.integration.map.xaeros.worldmap.gui.GuiTexturedButtonWithSize;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xaero.map.MapProcessor;
import xaero.map.gui.*;

@Mixin(value = GuiMap.class, remap = false)
public abstract class GuiMapMixin extends ScreenBase implements IRightClickableElement {

    @Shadow
    public abstract <T extends GuiEventListener & Renderable & NarratableEntry> T addButton(T guiEventListener);

    protected GuiMapMixin(Screen parent, Screen escape, MapProcessor mapProcessor, Entity player) {
        super(parent, escape, Component.translatable("gui.xaero_world_map_screen"));
    }

    @Inject(method = "init", at = @At("TAIL"), remap = true)
    private void gtceu$injectInitGui(CallbackInfo ci) {
        if (!MinimapCompatConfig.XAEROS_MAP_INTEGRATION.get()) return;
        int startX, startY, xOffset, yOffset;

        switch (MinimapCompatConfig.DIRECTION.get()) {
            case VERTICAL -> {
                xOffset = 0;
                yOffset = 1;
            }
            case HORIZONTAL -> {
                xOffset = 1;
                yOffset = 0;
            }
            default -> throw new IllegalStateException(
                    "Unexpected value: " + MinimapCompatConfig.DIRECTION.get());
        }

        switch (MinimapCompatConfig.BUTTON_ANCHOR.get()) {
            case TOP_LEFT -> {
                startX = MinimapCompatConfig.X_OFFSET.get();
                startY = MinimapCompatConfig.Y_OFFSET.get();
            }
            case TOP_CENTER -> {
                startX = width / 2 + MinimapCompatConfig.X_OFFSET.get();
                startY = MinimapCompatConfig.Y_OFFSET.get();
            }
            case TOP_RIGHT -> {
                startX = width - 20 - MinimapCompatConfig.X_OFFSET.get();
                startY = MinimapCompatConfig.Y_OFFSET.get();
                xOffset = -xOffset;
            }
            case RIGHT_CENTER -> {
                startX = width - 20 - MinimapCompatConfig.X_OFFSET.get();
                startY = height / 2 + MinimapCompatConfig.Y_OFFSET.get();
                xOffset = -xOffset;
                yOffset = -yOffset;
            }
            case BOTTOM_RIGHT -> {
                startX = width - 20 - MinimapCompatConfig.X_OFFSET.get();
                startY = height - 20 - MinimapCompatConfig.Y_OFFSET.get();
                xOffset = -xOffset;
                yOffset = -yOffset;
            }
            case BOTTOM_CENTER -> {
                startX = width / 2 + MinimapCompatConfig.X_OFFSET.get();
                startY = height - 20 - MinimapCompatConfig.Y_OFFSET.get();
                yOffset = -yOffset;
            }
            case BOTTOM_LEFT -> {
                startX = MinimapCompatConfig.X_OFFSET.get();
                startY = height - 20 - MinimapCompatConfig.Y_OFFSET.get();
                yOffset = -yOffset;
            }
            case LEFT_CENTER -> {
                startX = MinimapCompatConfig.X_OFFSET.get();
                startY = height / 2 + MinimapCompatConfig.Y_OFFSET.get();
                yOffset = -yOffset;
            }
            default -> throw new IllegalStateException(
                    "Unexpected value: " + MinimapCompatConfig.BUTTON_ANCHOR.get());
        }

        if (MinimapCompatConfig.BUTTON_ANCHOR.get().isCentered()) {
            int totalButtonSize = ButtonState.buttonAmount() * 10;
            if (MinimapCompatConfig.BUTTON_ANCHOR.get().usualDirection()
                    .equals(MinimapCompatConfig.DIRECTION.get())) {
                startX -= xOffset * totalButtonSize;
                startY -= yOffset * totalButtonSize;
                if (xOffset < 0) startX -= 20;
                if (yOffset < 0) startY -= 20;
            } else {
                startX -= Math.abs(yOffset) * 10;
                startY -= Math.abs(xOffset) * 10;
            }
        }

        int offset = 0;
        for (ButtonState.Button button : ButtonState.getAllButtons()) {
            Button mapButton = new GuiTexturedButtonWithSize(
                    startX + (20 * xOffset * offset), startY + (20 * yOffset * offset), 20, 20,
                    0, ButtonState.isEnabled(button) ? 16 : 0, 16, 16, 16, 32,
                    GTCEu.id("textures/gui/widget/button_" + button.name + ".png"),
                    guiButton -> {
                        ButtonState.toggleButton(button);
                        init(minecraft, width, height);
                    },
                    () -> new CursorBox("gtceu.button." + button.name));

            addButton(mapButton);
            offset++;
        }
    }
}
