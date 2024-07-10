package net.malarky.monkeymod.item;

import net.malarky.monkeymod.MonkeyMod;
import net.malarky.monkeymod.entity.ModEntities;
import net.malarky.monkeymod.sounds.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MonkeyMod.MOD_ID);

    // Foods

    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoods.BANANA)));

    // Music Discs

public static final RegistryObject<Item> RETURN_TO_MONKE_DISC = ITEMS.register("return_to_monke_disc",
        () -> new RecordItem(6, ModSounds.RETURN_TO_MONKEY, new Item.Properties().stacksTo(1), 7760));

// Spawn Eggs




public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
}
}

