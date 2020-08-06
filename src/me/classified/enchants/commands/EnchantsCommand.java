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

public class EnchantsCommand implements CommandExecutor{

	public static void openEnchantsInv(Player p) {
		p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 2);
		Inventory inv = Bukkit.createInventory(null, Config.enchantsSize, API.color(Config.enchantsTitle));
		ItemStack spacer = API.itemBuilder(Material.STAINED_GLASS_PANE, (short) 0, " ", null, false);
		for(int i = 0; i < Config.enchantsSize; i++){
			inv.setItem(i, spacer);
		}
		ItemStack tier1 = API.itemBuilder(Config.enchantsBook1Material, Config.enchantsBook1Data, 1, Config.enchantsBook1Name, Config.enchantsBook1Lore, Config.enchantsBook1Glowing);
		ItemStack tier2 = API.itemBuilder(Config.enchantsBook2Material, Config.enchantsBook2Data, 1, Config.enchantsBook2Name, Config.enchantsBook2Lore, Config.enchantsBook2Glowing);
		ItemStack tier3 = API.itemBuilder(Config.enchantsBook3Material, Config.enchantsBook3Data, 1, Config.enchantsBook3Name, Config.enchantsBook3Lore, Config.enchantsBook3Glowing);
		ItemStack tier4 = API.itemBuilder(Config.enchantsBook4Material, Config.enchantsBook4Data, 1, Config.enchantsBook4Name, Config.enchantsBook4Lore, Config.enchantsBook4Glowing);
		ItemStack tier5 = API.itemBuilder(Config.enchantsBook5Material, Config.enchantsBook5Data, 1, Config.enchantsBook5Name, Config.enchantsBook5Lore, Config.enchantsBook5Glowing);
		inv.setItem(Config.enchantsBook1InvSlot, tier1);
		inv.setItem(Config.enchantsBook2InvSlot, tier2);
		inv.setItem(Config.enchantsBook3InvSlot, tier3);
		inv.setItem(Config.enchantsBook4InvSlot, tier4);
		inv.setItem(Config.enchantsBook5InvSlot, tier5);
		p.openInventory(inv);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage(API.color("&c&(!) &cYou must be a player to use this command."));
			return false;
		}
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("enchants")){
			openEnchantsInv(p);
		}
		return false;
	}



}
