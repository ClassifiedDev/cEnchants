package me.classified.enchants.enchants;

import me.classified.enchants.cEnchants;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import com.gmail.nossr50.runnables.skills.BleedTimerTask;
import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

import me.classified.enchants.utils.API;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class AdvancedEnchants implements Listener{

	double shockChance = 5.0;
	double obsidiandestroyerChance = 20.0;
	double replenishChance = 1.75;
	double confusionChance = 2.0;
	double radioactiveChance = 5.0;
	double selfdestructChance = 5.0;
	double creeperChance = 60.0;
	double shieldChance = 4.0;
	double ninjaChance = 25.0;
	double marshmallowChance = 1.0;
	double thiefChance = 5.0;
	double counterChance = 2.0;
	double woundChance = 5.0;
	double safeguardChance = 0.5;
	double pushChance = 15.0;
	double virusChance = 4.0;
	double minerChance = 50.0;
	double wormholeChance = 25.0;
	double fractureChance = 7.0;

	double eyepatchChance = 30.0;
	
	public Economy econ = cEnchants.econ;

	@EventHandler
	public void onShock(EntityDamageByEntityEvent e){
		if ((e.getDamager() instanceof Player)){
			if((e.getEntity() instanceof Player)){
				Player target = (Player) e.getEntity();
				Player attacker = (Player)e.getDamager();
				if (API.hasEnchant("Shock", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Shock", attacker.getItemInHand());
					int addChance = 80;
					if (tier == 3) {
						addChance = 6;
					}
					if (tier == 2) {
						addChance = 4;
					}
					if (tier == 1) {
						addChance = 2;
					}
					if (API.randDouble(1, 100) <= shockChance + addChance) {
						World world = target.getWorld();
						Location l = target.getLocation();
						world.strikeLightningEffect(l);
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Shock " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Shock " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onObbyDestroy(BlockDamageEvent e){
		Player p = e.getPlayer();
		FPlayer fp = FPlayers.getInstance().getByPlayer(p);
		Block b = e.getBlock();
		Location bl = b.getLocation();
		FLocation fLoc = new FLocation(bl);
		Faction pf = fp.getFaction();
		Faction bf = Board.getInstance().getFactionAt(fLoc);
		Faction wilderness = Factions.getInstance().getWilderness();
		Faction warzone = Factions.getInstance().getWarZone();
		if(bf == warzone){
			return;
		}
		if(bf == wilderness || bf == pf){
			if ((e.getBlock().getType() == Material.OBSIDIAN) && 
					API.hasEnchant("Obsidian Destroyer", p.getItemInHand())){
				int tier = API.getEnchantLvl("Obsidian Destroyer", p.getItemInHand());
				int addChance = 0;
				if(tier == 1){
					addChance = 5;
				} 
				if(tier == 2){
					addChance = 10;
				} 
				if(tier == 3){
					addChance = 15;
				} 
				if(tier == 4){
					addChance = 20;
				}
				if(tier == 5){
					addChance = 25;
				}
				if (API.randDouble(1, 100) <= obsidiandestroyerChance + addChance){
					e.getBlock().breakNaturally();
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Obsidian Destroyer " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onSprings(ArmorEquipEvent e){
		Player p = e.getPlayer();
		if (!(e.getNewArmorPiece() == null) && (e.getNewArmorPiece().getType() != Material.AIR)){
			if(API.hasEnchant("Springs", e.getNewArmorPiece())){
				int tier = API.getEnchantLvl("Springs", e.getNewArmorPiece()); 	  
				if(tier == 1){
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 0));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Springs " + API.romanNumerals.get(tier));
					}
				}
				if(tier == 2){
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Springs " + API.romanNumerals.get(tier));
					}
				}
				if(tier == 3){
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 2));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Springs " + API.romanNumerals.get(tier));
					}
				}
			}
		}
		if (!(e.getOldArmorPiece() == null) && !(e.getOldArmorPiece().getType() == Material.AIR)){
			if(API.hasEnchant("Springs", e.getOldArmorPiece())){
				p.removePotionEffect(PotionEffectType.JUMP);
			}
		}
	}

	@EventHandler
	public void onReplenish(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			Player target = (Player) e.getEntity();
			if (API.hasEnchant("Replenish", target.getInventory().getChestplate()) ||
					API.hasEnchant("Replenish", target.getInventory().getLeggings())){
				int tier = 0;
				if(API.hasEnchant("Replenish", target.getInventory().getChestplate())){
					tier = API.getEnchantLvl("Replenish", target.getInventory().getChestplate());
				}
				else if(API.hasEnchant("Replenish", target.getInventory().getLeggings())){
					tier = API.getEnchantLvl("Replenish", target.getInventory().getLeggings());
				}
				int addChance = 0;
				int duration = 0;
				int level = 0;
				if (tier == 1) {
					addChance = 0;
					duration = 2 *20;
					level = 0;
				}
				if (tier == 2) {
					addChance = 2;
					duration = 3 * 20;
					level = 1;
				}
				if(API.randDouble(1, 100) <= replenishChance + addChance){
					target.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, duration, level));
					if(API.DEBUG_MODE){
						API.sendDebug(target, target, "Replenish " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onConfusion(EntityDamageByEntityEvent e){
		if ((e.getDamager() instanceof Player)){
			if((e.getEntity() instanceof Player)){
				Player target = (Player) e.getEntity();
				Player attacker = (Player)e.getDamager();
				if (API.hasEnchant("Confusion", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Confusion", attacker.getItemInHand());
					double addChance = 0;
					int duration = 0;
					int level = 0;
					if (tier == 3) {
						addChance = 2;
						duration = 6 * 20;
						level = 2;
					}
					if (tier == 2) {
						addChance = 1;
						duration = 4 * 20;
						level = 1;
					}
					if (tier == 1) {
						addChance = 0;
						duration = 3 * 20;
						level = 0;
					}
					if(API.randDouble(1, 100) <= confusionChance + addChance){
						target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, duration, level));
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Confusion " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Confusion " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onSelfDestruct(EntityDeathEvent e){
		if (e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			if (API.hasEnchant("Self Destruct", p.getInventory().getHelmet()) || 
					API.hasEnchant("Self Destruct", p.getInventory().getChestplate()) || 
					API.hasEnchant("Self Destruct", p.getInventory().getLeggings()) || 
					API.hasEnchant("Self Destruct", p.getInventory().getBoots())){
				int tier = 0;
				if (API.hasEnchant("Self Destruct", p.getInventory().getHelmet())) {
					tier = API.getEnchantLvl("Self Destruct", p.getInventory().getHelmet());
				} else if (API.hasEnchant("Self Destruct", p.getInventory().getChestplate())) {
					tier = API.getEnchantLvl("Self Destruct", p.getInventory().getChestplate());
				} else if (API.hasEnchant("Self Destruct", p.getInventory().getLeggings())) {
					tier = API.getEnchantLvl("Self Destruct", p.getInventory().getLeggings());
				} else if (API.hasEnchant("Self Destruct", p.getInventory().getBoots())) {
					tier = API.getEnchantLvl("Self Destruct", p.getInventory().getBoots());
				}
				int addChance = 0;
				if (tier == 3) {
					addChance = 20;
					if (API.randDouble(1, 100) <= selfdestructChance + addChance){
						Entity tnt = p.getWorld().spawn(p.getLocation().add(0, 1, 0), TNTPrimed.class);
						tnt.setMetadata("SD", new FixedMetadataValue(cEnchants.getInstance(), "SD"));
						((TNTPrimed)tnt).setFuseTicks(3 * 20);

						Entity tnt2 = p.getWorld().spawn(p.getLocation().add(0, 1, 2), TNTPrimed.class);
						tnt2.setMetadata("SD", new FixedMetadataValue(cEnchants.getInstance(), "SD"));
						((TNTPrimed)tnt2).setFuseTicks(3 * 20);

						Entity tnt3 = p.getWorld().spawn(p.getLocation().add(2, 1, 0), TNTPrimed.class);
						tnt3.setMetadata("SD", new FixedMetadataValue(cEnchants.getInstance(), "SD"));
						((TNTPrimed)tnt3).setFuseTicks(3 * 20);
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Self Destruct " + API.romanNumerals.get(tier));
						}
					}
				}
				if (tier == 2) {
					addChance = 10;
					if (API.randDouble(1, 100) <= selfdestructChance + addChance){
						Entity tnt = p.getWorld().spawn(p.getLocation().add(0, 1, 0), TNTPrimed.class);
						tnt.setMetadata("SD", new FixedMetadataValue(cEnchants.getInstance(), "SD"));
						((TNTPrimed)tnt).setFuseTicks(3 * 20);

						Entity tnt2 = p.getWorld().spawn(p.getLocation().add(1, 1, 2), TNTPrimed.class);
						tnt2.setMetadata("SD", new FixedMetadataValue(cEnchants.getInstance(), "SD"));
						((TNTPrimed)tnt2).setFuseTicks(3 * 20);
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Self Destruct " + API.romanNumerals.get(tier));
						}
					}
				}
				if (tier == 1) {
					addChance = 0;
					if (API.randDouble(1, 100) <= selfdestructChance + addChance){
						Entity tnt = p.getWorld().spawn(p.getLocation().add(0, 1, 0), TNTPrimed.class);
						tnt.setMetadata("SD", new FixedMetadataValue(cEnchants.getInstance(), "SD"));
						((TNTPrimed)tnt).setFuseTicks(3 * 20);
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Self Destruct " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onCreeper(EntityDamageEvent e){
		if ((e.getEntity() instanceof Player)){
			Player p = (Player)e.getEntity();
			if (e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) && 
					(API.hasEnchant("Creeper", p.getInventory().getHelmet()) || 
							(API.hasEnchant("Creeper", p.getInventory().getChestplate()) || 
									(API.hasEnchant("Creeper", p.getInventory().getLeggings()) || 
											(API.hasEnchant("Creeper", p.getInventory().getBoots())))))){
				int tier = 0;
				if (API.hasEnchant("Creeper", p.getInventory().getHelmet())){
					tier = API.getEnchantLvl("Creeper", p.getInventory().getHelmet());
				} else if (API.hasEnchant("Creeper", p.getInventory().getChestplate())) {
					tier = API.getEnchantLvl("Creeper", p.getInventory().getChestplate());
				} else if (API.hasEnchant("Creeper", p.getInventory().getLeggings())) {
					tier = API.getEnchantLvl("Creeper", p.getInventory().getLeggings());
				} else if (API.hasEnchant("Creeper", p.getInventory().getBoots())) {
					tier = API.getEnchantLvl("Creeper", p.getInventory().getBoots());
				}
				int addChance = 0;
				if (tier == 3) {
					addChance = 10;
				}
				if (tier == 2) {
					addChance = 5;
				}
				if (tier == 1) {
					addChance = 0;
				}
				if (API.randDouble(1, 100) <= creeperChance + addChance) {
					e.setCancelled(true);
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Creeper " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onShield(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			if (API.hasEnchant("Shield", p.getInventory().getChestplate())){
				int tier = API.getEnchantLvl("Shield", p.getInventory().getChestplate());
				int addChance = 0;
				if (tier == 4) {
					addChance = 4;
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
				if (API.randDouble(1, 100) <= shieldChance + addChance) {
					e.setCancelled(true);
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Shield " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onNinja(EntityDamageByEntityEvent event){
		if ((event.getEntity() instanceof Player)){
			Player p = (Player)event.getEntity();
			if ((p.getHealth() <= 6.0D) && 
					(API.hasEnchant("Ninja", p.getInventory().getBoots()))){
				int tier = API.getEnchantLvl("Ninja", p.getInventory().getBoots());
				int addChance = 80;
				int duration = 0;
				if (tier == 1) {
					addChance = 0;
					duration = 3 * 20;
				}
				if (tier == 2) {
					addChance = 2;
					duration = 5 * 20;
				}
				if (tier == 3) {
					addChance = 3;
					duration = 7 * 20;
				}
				if (tier == 4) {
					addChance = 5;
					duration = 8 * 20;
				}
				if (tier == 5) {
					addChance = 8;
					duration = 10 * 20;
				}
				if (API.randDouble(1, 100) <= ninjaChance + addChance){
					p.removePotionEffect(PotionEffectType.SPEED);
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, 4));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Ninja " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onMarshmallow(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			if (API.hasEnchant("Marshmallow", p.getInventory().getHelmet()) || 
					API.hasEnchant("Marshmallow", p.getInventory().getChestplate()) || 
					API.hasEnchant("Marshmallow", p.getInventory().getLeggings()) || 
					API.hasEnchant("Marshmallow", p.getInventory().getBoots())){
				int tier = 0;
				if (API.hasEnchant("Marshmallow", p.getInventory().getHelmet())) {
					tier = API.getEnchantLvl("Marshmallow", p.getInventory().getHelmet());
				} else if (API.hasEnchant("Marshmallow", p.getInventory().getChestplate())) {
					tier = API.getEnchantLvl("Marshmallow", p.getInventory().getChestplate());
				} else if (API.hasEnchant("Marshmallow", p.getInventory().getLeggings())) {
					tier = API.getEnchantLvl("Marshmallow", p.getInventory().getLeggings());
				} else if (API.hasEnchant("Marshmallow", p.getInventory().getBoots())) {
					tier = API.getEnchantLvl("Marshmallow", p.getInventory().getBoots());
				}
				int addChance = 0;
				int duration = 0;
				int lvl = 0;
				if(tier == 1){
					addChance = 0;
					duration = 2 * 20;
					lvl = 0;
				}
				if(tier == 2){
					addChance = 0;
					duration = 2 * 20;
					lvl = 0;
				}
				if(tier == 3){
					addChance = 1;
					duration = 3 * 20;
					lvl = 0;
				}
				if(tier == 4){
					addChance = 1;
					duration = 3 * 20;
					lvl = 1;
				}
				if(tier == 5){
					addChance = 2;
					duration = 4 * 20;
					lvl = 1;
				}
				if (API.randDouble(1, 100) <= marshmallowChance + addChance){
					p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, lvl));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Marshmallow " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}


	@EventHandler
	public void onThief(EntityDamageByEntityEvent e){
		if (e.getDamager() instanceof Player){
			if(e.getEntity() instanceof Player){
				Player target = (Player) e.getEntity();
				Player attacker = (Player)e.getDamager();
				if (API.hasEnchant("Thief", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Thief", attacker.getItemInHand());
					double addChance = 0;
					double moneyRange = 0;
					int xpRange = 0;
					int xpMoney = 0;
					if (tier == 3) {
						addChance = 4;
						moneyRange = API.randDouble(50.00, 200.00);
						xpRange = API.randomInt(100, 200);
						xpMoney = API.randomInt(1, 2);
					}
					if (tier == 2) {
						addChance = 2;
						moneyRange = API.randDouble(50.00, 125.00);
						xpRange = API.randomInt(75, 150);
						xpMoney = API.randomInt(1, 2);
					}
					if (tier == 1) {
						addChance = 0;
						moneyRange = API.randDouble(50.00, 100.00);
						xpRange = API.randomInt(50, 100);
						xpMoney = API.randomInt(1, 2);
					}
					if(API.randDouble(1, 100) <= thiefChance + addChance){
						if(xpMoney == 1){
							int targetXp = target.getTotalExperience();
							if(targetXp >= 200){
								target.setTotalExperience(targetXp - xpRange);
								attacker.setTotalExperience(attacker.getTotalExperience() + xpRange);
								attacker.sendMessage(API.color("&a&l+ " + xpRange + " XP"));
							}
						}
						if(xpMoney == 2){
							double tBal = econ.getBalance(target);			
							if(tBal >= 200.00){
								EconomyResponse r = econ.withdrawPlayer(target, moneyRange);
								if(r.transactionSuccess()){
									econ.depositPlayer(attacker, moneyRange);
									attacker.sendMessage(API.color("&a&l+ $" + moneyRange));
									return;
								}
							}
						}
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Thief " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Thief " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onCounter(EntityDamageByEntityEvent e){
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			Player target = (Player)e.getEntity();
			Player attacker = (Player)e.getDamager();
			if (API.hasEnchant("Counter", target.getInventory().getLeggings())){
				int tier = API.getEnchantLvl("Counter", target.getInventory().getLeggings());
				int addChance = 0;
				int damage = 0;
				if (tier == 1) {
					addChance = 0;
					damage = 1;
				} 
				if (tier == 2) {
					addChance = 2;
					damage = API.randomInt(1, 2);
				}
				if (tier == 3) {
					addChance = 3;
					damage = API.randomInt(1, 3);
				}
				if (API.randDouble(1, 100) <= counterChance + addChance){
					attacker.damage(damage);
					if(API.DEBUG_MODE){
						API.sendDebug(target, target, "Counter " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, target, "Counter " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onWound(EntityDamageByEntityEvent e){
		if ((e.getDamager() instanceof Player)){
			if((e.getEntity() instanceof Player)){
				Player target = (Player) e.getEntity();
				Player attacker = (Player)e.getDamager();
				if (API.hasEnchant("Wound", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Wound", attacker.getItemInHand());
					double addChance = 0;
					int duration = 0;
					if (tier == 3) {
						addChance = 2;
						duration = 6 * 20;
					}
					if (tier == 2) {
						addChance = 1;
						duration = 4 * 20;
					}
					if (tier == 1) {
						addChance = 0;
						duration = 3 * 20;
					}
					if(API.randDouble(1, 100) <= woundChance + addChance){
						BleedTimerTask.add(target, duration);
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Wound " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Wound " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onSafeguard(EntityDamageByEntityEvent e){
		if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))){
			Player target = (Player)e.getEntity();
			Player attacker = (Player)e.getDamager();
			if (API.hasEnchant("Safeguard", target.getInventory().getChestplate())){
				int tier = API.getEnchantLvl("Safeguard", target.getInventory().getChestplate());
				double addChance = 0;
				int amount = 0;
				if (tier == 10) {
					addChance = 2;
					amount = 3;
				}
				if (tier == 9) {
					addChance = 1;
					amount = 2;
				}
				if (tier == 8) {
					addChance = 1;
					amount = 2;
				}
				if (tier == 7) {
					addChance = 1;
					amount = 2;
				}
				if (tier == 6) {
					addChance = 0.5;
					amount = 2;
				}
				if (tier == 5) {
					addChance = 0.5;
					amount = 1;
				}
				if (tier == 4) {
					addChance = 0.5;
					amount = 1;
				}
				if (tier == 3) {
					addChance = 0;
					amount = 1;
				}
				if (tier == 2) {
					addChance = 0;
					amount = 1;
				}
				if (tier == 1) {
					addChance = 0;
					amount = 1;
				}
				if (API.randDouble(1, 250) <= safeguardChance + addChance) {
					spawnHeros(attacker, target, amount);
					if(API.DEBUG_MODE){
						API.sendDebug(target, target, "Hero " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, target, "Hero " + API.romanNumerals.get(tier));
					}
				}
			}
			else if (API.hasEnchant("Safeguard", target.getInventory().getLeggings())){
				int tier = API.getEnchantLvl("Safeguard", target.getInventory().getLeggings());
				double addChance = 0;
				int amount = 0;
				if (tier == 10) {
					addChance = 2;
					amount = 3;
				}
				if (tier == 9) {
					addChance = 1;
					amount = 2;
				}
				if (tier == 8) {
					addChance = 1;
					amount = 2;
				}
				if (tier == 7) {
					addChance = 1;
					amount = 2;
				}
				if (tier == 6) {
					addChance = 0.5;
					amount = 2;
				}
				if (tier == 5) {
					addChance = 0.5;
					amount = 1;
				}
				if (tier == 4) {
					addChance = 0.5;
					amount = 1;
				}
				if (tier == 3) {
					addChance = 0;
					amount = 1;
				}
				if (tier == 2) {
					addChance = 0;
					amount = 1;
				}
				if (tier == 1) {
					addChance = 0;
					amount = 1;
				}
				if (API.randDouble(1, 250) <= safeguardChance + addChance) {
					spawnHeros(attacker, target, amount);
					if(API.DEBUG_MODE){
						API.sendDebug(target, target, "Safeguard " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, target, "Safeguard " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	public void spawnHeros(Player attacker, Player victim, int amount){
		for (int i = 0; i < amount; i++){
			IronGolem ig = (IronGolem)victim.getWorld().spawnEntity(victim.getLocation(), EntityType.IRON_GOLEM);
			ig.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 1));
			ig.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 99999, 1));
			ig.setCustomName(API.color("&b&l" + victim.getName() + "'s &b&lHero"));
			ig.setTarget(attacker);
			ig.setCanPickupItems(false);
			Bukkit.getScheduler().scheduleSyncDelayedTask(cEnchants.getInstance(), new Runnable(){
		      public void run(){
		        ig.remove();
		      }
		    }, 200L);
		}
	}

	@EventHandler
	public void onPush(EntityDamageByEntityEvent event){
		if (event.getDamager() instanceof Player && event.getEntity() instanceof Player){
			Player target = (Player)event.getEntity();
			Player attacker = (Player)event.getDamager();
			if (API.hasEnchant("Push", attacker.getItemInHand())){
				int tier = API.getEnchantLvl("Push", attacker.getItemInHand());
				int addChance = 0;
				if (tier == 2) {
					addChance = 5;
					if (API.randDouble(1, 100) <= pushChance + addChance) {
						target.setVelocity(new Vector(-target.getLocation().getDirection().getX() * 4.0D, target.getVelocity().getY(), -target.getLocation().getDirection().getZ() * 4.0D));
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Push " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Push " + API.romanNumerals.get(tier));
						}
					}
				}
				if (tier == 1) {
					addChance = 0;
					if (API.randDouble(1, 100) <= pushChance + addChance) {
						target.setVelocity(new Vector(-target.getLocation().getDirection().getX() * 2.0D, target.getVelocity().getY(), -target.getLocation().getDirection().getZ() * 2.0D));
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Push " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Push " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onVirus(EntityDamageByEntityEvent e){
		if ((e.getDamager() instanceof Player)){
			if((e.getEntity() instanceof Player)){
				Player target = (Player) e.getEntity();
				Player attacker = (Player)e.getDamager();
				if (API.hasEnchant("Virus", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Virus", attacker.getItemInHand());
					double addChance = 0;
					int duration = 0;
					int level = 0;
					if (tier == 3) {
						addChance = 2;
						duration = 6 * 20;
						level = 2;
					}
					if (tier == 2) {
						addChance = 1;
						duration = 4 * 20;
						level = 1;
					}
					if (tier == 1) {
						addChance = 0;
						duration = 3 * 20;
						level = 0;
					}
					if(API.randDouble(1, 100) <= virusChance + addChance){
						target.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, duration, level));
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Virus " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Virus " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onMiner(BlockBreakEvent e){
		Player p = e.getPlayer();
		Block b  = e.getBlock();
		if (API.hasEnchant("Miner", p.getItemInHand())){
			int tier = API.getEnchantLvl("Miner", p.getItemInHand());
			int addChance = 80;
			int xp = 0;
			if(tier == 1){  	        	
				addChance = 0;
				xp = 3;          
			}
			if(tier == 2){
				addChance = 5;
				xp = 5;
			}
			if(tier == 3){
				addChance = 10;
				xp = 7;
			}
			if(tier == 4){
				addChance = 12;
				xp = 9;
			}
			if(tier == 5){
				addChance = 15;
				xp = 10;
			}
			if (API.randDouble(1, 100) <= minerChance + addChance) {
				if(b.getType().equals(Material.GOLD_ORE)){
					p.giveExp(xp);
				}
				if(b.getType().equals(Material.IRON_ORE)){
					p.giveExp(xp);
				}
				if(b.getType().equals(Material.REDSTONE_ORE)){
					p.giveExp(xp);
				}
				if(b.getType().equals(Material.LAPIS_ORE)){
					p.giveExp(xp);
				}
				if(b.getType().equals(Material.EMERALD_ORE)){
					p.giveExp(xp);
				}
				if(b.getType().equals(Material.DIAMOND_ORE)){
					p.giveExp(xp);
				}
				if(b.getType().equals(Material.COAL_ORE)){
					p.giveExp(xp);
				}
				if(b.getType().equals(Material.QUARTZ_ORE)){
					p.giveExp(xp);
				}
				if(API.DEBUG_MODE){
					API.sendDebug(p, p, "Miner " + API.romanNumerals.get(tier));
				}
			}
		}
	}

	@EventHandler
	public void onBlaze(ArmorEquipEvent e){
		Player p = e.getPlayer();
		if (!(e.getNewArmorPiece() == null) && (e.getNewArmorPiece().getType() != Material.AIR)){
			if(API.hasEnchant("Blaze", e.getNewArmorPiece())){
				int tier = API.getEnchantLvl("Blaze", e.getNewArmorPiece()); 	  
				if(tier == 1){
					p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Blaze " + API.romanNumerals.get(tier));
					}
				}
			}
		}
		if (!(e.getOldArmorPiece() == null) && !(e.getOldArmorPiece().getType() == Material.AIR)){
			if(API.hasEnchant("Blaze", e.getOldArmorPiece())){
				p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
			}
		}
	}

	@EventHandler
	public void onWormhole(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			Player user = (Player) e.getEntity();
			if ((user.getHealth() <= 6.0D) && 
					(API.hasEnchant("Wormhole", user.getInventory().getHelmet()))){
				int tier = API.getEnchantLvl("Wormhole", user.getInventory().getHelmet());
				int addChance = 0;
				int duration = 0;
				if(tier == 1){
					addChance = 0;
					duration = 2 * 20;
				}
				if(tier == 2){
					addChance = 2;
					duration = 4 * 20;
				}
				if(tier == 3){
					addChance = 5;
					duration = 6 * 20;
				}
				if(API.randDouble(1, 100) <= wormholeChance + addChance){
					user.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, duration, 4));
					user.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, 4));
					if(API.hasEnchant("Eyepatch", user.getInventory().getHelmet())) {
						int eptier = API.getEnchantLvl("Eyepatch", user.getItemInHand());
						double epaddChance = 0;
						if (eptier == 3) {
							epaddChance = 10;
						}
						if (eptier == 2) {
							epaddChance = 5;
						}
						if (eptier == 1) {
							epaddChance = 0;
						}
						if(API.randDouble(1, 100) <= eyepatchChance + epaddChance){
							return;
						}
					}
					user.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, duration, 10));
					if(API.DEBUG_MODE){
						API.sendDebug(user, user, "Wormhole " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onFracture(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player target = (Player) e.getEntity();
			Player attacker = (Player) e.getDamager();
			if(API.hasEnchant("Fracture", attacker.getItemInHand())){
				int tier = API.getEnchantLvl("Fracture", attacker.getItemInHand());
				int addChance = 1;
				int duration = 0;
				int level = 0;
				int negateChance = 0;
				if(tier == 1){
					addChance = 0;
					duration = 2;
					level = 0;
				}
				if(tier == 2){
					addChance = 1;
					duration = 4;
					level = 0;
				}
				if(tier == 3){
					addChance = 2;
					duration = 5;
					level = 1;
				}
				if(tier == 4){
					addChance = 3;
					duration = 6;
					level = 2;
				}
				if(API.hasEnchant("Agility", target.getInventory().getBoots())){
					int agilityTier = API.getEnchantLvl("Agility", target.getInventory().getBoots());
					if(agilityTier == 1){
						negateChance = 15;
					}
					if(agilityTier == 2){
						negateChance = 25;
					}
					if(agilityTier == 3){
						negateChance = 35;
					}
					if(agilityTier == 4){
						negateChance = 50;
					}
				}
				if(API.randDouble(1, 100) <= fractureChance + addChance){
					if(API.randDouble(1, 100) <= negateChance){
						API.sendDebug(target, attacker, "Agility " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, attacker, "Agility " + API.romanNumerals.get(tier));
						return;
					}
					target.getWorld().strikeLightningEffect(target.getLocation());
					target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, duration * 20, level));
					target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, duration * 20, level));
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Fracture " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Fracture " + API.romanNumerals.get(tier));
						}
					
				}
			}
		}
	}
}
