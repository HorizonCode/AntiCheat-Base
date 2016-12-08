package net.horizoncode.anticheat.checkbase;

import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.Location;
import org.bukkit.event.Listener;

public class Check implements Listener {

  String name;
  boolean disabled;

  public Check(String name) {
    setName(name);
    setDisabled(false);
  }

  public boolean isDisabled() {
    return disabled;
  }

  public String getName() {
    return name;
  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void onInteract(FlagPlayer p) {
  }

  public void onMove(FlagPlayer p, Location from, Location to) {
  }

  public void onUpdate(FlagPlayer p) {
  }

  public void onUpdate1(FlagPlayer p) {
  }
}
