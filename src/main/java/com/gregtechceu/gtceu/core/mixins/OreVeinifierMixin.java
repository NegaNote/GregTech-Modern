package com.gregtechceu.gtceu.core.mixins;

import com.gregtechceu.gtceu.config.worldgen.OreVeinConfig;

import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.OreVeinifier;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OreVeinifier.class)
public class OreVeinifierMixin {

    @Inject(
            method = "create(Lnet/minecraft/world/level/levelgen/DensityFunction;Lnet/minecraft/world/level/levelgen/DensityFunction;Lnet/minecraft/world/level/levelgen/DensityFunction;Lnet/minecraft/world/level/levelgen/PositionalRandomFactory;)Lnet/minecraft/world/level/levelgen/NoiseChunk$BlockStateFiller;",
            at = @At("HEAD"),
            cancellable = true)
    private static void gtceu$create(DensityFunction function1, DensityFunction function2, DensityFunction function3,
                                     PositionalRandomFactory random,
                                     CallbackInfoReturnable<NoiseChunk.BlockStateFiller> cir) {
        if (OreVeinConfig.REMOVE_VANILLA_LARGE_ORE_VEINS.get())
            cir.setReturnValue(functionContext -> null);
    }
}
