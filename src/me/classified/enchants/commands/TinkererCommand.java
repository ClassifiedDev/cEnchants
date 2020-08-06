package me.classified.enchants.commands;

import me.classified.enchants.cEnchants;
import me.classified.enchants.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.classified.enchants.utils.API;

public class TinkererCommand implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)){
			sender.sendMessage("(!) You must be a player to use this command.");
			return false;
		}
		
		Player p = (Player)sender;
		
			if(!p.hasPermission("enchants.tinkerer")){
				p.sendMessage(API.color("&c&l(!) &cYou do not have permission to use this command."));
				return false;
			}
			
			String tinkererName = API.color(Config.tinkererTitle);
			Inventory tinkerer = Bukkit.createInventory(p, 54, tinkererName);
			
			ItemStack spacer = API.itemBuilder(Material.STAINED_GLASS_PANE, (short) 0, " ", null, false);
			ItemStack acceptButton = API.itemBuilder(Material.STAINED_GLASS_PANE, (short) 14, "&cClick to ACCEPT Trade", null, false);
	
			tinkerer.setItem(0, acceptButton);
			tinkerer.setItem(8, acceptButton);
			tinkerer.setItem(4, spacer);
			tinkerer.setItem(13, spacer);
			tinkerer.setItem(22, spacer);
			tinkerer.setItem(31, spacer);
			tinkerer.setItem(40, spacer);
			tinkerer.setItem(49, spacer);
			p.playSound(p.getLocation(), Sound.WOOD_CLICK, 1, 1);
			p.openInventory(tinkerer);	
		return false;
	}

}
