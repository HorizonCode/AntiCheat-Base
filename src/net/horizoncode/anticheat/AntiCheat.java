package net.horizoncode.anticheat;

import java.util.Vector;

import net.horizoncode.anticheat.checkbase.CheckManager;
import net.horizoncode.anticheat.listener.DamageEvent;
import net.horizoncode.anticheat.listener.InteractEvent;
import net.horizoncode.anticheat.listener.JoinEvent;
import net.horizoncode.anticheat.listener.MoveEvent;
import net.horizoncode.anticheat.listener.QuitEvent;
import net.horizoncode.anticheat.listener.TeleportEvent;
import net.horizoncode.anticheat.logging.Logger;
import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCheat extends JavaPlugin {

	private static AntiCheat instance;
	public Logger logger;
	public Vector<FlagPlayer> playerlist = new Vector<FlagPlayer>();
	public CheckManager checkManager;
	private static String ANTICHEAT_NAME = "AntiCheat";

	@Override
	public void onEnable() {
		instance = this;
		logger = new Logger(this);
		registerEvents();
		checkManager = new CheckManager(this);
		logger.log(getANTICHEAT_NAME() + " is now watching");
	}

	public void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new MoveEvent(), this);
		Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
		Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
		Bukkit.getPluginManager().registerEvents(new DamageEvent(), this);
		Bukkit.getPluginManager().registerEvents(new TeleportEvent(), this);
	}

	public static AntiCheat getInstance() {
		return instance;
	}

	public static String getANTICHEAT_NAME() {
		return ANTICHEAT_NAME;
	}

	public FlagPlayer get(Player p) {
		for (FlagPlayer fp : playerlist) {
			if (fp.getPlayer() == p) {
				return fp;
			}
		}
		FlagPlayer newfp = new FlagPlayer(p);
		playerlist.add(newfp);
		return newfp;
	}
}
