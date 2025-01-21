	package net.dawkstorm.schizo;

	import net.dawkstorm.schizo.util.IEntityDataSaver;
	import net.dawkstorm.schizo.util.InsanityData;
	import net.dawkstorm.schizo.util.RandomNoises;
	import net.fabricmc.api.ModInitializer;

	import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
	import net.minecraft.entity.player.PlayerEntity;
	import net.minecraft.text.Style;
	import net.minecraft.text.Text;
	import net.minecraft.util.Formatting;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;


	public class Schizo implements ModInitializer {
		public static final String MOD_ID = "schizo";
		public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

		@Override
		public void onInitialize() {
			LOGGER.info("meow :3");
			ClientTickEvents.START_WORLD_TICK.register(client -> {
				PlayerEntity player = client.getPlayers().getFirst();
				if(Math.random() < 0.005){
					LOGGER.info("hehehee");
					RandomNoises.playRandomSound(client);
					LOGGER.info(""+InsanityData.getInsanity((IEntityDataSaver) player));
				}
				/*InsanityData.addInsanity((IEntityDataSaver) player, 0.0025f);
				player.sendMessage(Text.literal("Insanity: " + ((IEntityDataSaver) player)
						.getPersistentData().getFloat("schizo_insanity")).
							fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), true);*/
			});
		}


	}