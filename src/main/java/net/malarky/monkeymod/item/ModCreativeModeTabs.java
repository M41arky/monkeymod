package net.malarky.monkeymod.item;

import net.malarky.monkeymod.MonkeyMod;
import net.malarky.monkeymod.block.ModBlocks;
import net.malarky.monkeymod.MonkeyMod;
import net.malarky.monkeymod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.NavigableMap;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MonkeyMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> DESERT_MOD_ITEMS = CREATIVE_MODE_TABS.register("desert_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BANANA.get()))
                    .title(Component.translatable("creativetab.desert_mod_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        // Items

                        output.accept(ModItems.BANANA.get());

                        // Discs

                        output.accept(ModItems.RETURN_TO_MONKE_DISC.get());

                    })

                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
