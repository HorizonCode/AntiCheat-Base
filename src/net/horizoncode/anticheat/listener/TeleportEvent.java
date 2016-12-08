package net.horizoncode.anticheat.listener;

import net.horizoncode.anticheat.AntiCheat;
import net.horizoncode.anticheat.checkbase.Check;
import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportEvent implements Listener {

	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		Player p = e.getPlayer();
		Location from = e.getFrom();
		Location to = e.getTo();
		FlagPlayer fp = AntiCheat.getInstance().get(p);
		for (Check c : AntiCheat.getInstance().checkManager.checks) {
			c.onTeleport(fp, from, to);
		}
	}
}
