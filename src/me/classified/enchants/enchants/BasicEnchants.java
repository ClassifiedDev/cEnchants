package me.classified.enchants.enchants;

import java.util.ArrayList;

import me.classified.enchants.cEnchants;
import me.classified.enchants.utils.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

import me.classified.enchants.utils.API;
import org.bukkit.scheduler.BukkitRunnable;

public class BasicEnchants implements Listener{

	double venomChance = 5.0;
	double blackoutChance = 5.0;
	double hasteChance = 100.00;
	double ravenousChance = 5.0;
	double explosiveChance = 15.00;
	double furnaceChance = 75.00;
	double saturatedChance = 0.2;
	double flashbackChance = 5.0;
	double frozenChance = 5.0;
	double bulletproofChance = 25.0;
	double ghastChance = 15.0;
	double scavengerChance = 25.0;
	double witherChance = 1.0;
	double pineappleChance = 25.0;
	double voltageChance = 5.0;
	double agilityChance = 10.0;

	double eyepatchChance = 30.0;
	
	@EventHandler
	public void onVenom(EntityDamageByEntityEvent e){
		if ((e.getDamager() instanceof Player)){
			if((e.getEntity() instanceof Player)){
				Player target = (Player) e.getEntity();
				Player attacker = (Player)e.getDamager();
				if (API.hasEnchant("Venom", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Venom", attacker.getItemInHand());
					double addChance = 0;
					int duration = 0;
					int level = 0;
					if (tier == 3) {
						addChance = 2;
						duration = 6 * 20;
						level = 3;
					}
					if (tier == 2) {
						addChance = 1;
						duration = 4 * 20;
						level = 2;
					}
					if (tier == 1) {
						addChance = 0;
						duration = 3 * 20;
						level = 1;
					}
					if(API.randDouble(1, 100) <= venomChance + addChance){
						target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, duration, level));
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Venom " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Venom " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onBlackout(EntityDamageByEntityEvent e){
		if ((e.getDamager() instanceof Player)){
			if((e.getEntity() instanceof Player)){
				Player target = (Player) e.getEntity();
				Player attacker = (Player)e.getDamager();
				if (API.hasEnchant("Blackout", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Blackout", attacker.getItemInHand());
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
					if(API.randDouble(1, 100) <= blackoutChance + addChance){
						if(API.hasEnchant("Eyepatch", target.getInventory().getHelmet())) {
							int eptier = API.getEnchantLvl("Eyepatch", attacker.getItemInHand());
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
						target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, duration, level));
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Blackout " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Blackout " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onHaste(EntityDamageByEntityEvent e){
		if ((e.getDamager() instanceof Player)){
			Player attacker = (Player)e.getDamager();
			if (API.hasEnchant("Haste", attacker.getItemInHand())){
				int tier = API.getEnchantLvl("Haste", attacker.getItemInHand());
				int addChance = 0;
				int duration = 0;
				int level = 0;
				if (tier == 3) {
					addChance = 2;
					duration = 6 *20;
					level = 2;
				}
				if (tier == 2) {
					addChance = 1;
					duration = 4 * 20;
					level = 1;
				}
				if (tier == 1) {
					addChance = 0;
					duration = 2 * 20;
					level = 0;
				}
				if(API.randDouble(1, 100) <= hasteChance + addChance){
					attacker.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, duration, level));
					if(API.DEBUG_MODE){
						API.sendDebug(attacker, attacker, "Haste " + API.romanNumerals.get(tier) + " (COMBAT)");
					}
				}
			}
		}
	}

	@EventHandler
	public void onRavenous(EntityDamageByEntityEvent e){
		if ((e.getDamager() instanceof Player)){
			if(e.getEntity() instanceof Player){
				Player target = (Player) e.getEntity();
				Player attacker = (Player) e.getDamager();
				if (API.hasEnchant("Ravenous", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Ravenous", attacker.getItemInHand());
					int addChance = 0;
					int duration = 0;
					int level = 0;
					if (tier == 5) {
						addChance = 2;
						duration = 15 *20;
						level = 5;
					}
					if (tier == 4) {
						addChance = 1;
						duration = 12 * 20;
						level = 4;
					}
					if (tier == 3) {
						addChance = 0;
						duration = 10 * 20;
						level = 3;
					}
					if(tier == 2){
						addChance = 0;
						duration = 8 * 20;
						level = 2;
					}
					if(tier == 1){
						addChance = 0;
						duration = 6 * 20;
						level = 1;
					}
					if(API.randDouble(1, 100) <= ravenousChance + addChance){
						target.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, duration, level));
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Ravenous " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Ravenous " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onHaste(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(p.getItemInHand().getType().toString().contains("PICKAXE")){
			if(API.hasEnchant("Haste", p.getItemInHand())){
				int tier = API.getEnchantLvl("Haste", p.getItemInHand());
				int level = 0;
				int duration = 0;
				if (tier == 3) {
					level = 2;
					duration = 15 * 20;
				}
				if (tier == 2) {
					level = 1;
					duration = 10 * 20;
				}
				if (tier == 1) {
					level = 0;
					duration = 5 * 20;
				}
				p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, duration, level));
				if(API.DEBUG_MODE){
					API.sendDebug(p, p, "Ravenous " + API.romanNumerals.get(tier) + " (BLOCKS)");
				}
			}
		}
	}

	ArrayList<Player> successfulshot = new ArrayList<Player>();
	@EventHandler
	public void onExplosive(ProjectileHitEvent e){
		if ((e.getEntity() instanceof Arrow)){
			ProjectileSource attacker = e.getEntity().getShooter();
			if(attacker instanceof Player && successfulshot.contains(attacker)){
				Projectile a = e.getEntity();
				a.getWorld().createExplosion(a.getLocation(), 0);
				for(Entity en : a.getNearbyEntities(3, 3, 3)){
					if(en instanceof Player){
						Player p = (Player) en;
						if(!p.equals(e.getEntity().getShooter())) p.damage(3);
					}
				}
				successfulshot.remove(attacker);
			}
		}
	}

	@EventHandler
	public void onExplosive(EntityShootBowEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			if (API.hasEnchant("Explosive", p.getItemInHand())){
				int tier = API.getEnchantLvl("Explosive", p.getItemInHand());
				int addChance = 0;
				if (tier == 4) {
					addChance = 10;
				}
				if (tier == 3) {
					addChance = 8;
				}
				if (tier == 2) {
					addChance = 5;
				}
				if (tier == 1) {
					addChance = 3;
				} 
				if (API.randDouble(1, 100) <= explosiveChance + addChance){
					successfulshot.add(p);
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Explosive " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onFurnace(BlockBreakEvent e){
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
			if (API.hasEnchant("Furnace", p.getItemInHand())){
				int tier = API.getEnchantLvl("Furnace", p.getItemInHand());
				int addChance = 80;
				if(tier == 1){  	        	
					addChance = 10;
				}
				if(tier == 2){
					addChance = 8;
				}
				if(tier == 3){
					addChance = 5;
				}
				if (API.randDouble(1, 100) <= furnaceChance + addChance) {
					if(b.getType().equals(Material.GOLD_ORE)){
						b.breakNaturally(new ItemStack(Material.AIR));
						p.getWorld().dropItem(b.getLocation(), new ItemStack(Material.GOLD_INGOT, 1));
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Furnace " + API.romanNumerals.get(tier));
						}
					}
					if(b.getType().equals(Material.IRON_ORE)){
						b.breakNaturally(new ItemStack(Material.IRON_INGOT));
						p.getWorld().dropItem(b.getLocation(), new ItemStack(Material.IRON_INGOT, 1));
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Furnace " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onGlowing(ArmorEquipEvent e){
		Player p = e.getPlayer();
		if (!(e.getNewArmorPiece() == null) && (e.getNewArmorPiece().getType() != Material.AIR)){
			if(API.hasEnchant("Glowing", e.getNewArmorPiece())){
				int tier = API.getEnchantLvl("Glowing", e.getNewArmorPiece()); 	  
				if(tier == 1){
					p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Glowing " + API.romanNumerals.get(tier));
					}
				}
			}
		}
		if (!(e.getOldArmorPiece() == null) && !(e.getOldArmorPiece().getType() == Material.AIR)){
			if(API.hasEnchant("Glowing", e.getOldArmorPiece())){
				p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			}
		}
	}

	@EventHandler
	public void onDiver(ArmorEquipEvent e){
		Player p = e.getPlayer();
		if (!(e.getNewArmorPiece() == null) && (e.getNewArmorPiece().getType() != Material.AIR)){
			if(API.hasEnchant("Diver", e.getNewArmorPiece())){
				int tier = API.getEnchantLvl("Diver", e.getNewArmorPiece()); 	  
				if(tier == 1){
					p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Diver " + API.romanNumerals.get(tier));
					}
				}
			}
		}
		if (!(e.getOldArmorPiece() == null) && !(e.getOldArmorPiece().getType() == Material.AIR)){
			if(API.hasEnchant("Diver", e.getOldArmorPiece())){
				p.removePotionEffect(PotionEffectType.WATER_BREATHING);
			}
		}
	}

	@EventHandler
	public void onSaturated(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if (API.hasEnchant("Saturated", p.getInventory().getHelmet()) || 
				API.hasEnchant("Saturated", p.getInventory().getChestplate()) || 
				API.hasEnchant("Saturated", p.getInventory().getLeggings()) || 
				API.hasEnchant("Saturated", p.getInventory().getBoots())){
			int tier = 1;
			if (API.hasEnchant("Saturated", p.getInventory().getHelmet())) {
				tier = API.getEnchantLvl("Saturated", p.getInventory().getHelmet());
			} else if (API.hasEnchant("Saturated", p.getInventory().getChestplate())) {
				tier = API.getEnchantLvl("Saturated", p.getInventory().getChestplate());
			} else if (API.hasEnchant("Saturated", p.getInventory().getLeggings())) {
				tier = API.getEnchantLvl("Saturated", p.getInventory().getLeggings());
			} else if (API.hasEnchant("Saturated", p.getInventory().getBoots())) {
				tier = API.getEnchantLvl("Saturated", p.getInventory().getBoots());
			}
			double addChance = 0;
			if(tier == 1){
				addChance = 0;
			}
			if(tier == 2){
				addChance = 0.5;
			}
			if(tier == 3){
				addChance = 1;
			}
			if (API.randDouble(1, 100) <= saturatedChance + addChance){
				int currentfood = p.getFoodLevel();
				p.setFoodLevel(currentfood + 1);
				if(API.DEBUG_MODE){
					API.sendDebug(p, p, "Saturated " + API.romanNumerals.get(tier));
				}
			}
		}
	}


	@EventHandler
	public void onFlashback(EntityDamageByEntityEvent e){
	    //When enchantment procs, get the players location and yaw pitches. Wait X amount of time and then set the player back to that location.
        if ((e.getDamager() instanceof Player)){
            if((e.getEntity() instanceof Player)){
                Player target = (Player) e.getEntity();
                Player attacker = (Player)e.getDamager();
                if (API.hasEnchant("Flashback", target.getItemInHand())){
                    int tier = API.getEnchantLvl("Flashback", target.getItemInHand());
                    double addChance = 0;
                    int time = 0; //In ticks, 20 ticks = 1 second
                    if (tier == 7) {
                        addChance = 2;
                        time = 100;
                    }
                    if (tier == 6) {
                        addChance = 2;
                        time = 80;
                    }
                    if (tier == 5) {
                        addChance = 2;
                        time = 70;
                    }
                    if (tier == 4) {
                        addChance = 1;
                        time = 60;
                    }
                    if (tier == 3) {
                        addChance = 1;
                        time = 50;
                    }
                    if (tier == 2) {
                        addChance = 1;
                        time = 40;
                    }
                    if (tier == 1) {
                        addChance = 0;
                        time = 30;
                    }
                    if(API.randDouble(1, 100) <= flashbackChance + addChance){
                        Location location = target.getLocation();
                        float yaw = target.getLocation().getYaw();
                        float pitch = target.getLocation().getPitch();
                        new BukkitRunnable(){
                            public void run() {
                                target.teleport(location);
                                target.getLocation().setYaw(yaw);
                                target.getLocation().setPitch(pitch);
                                target.sendMessage(API.color("&8&l*** &b&lFLASHBACK &8&l***"));
                                target.playSound(target.getLocation(), Sound.PORTAL_TRAVEL, 10, 2);
                                attacker.playSound(attacker.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 1);
                                ParticleEffect.BLOCK_CRACK.display(new ParticleEffect.BlockData(Material.WOOL, (byte) 10), 0.3f, 1.0f, 0.3f, 1, 200, target.getLocation(), 150);
                                ParticleEffect.BLOCK_CRACK.display(new ParticleEffect.BlockData(Material.STAINED_GLASS, (byte) 2), 0.2f, 1.2f, 0.2f, 1, 100, target.getLocation(), 75);}
                        }.runTaskLater(cEnchants.getInstance(), time);
                        if(API.DEBUG_MODE){
                            API.sendDebug(target, target, "Flashback (Location Set)" + API.romanNumerals.get(tier));
                            API.sendDebug(attacker, target, "Flashback (Location Set)" + API.romanNumerals.get(tier));
                        }
                    }
                }
            }
        }
	}

	@EventHandler
	public void onFrozen(EntityDamageByEntityEvent e){
		if ((e.getDamager() instanceof Player)){
			if((e.getEntity() instanceof Player)){
				Player target = (Player) e.getEntity();
				Player attacker = (Player)e.getDamager();
				if (API.hasEnchant("Frozen", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Frozen", attacker.getItemInHand());
					double addChance = 0;
					int duration = 0;
					int level = 0;
					if (tier == 3) {
						addChance = 2;
						duration = 5 * 20;
						level = 4;
					}
					if (tier == 2) {
						addChance = 1;
						duration = 3 * 20;
						level = 3;
					}
					if (tier == 1) {
						addChance = 0;
						duration = 2 * 20;
						level = 2;
					}
					if(API.randDouble(1, 100) <= frozenChance + addChance){
						target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, duration, level));
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Frozen " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Frozen " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onBulletproof(EntityDamageByEntityEvent e){
		if (e.getDamager() instanceof Arrow && 
				e.getEntity() instanceof Player){
			Player target = (Player)e.getEntity();
			if (API.hasEnchant("BulletProof", target.getInventory().getLeggings())){
				int tier = API.getEnchantLvl("BulletProof", target.getInventory().getLeggings());
				int addChance = 0;
				if (tier == 4) {
					addChance = 8;
				}
				if (tier == 3) {
					addChance = 6;
				}
				if (tier == 2) {
					addChance = 4;
				}
				if (tier == 1) {
					addChance = 2;
				}
				if (API.randDouble(1, 100) <= bulletproofChance + addChance){
					e.setCancelled(true);
					if(API.DEBUG_MODE){
						API.sendDebug(target, target, "BulletProof " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onGhast(EntityShootBowEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			if (API.hasEnchant("Ghast", p.getInventory().getItemInHand())){
				int tier = API.getEnchantLvl("Ghast", p.getItemInHand()); 
				int addChance = 0;
				if (tier == 3){
					addChance = 10;
				}
				if (tier == 2){
					addChance = 7;
				}
				if (tier == 1){
					addChance = 4;
				}
				if (API.randDouble(1, 100) <= ghastChance + addChance){
					Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(2))
							.toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
					Fireball fireball = (Fireball)p.getWorld().spawn(loc, Fireball.class);
					fireball.setIsIncendiary(false);
					e.setProjectile(fireball);
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Ghast " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onScavenger(BlockBreakEvent e){
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
			if (API.hasEnchant("Scavenger", p.getItemInHand())){
				if(p.getItemInHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
					return;
				}
				int tier = API.getEnchantLvl("Scavenger", p.getItemInHand());
				int addChance = 0;
				int amount = 0;
				if (tier == 1){
					addChance = 2;
					amount = API.randomInt(1, 2);
				}  
				if (tier == 2){
					addChance = 4;
					amount = API.randomInt(1, 3);
				}  
				if (tier == 3){
					addChance = 6;
					amount = API.randomInt(1, 3);
				}  
				if (tier == 4){
					addChance = 8;
					amount = API.randomInt(1, 4);
				} 
				if (tier == 5){
					addChance = 10;
					amount = API.randomInt(1, 5);
				}
				if (API.randDouble(1, 100) <= scavengerChance + addChance){
					if ((b.getType().equals(Material.GOLD_ORE)) || (b.getType().equals(Material.IRON_ORE)) || 
							(b.getType().equals(Material.DIAMOND_ORE)) || (b.getType().equals(Material.EMERALD_ORE))){
						if(b.getType().equals(Material.DIAMOND_ORE)){
							b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.DIAMOND, amount));
							if(API.DEBUG_MODE){
								API.sendDebug(p, p, "Scavenger " + API.romanNumerals.get(tier));
							}
						}
						else if(b.getType().equals(Material.EMERALD_ORE)){
							b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.EMERALD, amount));
							if(API.DEBUG_MODE){
								API.sendDebug(p, p, "Scavenger " + API.romanNumerals.get(tier));
							}
						}
						else{
							b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(b.getType(), amount));
							if(API.DEBUG_MODE){
								API.sendDebug(p, p, "Scavenger " + API.romanNumerals.get(tier));
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onVoltage(EntityDamageByEntityEvent e){
		if ((e.getDamager() instanceof Player)){
			if((e.getEntity() instanceof Player)){
				Player target = (Player) e.getEntity();
				Player attacker = (Player)e.getDamager();
				if (API.hasEnchant("Voltage", attacker.getItemInHand())){
					int tier = API.getEnchantLvl("Voltage", attacker.getItemInHand());
					int addChance = 80;
					if (tier == 3) {
						addChance = 5;
					}
					if (tier == 2) {
						addChance = 3;
					}
					if (tier == 1) {
						addChance = 0;
					}
					if (API.randDouble(1, 100) <= voltageChance + addChance) {
						World world = target.getWorld();
						Location l = target.getLocation();
						world.strikeLightningEffect(l);
						target.damage(2.0);
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Voltage " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Voltage " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onWither(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player user = (Player) e.getEntity();
			Player attacker = (Player) e.getDamager();
			if(API.hasEnchant("Wither", user.getInventory().getHelmet())){
				int tier  = API.getEnchantLvl("Wither", user.getInventory().getHelmet());
				double addChance = 0;
				int duration = 0;
				int level = 0;
				if(tier == 1){
					addChance = 0;
					duration = 2;
					level = 0;
				}
				if(tier == 2){
					addChance = 1;
					duration = 3;
					level = 0;
				}
				if(tier == 3){
					addChance = 1.5;
					duration = 4;
					level = 1;
				}
				if(tier == 4){
					addChance = 2;
					duration = 5;
					level = 1;
				}
				if(tier == 5){
					addChance = 2.5;
					duration = 6;
					level = 2;
				}
				if(API.randDouble(1, 100) <= witherChance + addChance){
					attacker.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, duration * 20, level));
					if(API.DEBUG_MODE){
						API.sendDebug(user, user, "Wither " + API.romanNumerals.get(tier));
					}
				}
			}
			if(API.hasEnchant("Wither", user.getInventory().getChestplate())){
				int tier  = API.getEnchantLvl("Wither", user.getInventory().getChestplate());
				double addChance = 0;
				int duration = 0;
				int level = 0;
				if(tier == 1){
					addChance = 0;
					duration = 2;
					level = 0;
				}
				if(tier == 2){
					addChance = 1;
					duration = 3;
					level = 0;
				}
				if(tier == 3){
					addChance = 1.5;
					duration = 4;
					level = 1;
				}
				if(tier == 4){
					addChance = 2;
					duration = 5;
					level = 1;
				}
				if(tier == 5){
					addChance = 2.5;
					duration = 6;
					level = 2;
				}
				if(API.randDouble(1, 100) <= witherChance + addChance){
					attacker.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, duration * 20, level));
					if(API.DEBUG_MODE){
						API.sendDebug(user, user, "Wither " + API.romanNumerals.get(tier));
					}
				}
			}
			if(API.hasEnchant("Wither", user.getInventory().getLeggings())){
				int tier  = API.getEnchantLvl("Wither", user.getInventory().getLeggings());
				double addChance = 0;
				int duration = 0;
				int level = 0;
				if(tier == 1){
					addChance = 0;
					duration = 2;
					level = 0;
				}
				if(tier == 2){
					addChance = 1;
					duration = 3;
					level = 0;
				}
				if(tier == 3){
					addChance = 1.5;
					duration = 4;
					level = 1;
				}
				if(tier == 4){
					addChance = 2;
					duration = 5;
					level = 1;
				}
				if(tier == 5){
					addChance = 2.5;
					duration = 6;
					level = 2;
				}
				if(API.randDouble(1, 100) <= witherChance + addChance){
					attacker.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, duration * 20, level));
					if(API.DEBUG_MODE){
						API.sendDebug(user, user, "Wither " + API.romanNumerals.get(tier));
					}
				}
			}
			if(API.hasEnchant("Wither", user.getInventory().getBoots())){
				int tier  = API.getEnchantLvl("Wither", user.getInventory().getBoots());
				double addChance = 0;
				int duration = 0;
				int level = 0;
				if(tier == 1){
					addChance = 0;
					duration = 2;
					level = 0;
				}
				if(tier == 2){
					addChance = 1;
					duration = 3;
					level = 0;
				}
				if(tier == 3){
					addChance = 1.5;
					duration = 4;
					level = 1;
				}
				if(tier == 4){
					addChance = 2;
					duration = 5;
					level = 1;
				}
				if(tier == 5){
					addChance = 2.5;
					duration = 6;
					level = 2;
				}
				if(API.randDouble(1, 100) <= witherChance + addChance){
					attacker.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, duration * 20, level));
					if(API.DEBUG_MODE){
						API.sendDebug(user, user, "Wither " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onPineapple(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player user = (Player) e.getEntity();
			Player attacker = (Player) e.getDamager();
			if(API.hasEnchant("Pineapple", user.getInventory().getChestplate())){
				int tier  = API.getEnchantLvl("Pineapple", user.getInventory().getChestplate());
				double addChance = 0;
				if(tier == 1){
					addChance = 0;
				}
				if(tier == 2){
					addChance = 5;
				}
				if(API.randDouble(1, 100) <= pineappleChance + addChance){
					attacker.damage(1.0);
					if(API.DEBUG_MODE){
						API.sendDebug(user, user, "Pineapple " + API.romanNumerals.get(tier));
					}
				}
			}
			if(API.hasEnchant("Pineapple", user.getInventory().getLeggings())){
				int tier  = API.getEnchantLvl("Pineapple", user.getInventory().getLeggings());
				double addChance = 0;
				if(tier == 1){
					addChance = 0;
				}
				if(tier == 2){
					addChance = 5;
				}
				if(API.randDouble(1, 100) <= pineappleChance + addChance){
					attacker.damage(1.0);
					if(API.DEBUG_MODE){
						API.sendDebug(user, user, "Pineapple " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

}
