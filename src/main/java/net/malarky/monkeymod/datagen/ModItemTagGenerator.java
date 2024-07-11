package net.malarky.monkeymod.datagen;

import net.malarky.monkeymod.MonkeyMod;
import net.malarky.monkeymod.block.ModBlocks;
import net.malarky.monkeymod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_,  @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, MonkeyMod.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.RETURN_TO_MONKE_DISC.get());

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.RETURN_TO_MONKE_DISC.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MONKEY_PUZZLE_LOG.get().asItem())
                .add(ModBlocks.MONKEY_PUZZLE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MONKEY_PUZZLE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MONKEY_PUZZLE_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.MONKEY_PUZZLE_PLANKS.get().asItem());


    }
}
