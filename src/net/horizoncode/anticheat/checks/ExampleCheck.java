package net.horizoncode.anticheat.checks;

import net.horizoncode.anticheat.checkbase.Check;
import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.Location;

public class ExampleCheck extends Check {

	public ExampleCheck() {
		super("Example");
	}
	
	@Override
	public void onInteract(FlagPlayer p) {

	}
	
	@Override
	public void onMove(FlagPlayer p, Location from, Location to) {

	}
	
	@Override
	public void onUpdate(FlagPlayer p) {
	}
	
	@Override
	public void onUpdate1(FlagPlayer p) {
		
	}

}
