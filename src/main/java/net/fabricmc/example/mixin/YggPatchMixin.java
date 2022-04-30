package net.fabricmc.example.mixin;

import com.mojang.authlib.yggdrasil.response.KeyPairResponse;
import net.fabricmc.example.ExampleMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(com.mojang.authlib.yggdrasil.YggdrasilUserApiService.class)
public class YggPatchMixin {
    @Inject(method = "getKeyPair",
            at = @At("HEAD"), cancellable = true, remap = false)
    private void getKeyPair(CallbackInfoReturnable<KeyPairResponse> cir) {
        ExampleMod.LOGGER.info("getKeyPair() returning null here");
        cir.setReturnValue(null);
    }
}
