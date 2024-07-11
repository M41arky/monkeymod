package net.malarky.monkeymod.datagen;

import net.malarky.monkeymod.MonkeyMod;
import net.malarky.monkeymod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocksStateProvider extends BlockStateProvider {
    public ModBlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MonkeyMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        // Blocks

        // Logs/Wood

        logBlock(((RotatedPillarBlock) ModBlocks.MONKEY_PUZZLE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.MONKEY_PUZZLE_WOOD.get()), blockTexture(ModBlocks.MONKEY_PUZZLE_LOG.get()), blockTexture(ModBlocks.MONKEY_PUZZLE_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_MONKEY_PUZZLE_LOG.get()), blockTexture(ModBlocks.STRIPPED_MONKEY_PUZZLE_LOG.get()),
                new ResourceLocation(MonkeyMod.MOD_ID, "block/stripped_monkey_puzzle_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_MONKEY_PUZZLE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_MONKEY_PUZZLE_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_MONKEY_PUZZLE_LOG.get()));

        blockItem(ModBlocks.MONKEY_PUZZLE_LOG);
        blockItem(ModBlocks.MONKEY_PUZZLE_WOOD);
        blockItem(ModBlocks.STRIPPED_MONKEY_PUZZLE_LOG);
        blockItem(ModBlocks.STRIPPED_MONKEY_PUZZLE_WOOD);

        blockWithItem(ModBlocks.MONKEY_PUZZLE_PLANKS);

        leavesBlock(ModBlocks.MONKEY_PUZZLE_LEAVES);

    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));

    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(MonkeyMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
