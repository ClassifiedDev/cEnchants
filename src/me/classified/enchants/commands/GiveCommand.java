package me.classified.enchants.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import me.classified.enchants.enchants.Books;
import me.classified.enchants.utils.API;
import me.classified.enchants.utils.CustomItems;

public class GiveCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("giveenchant")){
			if(!sender.hasPermission("classifiedenchants.give")){
				sender.sendMessage(API.color("&c&l(!) &cYou do not have permission to use that command."));
				return false;
			}
			if(args.length == 0){
				sender.sendMessage(API.color("&c&l(!) &cUsage: &7/giveenchant <player> <enchant> <amount> [<success/random> <destroy/random>]"));
				return false;
			}
			if(args.length == 3){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target == null){
					sender.sendMessage(API.color("&c&l(!) &cPlayer could not be found!"));
					return false;
				}
				int amount = Integer.parseInt(args[2]);
				
				if(args[1].equalsIgnoreCase("lootingIV")){
					for(int i = 0; i < amount; i++){
						target.getInventory().addItem(Books.lootingIV);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("lootingV")){
					for(int i = 0; i < amount; i++){
						target.getInventory().addItem(Books.lootingV);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("depthStriderI")){
					for(int i = 0; i < amount; i++){
						target.getInventory().addItem(Books.depthStriderI);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("depthStriderII")){
					for(int i = 0; i < amount; i++){
						target.getInventory().addItem(Books.depthStriderII);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("depthStriderIII")){
					for(int i = 0; i < amount; i++){
						target.getInventory().addItem(Books.depthStriderIII);
					}
					return false;
				}
				
				if(!API.enchants.containsKey(args[1])){
					sender.sendMessage(API.color("&c&l(!) &cThe specified enchantment could not be found. Use format enchantIII."));
					return false;
				}
				for(int i = 0; i < amount; i++){
					API.giveEnchant(target, API.enchants.get(args[1]), API.randomInt(1, 100), API.randomInt(1, 100));
				}
				return false;
			}
			if(args.length == 5){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				int success = 0;
				int destroy = 0;
				if(target == null){
					sender.sendMessage(API.color("&c&l(!) &cPlayer could not be found!"));
					return false;
				}
				int amount = Integer.parseInt(args[2]);
				if(!API.enchants.containsKey(args[1])){
					sender.sendMessage(API.color("&c&l(!) &cThe specified enchantment could not be found. Use format enchantIII."));
					return false;
				}
				if(args[3].equalsIgnoreCase("random")){
					success = API.randomInt(1, 100);
				}
				else{
					success = Integer.parseInt(args[3]);
				}
				if(args[4].equalsIgnoreCase("random")){
					destroy = API.randomInt(1, 100);
				}
				else{
					destroy = Integer.parseInt(args[4]);
				}
				for(int i = 0; i < amount; i++){
					API.giveEnchant(target, API.enchants.get(args[1]), success, destroy);
				}
				return false;
			}
		}


		if(cmd.getName().equalsIgnoreCase("giveenchantitem")){
			if(!sender.hasPermission("classifiedenchants.give")){
				sender.sendMessage(API.color("&c&l(!) &cYou do not have permission to use that command."));
				return false;
			}
			if(args.length == 0){
				sender.sendMessage(API.color("&c&l(!) &cUsage: &7/giveenchantitem <player> <item> <amount> [rarity/percent/amount]"));
				return false;
			}
			if(args.length == 3){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target == null){
					sender.sendMessage(API.color("&c&l(!) &cPlayer could not be found!"));
					return false;
				}
				PlayerInventory ti = target.getInventory();
				int amount = Integer.parseInt(args[2]);
				if(args[1].equalsIgnoreCase("protection")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.protectionOrb);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("discharge")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.dischargeOrb(API.randomInt(25, 100)));
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("organization")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.ocdScroll);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("rename")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.renameScroll);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("book1")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.basicOrb);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("book2")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.advancedOrb);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("book3")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.epicOrb);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("book4")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.legendaryOrb);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("book5")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.ancientOrb);
					}
					return false;
				}
				
				if(args[1].equalsIgnoreCase("magic1")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.basicMagicOrb);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("magic2")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.advancedMagicOrb);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("magic3")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.epicMagicOrb);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("magic4")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.legendaryMagicOrb);
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("magic5")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.ancientMagicOrb);
					}
					return false;
				}
				else{
					sender.sendMessage(" ");
					sender.sendMessage(API.color("&c&l(!) &cInvalid item! An item with that name could not be found!"));
					sender.sendMessage(" ");
					sender.sendMessage(API.color("            &f&l*** &a&lVALID ITEMS &f&l***"));
					return false;
				}
			}
			if(args.length == 4){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target == null){
					sender.sendMessage(API.color("&c&l(!) &cPlayer could not be found!"));
					return false;
				}
				PlayerInventory ti = target.getInventory();
				int amount = Integer.parseInt(args[2]);
				if(args[1].equalsIgnoreCase("discharge")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.dischargeOrb(Integer.parseInt(args[3])));
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("dust1")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.dust("basic", Integer.parseInt(args[3])));
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("dust2")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.dust("advanced", Integer.parseInt(args[3])));
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("dust3")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.dust("epic", Integer.parseInt(args[3])));
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("dust4")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.dust("legendary", Integer.parseInt(args[3])));
					}
					return false;
				}
				if(args[1].equalsIgnoreCase("dust5")){
					for(int i = 0; i < amount; i++){
						ti.addItem(CustomItems.dust("ancient", Integer.parseInt(args[3])));
					}
					return false;
				}
				else{
					sender.sendMessage(" ");
					sender.sendMessage(API.color("&c&l(!) &cInvalid item! An item with that name could not be found!"));
					sender.sendMessage(" ");
					sender.sendMessage(API.color("            &f&l*** &a&lVALID ITEMS &f&l***"));
					return false;
				}
			}
		}
		return false;
	}

}
