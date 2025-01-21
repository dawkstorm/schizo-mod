package net.dawkstorm.schizo.util;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class RandomNoises {
    private static SoundEvent[] potentialSounds = {
            SoundEvents.ENTITY_ZOMBIE_AMBIENT,
            SoundEvents.ENTITY_CREEPER_PRIMED,
            SoundEvents.ENTITY_SKELETON_AMBIENT,
            SoundEvents.ENTITY_SKELETON_SHOOT,
            SoundEvents.ENTITY_SPIDER_AMBIENT,
            SoundEvents.ENTITY_SPIDER_STEP
    };

    public static void playRandomSound(ClientWorld client) {
        int rand = (int)(Math.random() * potentialSounds.length);
        client.getPlayers().getFirst().playSound(potentialSounds[rand]);
    }
}
