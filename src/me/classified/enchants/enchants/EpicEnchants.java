package me.classified.enchants.enchants;

import java.util.ArrayList;
import java.util.HashMap;

import me.classified.enchants.cEnchants;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

import com.codingforcookies.armorequip.ArmorEquipEvent;

import me.classified.enchants.utils.API;
import me.classified.enchants.utils.CustomItems;
import me.classified.enchants.utils.ParticleEffect;
import me.classified.enchants.utils.ParticleEffect.BlockData;

public class EpicEnchants implements Listener{

	double chickenChance = 50.0;
	double punctureChance = 5.0;
	double blessedChance = 5.0;
	double angelChance = 4.0;
	double trophyChance = 25.0;
	double flashbangChance = 5.0;
	double archerChance = 5.0;
	double spectralChance = 5.0;
	double collectionChance = 90.0;
	double bruteChance = 3.0;
	double vestChance = 3.0;
	double snareChance = 3.0;
	double pyroChance = 3.0;
	double overdoseChance = 4.0;
	double muffleChance = 3.0;
	
	double eyepatchChance = 30.0;

	public static HashMap<String, ArrayList<ItemStack>> deathBags = new HashMap<String, ArrayList<ItemStack>>();
	public static ArrayList<Player> muffled = new ArrayList<Player>();

	@EventHandler
	public void onChicken(EntityDamageEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(e.getCause().equals(DamageCause.FALL)){
				if(API.hasEnchant("Chicken", p.getInventory().getBoots())){
					int tier = API.getEnchantLvl("Chicken", p.getInventory().getBoots());			
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
					if(API.randDouble(1, 100) <= chickenChance + addChance){
						e.setCancelled(true);
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Chicken " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onPenetrate(EntityDamageByEntityEvent event){
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player){
			Player target = (Player)event.getEntity();
			Player attacker = (Player)event.getDamager();
			if (API.hasEnchant("Puncture", attacker.getInventory().getItemInHand())){
				int tier = API.getEnchantLvl("Puncture", attacker.getInventory().getItemInHand());
				int addChance = 0;
				int percent = 0;
				if (tier == 5) {
					addChance = 5;
					percent = 5;
				}
				if (tier == 4) {
					addChance = 2;
					percent = 3;
				}
				if (tier == 3) {
					addChance = 2;
					percent = 2;
				}
				if (tier == 2) {
					addChance = 1;
					percent = 2;
				}
				if (tier == 1) {
					addChance = 0;
					percent = 1;
				}
				if(API.randDouble(1, 100) <= punctureChance + addChance){	
					if (target.getInventory().getHelmet() != null){
						ItemStack hand_item = target.getInventory().getHelmet();
						hand_item.setDurability((short)(hand_item.getDurability() + percent));
						target.getInventory().setHelmet(hand_item);
					}
					if (target.getInventory().getChestplate() != null){
						ItemStack hand_item = target.getInventory().getChestplate();
						hand_item.setDurability((short)(hand_item.getDurability() + percent));
						target.getInventory().setChestplate(hand_item);
					}
					if (target.getInventory().getLeggings() != null){
						ItemStack hand_item = target.getInventory().getLeggings();
						hand_item.setDurability((short)(hand_item.getDurability() + percent));
						target.getInventory().setLeggings(hand_item);
					}
					if (target.getInventory().getBoots() != null){
						ItemStack hand_item = target.getInventory().getBoots();
						hand_item.setDurability((short)(hand_item.getDurability() + percent));
						target.getInventory().setBoots(hand_item);
					}
					//Effect
					target.playSound(target.getLocation(), Sound.ANVIL_LAND, 1, 3);
					if(API.DEBUG_MODE){
						API.sendDebug(target, attacker, "Puncture " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, attacker, "Puncture " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onOverload(ArmorEquipEvent e){
		Player p = e.getPlayer();
		if (!(e.getNewArmorPiece() == null) && (e.getNewArmorPiece().getType() != Material.AIR)){
			if(API.hasEnchant("Overload", e.getNewArmorPiece())){
				int tier = API.getEnchantLvl("Overload", e.getNewArmorPiece()); 	  
				if(tier == 1){
					p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 0));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Overload " + API.romanNumerals.get(tier));
					}
				}
				if(tier == 2){
					p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 1));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Overload " + API.romanNumerals.get(tier));
					}
				}
				if(tier == 3){
					p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 2));
					if(API.DEBUG_MODE){
						API.sendDebug(p, p, "Overload " + API.romanNumerals.get(tier));
					}
				}
			}
		}
		if (!(e.getOldArmorPiece() == null) && !(e.getOldArmorPiece().getType() == Material.AIR)){
			if(API.hasEnchant("Overload", e.getOldArmorPiece())){
				p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
			}
		}
	}

	@EventHandler
	public void onBlessed(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player target = (Player) e.getEntity();
			Player attacker = (Player) e.getDamager();
			if(API.hasEnchant("Blessed", attacker.getItemInHand())){
				int tier = API.getEnchantLvl("Blessed", attacker.getItemInHand());
				int addChance = 1;
				if(tier == 1){
					addChance = 0;
				}
				if(tier == 2){
					addChance = 2;
				}
				if(tier == 3){
					addChance = 4;
				}
				if(API.randDouble(1, 100) <= blessedChance + addChance){
					for(PotionEffectType pe : cEnchants.negativePotions){
						attacker.removePotionEffect(pe);
					}
					attacker.playSound(attacker.getLocation(), Sound.WATER, 1, 1);
                    ParticleEffect.BLOCK_CRACK.display(new BlockData(Material.WATER, (byte) 2), 0.2f, 1.2f, 0.2f, 1, 100, target.getLocation(), 75);
					if(API.DEBUG_MODE){
						API.sendDebug(target, attacker, "Blessed " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, attacker, "Blessed " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onSnare(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player target = (Player) e.getEntity();
			Player attacker = (Player) e.getDamager();
			if(API.hasEnchant("Snare", attacker.getItemInHand())){
				int tier = API.getEnchantLvl("Snare", attacker.getItemInHand());
				int addChance = 1;
				int duration = 0;
				int level = 0;
				int negateChance = 0;
				if(tier == 1){
					addChance = 0;
					duration = 2;
					level = 1;
				}
				if(tier == 2){
					addChance = 2;
					duration = 4;
					level = 2;
				}
				if(tier == 3){
					addChance = 4;
					duration = 6;
					level = 3;
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
				if(API.randDouble(1, 100) <= snareChance + addChance){
					if(API.randDouble(1, 100) <= negateChance){
						API.sendDebug(target, attacker, "Agility " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, attacker, "Agility " + API.romanNumerals.get(tier));
						return;
					}
					target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, duration * 20, level));
					if(API.DEBUG_MODE){
						API.sendDebug(target, attacker, "Snare " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, attacker, "Snare " + API.romanNumerals.get(tier));
					}

				}
			}
		}
	}

	@EventHandler
	public void onAngel(EntityDamageByEntityEvent event){
		if ((event.getEntity() instanceof Player)){
			Player p = (Player)event.getEntity();
			if ((p.getHealth() <= 6.0D) && 
					(API.hasEnchant("Angel", p.getInventory().getHelmet()))){
				int tier = API.getEnchantLvl("Angel", p.getInventory().getHelmet());
				int addChance = 0;
				if (tier == 1) {
					addChance = 15;
					if (API.randDouble(1, 100) <= angelChance + addChance){
						p.removePotionEffect(PotionEffectType.REGENERATION);
						p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3 *20, 0));
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Angel " + API.romanNumerals.get(tier));
						}
					}
				}
				if (tier == 2) {
					addChance = 10;
					if (API.randDouble(1, 100) <= angelChance + addChance){
						p.removePotionEffect(PotionEffectType.REGENERATION);
						p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3 *20, 1));
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Angel " + API.romanNumerals.get(tier));
						}
					}
				}
				if (tier == 3) {
					addChance = 5;
					if (API.randDouble(1, 100) <= angelChance + addChance){
						p.removePotionEffect(PotionEffectType.REGENERATION);
						p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3 *20, 2));
						if(API.DEBUG_MODE){
							API.sendDebug(p, p, "Angel " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	@EventHandler
	private void onBehead(PlayerDeathEvent e){
		if (e.getEntity().getKiller() instanceof Player && e.getEntity().getPlayer() instanceof Player){
			Player killer = e.getEntity().getKiller();
			Player victim = e.getEntity().getPlayer();
			if (API.hasEnchant("Trophy", killer.getItemInHand())){
				int tier = API.getEnchantLvl("Trophy", killer.getItemInHand());
				int addChance = 0;
				if (tier == 1) {
					addChance = 0;
				}
				if (tier == 2) {
					addChance = 5;
				}
				if (tier == 3) {
					addChance = 10;
				}
				if (API.randDouble(1, 100) <= trophyChance + addChance){
					ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta sm = (SkullMeta)is.getItemMeta();
					ArrayList<String> headLore = new ArrayList<String>();
					sm.setOwner(victim.getName());
					sm.setDisplayName(API.color("&c&l"+ victim.getName() +"'s Head"));
					headLore.add(API.color("&bDefeated by: &8" + killer.getName()));
					sm.setLore(headLore);
					is.setItemMeta(sm);
					victim.getWorld().dropItemNaturally(victim.getLocation(), is);
					if(API.DEBUG_MODE){
						API.sendDebug(killer, killer, "Trophy " + API.romanNumerals.get(tier));
						API.sendDebug(victim, killer, "Trophy " + API.romanNumerals.get(tier));
					}
					return;
				}
			}
		}
	}

	@EventHandler
	public void onFlashbang(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player target = (Player) e.getEntity();
			Player attacker = (Player) e.getDamager();
			if(API.hasEnchant("Flashbang", target.getInventory().getHelmet())){
				int tier = API.getEnchantLvl("Flashbang", target.getInventory().getHelmet());			
				int addChance = 0;
				int particleAmount = 0;
				if(tier == 1){
					addChance = 0;
					particleAmount = 3;
				}
				if(tier == 2){
					addChance = 2;
					particleAmount = 4;
				}
				if(tier == 3){
					addChance = 2;
					particleAmount = 5;
				}
				if(tier == 4){
					addChance = 2;
					particleAmount = 6;
				}
				if(tier == 5){
					addChance = 3;
					particleAmount = 8;
				}
				if(tier == 6){
					addChance = 3;
					particleAmount = 10;
				}
				if(tier == 7){
					addChance = 4;
					particleAmount = 12;
				}
				if(tier == 8){
					addChance = 5;
					particleAmount = 15;
				}
				if(API.randDouble(1, 100) <= flashbangChance + addChance){
					for(int i = 0; i < particleAmount; i++){
						ParticleEffect.BLOCK_CRACK.display(new BlockData(Material.WOOL, (byte) 15), 0.3f, 1.0f, 0.3f, 1, 200, attacker.getLocation(), 150);
						if(API.DEBUG_MODE){
							API.sendDebug(target, target, "Flashbang " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, target, "Flashbang " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}

	ArrayList<Player> archershot = new ArrayList<Player>();
	@EventHandler
	public void onArcherShot(EntityDamageByEntityEvent e){
		if (e.getDamager() instanceof Arrow){
			ProjectileSource attacker = ((Arrow)e.getDamager()).getShooter();
			if (attacker instanceof Player && archershot.contains(attacker)){
				e.setDamage(e.getDamage() * 2.0D);
				archershot.remove(attacker);
			}
		}
	}

	@EventHandler
	public void onArcher(EntityShootBowEvent e){
		Player p = (Player)e.getEntity();
		if (API.hasEnchant("Archer", p.getInventory().getItemInHand())){
			int tier = API.getEnchantLvl("Archer", p.getItemInHand());
			int addChance = 80;
			if (tier == 3) {
				addChance = 0;
			}
			if (tier == 2) {
				addChance = 3;
			}
			if (tier == 1) {
				addChance = 6;
			}
			if (API.randDouble(1, 100) <= archerChance + addChance) {
				archershot.add(p);
				if(API.DEBUG_MODE){
					API.sendDebug(p, p, "Archer " + API.romanNumerals.get(tier));
				}
			}
		}
	}

	@EventHandler
	public void onSpectral(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			Player attacker = (Player) e.getDamager();
			Player target = (Player) e.getEntity();
			if(API.hasEnchant("Spectral", target.getInventory().getHelmet())){
				int tier = API.getEnchantLvl("Spectral", target.getInventory().getHelmet());
				int addChance = 0;
				int duration = 0;
				if(tier == 1){
					addChance = 0;
					duration = 2 * 20;
				}
				if(tier == 2){
					addChance = 5;
					duration = 4 * 20;
				}
				if(tier == 3){
					addChance = 10;
					duration = 6 * 20;
				}
				if(API.randDouble(1, 100) <= spectralChance + addChance){
					target.playSound(target.getLocation(), Sound.DRINK, 1, 2);
					target.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, duration, 0));
					if(API.DEBUG_MODE){
						API.sendDebug(target, target, "Spectral " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, target, "Spectral " + API.romanNumerals.get(tier));
					}
				}
			}
		}
	}

	@EventHandler
	public void onBrute(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			Player attacker = (Player) e.getDamager();
			Player target = (Player) e.getEntity();
			if(attacker.getItemInHand().getType().toString().contains("AXE")){
				if(API.hasEnchant("Brute", target.getInventory().getHelmet())){
					int tier = API.getEnchantLvl("Brute", target.getInventory().getHelmet());
					int addChance = 0;
					double multiplier = 0;
					if(tier == 1){
						addChance = 0;
						multiplier = 1.85;
					}
					if(tier == 2){
						addChance = 3;
						multiplier = 3.7;
					}
					if(tier == 3){
						addChance = 5;
						multiplier = 5.55;
					}
					if(tier == 4){
						addChance = 8;
						multiplier = 7.4;
					}
					if(API.randDouble(1, 100) <= bruteChance + addChance){
						e.setDamage(e.getDamage() / multiplier);
						if(API.DEBUG_MODE){
							API.sendDebug(target, target, "Brute " + API.romanNumerals.get(tier) + " (Helmet)");
							API.sendDebug(attacker, target, "Brute " + API.romanNumerals.get(tier) + " (Helmet)");
						}
					}
				}
				if(API.hasEnchant("Brute", target.getInventory().getChestplate())){
					int tier = API.getEnchantLvl("Brute", target.getInventory().getChestplate());
					int addChance = 0;
					double multiplier = 0;
					if(tier == 1){
						addChance = 0;
						multiplier = 1.85;
					}
					if(tier == 2){
						addChance = 3;
						multiplier = 3.7;
					}
					if(tier == 3){
						addChance = 5;
						multiplier = 5.55;
					}
					if(tier == 4){
						addChance = 8;
						multiplier = 7.4;
					}
					if(API.randDouble(1, 100) <= bruteChance + addChance){
						e.setDamage(e.getDamage() / multiplier);
						if(API.DEBUG_MODE){
							API.sendDebug(target, target, "Brute " + API.romanNumerals.get(tier) + " (Chestplate)");
							API.sendDebug(attacker, target, "Brute " + API.romanNumerals.get(tier) + " (Chestplate)");
						}
					}
				}
				if(API.hasEnchant("Brute", target.getInventory().getLeggings())){
					int tier = API.getEnchantLvl("Brute", target.getInventory().getLeggings());
					int addChance = 0;
					double multiplier = 0;
					if(tier == 1){
						addChance = 0;
						multiplier = 1.85;
					}
					if(tier == 2){
						addChance = 3;
						multiplier = 3.7;
					}
					if(tier == 3){
						addChance = 5;
						multiplier = 5.55;
					}
					if(tier == 4){
						addChance = 8;
						multiplier = 7.4;
					}
					if(API.randDouble(1, 100) <= bruteChance + addChance){
						e.setDamage(e.getDamage() / multiplier);
						if(API.DEBUG_MODE){
							API.sendDebug(target, target, "Brute " + API.romanNumerals.get(tier) + " (Leggings)");
							API.sendDebug(attacker, target, "Brute " + API.romanNumerals.get(tier) + " (Leggings)");
						}
					}
				}
				if(API.hasEnchant("Brute", target.getInventory().getBoots())){
					int tier = API.getEnchantLvl("Brute", target.getInventory().getBoots());
					int addChance = 0;
					double multiplier = 0;
					if(tier == 1){
						addChance = 0;
						multiplier = 1.85;
					}
					if(tier == 2){
						addChance = 3;
						multiplier = 3.7;
					}
					if(tier == 3){
						addChance = 5;
						multiplier = 5.55;
					}
					if(tier == 4){
						addChance = 8;
						multiplier = 7.4;
					}
					if(API.randDouble(1, 100) <= bruteChance + addChance){
						e.setDamage(e.getDamage() / multiplier);
						if(API.DEBUG_MODE){
							API.sendDebug(target, target, "Brute " + API.romanNumerals.get(tier) + " (Boots)");
							API.sendDebug(attacker, target, "Brute " + API.romanNumerals.get(tier) + " (Boots)");
						}
					}
				}
			}
		}
	}
	@EventHandler
	public void onVest(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			Player attacker = (Player) e.getDamager();
			Player target = (Player) e.getEntity();
			if(attacker.getItemInHand().getType().toString().contains("SWORD")){
				if(API.hasEnchant("Vest", target.getInventory().getHelmet())){
					int tier = API.getEnchantLvl("Vest", target.getInventory().getHelmet());
					int addChance = 0;
					double multiplier = 0;
					if(tier == 1){
						addChance = 0;
						multiplier = 1.85;
					}
					if(tier == 2){
						addChance = 3;
						multiplier = 3.7;
					}
					if(tier == 3){
						addChance = 5;
						multiplier = 5.55;
					}
					if(tier == 4){
						addChance = 8;
						multiplier = 7.4;
					}
					if(API.randDouble(1, 100) <= vestChance + addChance){
						e.setDamage(e.getDamage() / multiplier);
						if(API.DEBUG_MODE){
							API.sendDebug(target, target, "Vest " + API.romanNumerals.get(tier) + " (Helmet)");
							API.sendDebug(attacker, target, "Vest " + API.romanNumerals.get(tier) + " (Helmet)");
						}
					}
				}
				if(API.hasEnchant("Vest", target.getInventory().getChestplate())){
					int tier = API.getEnchantLvl("Vest", target.getInventory().getChestplate());
					int addChance = 0;
					double multiplier = 0;
					if(tier == 1){
						addChance = 0;
						multiplier = 1.85;
					}
					if(tier == 2){
						addChance = 3;
						multiplier = 3.7;
					}
					if(tier == 3){
						addChance = 5;
						multiplier = 5.55;
					}
					if(tier == 4){
						addChance = 8;
						multiplier = 7.4;
					}
					if(API.randDouble(1, 100) <= vestChance + addChance){
						e.setDamage(e.getDamage() / multiplier);
						if(API.DEBUG_MODE){
							API.sendDebug(target, target, "Vest " + API.romanNumerals.get(tier) + " (Chestplate)");
							API.sendDebug(attacker, target, "Vest " + API.romanNumerals.get(tier) + " (Chestplate)");
						}
					}
				}
				if(API.hasEnchant("Vest", target.getInventory().getLeggings())){
					int tier = API.getEnchantLvl("Vest", target.getInventory().getLeggings());
					int addChance = 0;
					double multiplier = 0;
					if(tier == 1){
						addChance = 0;
						multiplier = 1.85;
					}
					if(tier == 2){
						addChance = 3;
						multiplier = 3.7;
					}
					if(tier == 3){
						addChance = 5;
						multiplier = 5.55;
					}
					if(tier == 4){
						addChance = 8;
						multiplier = 7.4;
					}
					if(API.randDouble(1, 100) <= vestChance + addChance){
						e.setDamage(e.getDamage() / multiplier);
						if(API.DEBUG_MODE){
							API.sendDebug(target, target, "Vest " + API.romanNumerals.get(tier) + " (Leggings)");
							API.sendDebug(attacker, target, "Vest " + API.romanNumerals.get(tier) + " (Leggings)");
						}
					}
				}
				if(API.hasEnchant("Vest", target.getInventory().getBoots())){
					int tier = API.getEnchantLvl("Vest", target.getInventory().getBoots());
					int addChance = 0;
					double multiplier = 0;
					if(tier == 1){
						addChance = 0;
						multiplier = 1.85;
					}
					if(tier == 2){
						addChance = 3;
						multiplier = 3.7;
					}
					if(tier == 3){
						addChance = 5;
						multiplier = 5.55;
					}
					if(tier == 4){
						addChance = 8;
						multiplier = 7.4;
					}
					if(API.randDouble(1, 100) <= vestChance + addChance){
						e.setDamage(e.getDamage() / multiplier);
						if(API.DEBUG_MODE){
							API.sendDebug(target, target, "Vest " + API.romanNumerals.get(tier) + " (Boots)");
							API.sendDebug(attacker, target, "Vest " + API.romanNumerals.get(tier) + " (Boots)");
						}
					}
				}
			}
		}
	}
	@EventHandler
	public void onPyro(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player target = (Player) e.getEntity();
			Player attacker = (Player) e.getDamager();
			if(API.hasEnchant("Pyro", attacker.getItemInHand())){
				int tier = API.getEnchantLvl("Pyro", attacker.getItemInHand());
				int addChance = 1;
				if(tier == 1){
					addChance = 0;
				}
				if(tier == 2){
					addChance = 2;
				}
				if(tier == 3){
					addChance = 4;
				}
				if(API.randDouble(1, 100) <= pyroChance + addChance){
					if(target.getFireTicks() != 0){
						target.damage(2.0);
						if(API.DEBUG_MODE){
							API.sendDebug(target, attacker, "Pyro " + API.romanNumerals.get(tier));
							API.sendDebug(attacker, attacker, "Pyro " + API.romanNumerals.get(tier));
						}
					}
				}
			}
		}
	}
	@EventHandler
	public void onOverdose(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player target = (Player) e.getEntity();
			Player attacker = (Player) e.getDamager();
			if(API.hasEnchant("Overdose", attacker.getItemInHand())){
				int tier = API.getEnchantLvl("Overdose", attacker.getItemInHand());
				int addChance = 1;
				if(tier == 1){
					addChance = 0;
				}
				if(tier == 2){
					addChance = 2;
				}
				if(tier == 3){
					addChance = 4;
				}
				if(API.randDouble(1, 100) <= overdoseChance + addChance){
					target.damage(e.getDamage() * 2 / 8);
					target.playSound(target.getLocation(), Sound.GHAST_SCREAM2, 1, 2);
					if(API.DEBUG_MODE){
						API.sendDebug(target, attacker, "Overdose " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, attacker, "Overdose " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, attacker, "&a&lOriginal Damage: " + e.getDamage());
						API.sendDebug(attacker, attacker, "&c&lMultiplied Damage: " + e.getDamage() * 2 / 8);
					}

				}
			}
		}
	} 
	@EventHandler
	public void onMuffle(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player target = (Player) e.getEntity();
			Player attacker = (Player) e.getDamager();
			if(API.hasEnchant("Muffle", attacker.getItemInHand())){
				int tier = API.getEnchantLvl("Muffle", attacker.getItemInHand());
				int addChance = 1;
				int muffleTime = 3;
				if(tier == 1){
					addChance = 0;
					muffleTime = 2;
				}
				if(tier == 2){
					addChance = 2;
					muffleTime = 3;
				}
				if(tier == 3){
					addChance = 3;
					muffleTime = 5;
				}
				if(tier == 4){
					addChance = 4;
					muffleTime = 7;
				}
				if(API.randDouble(1, 100) <= muffleChance + addChance){
					muffled.add(target);
					target.sendMessage(API.color("&8&l** &e&lMUFFLED &7("+ muffleTime +"s) &8&l***"));
					Bukkit.getScheduler().runTaskLater(cEnchants.getInstance(), new Runnable() {
						public void run(){
							muffled.remove(target);
						}
					},muffleTime * 20L); 
					if(API.DEBUG_MODE){
						API.sendDebug(target, attacker, "Muffle " + API.romanNumerals.get(tier));
						API.sendDebug(attacker, attacker, "Muffle " + API.romanNumerals.get(tier));
					}

				}
			}
		}
	}
}
