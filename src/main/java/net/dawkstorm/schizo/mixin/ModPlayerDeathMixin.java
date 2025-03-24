package net.dawkstorm.schizo.mixin;

import net.dawkstorm.schizo.util.IEntityDataSaver;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.dawkstorm.schizo.util.InsanityData;

@Mixin(PlayerEntity.class)
public class ModPlayerDeathMixin {
    @Inject(method = "onDeath", at = @At("TAIL"))
    protected void injectOnDeathMethod(DamageSource damageSource, CallbackInfo info){
        InsanityData.removeInsanity((IEntityDataSaver) this, 100);
    }
}
