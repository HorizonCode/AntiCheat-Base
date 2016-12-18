package net.horizoncode.anticheat.listener;

import net.horizoncode.anticheat.AntiCheatAPI;
import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		FlagPlayer fp = AntiCheatAPI.getInstance().get(e.getPlayer());
		if (fp != null) {
			AntiCheatAPI.getInstance().playerlist.remove(fp);
		}
	}

}
