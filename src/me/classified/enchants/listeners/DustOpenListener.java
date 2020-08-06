package me.classified.enchants.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.classified.enchants.utils.API;
import me.classified.enchants.utils.CustomItems;

public class DustOpenListener implements Listener{

	@EventHandler
	public void onDustOpen(PlayerInteractEvent e){
		Player p = e.getPlayer();
		ItemStack hand = p.getItemInHand();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) && hand.hasItemMeta() && hand.getType().equals(Material.FIREBALL) && hand.getItemMeta().getDisplayName().equals(API.color("&aCommon Dust Pouch &7(Right-Click)")) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && hand.hasItemMeta() && hand.getType().equals(Material.FIREBALL) && hand.getItemMeta().getDisplayName().equals(API.color("&aCommon Dust Pouch &7(Right-Click)"))){
			if(hand.getAmount() > 1){
				if(p.getInventory().firstEmpty() > -1){
					hand.setAmount(hand.getAmount() - 1);
					if(API.randomInt(1, 100) <= 15){
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 2);
						p.getInventory().addItem(CustomItems.dust("basic", API.randomInt(1, 10)));
						return;
					}
					p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 2);
					p.getInventory().addItem(CustomItems.uselessPowder);
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
					if(API.randomInt(1, 100) <= 15){
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 2);
						p.getInventory().addItem(CustomItems.dust("basic", API.randomInt(1, 10)));
						return;
					}
					p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 2);
					p.getInventory().addItem(CustomItems.uselessPowder);
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			return;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) && hand.hasItemMeta() && hand.getType().equals(Material.FIREBALL) && hand.getItemMeta().getDisplayName().equals(API.color("&3Uncommon Dust Pouch &7(Right-Click)")) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && hand.hasItemMeta() && hand.getType().equals(Material.FIREBALL) && hand.getItemMeta().getDisplayName().equals(API.color("&3Uncommon Dust Pouch &7(Right-Click)"))){
			if(hand.getAmount() > 1){
				if(p.getInventory().firstEmpty() > -1){
					hand.setAmount(hand.getAmount() - 1);
					if(API.randomInt(1, 100) <= 15){
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 2);
						p.getInventory().addItem(CustomItems.dust("advanced", API.randomInt(1, 10)));
						return;
					}
					p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 2);
					p.getInventory().addItem(CustomItems.uselessPowder);
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
					if(API.randomInt(1, 100) <= 15){
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 2);
						p.getInventory().addItem(CustomItems.dust("advanced", API.randomInt(1, 10)));
						return;
					}
					p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 2);
					p.getInventory().addItem(CustomItems.uselessPowder);
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			return;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) && hand.hasItemMeta() && hand.getType().equals(Material.FIREBALL) && hand.getItemMeta().getDisplayName().equals(API.color("&eRare Dust Pouch &7(Right-Click)")) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && hand.hasItemMeta() && hand.getType().equals(Material.FIREBALL) && hand.getItemMeta().getDisplayName().equals(API.color("&eRare Dust Pouch &7(Right-Click)"))){
			if(hand.getAmount() > 1){
				if(p.getInventory().firstEmpty() > -1){
					hand.setAmount(hand.getAmount() - 1);
					if(API.randomInt(1, 100) <= 15){
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 2);
						p.getInventory().addItem(CustomItems.dust("epic", API.randomInt(1, 10)));
						return;
					}
					p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 2);
					p.getInventory().addItem(CustomItems.uselessPowder);
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
					if(API.randomInt(1, 100) <= 15){
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 2);
						p.getInventory().addItem(CustomItems.dust("epic", API.randomInt(1, 10)));
						return;
					}
					p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 2);
					p.getInventory().addItem(CustomItems.uselessPowder);
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			return;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) && hand.hasItemMeta() && hand.getType().equals(Material.FIREBALL) && hand.getItemMeta().getDisplayName().equals(API.color("&cLegendary Dust Pouch &7(Right-Click)")) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && hand.hasItemMeta() && hand.getType().equals(Material.FIREBALL) && hand.getItemMeta().getDisplayName().equals(API.color("&cLegendary Dust Pouch &(Right-Click)"))){
			if(hand.getAmount() > 1){
				if(p.getInventory().firstEmpty() > -1){
					hand.setAmount(hand.getAmount() - 1);
					if(API.randomInt(1, 100) <= 15){
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 2);
						p.getInventory().addItem(CustomItems.dust("legendary", API.randomInt(1, 10)));
						return;
					}
					p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 2);
					p.getInventory().addItem(CustomItems.uselessPowder);
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
					if(API.randomInt(1, 100) <= 15){
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 2);
						p.getInventory().addItem(CustomItems.dust("legendary", API.randomInt(1, 10)));
						return;
					}
					p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 2);
					p.getInventory().addItem(CustomItems.uselessPowder);
				}
				else{
					p.sendMessage(API.color("&c&l(!) &cYour inventory is full!"));
					return;
				}
				return;
			}
			return;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) && hand.hasItemMeta() && hand.getType().equals(Material.FIREBALL) && hand.getItemMeta().getDisplayName().equals(API.color("&dUltimate Dust Pouch &7(Right-Click)")) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && hand.hasItemMeta() && hand.getType().equals(Material.FIREBALL) && hand.getItemMeta().getDisplayName().equals(API.color("&dUltimate Dust Pouch &7(Right-Click)"))){
			if(hand.getAmount() > 1){
				if(p.getInventory().firstEmpty() > -1){
					hand.setAmount(hand.getAmount() - 1);
					if(API.randomInt(1, 100) <= 15){
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 2);
						p.getInventory().addItem(CustomItems.dust("ancient", API.randomInt(1, 10)));
						return;
					}
					p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 2);
					p.getInventory().addItem(CustomItems.uselessPowder);
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
					if(API.randomInt(1, 100) <= 15){
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 2);
						p.getInventory().addItem(CustomItems.dust("ancient", API.randomInt(1, 10)));
						return;
					}
					p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 2);
					p.getInventory().addItem(CustomItems.uselessPowder);
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
