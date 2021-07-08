package com.BoMC.API.clans;

import static com.BoMC.API.API.CLANS_YML;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import com.BoMC.API.clans.data.Clan;

public class Clans {
	
	public enum Side {
		
		GOOD, BAD, NEUTRAL
		
	}
	
	public static List<Clan> initClans() {
		
		return loadClans(CLANS_YML);
		
	}
	
	private static List<Clan> loadClans(FileConfiguration clansConfig) {
		
		List<Clan> clans = new ArrayList<Clan>();
		
		for(String section : clansConfig.getKeys(false)) {
			
			if(clansConfig.isConfigurationSection(section)) {
				
				ConfigurationSection configSection = clansConfig.getConfigurationSection(section);
				
				clans.add(new Clan(section, configSection.getString("name"), (Side)configSection.get("side")));
				
			}
			
		}
		
		return clans;
		
	}
	
	public static void saveClans() {
		
		// TODO: Create saves method
		
	}

}
