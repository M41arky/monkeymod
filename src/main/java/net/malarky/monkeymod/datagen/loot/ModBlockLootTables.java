package net.malarky.monkeymod.datagen.loot;

import net.malarky.monkeymod.block.ModBlocks;
import net.malarky.monkeymod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        // Add blocks that drop themselves here

        this.dropSelf(ModBlocks.MONKEY_PUZZLE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MONKEY_PUZZLE_LOG.get());
        this.dropSelf(ModBlocks.MONKEY_PUZZLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MONKEY_PUZZLE_WOOD.get());
        this.dropSelf(ModBlocks.MONKEY_PUZZLE_PLANKS.get());




        // Leaves Drops

        this.add(ModBlocks.MONKEY_PUZZLE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.MONKEY_PUZZLE_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES)); //TODO: CHANGE TO SAPLING!



    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}


// EVERYTIME AN ITEM IS ADDED RUN DATAGEN
// HAVE TO SWITCH TO RUN CLIENT IN TOP AFTER