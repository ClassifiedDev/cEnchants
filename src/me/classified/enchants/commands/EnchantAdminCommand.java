package me.classified.enchants.commands;

import me.classified.enchants.enchants.Books;
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
import me.classified.enchants.utils.CustomItems;

public class EnchantAdminCommand implements CommandExecutor{


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(!(sender instanceof Player)){
			return false;
		}
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("enchantadmin")){
			if(p.isOp()){
				Inventory inv = Bukkit.createInventory(null, 36, API.color(Config.enchantAdminTitle));
				ItemStack spacer = API.itemBuilder(Material.STAINED_GLASS_PANE, (short) 0, 1, " ", new String[]{""}, false);
				for(int i = 0; i < 36; i++){
					inv.setItem(i, spacer);
				}
				inv.setItem(0, CustomItems.basicOrb);
                inv.setItem(1, CustomItems.advancedOrb);
				inv.setItem(2, CustomItems.epicOrb);
				inv.setItem(3, CustomItems.legendaryOrb);
				inv.setItem(4, CustomItems.ancientOrb);
				inv.setItem(5, CustomItems.protectionOrb);
				inv.setItem(6, CustomItems.ocdScroll);
				inv.setItem(7, CustomItems.renameScroll);
				inv.setItem(8, CustomItems.dischargeOrb(API.randomInt(1, 100)));
				inv.setItem(9, CustomItems.dischargeOrb(100));
				inv.setItem(10, CustomItems.basicMagicOrb);
				inv.setItem(11, CustomItems.advancedMagicOrb);
				inv.setItem(12, CustomItems.epicMagicOrb);
				inv.setItem(13, CustomItems.legendaryMagicOrb);
				inv.setItem(14, CustomItems.ancientMagicOrb);
				inv.setItem(15, CustomItems.dust("basic", 10));
				inv.setItem(16, CustomItems.dust("advanced", 10));
				inv.setItem(17, CustomItems.dust("epic", 10));
				inv.setItem(18, CustomItems.dust("legendary", 10));
				inv.setItem(19, CustomItems.dust("ancient", 10));
				inv.setItem(20, Books.lootingIV);
				inv.setItem(21, Books.lootingV);
				inv.setItem(22, Books.depthStriderI);
				inv.setItem(23,  Books.depthStriderII);
                inv.setItem(24, Books.depthStriderIII);
                ItemStack allTier1 = API.itemBuilder(Material.STAINED_GLASS_PANE, (short) 5, 1, "&a&lALL TIER 1 ENCHANTMENTS", new String[]{"&7Click to receive ALL &f&n18&7 tier 1", "&7enchantments.", " ", "&c&lTIP: &7Have an empty inventory."}, false);
                ItemStack allTier2 = API.itemBuilder(Material.STAINED_GLASS_PANE, (short) 9, 1, "&3&lALL TIER 2 ENCHANTMENTS", new String[]{"&7Click to receive ALL &f&n21&7 tier 2", "&7enchantments.", " ", "&c&lTIP: &7Have an empty inventory."}, false);
                ItemStack allTier3 = API.itemBuilder(Material.STAINED_GLASS_PANE, (short) 4, 1, "&e&lALL TIER 3 ENCHANTMENTS", new String[]{"&7Click to receive ALL &f&n16&7 tier 3", "&7enchantments.", " ", "&c&lTIP: &7Have an empty inventory."}, false);
                ItemStack allTier4 = API.itemBuilder(Material.STAINED_GLASS_PANE, (short) 14, 1, "&c&lALL TIER 4 ENCHANTMENTS", new String[]{"&7Click to receive ALL &f&n15&7 tier 4", "&7enchantments.", " ", "&c&lTIP: &7Have an empty inventory."}, false);
                ItemStack allTier5 = API.itemBuilder(Material.STAINED_GLASS_PANE, (short) 6, 1, "&d&lALL TIER 5 ENCHANTMENTS", new String[]{"&7Click to receive ALL &f&n2&7 tier 5", "&7enchantments.", " ", "&c&lTIP: &7Have an empty inventory."}, false);
                inv.setItem(27, allTier1);
                inv.setItem(28, allTier2);
                inv.setItem(29, allTier3);
                inv.setItem(30, allTier4);
                inv.setItem(31, allTier5);
				p.openInventory(inv);
				p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);
			}
			return false;
		}
		return false;
	}
	
	

}
