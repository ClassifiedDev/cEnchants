package me.classified.enchants.listeners;

import me.classified.enchants.cEnchants;
import me.classified.enchants.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.classified.enchants.commands.EnchantsCommand;
import me.classified.enchants.utils.API;
import me.classified.enchants.utils.CustomItems;

public class InventoryClickListener implements Listener{

	@EventHandler
	public void onEnchanterClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(p.getOpenInventory().getTitle().equals(API.color(Config.enchanterTitle))){
			if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(!e.getCurrentItem().hasItemMeta()){
				e.setCancelled(true); 
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color(Config.enchanterBook1Name))){
				int tier1Cost = Config.enchanterBook1Price;
				if(p.getTotalExperience() >= tier1Cost){
					p.getInventory().addItem(CustomItems.basicOrb);
					int xp = p.getTotalExperience();
					p.setExp(0);
					p.setTotalExperience(0);
					p.setLevel(0);
					p.giveExp(xp - tier1Cost);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 2);
					p.sendMessage(API.color("&c&l- " + tier1Cost + " XP"));
					e.setCancelled(true);
					return;
				}
				p.sendMessage(API.color("&c&l(!) &cYou do not have enough XP to buy this."));
				p.sendMessage(API.color("&8&l* &cEnchantment Cost: &7" + tier1Cost + " XP"));
				p.sendMessage(API.color("&8&l* &aYour current XP: &7" + p.getTotalExperience()));
				p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1, 2);
				e.setCancelled(true); 
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color(Config.enchanterBook2Name))){
				int tier2Cost = Config.enchanterBook2Price;
				if(p.getTotalExperience() >= tier2Cost){
					p.getInventory().addItem(CustomItems.advancedOrb);
					int xp = p.getTotalExperience();
					p.setExp(0);
					p.setTotalExperience(0);
					p.setLevel(0);
					p.giveExp(xp - tier2Cost);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 2);
					p.sendMessage(API.color("&c&l- " + tier2Cost + " XP"));
					e.setCancelled(true);
					return;
				}
                p.sendMessage(API.color("&c&l(!) &cYou do not have enough XP to buy this."));
                p.sendMessage(API.color("&8&l* &cEnchantment Cost: &7" + tier2Cost + " XP"));
                p.sendMessage(API.color("&8&l* &aYour current XP: &7" + p.getTotalExperience()));
				p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1, 2);
				e.setCancelled(true); 
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color(Config.enchanterBook3Name))){
				int tier3Cost = Config.enchanterBook3Price;
				if(p.getTotalExperience() >= tier3Cost){
					p.getInventory().addItem(CustomItems.epicOrb);
					int xp = p.getTotalExperience();
					p.setExp(0);
					p.setTotalExperience(0);
					p.setLevel(0);
					p.giveExp(xp - tier3Cost);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 2);
					p.sendMessage(API.color("&c&l- " + tier3Cost + " XP"));
					e.setCancelled(true);
					return;
				}
                p.sendMessage(API.color("&c&l(!) &cYou do not have enough XP to buy this."));
                p.sendMessage(API.color("&8&l* &cEnchantment Cost: &7" + tier3Cost + " XP"));
                p.sendMessage(API.color("&8&l* &aYour current XP: &7" + p.getTotalExperience()));
				p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1, 2);
				e.setCancelled(true); 
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color(Config.enchanterBook4Name))){
				int tier4Cost = Config.enchanterBook4Price;
				if(p.getTotalExperience() >= tier4Cost){
					p.getInventory().addItem(CustomItems.legendaryOrb);
					int xp = p.getTotalExperience();
					p.setExp(0);
					p.setTotalExperience(0);
					p.setLevel(0);
					p.giveExp(xp - tier4Cost);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 2);
					p.sendMessage(API.color("&c&l- " + tier4Cost + " XP"));
					e.setCancelled(true);
					return;
				}
                p.sendMessage(API.color("&c&l(!) &cYou do not have enough XP to buy this."));
                p.sendMessage(API.color("&8&l* &cEnchantment Cost: &7" + tier4Cost + " XP"));
                p.sendMessage(API.color("&8&l* &aYour current XP: &7" + p.getTotalExperience()));
				p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1, 2);
				e.setCancelled(true); 
				return;
			}
			e.setCancelled(true);
			return;
		}
	}

	ItemStack back = API.itemBuilder(Material.STAINED_GLASS_PANE, (short) 14, 1, "&7» &c&lBack &7«", new String[]{"&7Click view enchant tiers."} , false);
	
	//Enchant List For /enchants
	//BASIC
	ItemStack glowing = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lGlowing &8[&7I&8]", new String[] {"&f&lDescription:", "&7Gives you permanent night", "&7vision effect.", " ", "&f&lEnchant Type:", "&7Helmet"}, Config.enchantsBook1Glowing);
	ItemStack diver = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lDiver &8[&7I&8]", new String[] {"&f&lDescription:", "&7Gives you permanent water", "&7breathing effect.", " ", "&f&lEnchant Type:", "&7Helmet"}, Config.enchantsBook1Glowing);
	ItemStack pineapple = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lPineapple &8[&7I-II&8]", new String[] {"&f&lDescription:", "&7Chance to give your attacker", "&7a tick of damage.", " ", "&f&lEnchant Type:", "&7Chestplate, Leggings"}, Config.enchantsBook1Glowing);
	ItemStack bulletproof = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lBullet Proof &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to deflect arrows.", " ", "&f&lEnchant Type:", "&7Leggings"}, Config.enchantsBook1Glowing);
	ItemStack agility = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lAgility &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance negate the slowness", "&7effect.", " ", "&f&lEnchant Type:", "&7Boots"}, Config.enchantsBook1Glowing);
	ItemStack wither = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lWither &8[&7I-V&8]", new String[] {"&f&lDescription:", "&7Chance to give wither effect", "&7to your attacker.", " ", "&f&lEnchant Type:", "&7Armor"}, Config.enchantsBook1Glowing);
	ItemStack saturated = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lSaturated &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to give you food", "&7bars while sprinting.", " ", "&f&lEnchant Type:", "&7Armor"}, Config.enchantsBook1Glowing);
	ItemStack frozen = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lFrozen &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to freeze your opponent", "&7in their place for limited time.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook1Glowing);
	ItemStack voltage = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lVoltage &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to strike your attacker", "&7with lightning.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook1Glowing);
	ItemStack venom = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lVenom &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to give your opponent", "&7poision for a limited time.", " ", "&f&lEnchant Type:", "&7Sword, Axe"}, Config.enchantsBook1Glowing);
	ItemStack blackout = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lBlackout &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to give your opponent", "&7blindness for a limited time.", " ", "&f&lEnchant Type:", "&7Sword, Axe"}, Config.enchantsBook1Glowing);
	ItemStack ravenous = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lRavenous &8[&7I-V&8]", new String[] {"&f&lDescription:", "&7Chance to give your opponent", "&7hunger for a limited time.", " ", "&f&lEnchant Type:", "&7Sword, Axe"}, Config.enchantsBook1Glowing);
	ItemStack flashback = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lFlashback &8[&7I-VIII&8]", new String[] {"&f&lDescription:", "&7Chance to teleport behind", "&7your opponent.", " ", "&f&lEnchant Type:", "&7Sword, Axe"}, Config.enchantsBook1Glowing);
	ItemStack haste = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lHaste &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to get a burst of", "&7haste for a limited time.", " ", "&f&lEnchant Type:", "&7Sword, Axe, Pickaxe"}, Config.enchantsBook1Glowing);
	ItemStack explosive = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lExplosive &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to cause an explosion", "&7where your arrow lands.", " ", "&f&lEnchant Type:", "&7Bow"}, Config.enchantsBook1Glowing);
	ItemStack ghast = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lGhast &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to shoot fireballs", "&7instead of arrows.", " ", "&f&lEnchant Type:", "&7Bow"}, Config.enchantsBook1Glowing);
	ItemStack furnace = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lFurnace &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to automatially smelt", "&7ores.", " ", "&f&lEnchant Type:", "&7Pickaxe"}, Config.enchantsBook1Glowing);
	ItemStack scavenger = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.tier1BookColor + "&lScavenger &8[&7I-V&8]", new String[] {"&f&lDescription:", "&7Chance to recieve more loot", "&7while mining ores.", " ", "&f&lEnchant Type:", "&7Pickaxe"}, Config.enchantsBook1Glowing);
	//ADVANCED
	ItemStack wormhole = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lWormhole &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7On low hp recieve high levels of", "&7speed, regeneration and blindness", "&7to escape your attacker.", " ", "&f&lEnchant Type:", "&7Helmet"}, Config.enchantsBook2Glowing);
	ItemStack shield = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lShield &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to block damage from", "&7your opponent.", " ", "&f&lEnchant Type:", "&7Chestplate"}, Config.enchantsBook2Glowing);
	ItemStack selfdestruct = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lSelf Destruct &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to drop tnt when you die.", " ", "&f&lEnchant Type:", "&7Chestplate, Leggings"}, Config.enchantsBook2Glowing);
	ItemStack creeper = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lCreeper &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Immune to explosions depending on level.", " ", "&f&lEnchant Type:", "&7Chestplate, Leggings"}, Config.enchantsBook2Glowing);
	ItemStack safeguard = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lSafeguard &8[&7I-X&8]", new String[] {"&f&lDescription:", "&7Chance to spawn iron golems to", "&7defend you.", " ", "&f&lEnchant Type:", "&7Chestplate, Leggings"}, Config.enchantsBook2Glowing);
	ItemStack replenish = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lReplenish &8[&7I-II&8]", new String[] {"&f&lDescription:", "&7Chance to get regeneration effect", "&7while being attacked.", " ", "&f&lEnchant Type:", "&7Chestplate, Leggings"}, Config.enchantsBook2Glowing);
	ItemStack radioactive = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lRadioactive &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to give nearby opponents", "&7negative debuffs for limited time.", " ", "&f&lEnchant Type:", "&7Leggings"}, Config.enchantsBook2Glowing);
	ItemStack counter = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lCounter &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to redirect an attack back", "&7onto your opponent.", " ", "&f&lEnchant Type:", "&7Leggings"}, Config.enchantsBook2Glowing);
	ItemStack springs = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lSprings &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Gives permanent jump according to", "&7the level of enchant.", " ", "&f&lEnchant Type:", "&7Boots"}, Config.enchantsBook2Glowing);
	ItemStack ninja = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lNinja &8[&7I&8]", new String[] {"&f&lDescription:", "&7Chance get a burst of speed 4", "&7when low on hp.", " ", "&f&lEnchant Type:", "&7Boots"}, Config.enchantsBook2Glowing);
	ItemStack marshmallow = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lMarshmallow &8[&7I-V&8]", new String[] {"&f&lDescription:", "&7Chance to gain resistance for a", "&7limited time.", " ", "&f&lEnchant Type:", "&7Armor"}, Config.enchantsBook2Glowing);
	ItemStack blaze = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lBlaze &8[&7I&8]", new String[] {"&f&lDescription:", "&7Gives permanent fire resistance.", " ", "&f&lEnchant Type:", "&7Armor"}, Config.enchantsBook2Glowing);
	ItemStack thief = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lThief &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to steal your opponents", "&7xp or money.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook2Glowing);
	ItemStack fracture = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lFracture &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to give your opponent slowness,", "&7slow swinging and strike lightning ", "&7on your enemy.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook2Glowing);
	ItemStack confusion = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lConfusion &8[&7I-V&8]", new String[] {"&f&lDescription:", "&7Chance to give your opponent", "&7nausea effect for limited time.", " ", "&f&lEnchant Type:", "&7Axe"}, Config.enchantsBook2Glowing);
	ItemStack virus = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lVirus &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to give your opponent", "&7weakness for a limited time.", " ", "&f&lEnchant Type:", "&7Axe"}, Config.enchantsBook2Glowing);
	ItemStack wound = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lWound &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to give the bleed effect", "&7to your opponent.", " ", "&f&lEnchant Type:", "&7Sword, Axe"}, Config.enchantsBook2Glowing);
	ItemStack push = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lPush &8[&7I-II&8]", new String[] {"&f&lDescription:", "&7Chance to cause extreme knockback", "&7to your opponent.", " ", "&f&lEnchant Type:", "&7Sword, Axe"}, Config.enchantsBook2Glowing);
	ItemStack shock = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lShock &8[&7I-V&8]", new String[] {"&f&lDescription:", "&7Chance to smite your opponent.", " ", "&f&lEnchant Type:", "&7Sword, Axe, Bow"}, Config.enchantsBook2Glowing);
	ItemStack obsidiandestroyer = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lObsidian Destroyer &8[&7I-V&8]", new String[] {"&f&lDescription:", "&7Chance to insta break obsidian.", " ", "&f&lEnchant Type:", "&7Pickaxe"}, Config.enchantsBook2Glowing);
	ItemStack miner = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.tier2BookColor + "&lMiner &8[&7I-V&8]", new String[] {"&f&lDescription:", "&7Chance to get more xp from", "&7mining ores.", " ", "&f&lEnchant Type:", "&7Pickaxe"}, Config.enchantsBook2Glowing);
	
	//EPIC
	ItemStack angel = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lAngel &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to get regeneration 3", "&7on low hp.", " ", "&f&lEnchant Type:", "&7Helmet"}, Config.enchantsBook3Glowing);
	ItemStack flashbang = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lFlashbang &8[&7I-VIII&8]", new String[] {"&f&lDescription:", "&7Chance to blind your opponent", "&7with particle effects.", " ", "&f&lEnchant Type:", "&7Helmet"}, Config.enchantsBook3Glowing);
	ItemStack spectral = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lSpectral &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to go invisible for a limited time.", " ", "&f&lEnchant Type:", "&7Helmet"}, Config.enchantsBook3Glowing);
	ItemStack overload = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lOverload &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Gives permanent health boost.", " ", "&f&lEnchant Type:", "&7Chestplate, Leggings"}, Config.enchantsBook3Glowing);
	ItemStack chicken = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lChicken &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to negate fall damage.", " ", "&f&lEnchant Type:", "&7Boots"}, Config.enchantsBook3Glowing);
	ItemStack brute = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lBrute &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to decrease damage from axes", "&7by 1.85x per level.", " ", "&f&lEnchant Type:", "&7Armor"}, Config.enchantsBook3Glowing);
	ItemStack vest = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lVest &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to decrease damage from swords", "&7by 1.85x per level.", " ", "&f&lEnchant Type:", "&7Armor"}, Config.enchantsBook3Glowing);
	ItemStack lucky = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lLucky &8[&7I-X&8]", new String[] {"&f&lDescription:", "&7You will find yourself lucky in", "&7certain situations.", " ", "&f&lEnchant Type:", "&7Armor"}, Config.enchantsBook3Glowing);
	ItemStack puncture = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lPuncture &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to deal more damage to", "&7your opponents armor.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook3Glowing);
	ItemStack overdose = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lOverdose &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to deal extra damage.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook3Glowing);
	ItemStack muffle = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lMuffle &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to stop your opponents", "&7enchants from activating for", "&7a limited time.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook3Glowing);
	ItemStack pyro = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lPyro &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to deal more damage while", "&7your opponent is on fire.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook3Glowing);
	ItemStack snare = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lSnare &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance give your enemy the slowness", "&7effect.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook3Glowing);
	ItemStack blessed = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lBlessed &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to remove all negative", "&7potion effects.", " ", "&f&lEnchant Type:", "&7Axe"}, Config.enchantsBook3Glowing);
	ItemStack trophy = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lTrophy &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance for your opponents head", "&7to drop when they die.", " ", "&f&lEnchant Type:", "&7Sword, Axe"}, Config.enchantsBook3Glowing);
	ItemStack archer = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.tier3BookColor + "&lArcher &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance for arrows to deal", "&7double damage.", " ", "&f&lEnchant Type:", "&7Bow"}, Config.enchantsBook3Glowing);
	
	//LEGENDARY
	ItemStack juggernaut = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lJuggernaut &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Gives permanent strength, slowness",  "&7and mining fatigue.", " ", "&f&lEnchant Type:", "&7Helmet"}, Config.enchantsBook4Glowing);
	ItemStack eyepatch = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lEyepatch &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to negate the blindness", "&7effect.", " ", "&f&lEnchant Type:", "&7Helmet"}, Config.enchantsBook4Glowing);
	ItemStack meteor = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lMeteor &8[&7I-X&8]", new String[] {"&f&lDescription:", "&7Chance to launch op fireballs",  "&7at your opponent.", " ", "&f&lEnchant Type:", "&7Chestplate"}, Config.enchantsBook4Glowing);
	ItemStack hyper = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lHyper &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Gives permanent speed according to", "&7the level of enchant.", " ", "&f&lEnchant Type:", "&7Boots"}, Config.enchantsBook4Glowing);
	ItemStack jetpack = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lJetpack &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to shoot into the sky to", "&7escape death on low hp.", " ", "&f&lEnchant Type:", "&7Boots"}, Config.enchantsBook4Glowing);
	ItemStack lifeline = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lLifeline &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to heal while taking", "&7damage.", " ", "&f&lEnchant Type:", "&7Armor"}, Config.enchantsBook4Glowing);
	ItemStack bloodthirsty = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lBloodthirsty &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance deal extra damage to", "&7your enemy.", " ", "&f&lEnchant Type:", "&7Armor"}, Config.enchantsBook4Glowing);
	ItemStack reinforced = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lReinforced &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance for your armor to", "&7take less durability damage.", " ", "&f&lEnchant Type:", "&7Armor"}, Config.enchantsBook4Glowing);
	ItemStack adrenaline = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lAdrenaline &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to cancel an attack and", "&7gain 1-3 hp instead.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook4Glowing);
	ItemStack lifesteal = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lLifesteal &8[&7I-V&8]", new String[] {"&f&lDescription:", "&7Chance to steal health from",  "&7your opponent.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook4Glowing);
	ItemStack greed = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lGreed &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to get more xp from",  "&7killing mobs.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook4Glowing);
	ItemStack immolation = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lImmolation &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to deal insane damage and", "&7light all nearby opponents on fire.", " ", "&f&lEnchant Type:", "&7Sword"}, Config.enchantsBook4Glowing);
	ItemStack aura = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lAura &8[&7I-V&8]", new String[] {"&f&lDescription:", "&7Chance to damage nearby opponents.", " ", "&f&lEnchant Type:", "&7Axe"}, Config.enchantsBook4Glowing);
	ItemStack barbarian = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lBarbarian &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance deal more damage when your", "&7opponent is holding an axe.", " ", "&f&lEnchant Type:", "&7Axe"}, Config.enchantsBook4Glowing);
	ItemStack enrage = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lEnrage &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance deal more damage when you", "&7have low hp.", " ", "&f&lEnchant Type:", "&7Axe"}, Config.enchantsBook4Glowing);
	ItemStack rage = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.tier4BookColor + "&lRage &8[&7I-VI&8]", new String[] {"&f&lDescription:", "&7Chance to multiply damage by 1.1x",  "&7for every combo you land.", " ", "&f&lEnchant Type:", "&7Sword, Axe, Bow"}, Config.enchantsBook4Glowing);
	
	//ANCIENT
	ItemStack butcher = API.itemBuilder(Config.enchantsBook5Material, Config.enchantsBook5Data, 1, Config.tier5BookColor + "&lButcher &8[&7I-IV&8]", new String[] {"&f&lDescription:", "&7Chance to temorarily disable hit", "&7delay, adds 1.5 seconds per level.", " ", "&f&lEnchant Type:", "&7Axe"}, Config.enchantsBook5Glowing);
	ItemStack anvil = API.itemBuilder(Config.enchantsBook5Material, Config.enchantsBook5Data, 1, Config.tier5BookColor + "&lAnvil &8[&7I-III&8]", new String[] {"&f&lDescription:", "&7Chance to slightly repair your armor.", " ", "&f&lEnchant Type:", "&7Armor"}, Config.enchantsBook5Glowing);
	
	
	@EventHandler
	public void onEnchantsClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(p.getOpenInventory().getTitle().equals(API.color(Config.enchantsTitle))){
			if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(!e.getCurrentItem().hasItemMeta()){
				e.setCancelled(true); 
				return;
			}
			ItemStack spacer = API.itemBuilder(Material.STAINED_GLASS_PANE, (short) 0, " ", null, false);
			ItemStack cespacer = API.itemBuilder(Material.INK_SACK, (short) 8, "&8&l???", null, false);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color(Config.enchantsBook1Name))){
				Inventory basicInv = Bukkit.createInventory(null, 27, API.color(Config.enchants1Title));
				for(int i = 0; i < 27; i++){
					basicInv.setItem(i, spacer);
					
					basicInv.setItem(0, glowing);
					basicInv.setItem(1, diver);
					basicInv.setItem(2, pineapple);
					basicInv.setItem(3, bulletproof);
					basicInv.setItem(4, agility);
					basicInv.setItem(5, wither);
					basicInv.setItem(6, saturated);
					basicInv.setItem(7, frozen);
					basicInv.setItem(8, voltage);
					basicInv.setItem(9, venom);
					basicInv.setItem(10, blackout);
					basicInv.setItem(11, ravenous);
					basicInv.setItem(12, flashback);
					basicInv.setItem(13, haste);
					basicInv.setItem(14, explosive);
					basicInv.setItem(15, ghast);
					basicInv.setItem(16, furnace);
					basicInv.setItem(17, scavenger);
					
					basicInv.setItem(22, back);
				}
				p.openInventory(basicInv);
				e.setCancelled(true);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color(Config.enchantsBook2Name))){
				Inventory advancedInv = Bukkit.createInventory(null, 36, API.color(Config.enchants2Title));
				for(int i = 0; i < 36; i++){
					advancedInv.setItem(i, spacer);
					
					advancedInv.setItem(0, wormhole);
					advancedInv.setItem(1, shield);
					advancedInv.setItem(2, selfdestruct);
					advancedInv.setItem(3, creeper);
					advancedInv.setItem(4, safeguard);
					advancedInv.setItem(5, replenish);
					advancedInv.setItem(6, radioactive);
					advancedInv.setItem(7, counter);
					advancedInv.setItem(8, springs);
					advancedInv.setItem(9, ninja);
					advancedInv.setItem(10, marshmallow);
					advancedInv.setItem(11, blaze);
					advancedInv.setItem(12, thief);
					advancedInv.setItem(13, fracture);
					advancedInv.setItem(14, confusion);
					advancedInv.setItem(15, virus);
					advancedInv.setItem(16, wound);
					advancedInv.setItem(17, push);
					advancedInv.setItem(18, shock);
					advancedInv.setItem(19, obsidiandestroyer);
					advancedInv.setItem(20, miner);
					advancedInv.setItem(21, cespacer);
					advancedInv.setItem(22, cespacer);
					advancedInv.setItem(23, cespacer);
					advancedInv.setItem(24, cespacer);
					advancedInv.setItem(25, cespacer);
					advancedInv.setItem(26, cespacer);
					
					advancedInv.setItem(31, back);
				}
				p.openInventory(advancedInv);
				e.setCancelled(true);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color(Config.enchantsBook3Name))){
				Inventory epicInv = Bukkit.createInventory(null, 27, API.color(Config.enchants3Title));
				for(int i = 0; i < 27; i++){
					epicInv.setItem(i, spacer);
					
					epicInv.setItem(0, angel);
					epicInv.setItem(1, flashbang);
					epicInv.setItem(2, spectral);
					epicInv.setItem(3, overload);
					epicInv.setItem(4, chicken);
					epicInv.setItem(5, brute);
					epicInv.setItem(6, vest);
					epicInv.setItem(7, lucky);
					epicInv.setItem(8, puncture);
					epicInv.setItem(9, overdose);
					epicInv.setItem(10, muffle);
					epicInv.setItem(11, pyro);
					epicInv.setItem(12, snare);
					epicInv.setItem(13, blessed);
					epicInv.setItem(14, trophy);
					epicInv.setItem(15, archer);
					epicInv.setItem(16, cespacer);
					epicInv.setItem(17, cespacer);
					
					epicInv.setItem(22, back);
				}
				p.openInventory(epicInv);
				e.setCancelled(true);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color(Config.enchantsBook4Name))){
				Inventory legendaryInv = Bukkit.createInventory(null, 27, API.color(Config.enchants4Title));
				for(int i = 0; i < 27; i++){
					legendaryInv.setItem(i, spacer);
					
					legendaryInv.setItem(0, juggernaut);
					legendaryInv.setItem(1, eyepatch);
					legendaryInv.setItem(2, meteor);
					legendaryInv.setItem(3, hyper);
					legendaryInv.setItem(4, jetpack);
					legendaryInv.setItem(5, lifeline);
					legendaryInv.setItem(6, bloodthirsty);
					legendaryInv.setItem(7, reinforced);
					legendaryInv.setItem(8, adrenaline);
					legendaryInv.setItem(9, lifeline);
					legendaryInv.setItem(10, greed);
					legendaryInv.setItem(11, immolation);
					legendaryInv.setItem(12, aura);
					legendaryInv.setItem(13, barbarian);
					legendaryInv.setItem(14, enrage);
					legendaryInv.setItem(15, rage);
					legendaryInv.setItem(16, cespacer);
					legendaryInv.setItem(17, cespacer);
								
					legendaryInv.setItem(22, back);
				}
				p.openInventory(legendaryInv);
				e.setCancelled(true);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color(Config.enchantsBook5Name))){
				Inventory ancientInv = Bukkit.createInventory(null, 18, API.color(Config.enchants5Title));
				for(int i = 0; i < 18; i++){
					ancientInv.setItem(i, spacer);
					
					ancientInv.setItem(0, butcher);
					ancientInv.setItem(1, anvil);
					ancientInv.setItem(2, cespacer);
					ancientInv.setItem(3, cespacer);
					ancientInv.setItem(4, cespacer);
					ancientInv.setItem(5, cespacer);
					ancientInv.setItem(6, cespacer);
					ancientInv.setItem(7, cespacer);
					ancientInv.setItem(8, cespacer);
					
					
					ancientInv.setItem(13, back);
				}
				p.openInventory(ancientInv);
				e.setCancelled(true);
				return;
			}
			e.setCancelled(true);
			return;
		}
		if(p.getOpenInventory().getTitle().equals(API.color(Config.enchants1Title))){
			if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(!e.getCurrentItem().hasItemMeta()){
				e.setCancelled(true); 
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color("&7» &c&lBack &7«"))){
				EnchantsCommand.openEnchantsInv(p);
			}
			e.setCancelled(true);
		}
		if(p.getOpenInventory().getTitle().equals(API.color(Config.enchants2Title))){
			if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(!e.getCurrentItem().hasItemMeta()){
				e.setCancelled(true); 
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color("&7» &c&lBack &7«"))){
				EnchantsCommand.openEnchantsInv(p);
			}
			e.setCancelled(true);
		}
		if(p.getOpenInventory().getTitle().equals(API.color(Config.enchants3Title))){
			if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(!e.getCurrentItem().hasItemMeta()){
				e.setCancelled(true); 
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color("&7» &c&lBack &7«"))){
				EnchantsCommand.openEnchantsInv(p);
			}
			e.setCancelled(true);
		}
		if(p.getOpenInventory().getTitle().equals(API.color(Config.enchants4Title))){
			if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(!e.getCurrentItem().hasItemMeta()){
				e.setCancelled(true); 
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color("&7» &c&lBack &7«"))){
				EnchantsCommand.openEnchantsInv(p);
			}
			e.setCancelled(true);
		}
		if(p.getOpenInventory().getTitle().equals(API.color(Config.enchants5Title))){
			if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(!e.getCurrentItem().hasItemMeta()){
				e.setCancelled(true); 
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color("&7» &c&lBack &7«"))){
				EnchantsCommand.openEnchantsInv(p);
			}
			e.setCancelled(true);
		}

	}

	@EventHandler
	public void onEnchantAdminClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(p.getOpenInventory().getTitle().equals(API.color(Config.enchantAdminTitle))){
			if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(!e.getCurrentItem().hasItemMeta()){
			}
			if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()){
                if(API.removeColor(e.getCurrentItem().getItemMeta().getDisplayName()).contains("ALL TIER 1 ENCHANTMENTS")){
                    API.giveEnchant(p, API.enchants.get("glowingI"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("diverI"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("pineappleII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("bulletproofIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("agilityIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("witherIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("saturatedIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("frozenIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("voltageIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("venomIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("blackoutIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("ravenousV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("flashbackVIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("hasteIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("explosiveIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("ghastIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("furnaceIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("scavengerIII"), 100, 0);
                    e.setCancelled(true);
                    return;
                }
                if(API.removeColor(e.getCurrentItem().getItemMeta().getDisplayName()).contains("ALL TIER 2 ENCHANTMENTS")){
                    API.giveEnchant(p, API.enchants.get("wormholeIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("shieldIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("selfdestructIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("creeperIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("safeguardX"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("replenishII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("radioactiveIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("counterIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("springsIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("ninjaI"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("marshmallowV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("blazeI"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("thiefIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("fractureIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("confusionV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("virusIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("woundIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("pushII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("shockV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("obsidiandestroyerV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("minerV"), 100, 0);
                    e.setCancelled(true);
                    return;
                }
                if(API.removeColor(e.getCurrentItem().getItemMeta().getDisplayName()).contains("ALL TIER 3 ENCHANTMENTS")){
                    API.giveEnchant(p, API.enchants.get("angelIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("flashbangVIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("spectralIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("overloadIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("chickenIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("bruteIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("vestIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("luckyX"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("punctureIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("overdoseIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("muffleIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("pyroIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("snareIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("blessedIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("trophyIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("archerIII"), 100, 0);
                    e.setCancelled(true);
                    return;
                }
                if(API.removeColor(e.getCurrentItem().getItemMeta().getDisplayName()).contains("ALL TIER 4 ENCHANTMENTS")){
                    API.giveEnchant(p, API.enchants.get("juggernautIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("eyepatchIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("meteorX"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("hyperIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("jetpackIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("lifelineIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("bloodthirstyIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("reinforcedIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("adrenalineIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("greedIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("immolationIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("auraV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("barbarianIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("enrageIII"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("rageVI"), 100, 0);
                    e.setCancelled(true);
                    return;
                }
                if(API.removeColor(e.getCurrentItem().getItemMeta().getDisplayName()).contains("ALL TIER 5 ENCHANTMENTS")){
                    API.giveEnchant(p, API.enchants.get("butcherIV"), 100, 0);
                    API.giveEnchant(p, API.enchants.get("anvilIII"), 100, 0);
                    e.setCancelled(true);
                    return;
                }
            }
            if(e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
                e.setCancelled(true);
                return;
            }
			p.getInventory().addItem(e.getCurrentItem());
			e.setCancelled(true);
		}
	}

}
