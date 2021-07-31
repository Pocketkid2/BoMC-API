package com.BoMC.API.recipes;

import java.util.logging.Level;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;

import com.BoMC.API.API;

public class InitRecipes {
	
	public static void initAll(Plugin plugin) {
		
		plugin.getServer().resetRecipes();
		
		initShapelessRecipes(plugin);
		initShapedRecipes(plugin);
		initFurnaceRecipes(plugin);
		initGrindstoneRecipes();
		removeRecipes(plugin);
		
	}
	
	public static void initShapelessRecipes(Plugin plugin) {
		
		ShapelessRecipe ironInCrucible = new ShapelessRecipe(new NamespacedKey(plugin, "ironInCrucible"), new ItemStack(Material.BLAZE_ROD));
		ironInCrucible.addIngredient(Material.RAW_IRON);
		ironInCrucible.addIngredient(Material.NETHER_WART);
		
		plugin.getServer().addRecipe(ironInCrucible);
		
	}
	
	public static void initShapedRecipes(Plugin plugin) {
		
		ShapedRecipe macuahuitl = new ShapedRecipe(new NamespacedKey(plugin, "macuahuitl"), new ItemStack(Material.IRON_SWORD));
		macuahuitl.shape("OPO", "OPO", "*S*");
		macuahuitl.setIngredient('O', Material.GOLD_INGOT);
		macuahuitl.setIngredient('P', new RecipeChoice.MaterialChoice(Material.OAK_PLANKS, Material.ACACIA_PLANKS,
				Material.BIRCH_PLANKS, Material.DARK_OAK_PLANKS, Material.JUNGLE_PLANKS, Material.SPRUCE_PLANKS));
		macuahuitl.setIngredient('S', Material.STICK);
		
		plugin.getServer().addRecipe(macuahuitl);
		
		
	}
	
	public static void initFurnaceRecipes(Plugin plugin) {
		
		FurnaceRecipe moltenIron = new FurnaceRecipe(new NamespacedKey(plugin, "moltenIron"), new ItemStack(Material.BLAZE_POWDER, 1), Material.BLAZE_ROD, 0.4F, 1600);
		
		plugin.getServer().addRecipe(moltenIron);
		
	}
	
	public static void initGrindstoneRecipes() {
		
		API.addGrindstoneRecipe(Material.RAW_GOLD, Material.GOLD_INGOT);
		
	}
	
	public static void removeRecipes(Plugin plugin) {
		
		API.LOGGER.log(Level.INFO, plugin.getServer().getRecipesFor(new ItemStack(Material.BLAZE_ROD)).get(0).toString() );
		
		plugin.getServer().removeRecipe(NamespacedKey.minecraft("blaze_powder"));
		plugin.getServer().removeRecipe(NamespacedKey.minecraft("iron_sword"));
		plugin.getServer().removeRecipe(NamespacedKey.minecraft("gold_nugget"));
		plugin.getServer().removeRecipe(NamespacedKey.minecraft("brewing_stand"));
		
	}

}
