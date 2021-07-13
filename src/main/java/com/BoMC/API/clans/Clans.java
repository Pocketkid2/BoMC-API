package com.BoMC.API.clans;

import static com.BoMC.API.API.CLANS_YML;
import static com.BoMC.API.API.getClan;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.BoMC.API.clans.data.Clan;
import com.BoMC.API.clans.events.PlayerJoinClanEvent;

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
	
	public void joinClan(Clan clan, Player player) {
		
		PlayerJoinClanEvent joinClan = new PlayerJoinClanEvent(player, clan);

		Bukkit.getPluginManager().callEvent(joinClan);
		
		if(!joinClan.isCancelled()) {

			getClan(clan.getClanID()).addPlayer(player.getUniqueId());
			
		}
		
	}

}
