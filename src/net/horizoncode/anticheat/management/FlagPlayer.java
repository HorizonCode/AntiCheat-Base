package net.horizoncode.anticheat.management;

import net.horizoncode.anticheat.checkbase.Check;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class FlagPlayer {

	private Player player;
	private String name;
	private long lastFlag;
	private int timebetweenflags = 1;

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
		if (player.isFlying())
			return true;
		if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR)
			return true;
		if (player.hasPermission("anticheat.bypass"))
			return true;
		return false;
	}

	public void flag(Check c, String message) {
		if (!(lastFlag + timebetweenflags * 1000L < System.currentTimeMillis()))
			return;
		lastFlag = System.currentTimeMillis();
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (all.isOp() || all.hasPermission("anticheat.notify")) {
				all.sendMessage("§8> §7The Player " + player.getName() + " §7was");
				all.sendMessage("§8> §7detected for: " + c.getName());
				all.sendMessage("§8> §7" + message);
			}
		}
		Bukkit.getConsoleSender().sendMessage("§8> §7The Player " + player.getName() + " §7was");
		Bukkit.getConsoleSender().sendMessage("§8> §7detected for: " + c.getName());
		Bukkit.getConsoleSender().sendMessage("§8> §7" + message);	
	}

	public void flag(Check c) {
		if (!(lastFlag + timebetweenflags * 1000L < System.currentTimeMillis()))
			return;
		lastFlag = System.currentTimeMillis();
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (all.isOp() || all.hasPermission("anticheat.notify")) {
				all.sendMessage("§8> §7The Player " + player.getName() + " §7was");
				all.sendMessage("§8> §7detected for: " + c.getName());
			}
		}
		Bukkit.getConsoleSender().sendMessage("§8> §7The Player " + player.getName() + " §7was");
		Bukkit.getConsoleSender().sendMessage("§8> §7detected for: " + c.getName());
	}
}
