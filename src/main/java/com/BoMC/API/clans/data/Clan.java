package com.BoMC.API.clans.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.BoMC.API.clans.Clans.Side;

public class Clan {
	
	private List<UUID> players;
	private String clanID;
	private String clanName;
	private Side side;
	
	public Clan() {
		
		players = new ArrayList<UUID>();
		clanID = "";
		clanName = "";
		side = Side.NEUTRAL;
		
	}
	
	public Clan(String id, String name, Side side) {
		
		players = new ArrayList<UUID>();
		clanID = id;
		clanName = name;
		this.side = side;
		
	}
	
	public Clan(List<UUID> players, String id, String name, Side side) {
		
		this.players = players;
		clanID = id;
		clanName = name;
		this.side = side;
		
	}

}
