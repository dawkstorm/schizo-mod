package net.dawkstorm.schizo.item;

import net.dawkstorm.schizo.SchizoMod;
import net.dawkstorm.schizo.item.custom.Summoner;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;


public class ModItems {
    public static final Item SUMMONER = registerItem("summoner", Summoner::new, new Summoner.Settings());

    private static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        //return Registry.register(Registries.ITEM, Identifier.of(SchizoMod.MOD_ID, name), item);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SchizoMod.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static void registerModItems(){
        SchizoMod.LOGGER.info("Registering items in " + SchizoMod.MOD_ID + "...");
    }
}
