package com.BoMC.API;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class API extends JavaPlugin {
	
	@Override
	public void onEnable() {
		Bukkit.getLogger().log(Level.INFO, "PLUGIN LOADED");
		
		
	}
	
	@Override
	public void onDisable() {
		
		
		
	}

}
