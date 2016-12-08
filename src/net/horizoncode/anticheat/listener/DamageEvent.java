package net.horizoncode.anticheat.listener;

import net.horizoncode.anticheat.AntiCheat;
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
				FlagPlayer fp = AntiCheat.getInstance().get(p);
				for(Check c : AntiCheat.getInstance().checkManager.checks){
					c.onDamage(fp, e.getEntity());
				}
			}
		}
	}

}
