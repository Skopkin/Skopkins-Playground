package com.skopkin.skopkinsplayground.init;

import com.skopkin.skopkinsplayground.SkopkinsPlayground;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

//This class initializes items that are added in the mod so that Minecraft recognizes them as a part of the game
@ObjectHolder(SkopkinsPlayground.MOD_ID)
@Mod.EventBusSubscriber(modid = SkopkinsPlayground.MOD_ID, bus = Bus.MOD)
public class ItemInit {
	public static Item testrite_ingot_item;
	public static Item testrite_nugget_item;
	
	// This SubscribeEvent adds all custom Items (the physical blocks in the game world) into the game's registry
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("testrite_ingot_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("testrite_nugget_item"));
	}
}
