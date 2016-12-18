package net.horizoncode.anticheat.checkbase;

import java.util.Vector;

import net.horizoncode.anticheat.AntiCheatAPI;
import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CheckManager {

	private static Vector<Check> checks = new Vector<Check>();
	private static Plugin pl;

	public CheckManager(Plugin p) {
		pl = p;
		new BukkitRunnable() {
			
			@Override
			public void run() {

				for (Check c : checks) {
					for (Player p : Bukkit.getOnlinePlayers()) {
						FlagPlayer fp = AntiCheatAPI.getInstance().get(p);
						if (fp != null) {
							c.onUpdate(fp);
						}
					}
				}
			}
		}.runTaskTimerAsynchronously(p, 1, 1);
		
		new BukkitRunnable() {

			@Override
			public void run() {

				for (Check c : checks) {
					for (Player p : Bukkit.getOnlinePlayers()) {
						FlagPlayer fp = AntiCheatAPI.getInstance().get(p);
						if (fp != null) {
							c.onUpdate1(fp);
						}
					}
				}
			}
		}.runTaskTimerAsynchronously(p, 20, 20);
	}

	public static void registerCheck(Check c) {
		if (!checks.contains(c)) {
			checks.add(c);
			pl.getServer().getPluginManager().registerEvents(c, pl);
			AntiCheatAPI.getInstance().getACLogger().log(c.getName() + " successfully registered!");
		}
	}

	public Check getCheckbyClass(Class<?> c) {
		for (Check check : checks) {
			if (check.getClass() == c) {
				return check;
			}
		}
		return null;
	}
	
	public Vector<Check> getChecks(){
		return checks;
	}
}
