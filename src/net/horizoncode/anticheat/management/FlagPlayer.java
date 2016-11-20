package net.horizoncode.anticheat.management;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class FlagPlayer {

	private Player player;
	private String name;

	public FlagPlayer(Player p) {
		setPlayer(p);
		setName(p.getName());
	}

	private void setPlayer(Player player) {
		this.player = player;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Player getPlayer() {
		return player;
	}

	public String getName() {
		return name;
	}

	public boolean canBypass() {
		if(player.isFlying())
			return true;
		if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR)
			return true;
		if (player.hasPermission("xenon.bypass"))
			return true;
		return false;
	}

}
