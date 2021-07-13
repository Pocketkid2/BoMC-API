package com.BoMC.API.clans.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.BoMC.API.clans.data.Clan;

public class PlayerJoinClanEvent extends Event implements Cancellable {
	
	private final HandlerList handlers;
	
	private final Player player;
	private final Clan clan;
	
	private boolean cancelled;
	
	public PlayerJoinClanEvent(Player player, Clan clan) {
		
		handlers = new HandlerList();
		
		this.player = player;
		this.clan = clan;
		
		cancelled = false;
		
	}

	@Override
	public HandlerList getHandlers() {

		return handlers;
		
	}

	@Override
	public boolean isCancelled() {

		return cancelled;
		
	}

	@Override
	public void setCancelled(boolean cancel) {
		
		cancelled = cancel;
		
	}

	public Player getPlayer() {
		
		return player;
		
	}

	public Clan getClan() {
		
		return clan;
		
	}
	
	

}
