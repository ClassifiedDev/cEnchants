package me.classified.enchants.enchants;

import me.classified.enchants.cEnchants;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

import me.classified.enchants.utils.API;
import org.bukkit.scheduler.BukkitRunnable;

public class AncientEnchants implements Listener{

	public Plugin plugin = cEnchants.getInstance();
	
	double butcherChance = 2;
	
	@EventHandler
	public void onButcher(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player) {
			if (e.getDamager() instanceof Player) {
				Player victim = (Player) e.getEntity();
				Player attacker = (Player) e.getDamager();
				if(API.hasEnchant("Butcher", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Butcher", attacker.getItemInHand());
					double chance = 0;
					int time = 0;
					if(tier == 1){
						chance = butcherChance;
						time = 2;
					}
					if(tier == 2){
						chance = butcherChance + 1;
                        time = 2;
					}
					if(tier == 3){
						chance = butcherChance + 2;
                        time = 3;
					}
					if(tier == 4){
						chance = butcherChance + 3;
                        time = 4;
					}
					if(API.randDouble(1, 100) <= chance){
                        API.sendDebug(victim, attacker, "Butcher " + API.romanNumerals.get(tier));
						victim.setMaximumNoDamageTicks(0);
                        victim.playSound(victim.getLocation(), Sound.WITHER_IDLE, 1, 2);
                        attacker.playSound(attacker.getLocation(), Sound.LEVEL_UP, 1, 2);
                        /*new BukkitRunnable() {
                            int counter = 0;
                            public void run() {
                                victim.playSound(victim.getLocation(), Sound.DIG_SAND, 1, 2);
                                attacker.playSound(attacker.getLocation(), Sound.DIG_SAND, 1, 2);
                                counter++;
                                if(counter == 20){
                                    this.cancel();
                                }
                            }
                        }.runTask(cEnchants.getInstance());*/
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(cEnchants.getInstance(), new Runnable(){
							public void run() {	
								victim.setMaximumNoDamageTicks(20);
							}
						}, 20 * time);
					}
				}
			}
		}
	}
}

