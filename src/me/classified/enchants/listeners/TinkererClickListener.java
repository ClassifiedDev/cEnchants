package me.classified.enchants.listeners;

import me.classified.enchants.cEnchants;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;

import me.classified.enchants.utils.API;

public class TinkererClickListener implements Listener{

	@EventHandler
	public void onTinkererClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(p.getOpenInventory().getTopInventory().getTitle().equals(API.color(cEnchants.getConfigF().getString("tinkererTitle")))){
			if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
			if(!e.getCurrentItem().hasItemMeta()){
				e.setCancelled(true); 
				return;
			}
			if(e.getRawSlot() == 0 && e.getCurrentItem().getItemMeta().getDisplayName().equals(API.color("&cClick to ACCEPT Trade"))){
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 2);
				p.sendMessage(API.color("&a&l(!) &aTinkerer trade &a&nACCEPTED."));
				e.setCancelled(true);
				return;
			}
			Inventory ti = p.getOpenInventory().getTopInventory();
			Inventory pi = p.getOpenInventory().getBottomInventory();
			if(e.getClickedInventory() == ti) {
				p.sendMessage("TINKERER INV");
				e.setCancelled(true);
			}
			if(e.getClickedInventory() == pi) {
				if(API.removeColor(e.getCurrentItem().getItemMeta().getDisplayName()).contains("Enchant Orb") && API.removeColor(e.getCurrentItem().getItemMeta().getLore().get(1)).contains("Success Rate:")) {
					if(ti.getItem(1).getType() != Material.INK_SACK || ti.getItem(1) == null) {
						ti.setItem(1, e.getCurrentItem());
					}
					p.sendMessage("ORB");
				}
				p.sendMessage("PLAYER INV");
				e.setCancelled(true);
			}

			e.setCancelled(true);
			return;
		}
	}

}
