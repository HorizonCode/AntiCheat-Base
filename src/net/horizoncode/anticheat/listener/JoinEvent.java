package net.horizoncode.anticheat.listener;

import net.horizoncode.anticheat.AntiCheat;
import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    AntiCheat.getInstance().playerlist.add(new FlagPlayer(e.getPlayer()));
  }
}
