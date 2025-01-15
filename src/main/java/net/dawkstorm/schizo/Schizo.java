	package net.dawkstorm.schizo;

	import net.fabricmc.api.ModInitializer;

	import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
	import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
	import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
	import net.minecraft.client.MinecraftClient;
	import net.minecraft.sound.SoundCategory;
	import net.minecraft.sound.SoundEvents;
	import net.minecraft.util.ActionResult;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;


	public class Schizo implements ModInitializer {
		public static final String MOD_ID = "schizo";
		public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

		@Override
		public void onInitialize() {
			LOGGER.info("meow :3");
			ClientTickEvents.START_WORLD_TICK.register(client -> {
				if(Math.random() < 0.005){
					LOGGER.info("hehehee");
					client.getPlayers().getFirst().playSound(SoundEvents.ENTITY_ZOMBIE_AMBIENT);
				}
			});
		}

	}