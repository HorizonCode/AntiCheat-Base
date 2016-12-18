package net.horizoncode.anticheat.listener;

import net.horizoncode.anticheat.AntiCheatAPI;
import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
	AntiCheatAPI.getInstance().playerlist.add(new FlagPlayer(e.getPlayer()));
	}
}
