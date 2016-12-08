package net.horizoncode.anticheat.api;

import net.horizoncode.anticheat.checkbase.Check;

import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerViolationEvent extends PlayerEvent implements Cancellable {

  private static final HandlerList handlers = new HandlerList();
  private String flagname;
  private boolean cancelled;
  private String message;

  public PlayerViolationEvent(String name, Check flag, String Message) {
    super(Bukkit.getPlayerExact(name));
    this.flagname = flag.getName();
    this.message = Message;
  }

  @Override
  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

  public boolean isCancelled() {
    return this.cancelled;
  }

  public void setCancelled(boolean arg0) {
    this.cancelled = arg0;
  }

  public String getFlagName() {
    return this.flagname;
  }

  public String getMessage() {
    return message;
  }
}
