package net.horizoncode.anticheat.checkbase;

import java.util.Vector;

import net.horizoncode.anticheat.AntiCheat;
import net.horizoncode.anticheat.checks.ExampleCheck;
import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CheckManager {

  public Vector<Check> checks;
  public Plugin pl;

  public CheckManager(Plugin p) {
    pl = p;
    checks = new Vector<Check>();
    registerCheck(new ExampleCheck());

    new BukkitRunnable() {

      @Override
      public void run() {

        for (Check c : checks) {
          for (Player p : Bukkit.getOnlinePlayers()) {
            FlagPlayer fp = AntiCheat.getInstance().get(p);
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
            FlagPlayer fp = AntiCheat.getInstance().get(p);
            if (fp != null) {
              c.onUpdate1(fp);
            }
          }
        }
      }
    }.runTaskTimerAsynchronously(p, 20, 20);
  }

  public void registerCheck(Check c) {
    if (!checks.contains(c)) {
      checks.add(c);
      pl.getServer().getPluginManager().registerEvents(c, pl);
      AntiCheat.getInstance().logger.log(c.getName() + " successfully registered!");
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
}
