package com.BoMC.API.recipes;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import com.BoMC.API.API;

public class GrindstoneCraftEvent implements Listener {
	
	@EventHandler
	public void onGrindstoneClick(PlayerInteractEvent event) {
		
		if(event.getClickedBlock() == null) return;
		if(!event.getHand().equals(EquipmentSlot.HAND)) return;
		
		if(event.getClickedBlock().getType() == Material.GRINDSTONE && API.GRINDSTONE_RECIPES.containsKey(event.getPlayer().getInventory().getItemInMainHand().getType())) {
				
			event.setUseInteractedBlock(Result.DENY);
			
			event.getPlayer().getInventory().addItem(new ItemStack(API.GRINDSTONE_RECIPES.get(event.getPlayer().getInventory().getItemInMainHand().getType()), 1));
			event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount()-1);
			event.getPlayer().playSound(event.getClickedBlock().getLocation(), Sound.BLOCK_GRINDSTONE_USE, 1.0F, 0);
			
		}
		
	}

}
