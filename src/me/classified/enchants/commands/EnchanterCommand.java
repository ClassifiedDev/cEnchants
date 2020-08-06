package me.classified.enchants.commands;

import me.classified.enchants.cEnchants;
import me.classified.enchants.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.classified.enchants.utils.API;

public class EnchanterCommand implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("(!) You must be a player to use this command.");
			return false;
		}
		Player p = (Player)sender;
		ItemStack spacer = API.itemBuilder(Config.enchanterSpacerMaterial, Config.enchanterSpacerData, 1, Config.enchanterSpacerName, new String[]{"&9Your EXP: &7" + p.getTotalExperience()}, Config.enchanterSpacerGlowing);
		ItemStack tier1Book = API.itemBuilder(Config.enchanterBook1Material, Config.enchanterBook1Data, 1, Config.enchanterBook1Name, Config.enchanterBook1Lore, Config.enchanterBook1Glowing);
		ItemStack tier2Book = API.itemBuilder(Config.enchanterBook2Material, Config.enchanterBook2Data, 1, Config.enchanterBook2Name, Config.enchanterBook2Lore, Config.enchanterBook2Glowing);
		ItemStack tier3Book = API.itemBuilder(Config.enchanterBook3Material, Config.enchanterBook3Data, 1, Config.enchanterBook3Name, Config.enchanterBook3Lore, Config.enchanterBook3Glowing);
		ItemStack tier4Book = API.itemBuilder(Config.enchanterBook4Material, Config.enchanterBook4Data, 1, Config.enchanterBook4Name, Config.enchanterBook4Lore, Config.enchanterBook4Glowing);

		String enchanterName = API.color(Config.enchanterTitle);
		int enchanterSize = Config.enchanterSize;
		Inventory enchanter = Bukkit.getServer().createInventory(null, enchanterSize, enchanterName);
		for(int i = 0; i < enchanterSize; i++){
			enchanter.setItem(i, spacer);
		}		
		enchanter.setItem(Config.enchanterBook1InvSlot, tier1Book);
		enchanter.setItem(Config.enchanterBook2InvSlot, tier2Book);
		enchanter.setItem(Config.enchanterBook3InvSlot, tier3Book);
		enchanter.setItem(Config.enchanterBook4InvSlot, tier4Book);
		p.openInventory(enchanter);
		return false;
	}

}
