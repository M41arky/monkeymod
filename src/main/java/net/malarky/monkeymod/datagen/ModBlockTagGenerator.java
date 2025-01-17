package net.malarky.monkeymod.datagen;

import net.malarky.monkeymod.MonkeyMod;
import net.malarky.monkeymod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MonkeyMod.MOD_ID, existingFileHelper);

        // Needs Specific Tool Material Tags

        this.tag(BlockTags.NEEDS_IRON_TOOL);

        // Needs Specific Tool Tags

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE);

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);


        // Needs Fence Tag

        this.tag(BlockTags.FENCES);

        // Needs Fence Gate Tag

        this.tag(BlockTags.FENCE_GATES);

        // Needs Wall Tag

        this.tag(BlockTags.WALLS);

        // Block Tags

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MONKEY_PUZZLE_LOG.get())
                .add(ModBlocks.MONKEY_PUZZLE_WOOD.get())
                .add(ModBlocks.STRIPPED_MONKEY_PUZZLE_LOG.get())
                .add(ModBlocks.STRIPPED_MONKEY_PUZZLE_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.MONKEY_PUZZLE_PLANKS.get());


    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
