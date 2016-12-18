package net.horizoncode.anticheat.listener;

import net.horizoncode.anticheat.AntiCheatAPI;
import net.horizoncode.anticheat.checkbase.Check;
import net.horizoncode.anticheat.management.FlagPlayer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageEvent implements Listener {
	
	@EventHandler
	public void onDamageByEntity(EntityDamageByEntityEvent e){
		if(e.getDamager() != null){
			if(e.getDamager() instanceof Player){
				Player p = (Player) e.getDamager();
				FlagPlayer fp = AntiCheatAPI.getInstance().get(p);
				for(Check c : AntiCheatAPI.getInstance().getCheckManager().getChecks()){
					c.onDamage(fp, e.getEntity());
				}
			}
		}
	}

}
