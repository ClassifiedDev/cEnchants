package me.classified.enchants.enchants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.codingforcookies.armorequip.ArmorEquipEvent;

import me.classified.enchants.utils.API;
import me.classified.enchants.utils.ParticleEffect;
import me.classified.enchants.utils.ParticleEffect.BlockData;

public class LegendaryEnchants implements Listener{

	double greedChance = 15.0;
	double lifestealChance = 4.0;
	double rageChance = 10.0;
	double meteorChance = 1.0;
	double auraChance = 5.0;
	double immolationChance = 13.0;
	double barbarianChance = 5.0;
	double enrageChance = 8.0;
	double lifelineChance = 2.0;
	double jetpackChance = 30.0;

	double reinforcedChance = 20.0;
	double adrenalineChance = 5.0;
	double eyepatchChance = 30.0;
	double bloodthirstyChance = 2.0;

	boolean testing = false;
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
        if(testing){
            if ((e.getDamager() instanceof Player)){
                if((e.getEntity() instanceof Player)){
                    Player target = (Player) e.getEntity();
                    Player attacker = (Player)e.getDamager();
                    attacker.sendMessage(API.color("&c&l" + target.getName() + " HEALTH: &7" + target.getHealth()));
                }
            }
        }
	}

	@EventHandler
	public void onJuggernaut(ArmorEquipEvent e){
		Player p = e.getPlayer();
		if (!(e.getNewArmorPiece() == null) && (e.getNewArmorPiece().getType() != Material.AIR)){
			if(API.hasEnchant("Juggernaut", e.getNewArmorPiece())){
				int tier = API.getEnchantLvl("Juggernaut", e.getNewArmorPiece()); 	  
				if(tier == 1){
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 0));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 0));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Juggernaut " + API.romanNumerals.get(tier));
					}
				}
				if(tier == 2){
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 1));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Juggernaut " + API.romanNumerals.get(tier));
					}
				}
				if(tier == 3){
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 1));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Juggernaut " + API.romanNumerals.get(tier));
					}
				}
				if(tier == 4){
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 2));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 2));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 2));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Juggernaut " + API.romanNumerals.get(tier));
					}
				}
			}
		}
		if (!(e.getOldArmorPiece() == null) && !(e.getOldArmorPiece().getType() == Material.AIR)){
			if(API.hasEnchant("Juggernaut", e.getOldArmorPiece())){
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.SLOW);
				p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
			}
		}
	}

	@EventHandler
	public void onGreed(EntityDeathEvent e){
		if(!(e.getEntity() instanceof Player) && e.getEntity().getKiller() instanceof Player){
			Player p = e.getEntity().getKiller();
			if(API.hasEnchant("Greed", p.getItemInHand())){
				int tier = API.getEnchantLvl("Greed", p.getItemInHand());
				int addChance = 0;
				if(tier == 1){
					addChance = 5;
					if(API.randDouble(1, 100) <= greedChance + addChance){
						int normalXP = e.getDroppedExp();
						int greedxp = (int) (normalXP * 1.25);
						e.setDroppedExp(greedxp);
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Greed " + API.romanNumerals.get(tier));
						}
					}
					return;
				}
				if(tier == 2){
					addChance = 10;
					if(API.randDouble(1, 100) <= greedChance + addChance){
						int normalXP = e.getDroppedExp();
						int greedxp = (int) (normalXP * 1.5);
						e.setDroppedExp(greedxp);
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Greed " + API.romanNumerals.get(tier));
						}
					}
					return;
				}
				if(tier == 3){
					addChance = 15;
					if(API.randDouble(1, 100) <= greedChance + addChance){
						int normalXP = e.getDroppedExp();
						int greedxp = (int) (normalXP * 1.75);
						e.setDroppedExp(greedxp);
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Greed " + API.romanNumerals.get(tier));
						}
					}
					return;
				}
				if(tier == 4){
					addChance = 20;
					if(API.randDouble(1, 100) <= greedChance + addChance){
						int normalXP = e.getDroppedExp();
						int greedxp = (int) (normalXP * 2);
						p.sendMessage("" + normalXP);
						p.sendMessage("" + greedxp);
						e.setDroppedExp(greedxp);
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Greed " + API.romanNumerals.get(tier));
						}
					}
					return;
				}
			}
		}
	}

	@EventHandler
	public void onLifesteal(EntityDamageByEntityEvent e){
		if ((e.getDamager() instanceof Player)){
			if(e.getEntity() instanceof LivingEntity){
				LivingEntity target = (LivingEntity) e.getEntity();
				Player attacker = (Player)e.getDamager();
				if (API.hasEnchant("Lifesteal", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Lifesteal", attacker.getItemInHand());
					double addChance = 0;
					int stealHearts = 0;
					if (tier == 1) {
						addChance = 0;
						stealHearts = 1;
					}
					if (tier == 2) {
						addChance = 1;
						stealHearts = 1;
					}
					if (tier == 3) {
						addChance = 2;
						stealHearts = API.randomInt(1, 2);
					}
					if (tier == 4) {
						addChance = 3;
						stealHearts = API.randomInt(1, 3);
					}
					if (tier == 5) {
						addChance = 3;
						stealHearts = API.randomInt(2, 4);
					}
					if(API.randDouble(1, 100) <= lifestealChance + addChance){
						if (attacker.getHealth() + stealHearts <= attacker.getMaxHealth()) {
							attacker.setHealth(attacker.getHealth() + stealHearts);
							attacker.sendMessage(API.color("&8&l** &d&lLIFESTEAL &7(+" + stealHearts + " ♥&7) &8&l**"));
							if(API.DEBUG_MODE){
								API.sendDebug(target, attacker, "Lifesteal " + API.romanNumerals.get(tier));
								API.sendDebug(attacker, attacker, "Lifesteal " + API.romanNumerals.get(tier));
							}
						}
						if (target.getHealth() - stealHearts != 0.0D) {
							//target.setHealth((target).getHealth() - stealHearts / 2);
							target.damage(stealHearts);
							if(API.DEBUG_MODE){
								API.sendDebug(target, attacker, "Lifesteal " + API.romanNumerals.get(tier));
								API.sendDebug(attacker, attacker, "Lifesteal " + API.romanNumerals.get(tier));
							}
						}
					}
				}
			}		
		}
	}


	@EventHandler
	public void onMeteor(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player p = (Player)e.getEntity();
			if (API.hasEnchant("Meteor", p.getInventory().getChestplate())){
				int tier = API.getEnchantLvl("Meteor", p.getInventory().getChestplate());
				double addChance = 0;
				int amount = 0;
				if (tier == 10) {
					addChance = 2;
					amount = 3;
				}
				if (tier == 9) {
					addChance = 1.5;
					amount = 3;
				}
				if (tier == 8) {
					addChance = 1.2;
					amount = 2;
				}
				if (tier == 7) {
					addChance = 1;
					amount = 2;
				}
				if (tier == 6) {
					addChance = 0.8;
					amount = 2;
				}
				if (tier == 5) {
					addChance = 0.6;
					amount = 1;
				}
				if (tier == 4) {
					addChance = 0.5;
					amount = 1;
				}
				if (tier == 3) {
					addChance = 0.4;
					amount = 1;
				}
				if (tier == 2) {
					addChance = 0.2;
					amount = 1;
				}
				if (tier == 1) {
					addChance = 0.1;
					amount = 1;
				}
				if (API.randDouble(1, 100) <= meteorChance + addChance) {
					for (int i = 0; i < amount; i++){
						Location loc = p.getEyeLocation().toVector()
								.add(p.getLocation().getDirection().multiply(2)).toLocation(p.getWorld(), 
										p.getLocation().getYaw(), p.getLocation().getPitch());
						Fireball fireball = (Fireball)p.getWorld().spawn(loc, Fireball.class);
						fireball.setShooter(p);
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Meteor " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}


	@EventHandler
	public void onAura(EntityDamageByEntityEvent e){
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			Player attacker = (Player)e.getDamager();
			if (API.hasEnchant("Aura", attacker.getItemInHand())){
				int tier = API.getEnchantLvl("Aura", attacker.getItemInHand());
				int addChance = 0;
				int radius = 0;
				if (tier == 5) {
					addChance = 10;
					radius = 10;
				}
				if (tier == 4) {
					addChance = 8;
					radius = 8;
				}
				if (tier == 3) {
					addChance = 6;
					radius = 6;
				}
				if (tier == 2) {
					addChance = 4;
					radius = 4;
				}
				if (tier == 1) {
					addChance = 2;
					radius = 2;
				}
				if (API.randDouble(1, 100) <= auraChance + addChance){
					List<Player> nearbyplayers = API.getNearbyPlayers(attacker, radius);
					for (int i = 0; i < nearbyplayers.size(); i++){
						Player target = (Player)nearbyplayers.get(i);
						if (!target.equals(attacker)){
							int damage = API.randomInt(1, 2);
							if (target.getHealth() - damage != 0.0D){
								target.damage(damage);
								if(API.DEBUG_MODE){
									API.sendDebug(attacker, attacker, "Aura " + API.romanNumerals.get(tier));
								}
							}
						}
					}
				}
			}
		}
	}

	HashMap<Player, Double> rageStacks = new HashMap<Player, Double>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onRage(EntityDamageByEntityEvent e){
		if (e.getDamager() instanceof Player){
			if(e.getEntity() instanceof LivingEntity){
				LivingEntity target = (LivingEntity) e.getEntity();
				Player attacker = (Player)e.getDamager();
				if (API.hasEnchant("Rage", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Rage", attacker.getItemInHand());
					int addChance = 0;
					if(tier == 1){
						addChance = 0;
					}
					if(tier == 2){
						addChance = 5;
					}
					if(tier == 3){
						addChance = 10;
					}
					if(tier == 4){
						addChance = 15;
					}
					if(tier == 5){
						addChance = 20;
					}
					if(tier == 6){
						addChance = 25;
					}
					if(API.randDouble(1, 100) <= rageChance + addChance){
						if(rageStacks.containsKey(attacker)){
							if(rageStacks.get(attacker) >= 2.5){
								rageStacks.put(attacker, rageStacks.get(attacker));
							}
							else{
								rageStacks.put(attacker, rageStacks.get(attacker) + 0.1);
							}
						}
						else{
							rageStacks.put(attacker, 1.1);
						}
						double damageMultiplier = rageStacks.get(attacker);
						int damage = API.randomInt(1, 2);
						if (target.getHealth() - (damage * damageMultiplier) != 0.0D) {
							//target.setHealth(target.getHealth() - damage * damageMultiplier);
							target.damage(damage * damageMultiplier);
							attacker.sendMessage("DAMAGE: " + damage);
							attacker.sendMessage("DAMAGE MULTIPLIER: " + damageMultiplier);
							attacker.sendMessage("RAGE STACK: " + rageStacks.get(attacker));
							attacker.sendMessage("TOTAL DAMAGE: " + damage * damageMultiplier);
							if(API.randDouble(1, 100) <= 75) {
								ParticleEffect.BLOCK_CRACK.display(new BlockData(Material.REDSTONE_BLOCK, (byte) 0), 0.3f, 1.3f, 0.3f, 1, 50, target.getLocation(), 75);
							}
							attacker.playEffect(target.getLocation(), Effect.STEP_SOUND, 152);
							target.getWorld().playSound(target.getLocation(), Sound.DIG_SNOW, 10, 1);
							target.setFireTicks(60);
							if(API.DEBUG_MODE){
								API.sendDebug(target, attacker, "Rage " + API.romanNumerals.get(tier));
								API.sendDebug(attacker, attacker, "Rage " + API.romanNumerals.get(tier));
							}
						}
					}
					if(API.randDouble(1, 100) <= 75) {
						ParticleEffect.BLOCK_CRACK.display(new BlockData(Material.REDSTONE_BLOCK, (byte) 0), 0.3f, 1.3f, 0.3f, 1, 50, target.getLocation(), 75);
					}
					attacker.playEffect(target.getLocation(), Effect.STEP_SOUND, 152);

				}
			}
		}
	}

	@EventHandler
	public void onRageStackRemove(EntityDamageByEntityEvent e){
		if (e.getDamager() instanceof LivingEntity && e.getEntity() instanceof Player){
			Player target = (Player) e.getEntity();
			if(rageStacks.containsKey(target)){
				rageStacks.remove(target);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onImmolation(EntityDamageByEntityEvent e){
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			Player target = (Player) e.getEntity();
			Player attacker = (Player)e.getDamager();
			if (API.hasEnchant("Immolation", attacker.getItemInHand())){
				int tier = API.getEnchantLvl("Immolation", attacker.getItemInHand());
				int addChance = 0;
				int damage = 0;
				if(tier == 1){
					addChance = 0;
					damage = 1;
				}
				if(tier == 2){
					addChance = 1;
					damage = 1;
				}
				if(tier == 3){
					addChance = 3;
					damage = API.randomInt(1, 2);
				}
				if(tier == 4){
					addChance = 5;
					damage = API.randomInt(1, 3);
				}
				if(API.randDouble(1, 100) <= immolationChance + addChance){
					if (target.getHealth() - damage != 0.0D) {
						//target.setHealth(target.getHealth() - damage);
						target.damage(damage);
						ParticleEffect.BLOCK_CRACK.display(new BlockData(Material.STAINED_GLASS, (byte) 2), 0.2f, 1.2f, 0.2f, 1, 100, target.getLocation(), 75);
						ParticleEffect.BLOCK_CRACK.display(new BlockData(Material.STAINED_GLASS, (byte) 3), 0.2f, 1.2f, 0.2f, 1, 100, target.getLocation(), 75);
						attacker.playEffect(target.getLocation(), Effect.POTION_BREAK, 0);
						target.playEffect(target.getLocation(), Effect.POTION_BREAK, 0);
						target.setFireTicks(60);
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Immolation " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Immolation " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onBarbarian(EntityDamageByEntityEvent event){
		if (event.getDamager() instanceof Player && event.getEntity() instanceof Player){
			Player attacker = (Player)event.getDamager();
			Player target = (Player)event.getEntity();
			if (target.getItemInHand().getType().toString().contains("AXE") && 
					(API.hasEnchant("Barbarian", attacker.getItemInHand()))){
				int tier = API.getEnchantLvl("Barbarian", attacker.getItemInHand());
				int addChance = 0;
				int addedDamage = 0;
				if (tier == 4) {
					addChance = 5;
					addedDamage = 2;
				}
				if (tier == 3) {
					addChance = 3;
					addedDamage = 1;
				}
				if (tier == 2) {
					addChance = 2;
					addedDamage = 1;
				}
				if (tier == 1) {
					addChance = 0;
					addedDamage = 1;
				}
				if (API.randDouble(1, 100) <= barbarianChance + addChance) {
					if (target.getHealth() - addedDamage != 0.0D) {
						//target.setHealth(target.getHealth() - addedDamage);
						target.damage(addedDamage);
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Barbarian " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Barbarian " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onEnrage(EntityDamageByEntityEvent event){
		if (event.getDamager() instanceof Player){
			Player attacker = (Player)event.getDamager();
			if (API.hasEnchant("Enrage", attacker.getItemInHand())){
				int tier = API.getEnchantLvl("Enrage", attacker.getItemInHand());
				double health = attacker.getHealth();
				if(health <= 4){
					if(tier == 1){
						event.setDamage(event.getDamage() + 1);
					}
					if(tier == 2){
						event.setDamage(event.getDamage() + 1);
					}
					if(tier == 3){
						event.setDamage(event.getDamage() + 2);
					}
					if(API.DEBUG_MODE){
						API.sendDebug(attacker, attacker, "Enrage " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onLifeline(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			Player user = (Player) e.getEntity();
			if(API.hasEnchant("Lifeline", user.getInventory().getHelmet())){
				int tier  = API.getEnchantLvl("Lifeline", user.getInventory().getHelmet());
				int addChance = 0;
				if(tier == 1){
					addChance = 0;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 1.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 1.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier));
							}
						}
					}
				}
				if(tier == 2){
					addChance = 1;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 2.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 2.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier));
							}
						}
					}
				}
				if(tier == 3){
					addChance = 2;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 3.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 3.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier) + " (Helmet)");
							}
						}
					}
				}
			}
			if(API.hasEnchant("Lifeline", user.getInventory().getChestplate())){
				int tier  = API.getEnchantLvl("Lifeline", user.getInventory().getChestplate());
				int addChance = 0;
				if(tier == 1){
					addChance = 0;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 1.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 1.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier));
							}
						}
					}
				}
				if(tier == 2){
					addChance = 1;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 2.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 2.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier));
							}
						}
					}
				}
				if(tier == 3){
					addChance = 2;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 3.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 3.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier) + " (Chestplate)");
							}
						}
					}
				}
			}
			if(API.hasEnchant("Lifeline", user.getInventory().getLeggings())){
				int tier  = API.getEnchantLvl("Lifeline", user.getInventory().getLeggings());
				int addChance = 0;
				if(tier == 1){
					addChance = 0;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 1.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 1.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier));
							}
						}
					}
				}
				if(tier == 2){
					addChance = 1;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 2.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 2.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier));
							}
						}
					}
				}
				if(tier == 3){
					addChance = 2;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 3.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 3.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier) + " (Leggings)");
							}
						}
					}
				}
			}
			if(API.hasEnchant("Lifeline", user.getInventory().getBoots())){
				int tier  = API.getEnchantLvl("Lifeline", user.getInventory().getBoots());
				int addChance = 0;
				if(tier == 1){
					addChance = 0;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 1.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 1.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier));
							}
						}
					}
				}
				if(tier == 2){
					addChance = 1;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 2.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 2.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier));
							}
						}
					}
				}
				if(tier == 3){
					addChance = 2;
					if(API.randDouble(1, 100) <= lifelineChance + addChance){
						double currentHealth = user.getHealth();
						if (currentHealth + 3.0D <= user.getMaxHealth()){
							user.setHealth(user.getHealth() + 3.0D);
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Lifeline " + API.romanNumerals.get(tier) + " (Boots)");
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onHyper(ArmorEquipEvent e){
		Player p = e.getPlayer();
		if (!(e.getNewArmorPiece() == null) && (e.getNewArmorPiece().getType() != Material.AIR)){
			if(API.hasEnchant("Hyper", e.getNewArmorPiece())){
				int tier = API.getEnchantLvl("Hyper", e.getNewArmorPiece()); 	  
				if(tier == 1){
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Hyper " + API.romanNumerals.get(tier));
					}
				}
				if(tier == 2){
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Hyper " + API.romanNumerals.get(tier));
					}
				}
				if(tier == 3){
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Hyper " + API.romanNumerals.get(tier));
					}
				}
			}
		}
		if (!(e.getOldArmorPiece() == null) && !(e.getOldArmorPiece().getType() == Material.AIR)){
			if(API.hasEnchant("Hyper", e.getOldArmorPiece())){
				p.removePotionEffect(PotionEffectType.SPEED);
			}
		}
	}

	public static void launchPlayer(Player p) {
		p.setVelocity(p.getVelocity().setY(4));
	}

	@EventHandler
	public void onJetpack(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			Player user = (Player) e.getEntity();
			List<Player> nearbyplayers = API.getNearbyPlayers(user, 10);
			if(user.getHealth() <= 9.0D){
				if(API.hasEnchant("Jetpack", user.getInventory().getBoots())){
					int tier  = API.getEnchantLvl("Jetpack", user.getInventory().getBoots());
					int addChance = 0;
					if(tier == 1){
						addChance = 0;
						if(API.randDouble(1, 100) <= jetpackChance + addChance){
							user.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 2));
                            launchPlayer(user);
                            for(Player p : nearbyplayers){
                                p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1, 2);
                            }
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Jetpack " + API.romanNumerals.get(tier));
							}
						}

					}
					if(tier == 2){
						addChance = 10;
						if(API.randDouble(1, 100) <= jetpackChance + addChance){
							user.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 2));
                            launchPlayer(user);
                            for(Player p : nearbyplayers){
                                p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1, 2);
                            }
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Jetpack " + API.romanNumerals.get(tier));
							}
						}

					}
					if(tier == 3){
						addChance = 20;
						if(API.randDouble(1, 100) <= jetpackChance + addChance){
							user.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 3));
							launchPlayer(user);
                            for(Player p : nearbyplayers){
                                p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1, 2);
                            }
							if(API.DEBUG_MODE){
								API.sendDebug(user, user, "Jetpack " + API.romanNumerals.get(tier));
							}
						}
					}
				}
			}
		}
	}
	@EventHandler
	public void onReinforced(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			Player user = (Player) e.getEntity();
			if(API.hasEnchant("Reinforced", user.getInventory().getHelmet())){
				int tier  = API.getEnchantLvl("Reinforced", user.getInventory().getHelmet());
				int addChance = 0;
				if(tier == 1){
					addChance = 0;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getHelmet().setDurability((short) (user.getInventory().getHelmet().getDurability() + 1));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
				if(tier == 2){
					addChance = 1;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getHelmet().setDurability((short) (user.getInventory().getHelmet().getDurability() + 2));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
				if(tier == 3){
					addChance = 2;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getHelmet().setDurability((short) (user.getInventory().getHelmet().getDurability() + 3));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
			}
			if(API.hasEnchant("Reinforced", user.getInventory().getChestplate())){
				int tier  = API.getEnchantLvl("Reinforced", user.getInventory().getChestplate());
				int addChance = 0;
				if(tier == 1){
					addChance = 0;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getChestplate().setDurability((short) (user.getInventory().getChestplate().getDurability() + 1));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
				if(tier == 2){
					addChance = 1;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getChestplate().setDurability((short) (user.getInventory().getChestplate().getDurability() + 2));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
				if(tier == 3){
					addChance = 2;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getChestplate().setDurability((short) (user.getInventory().getChestplate().getDurability() + 3));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
			}
			if(API.hasEnchant("Reinforced", user.getInventory().getLeggings())){
				int tier  = API.getEnchantLvl("Reinforced", user.getInventory().getLeggings());
				int addChance = 0;
				if(tier == 1){
					addChance = 0;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getLeggings().setDurability((short) (user.getInventory().getLeggings().getDurability() + 1));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
				if(tier == 2){
					addChance = 1;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getLeggings().setDurability((short) (user.getInventory().getLeggings().getDurability() + 2));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
				if(tier == 3){
					addChance = 2;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getLeggings().setDurability((short) (user.getInventory().getLeggings().getDurability() + 3));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
			}
			if(API.hasEnchant("Reinforced", user.getInventory().getBoots())){
				int tier  = API.getEnchantLvl("Reinforced", user.getInventory().getBoots());
				int addChance = 0;
				if(tier == 1){
					addChance = 0;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getBoots().setDurability((short) (user.getInventory().getBoots().getDurability() + 1));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
				if(tier == 2){
					addChance = 1;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getBoots().setDurability((short) (user.getInventory().getBoots().getDurability() + 2));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
				if(tier == 3){
					addChance = 2;
					if(API.randDouble(1, 100) <= reinforcedChance + addChance){
						user.getInventory().getBoots().setDurability((short) (user.getInventory().getBoots().getDurability() + 3));
						if(API.DEBUG_MODE){
							API.sendDebug(user, user, "Reinforced " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}
	@EventHandler
	public void onAdrenaline(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player){
			Player target = (Player)e.getEntity();
			if (API.hasEnchant("Adrenaline", target.getItemInHand())){
				int tier = API.getEnchantLvl("Adrenaline", target.getItemInHand());
				int addChance = 0;
				if (tier == 4) {
					addChance = 5;
				}
				if (tier == 3) {
					addChance = 3;
				}
				if (tier == 2) {
					addChance = 2;
				}
				if (tier == 1) {
					addChance = 0;
				}
				if (API.randDouble(1, 100) <= adrenalineChance + addChance) {
					e.setCancelled(true);
					target.playSound(target.getLocation(), Sound.PISTON_EXTEND, 10, 2);
					int toHeal = API.randomInt(1, 3);
					if(target.getMaxHealth() < target.getHealth() + toHeal) {
						target.setHealth(target.getMaxHealth());
						target.sendMessage(API.color("&8&l** &c&lADRENALINE &7(+"+ toHeal +"♥) &8&l**"));
						return;
					}
					target.sendMessage(API.color("&8&l** &c&lADRENALINE &7(+"+ toHeal +"♥) &8&l**"));
					target.setHealth(target.getHealth() + toHeal);
					target.playSound(target.getLocation(), Sound.PISTON_EXTEND, 10, 2);
					if(API.DEBUG_MODE){
						API.sendDebug(target, target, "Adrenaline " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

}
