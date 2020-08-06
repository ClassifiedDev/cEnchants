package me.classified.enchants.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import me.classified.enchants.utils.Config;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.classified.enchants.utils.API;
import me.classified.enchants.utils.CustomItems;

public class RenameScrollListener implements Listener{

	ArrayList<UUID> step1 = new ArrayList<UUID>();
	HashMap<UUID, String> step2 = new HashMap<UUID, String> ();

	@EventHandler
	public void onRenameScroll(PlayerInteractEvent e){
		Player p = e.getPlayer();
		ItemStack hand = p.getItemInHand();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && hand.hasItemMeta() && hand.getType().equals(Config.renameScrollMaterial) && hand.getItemMeta().getDisplayName().equals(API.color(Config.renameScrollName)) ||
				e.getAction().equals(Action.RIGHT_CLICK_AIR) && hand.hasItemMeta() && hand.getType().equals(Config.renameScrollMaterial) && hand.getItemMeta().getDisplayName().equals(API.color(Config.renameScrollName))){
			if(hand.getAmount() > 1){
				hand.setAmount(hand.getAmount() - 1);
			}
			else{
				p.setItemInHand(new ItemStack(Material.AIR, 1));
			}
			p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 1);
			step1.add(p.getUniqueId());
			p.sendMessage(API.color(""));
			p.sendMessage(API.color("          &f&l**  &e&lRename Scroll Usage &f&l**"));
			p.sendMessage(API.color("   &e&l* &7(1) &eHold the item you want to rename."));
			p.sendMessage(API.color("   &e&l* &7(2) &eType the name with color codes in chat."));
			p.sendMessage(API.color("   &e&l* &7(3) &aconfirm &eor &ccancel &ethe new name. "));
			p.sendMessage(API.color(""));
			return;
		}

	}

	@EventHandler
	public void onRenameScrollChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		ItemStack hand = p.getItemInHand();
		String name = e.getMessage();
		if(step1.contains(p.getUniqueId())){
			e.setCancelled(true);
			if(name.equalsIgnoreCase("cancel")) {
				step1.remove(p.getUniqueId());
				p.getInventory().addItem(CustomItems.renameScroll);
				p.sendMessage(API.color("&c&l(!) &cCanceled item rename. Your rename scroll has been placed in your inventory."));
				return;
			}
			if(hand.getType().toString().contains("HELMET") || 
					hand.getType().toString().contains("CHESTPLATE") || 
					hand.getType().toString().contains("LEGGINGS") || 
					hand.getType().toString().contains("BOOTS") ||
					hand.getType().toString().contains("SWORD")||
					hand.getType().toString().contains("AXE")||
					hand.getType().toString().contains("PICKAXE")||
					hand.getType().toString().contains("SHOVEL")||
					hand.getType().toString().contains("BOW")||
					hand.getType().toString().contains("HOE")){
				if(name.length() > 64) {
					p.sendMessage(API.color("&c&l(!) &cYour custom name can not be longer than 64 characters."));
					return;
				}
				if(name.contains("�k")) {
					p.sendMessage(API.color("&c&l(!) &cYour custom name can not contain the") + " &k " + API.color("&ccolor code."));
					return;
				}
				if(name.contains("[") || name.contains("]") || name.contains("{") || name.contains("}") || name.contains("�") || name.contains("�")) {
					p.sendMessage(API.color("&c&l(!) &cYour custom name can not contain the following symbols: [, ], {, }, �, �"));
					return;
				}
				
				p.sendMessage("");
				p.sendMessage(API.color("&a&l(!) &7Item name preview:&r " + name));
				p.sendMessage(API.color("&a&l(!) &7Please type '&aconfirm&7' to rename item or '&ccancel&7' to start over."));
				p.sendMessage("");
				step1.remove(p.getUniqueId());
				step2.put(p.getUniqueId(), name);
				return;
			}
			else{
				p.sendMessage(API.color("&c&l(!) &cThis item can not be renamed!"));
				return;
			}
		}
		
		if(step2.containsKey(p.getUniqueId())){
			e.setCancelled(true);
			if(hand.getType().toString().contains("HELMET") || 
					hand.getType().toString().contains("CHESTPLATE") || 
					hand.getType().toString().contains("LEGGINGS") || 
					hand.getType().toString().contains("BOOTS") ||
					hand.getType().toString().contains("SWORD")||
					hand.getType().toString().contains("AXE")||
					hand.getType().toString().contains("PICKAXE")||
					hand.getType().toString().contains("SHOVEL")||
					hand.getType().toString().contains("BOW")||
					hand.getType().toString().contains("HOE")){
				if(e.getMessage().equalsIgnoreCase("cancel")){
					step2.remove(p.getUniqueId());
					p.getInventory().addItem(CustomItems.renameScroll);
					p.sendMessage(API.color("&c&l(!) &cCanceled item rename. Your rename scroll has been placed in your inventory."));
					return;
				}
				else if(e.getMessage().equalsIgnoreCase("confirm")){
					p.sendMessage("");
					p.sendMessage(API.color("&a&l(!) &aYour item has been successfully renamed to:&r " + step2.get(p.getUniqueId())));
					p.sendMessage("");
					ItemMeta im = hand.getItemMeta();
					im.setDisplayName(API.color(step2.get(p.getUniqueId())));
					hand.setItemMeta(im);
					p.updateInventory();
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					step2.remove(p.getUniqueId());	
				}
				else{
					p.sendMessage("");
					p.sendMessage(API.color("&a&l(!) &7Please type '&aconfirm&7' to rename item or '&ccancel&7' to start over."));
					p.sendMessage("");
					return;
				}
				return;
			}
			else{
				p.sendMessage(API.color("&c&l(!) &cThis item can not be renamed!"));
				return;
			}
		}
	}

}
