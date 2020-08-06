package me.classified.enchants.listeners;

import java.util.ArrayList;

import me.classified.enchants.cEnchants;
import me.classified.enchants.utils.Config;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.classified.enchants.utils.API;
import me.classified.enchants.utils.Enchant;
import me.classified.enchants.utils.ParticleEffect;

public class OrbApplyListener implements Listener{

    int MAX_ENCHANTS_PER_ITEM = 7;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEnchantApply(InventoryClickEvent e){
		if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
		Player p = (Player) e.getWhoClicked();
		ItemStack cursor = e.getCursor();
		ItemStack target = e.getCurrentItem();
		String targetName = "";
		if(cursor.hasItemMeta()){
			if(cursor.getItemMeta().hasDisplayName() && cursor.getItemMeta().hasLore()){
				String name = API.removeColor(cursor.getItemMeta().getDisplayName());
				if(name.contains("Enchant Orb")){
					if(cursor.getItemMeta().getLore().get(1).contains(API.color("&aSuccess Rate:"))){
						Enchant ench = API.getEnchant(cursor);
						if(target.getType().toString().contains("_") || target.getType().toString().contains("BOW")){
							if(target.getType().toString().contains("_")){
								targetName = target.getType().toString();
								String[] targetNameSplit = targetName.split("_");
								targetName = targetNameSplit[1];
							}
							else{
								targetName = "BOW";
							}
							if(ench.getTargets().toLowerCase().indexOf(targetName.toLowerCase()) != -1){
								if(target.getItemMeta().hasLore()){
									ArrayList<String> targetLore = new ArrayList<String>();
									int loreCount = 0;
									for(String s : target.getItemMeta().getLore()){
										if(s.endsWith("I") || s.endsWith("V") || s.endsWith("X")){
											targetLore.add(s);
										}
									}
									loreCount = targetLore.size();
									/*if(targetLore.contains(API.color(Config.protectedLore))){
									loreCount = loreCount - 1;
								}*/
									if(loreCount >= MAX_ENCHANTS_PER_ITEM){
									    if(p.isOp()){
                                            //p.sendMessage(API.color("&c&l(!) &cYou have reached the enchantment limit for this item. But because you are an admin it has been BYPASSED."));
                                            p.sendMessage(API.color("&c&l(!) &cYour admin status has allowed you to &c&nBYPASS&r&c the enchantment limit for this item."));
                                        }
									    else {
                                            p.sendMessage(API.color("&c&l(!) &cYou can not add any more enchantments to this piece of gear!"));
                                            return;
                                        }
									}
								}
								if(API.randomInt(1, 100) <= ench.getSuccess()){
									API.applyEnchant(target, API.getEnchant(cursor));
									p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
									API.playColorParticle(p, ench.getColor());
									e.setCursor(new ItemStack(Material.AIR));
									e.setCancelled(true);
									p.updateInventory();
									return;
								}
								else{
									if(ench.getDestroy() == 100){
										if(target.getItemMeta().hasLore()){
											if(target.getItemMeta().getLore().contains(API.color(Config.protectedLore))){
												ArrayList<String> wsItem = new ArrayList<String>();
												ItemMeta targetMeta = target.getItemMeta();
												for(String newLore : target.getItemMeta().getLore()){
													wsItem.add(newLore);
												}
												//TODO CHECK THIS
												int spaceIndex = wsItem.indexOf(API.color(Config.protectedLore)) - 1;
                                                wsItem.remove(spaceIndex);
                                                //TODO ---------------
												wsItem.remove(API.color(Config.protectedLore));
												targetMeta.setLore(wsItem);
												target.setItemMeta(targetMeta);
												wsItem.clear();
												p.playSound(p.getLocation(), Sound.ANVIL_USE, 1, 2);
												ParticleEffect.LAVA.display(0.5f, 1.0f, 0.5f, 5, 100, p.getLocation(), 100);
												p.sendMessage(API.color("&c&l(!) &cYour item would have been &c&ndestroyed&r &cbut your Protection Scroll saved it!"));
												e.setCursor(new ItemStack(Material.AIR));
												e.setCancelled(true);
												p.updateInventory();
												return;
											}
											else{
												p.setItemOnCursor(new ItemStack(Material.AIR));
												e.setCursor(new ItemStack(Material.AIR));
												e.setCurrentItem(new ItemStack(Material.AIR));
												p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
												ParticleEffect.LAVA.display(0.5f, 1.0f, 0.5f, 5, 100, p.getLocation(), 100);
												e.setCursor(new ItemStack(Material.AIR));
												e.setCancelled(true);
												p.updateInventory();
												return;
											}
										}
										else{
											p.setItemOnCursor(new ItemStack(Material.AIR));
											e.setCursor(new ItemStack(Material.AIR));
											e.setCurrentItem(new ItemStack(Material.AIR));
											p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
											ParticleEffect.LAVA.display(0.5f, 1.0f, 0.5f, 5, 100, p.getLocation(), 100);
											e.setCursor(new ItemStack(Material.AIR));
											e.setCancelled(true);
											p.updateInventory();
											return;
										}
									}
									if(API.randomInt(1, 100) <= ench.getDestroy()){
										if(target.getItemMeta().hasLore()){
											if(target.getItemMeta().getLore().contains(API.color(Config.protectedLore))){
												ArrayList<String> wsItem = new ArrayList<String>();
												ItemMeta targetMeta = target.getItemMeta();
												for(String newLore : target.getItemMeta().getLore()){
													wsItem.add(newLore);
												}
												wsItem.remove(API.color(Config.protectedLore));
												targetMeta.setLore(wsItem);
												target.setItemMeta(targetMeta);
												wsItem.clear();
												p.playSound(p.getLocation(), Sound.ANVIL_USE, 1, 2);
												ParticleEffect.LAVA.display(0.5f, 1.0f, 0.5f, 5, 100, p.getLocation(), 100);
												p.sendMessage(API.color("&c&l(!) &cYour item would have been &c&ndestroyed&r &cbut your Protection Scroll saved it!"));
												e.setCursor(new ItemStack(Material.AIR));
												e.setCancelled(true);
												p.updateInventory();
												return;
											}
											else{
												p.setItemOnCursor(new ItemStack(Material.AIR));
												e.setCursor(new ItemStack(Material.AIR));
												e.setCurrentItem(new ItemStack(Material.AIR));
												p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
												ParticleEffect.LAVA.display(0.5f, 1.0f, 0.5f, 5, 100, p.getLocation(), 100);
												e.setCursor(new ItemStack(Material.AIR));
												e.setCancelled(true);
												p.updateInventory();
												return;
											}
										}
										else{
											p.setItemOnCursor(new ItemStack(Material.AIR));
											e.setCursor(new ItemStack(Material.AIR));
											e.setCurrentItem(new ItemStack(Material.AIR));
											p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
											ParticleEffect.LAVA.display(0.5f, 1.0f, 0.5f, 5, 100, p.getLocation(), 100);
											e.setCursor(new ItemStack(Material.AIR));
											e.setCancelled(true);
											p.updateInventory();
											return;
										}
									}
									p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
									ParticleEffect.LAVA.display(0.5f, 1.0f, 0.5f, 5, 100, p.getLocation(), 100);
									e.setCursor(new ItemStack(Material.AIR));
									e.setCancelled(true);
									p.updateInventory();
									return;
								}
							}
							return;
						}
					}
					return;
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onProtectionApply(InventoryClickEvent e){
		if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
		Player p = (Player) e.getWhoClicked();
		ItemStack cursor = e.getCursor();
		ItemStack target = e.getCurrentItem();
		if(cursor.hasItemMeta()){
			if(cursor.getItemMeta().hasDisplayName() && cursor.getItemMeta().hasLore()){
				if(cursor.getItemMeta().getDisplayName().equals(API.color(Config.protectionScrollName)) && cursor.getType().equals(Config.protectionScrollMaterial)){
					if(target.getType().toString().contains("HELMET") || 
							target.getType().toString().contains("CHESTPLATE") || 
							target.getType().toString().contains("LEGGINGS") || 
							target.getType().toString().contains("BOOTS") ||
							target.getType().toString().contains("SWORD")||
							target.getType().toString().contains("AXE")||
							target.getType().toString().contains("PICKAXE")||
							target.getType().toString().contains("SHOVEL")||
							target.getType().toString().contains("BOW")||
							target.getType().toString().contains("HOE")){
						if(target.getItemMeta().hasLore()){
							if(target.getItemMeta().getLore().contains(API.color(Config.protectedLore))){
								p.sendMessage(API.color("&c&l(!) &cThis item is already protected with a protection scroll."));
								return;
							}
							ItemMeta tim = target.getItemMeta();
							ArrayList<String> lore = new ArrayList<String>();
							for(String s : tim.getLore()){
								lore.add(s);
							}
							//TODO CHECK THIS
                            lore.add(API.color(" "));
							//TODO -------------
							lore.add(API.color(Config.protectedLore));
							tim.setLore(lore);
							target.setItemMeta(tim);
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
							ParticleEffect.SPELL.display(0.5f, 1.0f, 0.5f, 5, 300, p.getLocation(), 100);
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
						ItemMeta tim = target.getItemMeta();
						ArrayList<String> tisLore = new ArrayList<String>();
						tisLore.add(API.color(Config.protectedLore));
						tim.setLore(tisLore);
						target.setItemMeta(tim);
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						ParticleEffect.SPELL.display(0.5f, 1.0f, 0.5f, 5, 300, p.getLocation(), 100);
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


	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDischargeApply(InventoryClickEvent e){
		if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
		Player p = (Player) e.getWhoClicked();
		ItemStack cursor = e.getCursor();
		ItemStack target = e.getCurrentItem();
		if(cursor.hasItemMeta()){
			if(cursor.getItemMeta().hasDisplayName() && cursor.getItemMeta().hasLore()){
				if(cursor.getItemMeta().getDisplayName().equals(API.color(Config.removalScrollName)) && cursor.getType().equals(Config.removalScrollMaterial)){
					if(target.getType().toString().contains("HELMET") || 
							target.getType().toString().contains("CHESTPLATE") || 
							target.getType().toString().contains("LEGGINGS") || 
							target.getType().toString().contains("BOOTS") ||
							target.getType().toString().contains("SWORD")||
							target.getType().toString().contains("AXE")||
							target.getType().toString().contains("PICKAXE")||
							target.getType().toString().contains("SHOVEL")||
							target.getType().toString().contains("BOW")||
							target.getType().toString().contains("HOE")){
						if(target.getItemMeta().hasLore()){

							if(!API.containsEnchants(target)){
								p.sendMessage(API.color("&c&l(!) &cThis item does not contain any custom enchantments.")); 
								//e.setCancelled(true); 
								return;
							}

							else{
								int removedEnchants = 0;

								String percentStr = API.removeColor(cursor.getItemMeta().getLore().get(2));
								percentStr = percentStr.replaceAll("into a ", "");
								percentStr = percentStr.replaceAll("% enchantment.", "");
								int percent = Integer.parseInt(percentStr);
								ArrayList<String> targetLore = new ArrayList<String>();
								ItemMeta tm = target.getItemMeta();
								int loreCount = 0;
								for(String s : target.getItemMeta().getLore()){
									targetLore.add(s);
								}
								loreCount = targetLore.size() - 1;
								int enchRemoveLine = API.randomInt(0, loreCount);
								String enchRemove = targetLore.get(enchRemoveLine);
								enchRemove = API.removeColor(enchRemove);

								if(enchRemove.endsWith("I") || enchRemove.endsWith("V") || enchRemove.endsWith("X")){
									if(API.dischargeEnchants.containsKey(enchRemove)){
										API.giveEnchant(p, API.dischargeEnchants.get(enchRemove), percent, 100);
										removedEnchants = removedEnchants + 1;
										ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
										for(int i = 0; i < 300; i++){
											ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
										}
										p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

										if(cursor.getAmount() > 1){
											cursor.setAmount(cursor.getAmount() - 1);
										}
										else{
											e.setCursor(new ItemStack(Material.AIR));
										}

										targetLore.remove(enchRemoveLine);
										tm.setLore(targetLore);
										target.setItemMeta(tm);
										targetLore.clear();
									}
								}

								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
								if(removedEnchants != 1){
									int enchRemoveLine2 = API.randomInt(0, loreCount);
									String enchRemove2 = targetLore.get(enchRemoveLine2);
									enchRemove2 = API.removeColor(enchRemove2);

									if(enchRemove2.endsWith("I") || enchRemove2.endsWith("V") || enchRemove2.endsWith("X")){
										if(API.dischargeEnchants.containsKey(enchRemove2)){
											API.giveEnchant(p, API.dischargeEnchants.get(enchRemove2), percent, 100);
											removedEnchants = removedEnchants + 1;
											ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
											for(int i = 0; i < 300; i++){
												ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
											}
											p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);

											if(cursor.getAmount() > 1){
												cursor.setAmount(cursor.getAmount() - 1);
											}
											else{
												e.setCursor(new ItemStack(Material.AIR));
											}

											targetLore.remove(enchRemoveLine2);
											tm.setLore(targetLore);
											target.setItemMeta(tm);
											targetLore.clear();
										}
									}
								}
							}

							e.setCancelled(true);
							p.updateInventory();
						}
					}
				}
			}
		}
	}


	@SuppressWarnings("deprecation")
	@EventHandler
	public void onOrganizationApply(InventoryClickEvent e){
		if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
		Player p = (Player) e.getWhoClicked();
		ItemStack cursor = e.getCursor();
		ItemStack target = e.getCurrentItem();
		if(cursor.hasItemMeta()){
			if(cursor.getItemMeta().hasDisplayName() && cursor.getItemMeta().hasLore()){
				if(cursor.getItemMeta().getDisplayName().equals(API.color(Config.organizationScrollName)) && cursor.getType().equals(Config.organizationScrollMaterial)){
					if(target.getType().toString().contains("HELMET") || 
							target.getType().toString().contains("CHESTPLATE") || 
							target.getType().toString().contains("LEGGINGS") || 
							target.getType().toString().contains("BOOTS") ||
							target.getType().toString().contains("SWORD")||
							target.getType().toString().contains("AXE")||
							target.getType().toString().contains("PICKAXE")||
							target.getType().toString().contains("SHOVEL")||
							target.getType().toString().contains("BOW")||
							target.getType().toString().contains("HOE")){
						if(target.getItemMeta().hasLore()){
							int loreCount = 0;
							ArrayList<String> lore = new ArrayList<String>();
							ArrayList<String> organizedLore = new ArrayList<String>();
							for(String s : target.getItemMeta().getLore()){
								lore.add(s);
							}
							for(String ss : lore){
								if(ss.startsWith(API.color(Config.tier5BookColor))){
									if(API.removeColor(ss).endsWith("I") || API.removeColor(ss).endsWith("V") || API.removeColor(ss).endsWith("X")){
										organizedLore.add(ss);
									}
								}
							}
							for(String sss : lore){
								if(sss.startsWith(API.color(Config.tier4BookColor))){
									if(API.removeColor(sss).endsWith("I") || API.removeColor(sss).endsWith("V") || API.removeColor(sss).endsWith("X")){
										organizedLore.add(sss);
									}
								}
							}
							for(String ssss : lore){
								if(ssss.startsWith(API.color(Config.tier3BookColor))){
									if(API.removeColor(ssss).endsWith("I") || API.removeColor(ssss).endsWith("V") || API.removeColor(ssss).endsWith("X")){
										organizedLore.add(ssss);
									}
								}
							}
							for(String sssss : lore){
								if(sssss.startsWith(API.color(Config.tier2BookColor))){
									if(API.removeColor(sssss).endsWith("I") || API.removeColor(sssss).endsWith("V") || API.removeColor(sssss).endsWith("X")){
										organizedLore.add(sssss);
									}
								}
							}
							for(String ssssss : lore){
								if(ssssss.startsWith(API.color(Config.tier1BookColor))){
									if(API.removeColor(ssssss).endsWith("I") || API.removeColor(ssssss).endsWith("V") || API.removeColor(ssssss).endsWith("X")){
										organizedLore.add(ssssss);
									}
								}
							}
                            /*for(String s2 : lore){
                                if(!s2.startsWith(API.color(Config.tier1BookColor)) && !s2.startsWith(API.color(Config.tier2BookColor)) && !s2.startsWith(API.color(Config.tier3BookColor)) && !s2.startsWith(API.color(Config.tier4BookColor)) && !s2.startsWith(API.color(Config.tier5BookColor))){
                                    if(!API.removeColor(s2).endsWith("I") && !API.removeColor(s2).endsWith("V") && !API.removeColor(s2).endsWith("X")){
                                        organizedLore.add(s2);
                                    }
                                }
                            }*/
                            for(String s2 : lore){
                                if(!API.removeColor(s2).endsWith("I") && !API.removeColor(s2).endsWith("V") && !API.removeColor(s2).endsWith("X")){
                                    organizedLore.add(s2);
                                }
                            }
							/*
							for(String s2 : lore){
								if(s2.startsWith(API.color("&b&o"))){
									organizedLore.add(s2);
								}
							}
							for(String ss2 : lore){
								if(ss2.startsWith(API.color("&9&o"))){
									organizedLore.add(ss2);
								}
							}
							for(String sss2 : lore){
								if(sss2.startsWith(API.color("&e&o"))){
									organizedLore.add(sss2);
								}
							}
							for(String ssss2 : lore){
								if(ssss2.startsWith(API.color("&c&o"))){
									organizedLore.add(ssss2);
								}
							}
							for(String sssss2 : lore){
								if(sssss2.startsWith(API.color("&d&o"))){
									organizedLore.add(sssss2);
								}
							}
							for(String ssssss2 : lore){
								if(ssssss2.startsWith(API.color("&6&o"))){
									organizedLore.add(ssssss2);
								}
							}*/
							//loreCount = lore.size();
							for(String lc : lore){
								if(API.removeColor(lc).endsWith("I") || API.removeColor(lc).endsWith("V") || API.removeColor(lc).endsWith("X")){
									loreCount = loreCount + 1;
						 		}
							}
							//TODO: Make sure this works correctly.
							/*if(lore.contains(API.color(Config.protectedLore))){
								organizedLore.add(API.color(Config.protectedLore));
								//loreCount = loreCount - 1;
							}*/
							ItemMeta im = target.getItemMeta();
							if(im.hasDisplayName()){
								if(im.getDisplayName().contains(API.color("&9&l[")) && im.getDisplayName().contains(API.color("&r&9&l]"))){

								}
								im.setDisplayName(im.getDisplayName() /*+ API.color(" &9&l[&a&l&n" + loreCount + "&r&9&l]"*/);
							}
							else{
								String itemName = target.getType().toString().toLowerCase();
								if(!itemName.contains("_")){
									itemName = API.color("&fBow" /*+ API.color(" &9&l[&a&l&n" + loreCount + "&r&9&l]"*/);
									im.setDisplayName(itemName);
								}
								else{
									String[] itemNameSplit = itemName.split("_");
									itemName = itemNameSplit[0] + itemNameSplit[1];
									String itemName0 = ("" + itemNameSplit[0].charAt(0)).toUpperCase() + itemNameSplit[0].substring(1);
									String itemName1 = ("" + itemNameSplit[1].charAt(0)).toUpperCase() + itemNameSplit[1].substring(1);
									itemName = API.color("&f" + itemName0) + " " + API.color("&f" + itemName1);
									im.setDisplayName(itemName /*+ API.color(" &9&l[&a&l&n" + loreCount + "&r&9&l]"*/);
								}
							}

							im.setLore(organizedLore);
							target.setItemMeta(im);
							lore.clear();
							organizedLore.clear();
							API.playRainbowParticle(p);
							p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 1);
							if(cursor.getAmount() > 1){
								cursor.setAmount(cursor.getAmount() - 1);
							}
							else{
								e.setCursor(new ItemStack(Material.AIR));
							}
							e.setCancelled(true);
							p.updateInventory();
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSpecialEnchantApply(InventoryClickEvent e){
		if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
		Player p = (Player) e.getWhoClicked();
		ItemStack cursor = e.getCursor();
		ItemStack target = e.getCurrentItem();
		if(cursor.hasItemMeta()){
			if(cursor.getItemMeta().hasDisplayName() && cursor.getItemMeta().hasLore()){
				if(cursor.getItemMeta().getDisplayName().equals(API.color("&6&l&nLooting IV Enchant Book")) && cursor.getType().equals(Material.ENCHANTED_BOOK)){
					if(target.getType().toString().contains("SWORD") || 
							target.getType().toString().contains("AXE")){
						ItemMeta im = target.getItemMeta();
						im.addEnchant(Enchantment.LOOT_BONUS_MOBS, 4, true);
						target.setItemMeta(im);
						API.playColorParticle(p, "pink");
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						e.setCursor(new ItemStack(Material.AIR));
						e.setCancelled(true);
						p.updateInventory();
					}
				}
				if(cursor.getItemMeta().getDisplayName().equals(API.color("&6&l&nLooting V Enchant Book")) && cursor.getType().equals(Material.ENCHANTED_BOOK)){
					if(target.getType().toString().contains("SWORD") || 
							target.getType().toString().contains("AXE")){
						ItemMeta im = target.getItemMeta();
						im.addEnchant(Enchantment.LOOT_BONUS_MOBS, 5, true);
						target.setItemMeta(im);
						API.playColorParticle(p, "pink");
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						e.setCursor(new ItemStack(Material.AIR));
						e.setCancelled(true);
						p.updateInventory();
					}
				}
				if(cursor.getItemMeta().getDisplayName().equals(API.color("&6&l&nDepth Strider I Enchant Book")) && cursor.getType().equals(Material.ENCHANTED_BOOK)){
					if(target.getType().toString().contains("BOOTS")){
						ItemMeta im = target.getItemMeta();
						im.addEnchant(Enchantment.DEPTH_STRIDER, 1, true);
						target.setItemMeta(im);
						API.playColorParticle(p, "pink");
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						e.setCursor(new ItemStack(Material.AIR));
						e.setCancelled(true);
						p.updateInventory();
					}
				}
				if(cursor.getItemMeta().getDisplayName().equals(API.color("&6&l&nDepth Strider II Enchant Book")) && cursor.getType().equals(Material.ENCHANTED_BOOK)){
					if(target.getType().toString().contains("BOOTS")){
						ItemMeta im = target.getItemMeta();
						im.addEnchant(Enchantment.DEPTH_STRIDER, 2, true);
						target.setItemMeta(im);
						API.playColorParticle(p, "pink");
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						e.setCursor(new ItemStack(Material.AIR));
						e.setCancelled(true);
						p.updateInventory();
					}
				}
				if(cursor.getItemMeta().getDisplayName().equals(API.color("&6&l&nDepth Strider III Enchant Book")) && cursor.getType().equals(Material.ENCHANTED_BOOK)){
					if(target.getType().toString().contains("BOOTS")){
						ItemMeta im = target.getItemMeta();
						im.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
						target.setItemMeta(im);
						API.playColorParticle(p, "orange");
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						e.setCursor(new ItemStack(Material.AIR));
						e.setCancelled(true);
						p.updateInventory();
					}
				}
			}
		}
	}
}
