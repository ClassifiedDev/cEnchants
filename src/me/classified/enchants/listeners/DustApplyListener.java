package me.classified.enchants.listeners;

import java.util.ArrayList;

import me.classified.enchants.utils.Config;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.classified.enchants.utils.API;
import me.classified.enchants.utils.ParticleEffect;
import me.classified.enchants.utils.ParticleEffect.BlockData;

public class DustApplyListener implements Listener{

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDustApply(InventoryClickEvent e){
		if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
		Player p = (Player) e.getWhoClicked();
		ItemStack cursor = e.getCursor();
		ItemStack target = e.getCurrentItem();
		if(cursor.hasItemMeta()){
			if(cursor.getItemMeta().hasDisplayName() && cursor.getItemMeta().hasLore()){
				if(API.removeColor(cursor.getItemMeta().getDisplayName()).contains("Enchantment Dust")){
					if(cursor.getItemMeta().getLore().get(4).contains(API.color("&7&oDrag n drop onto orb to apply."))){
						if(target.hasItemMeta() && target.getItemMeta().hasLore()){
							if(target.getItemMeta().getLore().get(1).contains(API.color("&aSuccess Rate:"))){
								if(target.getType().toString().contains("SACK")){
									int targetTier = 0;
									int cursorTier = 0;
									if(target.getAmount() > 1){
										return;
									}
									if(target.getItemMeta().getDisplayName().startsWith(API.color(Config.tier1BookColor + "&n&l"))){
										targetTier = 1;
									}
									if(target.getItemMeta().getDisplayName().startsWith(API.color(Config.tier2BookColor + "&n&l"))){
										targetTier = 2;
									}
									if(target.getItemMeta().getDisplayName().startsWith(API.color(Config.tier3BookColor + "&n&l"))){
										targetTier = 3;
									}
									if(target.getItemMeta().getDisplayName().startsWith(API.color(Config.tier4BookColor + "&n&l"))){
										targetTier = 4;
									}
									if(target.getItemMeta().getDisplayName().startsWith(API.color(Config.tier5BookColor + "&n&l"))){
										targetTier = 5;
									}
									if(cursor.getItemMeta().getDisplayName().startsWith(API.color(Config.tier1BookColor))){
										cursorTier = 1;
									}
									if(cursor.getItemMeta().getDisplayName().startsWith(API.color(Config.tier2BookColor))){
										cursorTier = 2;
									}
									if(cursor.getItemMeta().getDisplayName().startsWith(API.color(Config.tier3BookColor))){
										cursorTier = 3;
									}
									if(cursor.getItemMeta().getDisplayName().startsWith(API.color(Config.tier4BookColor))){
										cursorTier = 4;
									}
									if(cursor.getItemMeta().getDisplayName().startsWith(API.color(Config.tier5BookColor))){
										cursorTier = 5;
									}
									if(targetTier != cursorTier){
										return;
									}
									int toAdd = 0;
									int current = 0;
									int total = 0;
									String toAddString = cursor.getItemMeta().getLore().get(2);
									toAddString = API.removeColor(toAddString);
									toAddString = toAddString.replaceAll("orb's success rate by ", "");
									toAddString = toAddString.replaceAll("%", "");
									toAdd = Integer.parseInt(toAddString);
									String currentString = target.getItemMeta().getLore().get(1);
									currentString = API.removeColor(currentString);
									currentString = currentString.replaceAll("Success Rate: ", "");
									currentString = currentString.replaceAll("%", "");
									current = Integer.parseInt(currentString);
									if(current == 100){
										return;
									}
									if(toAdd + current >= 100){
										total = 100;
									}
									else{
										total = toAdd + current;
									}
									ItemMeta tim = target.getItemMeta();
									ArrayList<String> lore = new ArrayList<String>();
									for(String s : tim.getLore()){
										lore.add(s);
									}
									/*if(cursor.getAmount() > 1){
										p.sendMessage(API.color("&c&l(!) &cPlease unstack dust while you are applying it to enchantment orbs."));
										return;
									}*/
									lore.set(1, API.color("&aSuccess Rate: &7" + total + "%"));
									tim.setLore(lore);
									target.setItemMeta(tim);
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 8);
									ParticleEffect.BLOCK_CRACK.display(new BlockData(Material.QUARTZ_BLOCK, (byte) 0), 0.3f, 1.0f, 0.3f, 1, 200, p.getLocation(), 100);
									if(cursor.getAmount() > 1){
										cursor.setAmount(cursor.getAmount() - 1);
									}
									else{
										e.setCursor(new ItemStack(Material.AIR));
									}
									e.setCancelled(true);
									p.updateInventory();
									return;
								}
							}
						}
					}
				}
			}
		}
	}

}
