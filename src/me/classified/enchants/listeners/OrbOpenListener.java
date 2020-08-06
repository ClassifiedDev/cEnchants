package me.classified.enchants.listeners;

import me.classified.enchants.cEnchants;
import me.classified.enchants.utils.Config;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.classified.enchants.utils.API;

public class OrbOpenListener implements Listener{

	@EventHandler
	public void onOrbOpen(PlayerInteractEvent e){	
		Player p = e.getPlayer();
		ItemStack hand = p.getItemInHand();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) && hand.hasItemMeta() && hand.getType().equals(Config.enchantmentBook1Material) && hand.getItemMeta().getDisplayName().equals(API.color(Config.tier1BookName)) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && hand.hasItemMeta() && hand.getType().equals(Config.enchantmentBook1Material) && hand.getItemMeta().getDisplayName().equals(API.color(Config.tier1BookName))){
			if(hand.getAmount() > 1){
				if(p.getInventory().firstEmpty() > -1){
					hand.setAmount(hand.getAmount() - 1);
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 2);
					API.giveEnchantViaBook(p, API.basic_enchants.get( API.randomInt(1, API.basicEnchantCount)), API.randomInt(1, 100), API.randomInt(1, 100));
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			else if(hand.getAmount() == 1){
				if(p.getInventory().firstEmpty() > -1){
					p.setItemInHand(new ItemStack(Material.AIR, 1));
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 2);
					API.giveEnchantViaBook(p, API.basic_enchants.get( API.randomInt(1, API.basicEnchantCount)), API.randomInt(1, 100), API.randomInt(1, 100));
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			return;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) && hand.hasItemMeta() && hand.getType().equals(Config.enchantmentBook2Material) && hand.getItemMeta().getDisplayName().equals(API.color(Config.tier2BookName)) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && hand.hasItemMeta() && hand.getType().equals(Config.enchantmentBook2Material) && hand.getItemMeta().getDisplayName().equals(API.color(Config.tier2BookName))){
			if(hand.getAmount() > 1){
				if(p.getInventory().firstEmpty() > -1){
					hand.setAmount(hand.getAmount() - 1);
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 2);
					API.giveEnchantViaBook(p, API.advanced_enchants.get( API.randomInt(1, API.advancedEnchantCount)), API.randomInt(1, 100), API.randomInt(1, 100));
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			else if(hand.getAmount() == 1){
				if(p.getInventory().firstEmpty() > -1){
					p.setItemInHand(new ItemStack(Material.AIR, 1));
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 2);
					API.giveEnchantViaBook(p, API.advanced_enchants.get( API.randomInt(1, API.advancedEnchantCount)), API.randomInt(1, 100), API.randomInt(1, 100));
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			return;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) && hand.hasItemMeta() && hand.getType().equals(Config.enchantmentBook3Material) && hand.getItemMeta().getDisplayName().equals(API.color(Config.tier3BookName)) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && hand.hasItemMeta() && hand.getType().equals(Config.enchantmentBook3Material) && hand.getItemMeta().getDisplayName().equals(API.color(Config.tier3BookName))){
			if(hand.getAmount() > 1){
				if(p.getInventory().firstEmpty() > -1){
					hand.setAmount(hand.getAmount() - 1);
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 2);
					API.giveEnchantViaBook(p, API.epic_enchants.get( API.randomInt(1, API.epicEnchantCount)), API.randomInt(1, 100), API.randomInt(1, 100));

				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			else if(hand.getAmount() == 1){
				if(p.getInventory().firstEmpty() > -1){
					p.setItemInHand(new ItemStack(Material.AIR, 1));
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 2);
					API.giveEnchantViaBook(p, API.epic_enchants.get( API.randomInt(1, API.epicEnchantCount)), API.randomInt(1, 100), API.randomInt(1, 100));
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			return;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) && hand.hasItemMeta() && hand.getType().equals(Config.enchantmentBook4Material) && hand.getItemMeta().getDisplayName().equals(API.color(Config.tier4BookName)) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && hand.hasItemMeta() && hand.getType().equals(Config.enchantmentBook4Material) && hand.getItemMeta().getDisplayName().equals(API.color(Config.tier4BookName))){
			if(hand.getAmount() > 1){
				if(p.getInventory().firstEmpty() > -1){
					hand.setAmount(hand.getAmount() - 1);
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 2);
					API.giveEnchantViaBook(p, API.legendary_enchants.get( API.randomInt(1, API.legendaryEnchantCount)), API.randomInt(1, 100), API.randomInt(1, 100));
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			else if(hand.getAmount() == 1){
				if(p.getInventory().firstEmpty() > -1){
					p.setItemInHand(new ItemStack(Material.AIR, 1));
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 2);
					API.giveEnchantViaBook(p, API.legendary_enchants.get( API.randomInt(1, API.legendaryEnchantCount)), API.randomInt(1, 100), API.randomInt(1, 100));
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			return;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) && hand.hasItemMeta() && hand.getType().equals(Config.enchantmentBook5Material) && hand.getItemMeta().getDisplayName().equals(API.color(Config.tier5BookName)) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && hand.hasItemMeta() && hand.getType().equals(Config.enchantmentBook5Material) && hand.getItemMeta().getDisplayName().equals(API.color(Config.tier5BookName))){
			if(hand.getAmount() > 1){
				if(p.getInventory().firstEmpty() > -1){
					hand.setAmount(hand.getAmount() - 1);
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 2);
					API.giveEnchantViaBook(p, API.ancient_enchants.get( API.randomInt(1, API.ancientEnchantCount)), API.randomInt(1, 100), API.randomInt(1, 100));
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			else if(hand.getAmount() == 1){
				if(p.getInventory().firstEmpty() > -1){
					p.setItemInHand(new ItemStack(Material.AIR, 1));
					p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 2);
					API.giveEnchantViaBook(p, API.ancient_enchants.get( API.randomInt(1, API.ancientEnchantCount)), API.randomInt(1, 100), API.randomInt(1, 100));
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			return;
		}
	}
}
