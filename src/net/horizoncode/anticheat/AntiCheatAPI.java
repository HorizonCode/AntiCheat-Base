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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCheatAPI extends JavaPlugin {

	private static AntiCheatAPI instance;
	private static Logger logger;
	public Vector<FlagPlayer> playerlist = new Vector<FlagPlayer>();
	private static CheckManager checkManager;
	private static String ANTICHEAT_NAME = "AntiCheat";

	public static AntiCheatAPI getNewAPI(String AntiCheatName) {
		ANTICHEAT_NAME = AntiCheatName;
		logger = new Logger(instance);
		registerEvents();
		checkManager = new CheckManager(instance);
		logger.log(getANTICHEAT_NAME() + " is now watching");
		return AntiCheatAPI.instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		System.out.println("AntiCheatAPI loaded");
	}

	private static void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), (Plugin) instance);
		Bukkit.getPluginManager().registerEvents(new MoveEvent(), (Plugin) instance);
		Bukkit.getPluginManager().registerEvents(new InteractEvent(), (Plugin) instance);
		Bukkit.getPluginManager().registerEvents(new QuitEvent(), (Plugin) instance);
		Bukkit.getPluginManager().registerEvents(new DamageEvent(), (Plugin) instance);
		Bukkit.getPluginManager().registerEvents(new TeleportEvent(), (Plugin) instance);
	}

	public static AntiCheatAPI getInstance() {
		return instance;
	}

	public Logger getACLogger() {
		return logger;
	}

	public CheckManager getCheckManager() {
		return checkManager;
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
