package com.skopkin.skopkinsplayground.init;

import java.util.function.Supplier;

import com.skopkin.skopkinsplayground.SkopkinsPlayground;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
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
	
	// Create variables for the Testrite tools
	public static Item testrite_axe;
	public static Item testrite_hoe;
	public static Item testrite_pickaxe;
	public static Item testrite_shovel;
	public static Item testrite_sword;
	
	// This SubscribeEvent adds all custom Items (the physical blocks in the game world) into the game's registry
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		//items
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("testrite_ingot_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("testrite_nugget_item"));
	
		//tools
		event.getRegistry().register(new AxeItem(ModItemTier.TESTRITE, (int) ModItemTier.TESTRITE.getAttackDamage()/2, 2.5f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("testrite_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.TESTRITE, (int) ModItemTier.TESTRITE.getAttackDamage()/2, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("testrite_hoe"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.TESTRITE, (int) ModItemTier.TESTRITE.getAttackDamage()/2, 2.5f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("testrite_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.TESTRITE, (int) ModItemTier.TESTRITE.getAttackDamage()/2, 2.5f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("testrite_shovel"));
		event.getRegistry().register(new SwordItem(ModItemTier.TESTRITE, (int) ModItemTier.TESTRITE.getAttackDamage(), 2.5f, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("testrite_sword"));
	}
	
	public enum ModItemTier implements IItemTier
	{
		TESTRITE(2, 750, 8.0f, 3f, 20, () -> {
			return Ingredient.fromItems(testrite_ingot_item);
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchatability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) 
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchatability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}
		
		;
		@Override
		public int getMaxUses() {
			// TODO Auto-generated method stub
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			// TODO Auto-generated method stub
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			// TODO Auto-generated method stub
			return  this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			// TODO Auto-generated method stub
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			// TODO Auto-generated method stub
			return this.enchatability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			// TODO Auto-generated method stub
			return this.repairMaterial.getValue();
		}
	}
}
