package com.BoMC.API;

import static com.BoMC.API.clans.Clans.initClans;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.BoMC.API.clans.data.Clan;

public class API extends JavaPlugin {
	
	public static List<Clan> CLANS;
	
	// Files
	public static File CONFIG_FILE;
	public static File CLANS_FILE;
	
	// FileConfigurations
	public static FileConfiguration CONFIG;
	public static FileConfiguration CLANS_YML;
	
	// Logger
	public static Logger LOGGER;
	
	@Override
	public void onEnable() {
		
		LOGGER = Bukkit.getLogger();
		
		saveDefaultConfig();
		
		// Get Files
		CONFIG_FILE = new File(getDataFolder(), "config.yml");
		CLANS_FILE = new File(getDataFolder(), "clans.yml");
		
		// Create missing files
		if(!CLANS_FILE.exists()) {
			
			try {
				
				CLANS_FILE.mkdirs();
				CLANS_FILE.createNewFile();
				
			} catch (IOException e) {

				e.printStackTrace();
				
			}
			
		}
		
		// Get FileConfigurations
		CONFIG = getConfig();
		CLANS_YML = YamlConfiguration.loadConfiguration(CLANS_FILE);
		
		CLANS = initClans();
		
	}
	
	@Override
	public void onDisable() {
		
		
		
	}

}
