package hyphos.example.firstmod.mixin;

import hyphos.example.firstmod.FirstMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class firstmod {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		FirstMod.LOGGER.info("Fabric Mod 1.18.2 has Loaded!! :)");
	}
}
