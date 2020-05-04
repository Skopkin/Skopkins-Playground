package com.skopkin.skopkinsplayground.init;

import com.skopkin.skopkinsplayground.SkopkinsPlayground;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

// This class initializes blocks that are added in the mod so that Minecraft recognizes them as a part of the game
@ObjectHolder(SkopkinsPlayground.MOD_ID)
@Mod.EventBusSubscriber(modid = SkopkinsPlayground.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	//Creates a Block variable for a new type of ore and sets its parameters
	public static final Block testrite_ore = new Block(Block.Properties.create(Material.IRON).harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3, 3).sound(SoundType.METAL)).setRegistryName("testrite_ore");

	// This SubscribeEvent adds all custom Blocks (the physical blocks in the game world) into the game's registry
	@SubscribeEvent 
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().register(testrite_ore);
		}
	
	// This SubscribeEvent adds all custom BlockItems (the item blocks that are stored in your inventory and can be placed or dropped) into the game's registry
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(testrite_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("testrite_ore"));
	}
}
