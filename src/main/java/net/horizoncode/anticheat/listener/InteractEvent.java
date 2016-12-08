package net.horizoncode.anticheat.listener;

import net.horizoncode.anticheat.AntiCheat;
import net.horizoncode.anticheat.checkbase.Check;
import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {

  @EventHandler
  public void onInteract(PlayerInteractEvent e) {
    for (Check c : AntiCheat.getInstance().checkManager.checks) {
      FlagPlayer fp = AntiCheat.getInstance().get(e.getPlayer());
      if (fp != null) {
        c.onInteract(fp);
      }
    }
  }
}