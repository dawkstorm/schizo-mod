package net.dawkstorm.schizo.util;

import net.minecraft.nbt.NbtCompound;

public class InsanityData {
    public static final float maxInsanity = 100;

    public static float addInsanity(IEntityDataSaver player, float amount){
        NbtCompound nbt = player.getPersistentData();
        float insanity = nbt.getFloat("schizo_insanity");
        if(insanity + amount >= maxInsanity){
            insanity = maxInsanity;
        }
        else {
            insanity += amount;
        }
        nbt.putFloat("schizo_insanity", insanity);
        return insanity;
    }

    public static float removeInsanity(IEntityDataSaver player, float amount){
        NbtCompound nbt = player.getPersistentData();
        float insanity = nbt.getFloat("schizo_insanity");
        if(insanity - amount < 0){
            insanity = 0;
        }
        else {
            insanity -= amount;
        }
        nbt.putFloat("schizo_insanity", insanity);
        return insanity;
    }

    public static float getInsanity(IEntityDataSaver player){
        NbtCompound nbt = player.getPersistentData();
        float insanity = nbt.getFloat("schizo_insanity");
        return insanity;
    }
}
