package me.classified.enchants.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import me.classified.enchants.enchants.Books;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class API {

	public static boolean DEBUG_MODE = true; //This enables debug messages etc..

	public static HashMap<String, Enchant> enchants = new HashMap<String, Enchant>();
	public static HashMap<String, Enchant> dischargeEnchants = new HashMap<String, Enchant>();
	public static HashMap<Integer, Enchant> allEnchants = new HashMap<Integer, Enchant>();

	public static HashMap<Integer, Enchant> basic_enchants = new HashMap<Integer, Enchant>();
	public static HashMap<Integer, Enchant> advanced_enchants = new HashMap<Integer, Enchant>();
	public static HashMap<Integer, Enchant> epic_enchants = new HashMap<Integer, Enchant>();
	public static HashMap<Integer, Enchant> legendary_enchants = new HashMap<Integer, Enchant>();
	public static HashMap<Integer, Enchant> ancient_enchants = new HashMap<Integer, Enchant>();

	public static HashMap<Integer, String> romanNumerals = new HashMap<Integer, String>();
	public static HashMap<String, Integer> romanNumerals2 = new HashMap<String, Integer>();

	
	public static String color(String msg){
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	public static String removeColor(String msg){
		return ChatColor.stripColor(msg);
	}

	public static int randomInt(int min, int max){
		Random rand = new Random();
		int randomNum = rand.nextInt(max - min + 1) + min;
		return randomNum;
	}

	public static double randDouble(double min, double max){
		Random r = new Random();
		return min + (max - min) * r.nextDouble();
	}

	public static void sendDebug(LivingEntity p, Player user, String enchant){
		p.sendMessage(color("&b&lDEBUG:&8 (&7User: &f" + user.getName() + " ,&7 Enchant: &f" + enchant +"&8)"));
		return;
	}
	
	public static void sendPlayerDebug(Player p, String enchant){
		p.sendMessage(color("&b&lENCHANTMENT DEBUG&8: &f" + enchant));
		return;
	}
	
	public static String getDateAndTime(){
		DateFormat df = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");
		Date d = new Date();
		String fd = df.format(d);
		String[] fds = fd.split(" ");
		if(fds[0].startsWith("0")){
			fds[0] = fds[0].replaceFirst("0", "");
		}
		if(fds[1].startsWith("0")){
			fds[1] = fds[1].replaceFirst("0", "");
		}
		String ffd = fds[0] + " at " + fds[1] + " " + fds[2];
		return ffd;
	}

	public static boolean isInvEmpty(Player p){
		for(ItemStack item : p.getInventory().getContents()){
			if(item != null && !item.getType().equals(Material.AIR)){
				return false;
			}
		}
		return true;
	}

	public static boolean isArmorInvEmpty(Player p){
		for(ItemStack item : p.getInventory().getArmorContents()){
			if(item != null && !item.getType().equals(Material.AIR)){
				return false;
			}
		}
		return true;
	}

	public static int getAvaliableInvSlots(Player p){
		PlayerInventory pi = p.getInventory();
		int slots = 0;
		for(ItemStack is : pi){
			if(is == null || is.getType().equals(Material.AIR)){
				slots++;
			}
		}
		return slots;
	}

	public static String calculateCooldown(long seconds){
		int daysLeft = (int)TimeUnit.SECONDS.toDays(seconds);        
		long hoursLeft = TimeUnit.SECONDS.toHours(seconds) - (daysLeft *24);
		long minutesLeft = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds)* 60);
		long secondsLeft = TimeUnit.SECONDS.toSeconds(seconds) - TimeUnit.SECONDS.toSeconds(TimeUnit.SECONDS.toMinutes(seconds) * 60);
		if(minutesLeft <= 0 && hoursLeft <= 0 && daysLeft <= 0){
			return secondsLeft + "s";
		}
		if(hoursLeft <= 0 && daysLeft <= 0){
			return minutesLeft + "m " + secondsLeft + "s";
		}
		if(daysLeft <= 0){
			return hoursLeft + "h " + minutesLeft + "m " + secondsLeft + "s";
		}
		else{  
			return daysLeft + "d " + hoursLeft + "h " + minutesLeft + "m " + secondsLeft + "s";
		}
	}

	public static ItemStack itemBuilder(Material Material, Short Data, String ItemName, ArrayList<String> Lore, Boolean Glowing){
		ItemStack item = new ItemStack(Material, 1, (short) Data);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(color(ItemName));
		meta.setLore(Lore);
		if(Glowing){
			meta.addEnchant(Enchantment.DURABILITY, 1, true);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack itemBuilder(Material item, Short data, int amount, String name, String[] lore, boolean glowing){
		ArrayList<String> itemLore = new ArrayList<String>();
		ItemStack is = new ItemStack(item, amount, (short) data);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(color(name));
		for(String s : lore){
			itemLore.add(color(s));
		}
		im.setLore(itemLore);
		if(glowing){
			im.addEnchant(Enchantment.DURABILITY, 1, true);
			im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		is.setItemMeta(im);
		return is;
	}


	public static boolean hasEnchant(String enchant, ItemStack is){
		if ((is != null) && (is.getType() != Material.AIR) && 
				(is.hasItemMeta()) && (is.getItemMeta().hasLore())){
			ItemMeta im = is.getItemMeta();
			for (String s : im.getLore()){
				s = ChatColor.stripColor(s);
				if (s.equalsIgnoreCase(enchant + " I")) {
					return true;
				}
				if (s.equalsIgnoreCase(enchant + " II")) {
					return true;
				}
				if (s.equalsIgnoreCase(enchant + " III")) {
					return true;
				}
				if (s.equalsIgnoreCase(enchant + " IV")) {
					return true;
				}
				if (s.equalsIgnoreCase(enchant + " V")) {
					return true;
				}
				if (s.equalsIgnoreCase(enchant + " VI")) {
					return true;
				}
				if (s.equalsIgnoreCase(enchant + " VII")) {
					return true;
				}
				if (s.equalsIgnoreCase(enchant + " VIII")) {
					return true;
				}
				if (s.equalsIgnoreCase(enchant + " IX")) {
					return true;
				}
				if (s.equalsIgnoreCase(enchant + " X")) {
					return true;
				}
			}
		}
		return false;
	}


	public static int getEnchantLvl(String enchant, ItemStack is){
		if ((is != null) && (is.getType() != Material.AIR) && 
				(is.hasItemMeta()) && (is.getItemMeta().hasLore())){
			ItemMeta im = is.getItemMeta();
			for (String s : im.getLore()){
				s = removeColor(s);
				if (s.equalsIgnoreCase(enchant + " I")){
					return 1;
				}
				if (s.equalsIgnoreCase(enchant + " II")){
					return 2;
				}
				if (s.equalsIgnoreCase(enchant + " III")){
					return 3;
				}
				if (s.equalsIgnoreCase(enchant + " IV")){
					return 4;
				}
				if (s.equalsIgnoreCase(enchant + " V")){
					return 5;
				}
				if (s.equalsIgnoreCase(enchant + " VI")){
					return 6;
				}
				if (s.equalsIgnoreCase(enchant + " VII")){
					return 7;
				}
				if (s.equalsIgnoreCase(enchant + " VIII")){
					return 8;
				}
				if (s.equalsIgnoreCase(enchant + " IX")){
					return 9;
				}
				if (s.equalsIgnoreCase(enchant + " X")){
					return 10;
				}
			}
		}
		return 0;
	}

	public static List<Player> getNearbyPlayers(Player player, int distance){
		List<Player> near = new ArrayList<>();
		int d2 = distance * distance;
		for (Player p : Bukkit.getServer().getOnlinePlayers()){
			if(p.getWorld() == player.getWorld() && p.getLocation().distanceSquared(player.getLocation()) <= d2){
				near.add(p);
				if(near.contains(player)){
					near.remove(player);
				}
			}
		}
		return near;
	}

	public static boolean isWearingReaperSet(Player p) {
		ItemStack helmet = p.getInventory().getHelmet();
		ItemStack chestplate = p.getInventory().getChestplate();
		ItemStack leggings = p.getInventory().getLeggings();
		ItemStack boots = p.getInventory().getBoots();
		boolean helmetReaper = false;
		boolean chestplateReaper = false;
		boolean leggingsReaper = false;
		boolean bootsReaper = false;		
		if(helmet != null && helmet.getType() != Material.AIR && helmet.hasItemMeta() && helmet.getItemMeta().hasLore()) {
			if(helmet.getItemMeta().getLore().contains(color("&8» &c&lREAPER SET PIECE &8«"))) {
				helmetReaper = true;
			}
		}
		if(chestplate != null && chestplate.getType() != Material.AIR && chestplate.hasItemMeta() && chestplate.getItemMeta().hasLore()) {
			if(chestplate.getItemMeta().getLore().contains(color("&8» &c&lREAPER SET PIECE &8«"))) {
				chestplateReaper = true;
			}
		}
		if(leggings != null && leggings.getType() != Material.AIR && leggings.hasItemMeta() && leggings.getItemMeta().hasLore()) {
			if(leggings.getItemMeta().getLore().contains(color("&8» &c&lREAPER SET PIECE &8«"))) {
				leggingsReaper = true;
			}
		}
		if(boots != null && boots.getType() != Material.AIR && boots.hasItemMeta() && boots.getItemMeta().hasLore()) {
			if(boots.getItemMeta().getLore().contains(color("&8» &c&lREAPER SET PIECE &8«"))) {
				bootsReaper = true;
			}
		}
		if(helmetReaper && chestplateReaper && leggingsReaper && bootsReaper) {
			return true;
		}
		return false;
	}
	
	public static boolean isWearingReaperHelmet(Player p){
		ItemStack helmet = p.getInventory().getHelmet();
		if(helmet != null && helmet.getType() != Material.AIR && helmet.hasItemMeta() && helmet.getItemMeta().hasLore()) {
			if(helmet.getItemMeta().getLore().contains(API.color("&8» &c&lREAPER SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWearingReaperChestplate(Player p){
		ItemStack chestplate = p.getInventory().getChestplate();
		if(chestplate != null && chestplate.getType() != Material.AIR && chestplate.hasItemMeta() && chestplate.getItemMeta().hasLore()) {
			if(chestplate.getItemMeta().getLore().contains(API.color("&8» &c&lREAPER SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWearingReaperLeggings(Player p){
		ItemStack leggings = p.getInventory().getLeggings();
		if(leggings != null && leggings.getType() != Material.AIR && leggings.hasItemMeta() && leggings.getItemMeta().hasLore()) {
			if(leggings.getItemMeta().getLore().contains(API.color("&8» &c&lREAPER SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWearingReaperBoots(Player p){
		ItemStack boots = p.getInventory().getBoots();
		if(boots != null && boots.getType() != Material.AIR && boots.hasItemMeta() && boots.getItemMeta().hasLore()) {
			if(boots.getItemMeta().getLore().contains(API.color("&8» &c&lREAPER SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWearingGoblinSet(Player p) {
		ItemStack helmet = p.getInventory().getHelmet();
		ItemStack chestplate = p.getInventory().getChestplate();
		ItemStack leggings = p.getInventory().getLeggings();
		ItemStack boots = p.getInventory().getBoots();
		boolean helmetGoblin = false;
		boolean chestplateGoblin = false;
		boolean leggingsGoblin = false;
		boolean bootsGoblin = false;		
		if(helmet != null && helmet.getType() != Material.AIR && helmet.hasItemMeta() && helmet.getItemMeta().hasLore()) {
			if(helmet.getItemMeta().getLore().contains(color("&8» &a&lGOBLIN SET PIECE &8«"))) {
				helmetGoblin = true;
			}
		}
		if(chestplate != null && chestplate.getType() != Material.AIR && chestplate.hasItemMeta() && chestplate.getItemMeta().hasLore()) {
			if(chestplate.getItemMeta().getLore().contains(color("&8» &a&lGOBLIN SET PIECE &8«"))) {
				chestplateGoblin = true;
			}
		}
		if(leggings != null && leggings.getType() != Material.AIR && leggings.hasItemMeta() && leggings.getItemMeta().hasLore()) {
			if(leggings.getItemMeta().getLore().contains(color("&8» &a&lGOBLIN SET PIECE &8«"))) {
				leggingsGoblin = true;
			}
		}
		if(boots != null && boots.getType() != Material.AIR && boots.hasItemMeta() && boots.getItemMeta().hasLore()) {
			if(boots.getItemMeta().getLore().contains(color("&8» &a&lGOBLIN SET PIECE &8«"))) {
				bootsGoblin = true;
			}
		}
		if(helmetGoblin && chestplateGoblin && leggingsGoblin && bootsGoblin) {
			return true;
		}
		return false;
	}
	
	public static boolean isWearingGoblinHelmet(Player p){
		ItemStack helmet = p.getInventory().getHelmet();
		if(helmet != null && helmet.getType() != Material.AIR && helmet.hasItemMeta() && helmet.getItemMeta().hasLore()) {
			if(helmet.getItemMeta().getLore().contains(API.color("&8» &a&lGOBLIN SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWearingGoblinChestplate(Player p){
		ItemStack chestplate = p.getInventory().getChestplate();
		if(chestplate != null && chestplate.getType() != Material.AIR && chestplate.hasItemMeta() && chestplate.getItemMeta().hasLore()) {
			if(chestplate.getItemMeta().getLore().contains(API.color("&8» &a&lGOBLIN SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWearingGoblinLeggings(Player p){
		ItemStack leggings = p.getInventory().getLeggings();
		if(leggings != null && leggings.getType() != Material.AIR && leggings.hasItemMeta() && leggings.getItemMeta().hasLore()) {
			if(leggings.getItemMeta().getLore().contains(API.color("&8» &a&lGOBLIN SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWearingGoblinBoots(Player p){
		ItemStack boots = p.getInventory().getBoots();
		if(boots != null && boots.getType() != Material.AIR && boots.hasItemMeta() && boots.getItemMeta().hasLore()) {
			if(boots.getItemMeta().getLore().contains(API.color("&8» &a&lGOBLIN SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWearingPheonixSet(Player p) {
		ItemStack helmet = p.getInventory().getHelmet();
		ItemStack chestplate = p.getInventory().getChestplate();
		ItemStack leggings = p.getInventory().getLeggings();
		ItemStack boots = p.getInventory().getBoots();
		boolean helmetPheonix = false;
		boolean chestplatePheonix = false;
		boolean leggingsPheonix = false;
		boolean bootsPheonix = false;		
		if(helmet != null && helmet.getType() != Material.AIR && helmet.hasItemMeta() && helmet.getItemMeta().hasLore()) {
			if(helmet.getItemMeta().getLore().contains(color("&8» &b&lPHEONIX SET PIECE &8«"))) {
				helmetPheonix = true;
			}
		}
		if(chestplate != null && chestplate.getType() != Material.AIR && chestplate.hasItemMeta() && chestplate.getItemMeta().hasLore()) {
			if(chestplate.getItemMeta().getLore().contains(color("&8» &b&lPHEONIX SET PIECE &8«"))) {
				chestplatePheonix = true;
			}
		}
		if(leggings != null && leggings.getType() != Material.AIR && leggings.hasItemMeta() && leggings.getItemMeta().hasLore()) {
			if(leggings.getItemMeta().getLore().contains(color("&8» &b&lPHEONIX SET PIECE &8«"))) {
				leggingsPheonix = true;
			}
		}
		if(boots != null && boots.getType() != Material.AIR && boots.hasItemMeta() && boots.getItemMeta().hasLore()) {
			if(boots.getItemMeta().getLore().contains(color("&8» &b&lPHEONIX SET PIECE &8«"))) {
				bootsPheonix = true;
			}
		}
		if(helmetPheonix && chestplatePheonix && leggingsPheonix && bootsPheonix) {
			return true;
		}
		return false;
	}
	
	public static boolean isWearingPheonixHelmet(Player p){
		ItemStack helmet = p.getInventory().getHelmet();
		if(helmet != null && helmet.getType() != Material.AIR && helmet.hasItemMeta() && helmet.getItemMeta().hasLore()) {
			if(helmet.getItemMeta().getLore().contains(API.color("&8» &b&lPHEONIX SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWearingPheonixChestplate(Player p){
		ItemStack chestplate = p.getInventory().getChestplate();
		if(chestplate != null && chestplate.getType() != Material.AIR && chestplate.hasItemMeta() && chestplate.getItemMeta().hasLore()) {
			if(chestplate.getItemMeta().getLore().contains(API.color("&8» &b&lPHEONIX SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWearingPheonixLeggings(Player p){
		ItemStack leggings = p.getInventory().getLeggings();
		if(leggings != null && leggings.getType() != Material.AIR && leggings.hasItemMeta() && leggings.getItemMeta().hasLore()) {
			if(leggings.getItemMeta().getLore().contains(API.color("&8» &b&lPHEONIX SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWearingPheonixBoots(Player p){
		ItemStack boots = p.getInventory().getBoots();
		if(boots != null && boots.getType() != Material.AIR && boots.hasItemMeta() && boots.getItemMeta().hasLore()) {
			if(boots.getItemMeta().getLore().contains(API.color("&8� &b&lPHEONIX SET PIECE &8«"))) {
				return true;
			}
		}
		return false;
	}
	
	public static void giveEnchant(Player p, Enchant ench, int success, int destroy){
		ItemStack is = new ItemStack(ench.getMaterial(), 1, ench.getData());
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(color(ench.getName()));
		ArrayList<String> lore = new ArrayList<String>();
		ench.setSuccess(success);
		ench.setDestroy(destroy);
		lore.add("");
		lore.add(color("&aSuccess Rate: &7" + ench.getSuccess() + "%"));
		lore.add(color("&cDestroy Rate: &7" + ench.getDestroy() + "%"));
		lore.add("");
		for(String s : ench.getLore()){
			lore.add(color(s));
		}
		lore.add("");
		lore.add(color("&9Enchant Target(s): &7" + ench.getTargets()));
		im.setLore(lore);
        if(Config.enchantmentBookGlowing) {
            im.addEnchant(Enchantment.DURABILITY, 1, true);
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
		is.setItemMeta(im);
		if(p.getInventory().firstEmpty() > -1){
			p.getInventory().addItem(is);
		}
		else{
			p.sendMessage(color("&c&l(!) &cYour inventory was full so the enchantment has been dropped on the ground."));
			p.getWorld().dropItemNaturally(p.getLocation(), is);
		}
	}

    public static void giveEnchantViaBook(Player p, Enchant ench, int success, int destroy){
        ItemStack is = new ItemStack(ench.getMaterial(), 1, ench.getData());
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(color(ench.getName()));
        ArrayList<String> lore = new ArrayList<String>();
        ench.setSuccess(success);
        ench.setDestroy(destroy);
        lore.add("");
        lore.add(color("&aSuccess Rate: &7" + ench.getSuccess() + "%"));
        lore.add(color("&cDestroy Rate: &7" + ench.getDestroy() + "%"));
        lore.add("");
        for(String s : ench.getLore()){
            lore.add(color(s));
        }
        lore.add("");
        lore.add(color("&9Enchant Target(s): &7" + ench.getTargets()));
        im.setLore(lore);
        if(Config.enchantmentBookGlowing) {
            im.addEnchant(Enchantment.DURABILITY, 1, true);
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        is.setItemMeta(im);
        if(p.getInventory().firstEmpty() > -1){
            p.getInventory().addItem(is);
        }
        else{
            p.sendMessage(color("&c&l(!) &cYour inventory was full so the enchantment has been dropped on the ground."));
            p.getWorld().dropItemNaturally(p.getLocation(), is);
        }
        p.sendMessage(API.color("&3&l(!) &7You open the enchantment and receive: " + ench.getColor()
                .replaceAll("green", "")
                .replaceAll("teal", "")
                .replaceAll("yellow", "")
                .replaceAll("red", "")
                .replaceAll("pink", "") + API.removeColor(ench.getName().replaceAll(" Enchant Orb", "").replaceAll("&n&l", "")) + " &8(&7" + ench.getSuccess() + "%&8)"));
    }

	public static ItemStack toItemStack(Enchant ench, int success, int destroy){
		ItemStack is = new ItemStack(ench.getMaterial(), 1, ench.getData());
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(color(ench.getName()));
		ArrayList<String> lore = new ArrayList<String>();
		ench.setSuccess(success);
		ench.setDestroy(destroy);
		lore.add("");
		lore.add(color("&aSuccess Rate: &7" + ench.getSuccess() + "%"));
		lore.add(color("&cDestroy Rate: &7" + ench.getDestroy() + "%"));
		lore.add("");
		for(String s : ench.getLore()){
			lore.add(color(s));
		}
		lore.add("");
		lore.add(color("&9Enchant Target(s): &7" + ench.getTargets()));
		im.setLore(lore);
		if(Config.enchantmentBookGlowing) {
            im.addEnchant(Enchantment.DURABILITY, 1, true);
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
		is.setItemMeta(im);
		return is;
	}

	public static Enchant getEnchant(ItemStack is){
		ArrayList<String> lore = new ArrayList<String>();
		for(String s : is.getItemMeta().getLore()){
			lore.add(s);
		}
		String[] loreArray = lore.toArray(new String[0]);
		String color = color("");
		String pcolor = "";
		String cename = is.getItemMeta().getDisplayName();
        if(cename.startsWith(color("&a&l"))){
            color = color("&a");
            pcolor = "green";
        }
		if(cename.startsWith(color("&b&l"))){
			color = color("&b");
			pcolor = "blue";
		}
        if(cename.startsWith(color("&c&l"))){
            color = color("&c");
            pcolor = "red";
        }
        if(cename.startsWith(color("&d&l"))){
            color = color("&d");
            pcolor = "pink";
        }
        if(cename.startsWith(color("&e&l"))){
            color = color("&e");
            pcolor = "yellow";
        }
        if(cename.startsWith(color("&f&l"))){
            color = color("&f");
            pcolor = "white";
        }
        if(cename.startsWith(color("&1&l"))){
            color = color("&1");
            pcolor = "deepblue";
        }
        if(cename.startsWith(color("&2&l"))){
            color = color("&2");
            pcolor = "darkgreen";
        }
        if(cename.startsWith(color("&3&l"))){
            color = color("&3");
            pcolor = "teal";
        }
        if(cename.startsWith(color("&4&l"))){
            color = color("&4");
            pcolor = "darkred";
        }
        if(cename.startsWith(color("&5&l"))){
            color = color("&5");
            pcolor = "purple";
        }
        if(cename.startsWith(color("&6&l"))){
            color = color("&6");
            pcolor = "orange";
        }
        if(cename.startsWith(color("&7&l"))){
            color = color("&7");
            pcolor = "lightgray";
        }
        if(cename.startsWith(color("&8&l"))){
            color = color("&8");
            pcolor = "darkgray";
        }
		if(cename.startsWith(color("&9&l"))){
			color = color("&9");
			pcolor = "darkblue";
		}
        if(cename.startsWith(color("&0&l"))){
            color = color("&0");
            pcolor = "black";
        }



        if(cename.startsWith(color("&a&n&l"))){
            color = color("&a");
            pcolor = "green";
        }
        if(cename.startsWith(color("&b&n&l"))){
            color = color("&b");
            pcolor = "blue";
        }
        if(cename.startsWith(color("&c&n&l"))){
            color = color("&c");
            pcolor = "red";
        }
        if(cename.startsWith(color("&d&n&l"))){
            color = color("&d");
            pcolor = "pink";
        }
        if(cename.startsWith(color("&e&n&l"))){
            color = color("&e");
            pcolor = "yellow";
        }
        if(cename.startsWith(color("&f&n&l"))){
            color = color("&f");
            pcolor = "white";
        }
        if(cename.startsWith(color("&1&n&l"))){
            color = color("&1");
            pcolor = "deepblue";
        }
        if(cename.startsWith(color("&2&n&l"))){
            color = color("&2");
            pcolor = "darkgreen";
        }
        if(cename.startsWith(color("&3&n&l"))){
            color = color("&3");
            pcolor = "teal";
        }
        if(cename.startsWith(color("&4&n&l"))){
            color = color("&4");
            pcolor = "darkred";
        }
        if(cename.startsWith(color("&5&n&l"))){
            color = color("&5");
            pcolor = "purple";
        }
        if(cename.startsWith(color("&6&n&l"))){
            color = color("&6");
            pcolor = "orange";
        }
        if(cename.startsWith(color("&7&n&l"))){
            color = color("&7");
            pcolor = "lightgray";
        }
        if(cename.startsWith(color("&8&n&l"))){
            color = color("&8");
            pcolor = "darkgray";
        }
        if(cename.startsWith(color("&9&n&l"))){
            color = color("&9");
            pcolor = "darkblue";
        }
        if(cename.startsWith(color("&0&n&l"))){
            color = color("&0");
            pcolor = "black";
        }
		cename = removeColor(cename);
		cename = cename.replaceAll(" Enchant Orb", "");
		cename = color + cename;

		String success = lore.get(1);
		success = removeColor(success);
		success = success.replaceAll("Success Rate: ", "");
		success = success.replaceAll("%", "");

		String destroy = lore.get(2);
		destroy = removeColor(destroy);
		destroy = destroy.replaceAll("Destroy Rate: ", "");
		destroy = destroy.replaceAll("%", "");

		String targets = lore.get(lore.size() - 1);
		removeColor(targets);
		targets = targets.replaceAll("Enchant Targets: ", "");

		Enchant enchant = new Enchant(is.getType(), is.getDurability(), is.getItemMeta().getDisplayName(), loreArray, cename, Integer.parseInt(success), Integer.parseInt(destroy), targets, pcolor);		
		return enchant;
	}

	public static void applyEnchant(ItemStack is, Enchant ench){
		ItemMeta im = is.getItemMeta();
		ArrayList<String> isLore = new ArrayList<String>();
		if(is.getItemMeta().hasLore()){
			isLore.add("");
			for(String s : is.getItemMeta().getLore()){
				isLore.add(color(s));
			}
			String[] enchSplit = ench.getName().split(" ");
			for(int i = 0; i < isLore.size(); i++){
				if(isLore.get(i).contains(removeColor(enchSplit[0]))){
					/*if(API.getEnchantLvl(enchSplit[0], is) < romanNumerals2.get(enchSplit[1])){
						isLore.remove(i);
					}
					else{}*/
					isLore.remove(i);
				}
			}
			isLore.set(0, ench.getApplyLore());
			im.setLore(isLore);
			is.setItemMeta(im);
			return;
		}
		isLore.add(ench.getApplyLore());
		im.setLore(isLore);
		is.setItemMeta(im);
	}

	public static void removeRandomEnchant(ItemStack cursor, ItemStack target, Player p){
		String percentStr = API.removeColor(cursor.getItemMeta().getLore().get(2));
		percentStr = percentStr.replaceAll("into a ", "");
		percentStr = percentStr.replaceAll("% enchantment orb.", "");
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
		enchRemove = removeColor(enchRemove);
		if(enchRemove.contains(color("PROTECTED"))){
			p.sendMessage("1");
			if(target.getItemMeta().getLore().size() == 1){
				p.sendMessage("2");
				return;
			}
			removeRandomEnchant(cursor, target, p);
			p.sendMessage("3");
			return;
		}
		if(dischargeEnchants.containsKey(enchRemove)){
			giveEnchant(p, dischargeEnchants.get(enchRemove), percent, 100);
			ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(45, 43, 43);
			for(int i = 0; i < 300; i++){
				ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
			}
			p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1, 2);
			
			targetLore.remove(enchRemoveLine);
			tm.setLore(targetLore);
			target.setItemMeta(tm);
			targetLore.clear();
			return;
		}
		return;
	}
	
	public static boolean containsEnchants(ItemStack target){
		for(String s : target.getItemMeta().getLore()){
			if(s.endsWith("I") || s.endsWith("V") || s.endsWith("X")){
				return true;
			}
		}
		return false;
	}

	
	public static void playRainbowParticle(Player p){
		/*for(int i = 0; i < 400; i++){
			p.playEffect(p.getLocation().add(API.randDouble(-0.2, 0.2), API.randDouble(0, 2), API.randDouble(-0.2, 0.2)), Effect.POTION_SWIRL, 20D);
		}*/
		ParticleEffect.ParticleColor blue = new ParticleEffect.OrdinaryColor(66, 232, 244);
		for(int i = 0; i < 100; i++){
			ParticleEffect.REDSTONE.display(blue, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
		}
		ParticleEffect.ParticleColor dblue = new ParticleEffect.OrdinaryColor(58, 116, 232);
		for(int i = 0; i < 100; i++){
			ParticleEffect.REDSTONE.display(dblue, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
		}
		ParticleEffect.ParticleColor yellow = new ParticleEffect.OrdinaryColor(228, 255, 56);
		for(int i = 0; i < 100; i++){
			ParticleEffect.REDSTONE.display(yellow, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
		}
		ParticleEffect.ParticleColor red = new ParticleEffect.OrdinaryColor(255, 79, 79);
		for(int i = 0; i < 100; i++){
			ParticleEffect.REDSTONE.display(red, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
		}
		ParticleEffect.ParticleColor pink = new ParticleEffect.OrdinaryColor(244, 66, 220);
		for(int i = 0; i < 100; i++){
			ParticleEffect.REDSTONE.display(pink, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
		}
	}
	
	public static void playCandyParticle(Player p){
		/*for(int i = 0; i < 400; i++){
			p.playEffect(p.getLocation().add(API.randDouble(-0.2, 0.2), API.randDouble(0, 2), API.randDouble(-0.2, 0.2)), Effect.POTION_SWIRL, 20D);
		}*/
		ParticleEffect.ParticleColor orange = new ParticleEffect.OrdinaryColor(252, 154, 17);
		for(int i = 0; i < 100; i++){
			ParticleEffect.REDSTONE.display(orange , p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
		}
		ParticleEffect.ParticleColor purple = new ParticleEffect.OrdinaryColor(138, 16, 252);
		for(int i = 0; i < 100; i++){
			ParticleEffect.REDSTONE.display(purple, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
		}
		ParticleEffect.ParticleColor green = new ParticleEffect.OrdinaryColor(17, 255, 61);
		for(int i = 0; i < 100; i++){
			ParticleEffect.REDSTONE.display(green, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
		}
		ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(0, 0, 0);
		for(int i = 0; i < 100; i++){
			ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
		}
		ParticleEffect.ParticleColor gray = new ParticleEffect.OrdinaryColor(81, 81, 81);
		for(int i = 0; i < 100; i++){
			ParticleEffect.REDSTONE.display(gray, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
		}
	}

	public static void playColorParticle(Player p, String color){
		color = color.toLowerCase();
		switch(color){
		case "blue":
			ParticleEffect.ParticleColor blue = new ParticleEffect.OrdinaryColor(66, 232, 244);
			for(int i = 0; i < 500; i++){
				ParticleEffect.REDSTONE.display(blue, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
			}
			break;	
		case "darkblue":
			ParticleEffect.ParticleColor dblue = new ParticleEffect.OrdinaryColor(58, 116, 232);
			for(int i = 0; i < 500; i++){
				ParticleEffect.REDSTONE.display(dblue, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
			}
			break;
		case "green":
			ParticleEffect.ParticleColor green = new ParticleEffect.OrdinaryColor(0, 211, 21);
			for(int i = 0; i < 500; i++){
				ParticleEffect.REDSTONE.display(green, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
			}
			break;
		case "yellow":
			ParticleEffect.ParticleColor yellow = new ParticleEffect.OrdinaryColor(228, 255, 56);
			for(int i = 0; i < 500; i++){
				ParticleEffect.REDSTONE.display(yellow, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
			}
			break;
		case "orange":
			ParticleEffect.ParticleColor orange = new ParticleEffect.OrdinaryColor(255, 148, 0);
			for(int i = 0; i < 500; i++){
				ParticleEffect.REDSTONE.display(orange, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
			}
			break;
		case "red":
			ParticleEffect.ParticleColor red = new ParticleEffect.OrdinaryColor(255, 79, 79);
			for(int i = 0; i < 500; i++){
				ParticleEffect.REDSTONE.display(red, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
			}
			break;
		case "pink":
			ParticleEffect.ParticleColor pink = new ParticleEffect.OrdinaryColor(244, 66, 220);
			for(int i = 0; i < 500; i++){
				ParticleEffect.REDSTONE.display(pink, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
			}
			break;
            case "deepblue":
                ParticleEffect.ParticleColor deepblue = new ParticleEffect.OrdinaryColor(0, 12, 249);
                for(int i = 0; i < 500; i++){
                    ParticleEffect.REDSTONE.display(deepblue, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
                }
                break;
            case "darkgreen":
                ParticleEffect.ParticleColor darkgreen = new ParticleEffect.OrdinaryColor(0, 142, 35);
                for(int i = 0; i < 500; i++){
                    ParticleEffect.REDSTONE.display(darkgreen, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
                }
                break;
            case "teal":
                ParticleEffect.ParticleColor teal = new ParticleEffect.OrdinaryColor(0, 134, 142);
                for(int i = 0; i < 500; i++){
                    ParticleEffect.REDSTONE.display(teal, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
                }
                break;
            case "darkred":
                ParticleEffect.ParticleColor darkred = new ParticleEffect.OrdinaryColor(155, 0, 0);
                for(int i = 0; i < 500; i++){
                    ParticleEffect.REDSTONE.display(darkred, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
                }
                break;
            case "purple":
                ParticleEffect.ParticleColor purple = new ParticleEffect.OrdinaryColor(80, 0, 255);
                for(int i = 0; i < 500; i++){
                    ParticleEffect.REDSTONE.display(purple, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
                }
                break;
            case "lightgray":
                ParticleEffect.ParticleColor lightgray = new ParticleEffect.OrdinaryColor(145, 145, 145);
                for(int i = 0; i < 500; i++){
                    ParticleEffect.REDSTONE.display(lightgray, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
                }
                break;
            case "darkgray":
                ParticleEffect.ParticleColor darkgray = new ParticleEffect.OrdinaryColor(76, 76, 76);
                for(int i = 0; i < 500; i++){
                    ParticleEffect.REDSTONE.display(darkgray, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
                }
                break;
            case "black":
                ParticleEffect.ParticleColor black = new ParticleEffect.OrdinaryColor(0,0,0);
                for(int i = 0; i < 500; i++){
                    ParticleEffect.REDSTONE.display(black, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
                }
                break;
             case "white":
                ParticleEffect.ParticleColor white = new ParticleEffect.OrdinaryColor(255, 255, 255);
                for(int i = 0; i < 500; i++){
                    ParticleEffect.REDSTONE.display(white, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
                }
                break;
		default:
			ParticleEffect.ParticleColor none = new ParticleEffect.OrdinaryColor(255, 255, 255);
			for(int i = 0; i < 500; i++){
				ParticleEffect.REDSTONE.display(none, p.getLocation().add(API.randDouble(-0.6, 0.6), API.randDouble(0, 2.2), API.randDouble(-0.6, 0.6)), 20D);
			}
			break;

		}
	}


	public static int totalEnchantCount;
	public static int basicEnchantCount;
	public static int advancedEnchantCount;
	public static int epicEnchantCount;
	public static int legendaryEnchantCount;
	public static int ancientEnchantCount;


	public static void loadEnchants(){
		enchants.put("venomI", Books.venomI);
		enchants.put("venomII", Books.venomII);
		enchants.put("venomIII", Books.venomIII);
		enchants.put("blackoutI", Books.blackoutI);
		enchants.put("blackoutII", Books.blackoutII);
		enchants.put("blackoutIII", Books.blackoutIII);
		enchants.put("hasteI", Books.hasteI);
		enchants.put("hasteII", Books.hasteII);
		enchants.put("hasteIII", Books.hasteIII);
		enchants.put("ravenousI", Books.ravenousI);
		enchants.put("ravenousII", Books.ravenousII);
		enchants.put("ravenousIII", Books.ravenousIII);
		enchants.put("ravenousIV", Books.ravenousIV);
		enchants.put("ravenousV", Books.ravenousV);
		enchants.put("explosiveI", Books.explosiveI);
		enchants.put("explosiveII", Books.explosiveII);
		enchants.put("explosiveIII", Books.explosiveIII);
		enchants.put("explosiveIV", Books.explosiveIV);
		enchants.put("furnaceI", Books.furnaceI);
		enchants.put("furnaceII", Books.furnaceII);
		enchants.put("furnaceIII", Books.furnaceIII);
		enchants.put("glowingI", Books.glowingI);
		enchants.put("diverI", Books.diverI);
		enchants.put("saturatedI", Books.saturatedI);
		enchants.put("saturatedII", Books.saturatedII);
		enchants.put("saturatedIII", Books.saturatedIII);
		enchants.put("flashbackI", Books.flashbackI);
		enchants.put("flashbackII", Books.flashbackII);
		enchants.put("flashbackIII", Books.flashbackIII);
		enchants.put("flashbackIV", Books.flashbackIV);
		enchants.put("flashbackV", Books.flashbackV);
		enchants.put("flashbackVI", Books.flashbackVI);
		enchants.put("flashbackVII", Books.flashbackVII);
		enchants.put("flashbackVIII", Books.flashbackVIII);
		enchants.put("frozenI", Books.frozenI);
		enchants.put("frozenII", Books.frozenII);
		enchants.put("frozenIII", Books.frozenIII);
		enchants.put("bulletproofI", Books.bulletproofI);
		enchants.put("bulletproofII", Books.bulletproofII);
		enchants.put("bulletproofIII", Books.bulletproofIII);
		enchants.put("bulletproofIV", Books.bulletproofIV);
		enchants.put("ghastI", Books.ghastI);
		enchants.put("ghastII", Books.ghastII);
		enchants.put("ghastIII", Books.ghastIII);
		enchants.put("scavengerI", Books.scavengerI);
		enchants.put("scavengerII", Books.scavengerII);
		enchants.put("scavengerIII", Books.scavengerIII);
		enchants.put("scavengerIV", Books.scavengerIV);
		enchants.put("scavengerV", Books.scavengerV);
		enchants.put("witherI", Books.witherI);
		enchants.put("witherII", Books.witherII);
		enchants.put("witherIII", Books.witherIII);
		enchants.put("witherIV", Books.witherIV);
		enchants.put("witherV", Books.witherV);
		enchants.put("pineappleI", Books.pineappleI);
		enchants.put("pineappleII", Books.pineappleII);
		enchants.put("voltageI", Books.voltageI);
		enchants.put("voltageII", Books.voltageII);
		enchants.put("voltageIII", Books.voltageIII);
		enchants.put("agilityI", Books.agilityI);
		enchants.put("agilityII", Books.agilityII);
		enchants.put("agilityIII", Books.agilityIII);
		enchants.put("agilityIV", Books.agilityIV);

		enchants.put("shockI", Books.shockI);
		enchants.put("shockII", Books.shockII);
		enchants.put("shockIII", Books.shockIII);
		enchants.put("shockIV", Books.shockIV);
		enchants.put("shockV", Books.shockV);
		enchants.put("replenishI", Books.replenishI);
		enchants.put("replenishII", Books.replenishII);
		enchants.put("obsidiandestroyerI", Books.obsidiandestroyerI);
		enchants.put("obsidiandestroyerII", Books.obsidiandestroyerII);
		enchants.put("obsidiandestroyerIII", Books.obsidiandestroyerIII);
		enchants.put("obsidiandestroyerIV", Books.obsidiandestroyerIV);
		enchants.put("obsidiandestroyerV", Books.obsidiandestroyerV);
		enchants.put("springsI", Books.springsI);
		enchants.put("springsII", Books.springsII);
		enchants.put("springsIII", Books.springsIII);
		enchants.put("confusionI", Books.confusionI);
		enchants.put("confusionII", Books.confusionII);
		enchants.put("confusionIII", Books.confusionIII);
		enchants.put("confusionIV", Books.confusionIV);
		enchants.put("confusionV", Books.confusionV);
		enchants.put("radioactiveI", Books.radioactiveI);
		enchants.put("radioactiveII", Books.radioactiveII);
		enchants.put("radioactiveIII", Books.radioactiveIII);
		enchants.put("selfdestructI", Books.selfdestructI);
		enchants.put("selfdestructII", Books.selfdestructII);
		enchants.put("selfdestructIII", Books.selfdestructIII);
		enchants.put("selfdestructI", Books.selfdestructI);
		enchants.put("creeperI", Books.creeperI);
		enchants.put("creeperII", Books.creeperII);
		enchants.put("creeperIII", Books.creeperIII);
		enchants.put("shieldI", Books.shieldI);
		enchants.put("shieldII", Books.shieldII);
		enchants.put("shieldIII", Books.shieldIII);
		enchants.put("shieldIV", Books.shieldIV);
		enchants.put("ninjaI", Books.ninjaI);
		enchants.put("marshmallowI", Books.marshmallowI);
		enchants.put("marshmallowII", Books.marshmallowII);
		enchants.put("marshmallowIII", Books.marshmallowIII);
		enchants.put("marshmallowIV", Books.marshmallowIV);
		enchants.put("marshmallowV", Books.marshmallowV);
		enchants.put("thiefI", Books.thiefI);
		enchants.put("thiefII", Books.thiefII);
		enchants.put("thiefIII", Books.thiefIII);
		enchants.put("counterI", Books.counterI);
		enchants.put("counterII", Books.counterII);
		enchants.put("counterIII", Books.counterIII);
		enchants.put("woundI", Books.woundI);
		enchants.put("woundII", Books.woundII);
		enchants.put("woundIII", Books.woundIII);
		enchants.put("woundIV", Books.woundIV);
		enchants.put("safeguardI", Books.safeguardI);
		enchants.put("safeguardII", Books.safeguardII);
		enchants.put("safeguardIII", Books.safeguardIII);
		enchants.put("safeguardIV", Books.safeguardIV);
		enchants.put("safeguardV", Books.safeguardV);
		enchants.put("safeguardVI", Books.safeguardVI);
		enchants.put("safeguardVII", Books.safeguardVII);
		enchants.put("safeguardVIII", Books.safeguardVIII);
		enchants.put("safeguardIX", Books.safeguardIX);
		enchants.put("safeguardX", Books.safeguardX);
		enchants.put("pushI", Books.pushI);
		enchants.put("pushII", Books.pushII);
		enchants.put("virusI", Books.virusI);
		enchants.put("virusII", Books.virusII);
		enchants.put("virusIII", Books.virusIII);
		enchants.put("minerI", Books.minerI);
		enchants.put("minerII", Books.minerII);
		enchants.put("minerIII", Books.minerIII);
		enchants.put("minerIV", Books.minerIV);
		enchants.put("minerV", Books.minerV);
		enchants.put("blazeI", Books.blazeI);
		enchants.put("wormholeI", Books.wormholeI);
		enchants.put("wormholeII", Books.wormholeII);
		enchants.put("wormholeIII", Books.wormholeIII);
		enchants.put("fractureI", Books.fractureI);
		enchants.put("fractureII", Books.fractureII);
		enchants.put("fractureIII", Books.fractureIII);
		enchants.put("fractureIV", Books.fractureIV);


		enchants.put("chickenI", Books.chickenI);
		enchants.put("chickenII", Books.chickenII);
		enchants.put("chickenIII", Books.chickenIII);
		enchants.put("punctureI", Books.punctureI);
		enchants.put("punctureII", Books.punctureII);
		enchants.put("punctureIII", Books.punctureIII);
		enchants.put("punctureIV", Books.punctureIV);
		enchants.put("overloadI", Books.overloadI);
		enchants.put("overloadII", Books.overloadII);
		enchants.put("overloadIII", Books.overloadIII);
		enchants.put("blessedI", Books.blessedI);
		enchants.put("blessedII", Books.blessedII);
		enchants.put("blessedIII", Books.blessedIII);
		enchants.put("angelI", Books.angelI);
		enchants.put("angelII", Books.angelII);
		enchants.put("angelIII", Books.angelIII);
		enchants.put("trophyI", Books.trophyI);
		enchants.put("trophyII", Books.trophyII);
		enchants.put("trophyIII", Books.trophyIII);
		enchants.put("flashbangI", Books.flashbangI);
		enchants.put("flashbangII", Books.flashbangII);
		enchants.put("flashbangIII", Books.flashbangIII);
		enchants.put("flashbangIV", Books.flashbangIV);
		enchants.put("flashbangV", Books.flashbangV);
		enchants.put("flashbangVI", Books.flashbangVI);
		enchants.put("flashbangVII", Books.flashbangVII);
		enchants.put("flashbangVIII", Books.flashbangVIII);
		enchants.put("archerI", Books.archerI);
		enchants.put("archerII", Books.archerII);
		enchants.put("archerIII", Books.archerIII);
		enchants.put("spectralI", Books.spectralI);
		enchants.put("spectralII", Books.spectralII);
		enchants.put("spectralIII", Books.spectralIII);
		enchants.put("bruteI", Books.bruteI);
		enchants.put("bruteII", Books.bruteII);
		enchants.put("bruteIII", Books.bruteIII);
		enchants.put("bruteIV", Books.bruteIV);
		enchants.put("vestI", Books.vestI);
		enchants.put("vestII", Books.vestII);
		enchants.put("vestIII", Books.vestIII);
		enchants.put("vestIV", Books.vestIV);
		enchants.put("overdoseI", Books.overdoseI);
		enchants.put("overdoseII", Books.overdoseII);
		enchants.put("overdoseIII", Books.overdoseIII);
		enchants.put("muffleI", Books.muffleI);
		enchants.put("muffleII", Books.muffleII);
		enchants.put("muffleIII", Books.muffleIII);
		enchants.put("muffleIV", Books.muffleIV);
		enchants.put("luckyI", Books.luckyI);
		enchants.put("luckyII", Books.luckyII);
		enchants.put("luckyIII", Books.luckyIII);
		enchants.put("luckyIV", Books.luckyIV);
		enchants.put("luckyV", Books.luckyV);
		enchants.put("luckyVI", Books.luckyVII);
		enchants.put("luckyVII", Books.luckyVII);
		enchants.put("luckyVIII", Books.luckyVIII);
		enchants.put("luckyIX", Books.luckyIX);
		enchants.put("luckyX", Books.luckyX);
		enchants.put("pyroI", Books.pyroI);
		enchants.put("pyroII", Books.pyroII);
		enchants.put("pyroIII", Books.pyroIII);
		enchants.put("snareI", Books.snareI);
		enchants.put("snareII", Books.snareII);
		enchants.put("snareIII", Books.snareIII);
		//enchants.put("collectionI", Books.collectionI);
		//enchants.put("collectionII", Books.collectionII);
		//enchants.put("collectionIII", Books.collectionIII);


		enchants.put("juggernautI", Books.juggernautI);
		enchants.put("juggernautII", Books.juggernautII);
		enchants.put("juggernautIII", Books.juggernautIII);
		enchants.put("juggernautIV", Books.juggernautIV);
		enchants.put("greedI", Books.greedI);
		enchants.put("greedII", Books.greedII);
		enchants.put("greedIII", Books.greedIII);
		enchants.put("greedIV", Books.greedIV);
		enchants.put("lifestealI", Books.lifestealI);
		enchants.put("lifestealII", Books.lifestealII);
		enchants.put("lifestealIII", Books.lifestealIII);
		enchants.put("lifestealIV", Books.lifestealIV);
		enchants.put("lifestealV", Books.lifestealV);
		enchants.put("rageI", Books.rageI);
		enchants.put("rageII", Books.rageII);
		enchants.put("rageIII", Books.rageIII);
		enchants.put("rageIV", Books.rageIV);
		enchants.put("rageV", Books.rageV);
		enchants.put("rageVI", Books.rageVI);
		enchants.put("meteorI", Books.meteorI);
		enchants.put("meteorII", Books.meteorII);
		enchants.put("meteorIII", Books.meteorIII);
		enchants.put("meteorIV", Books.meteorIV);
		enchants.put("meteorV", Books.meteorV);
		enchants.put("meteorVI", Books.meteorVI);
		enchants.put("meteorVII", Books.meteorVII);
		enchants.put("meteorVIII", Books.meteorVIII);
		enchants.put("meteorIX", Books.meteorIX);
		enchants.put("meteorX", Books.meteorX);
		enchants.put("auraI", Books.auraI);
		enchants.put("auraII", Books.auraII);
		enchants.put("auraIII", Books.auraIII);
		enchants.put("auraIV", Books.auraIV);
		enchants.put("auraV", Books.auraV);
		enchants.put("immolationI", Books.immolationI);
		enchants.put("immolationII", Books.immolationII);
		enchants.put("immolationIII", Books.immolationIII);
		enchants.put("immolationIV", Books.immolationIV);
		enchants.put("barbarianI", Books.barbarianI);
		enchants.put("barbarianII", Books.barbarianII);
		enchants.put("barbarianIII", Books.barbarianIII);
		enchants.put("barbarianIV", Books.barbarianIV);
		enchants.put("enrageI", Books.enrageI);
		enchants.put("enrageII", Books.enrageII);
		enchants.put("enrageIII", Books.enrageIII);
		enchants.put("lifelineI", Books.lifelineI);
		enchants.put("lifelineII", Books.lifelineII);
		enchants.put("lifelineIII", Books.lifelineIII);
		enchants.put("hyperI", Books.hyperI);
		enchants.put("hyperII", Books.hyperII);
		enchants.put("hyperIII", Books.hyperIII);
		enchants.put("jetpackI", Books.jetpackI);
		enchants.put("jetpackII", Books.jetpackII);
		enchants.put("jetpackIII", Books.jetpackIII);
		enchants.put("reinforcedI", Books.reinforcedI);
		enchants.put("reinforcedII", Books.reinforcedII);
		enchants.put("reinforcedIII", Books.reinforcedIII);
		enchants.put("adrenalineI", Books.adrenalineI);
		enchants.put("adrenalineII", Books.adrenalineII);
		enchants.put("adrenalineIII", Books.adrenalineIII);
		enchants.put("adrenalineIV", Books.adrenalineIV);
		enchants.put("eyepatchI", Books.eyepatchI);
		enchants.put("eyepatchII", Books.eyepatchII);
		enchants.put("eyepatchIII", Books.eyepatchIII);
		enchants.put("bloodthirstyI", Books.bloodthirstyI);
		enchants.put("bloodthirstyII", Books.bloodthirstyII);
		enchants.put("bloodthirstyIII", Books.bloodthirstyIII);

		enchants.put("butcherI", Books.butcherI);
		enchants.put("butcherII", Books.butcherII);
		enchants.put("butcherIII", Books.butcherIII);
		enchants.put("butcherIV", Books.butcherIV);
		enchants.put("anvilI", Books.anvilI);
		enchants.put("anvilII", Books.anvilII);
		enchants.put("anvilIII", Books.anvilIII);

	}

	public static void loadNumberedEnchants(){
		basic_enchants.put(1, Books.venomI);
		basic_enchants.put(2, Books.venomII);
		basic_enchants.put(3, Books.venomIII);
		basic_enchants.put(4, Books.blackoutI);
		basic_enchants.put(5, Books.blackoutII);
		basic_enchants.put(6, Books.blackoutIII);
		basic_enchants.put(7, Books.hasteI);
		basic_enchants.put(8, Books.hasteII);
		basic_enchants.put(9, Books.hasteIII);
		basic_enchants.put(10, Books.ravenousI);
		basic_enchants.put(11, Books.ravenousII);
		basic_enchants.put(12, Books.ravenousIII);
		basic_enchants.put(13, Books.ravenousIV);
		basic_enchants.put(14, Books.ravenousV);
		basic_enchants.put(15, Books.explosiveI);
		basic_enchants.put(16, Books.explosiveII);
		basic_enchants.put(17, Books.explosiveIII);
		basic_enchants.put(18, Books.explosiveIV);
		basic_enchants.put(19, Books.furnaceI);
		basic_enchants.put(20, Books.furnaceII);
		basic_enchants.put(21, Books.furnaceIII);
		basic_enchants.put(22, Books.glowingI);
		basic_enchants.put(23, Books.diverI);
		basic_enchants.put(24, Books.saturatedI);
		basic_enchants.put(25, Books.saturatedII);
		basic_enchants.put(26, Books.saturatedIII);
		basic_enchants.put(27, Books.flashbackI);
		basic_enchants.put(28, Books.flashbackII);
		basic_enchants.put(29, Books.flashbackIII);
		basic_enchants.put(30, Books.flashbackIV);
		basic_enchants.put(31, Books.flashbackV);
		basic_enchants.put(32, Books.flashbackVI);
		basic_enchants.put(33, Books.flashbackVII);
		basic_enchants.put(34, Books.flashbackVIII);
		basic_enchants.put(35, Books.frozenI);
		basic_enchants.put(36, Books.frozenII);
		basic_enchants.put(37, Books.frozenIII);
		basic_enchants.put(38, Books.bulletproofI);
		basic_enchants.put(39, Books.bulletproofII);
		basic_enchants.put(40, Books.bulletproofIII);
		basic_enchants.put(41, Books.bulletproofIV);
		basic_enchants.put(42, Books.ghastI);
		basic_enchants.put(43, Books.ghastII);
		basic_enchants.put(44, Books.ghastIII);
		basic_enchants.put(45, Books.scavengerI);
		basic_enchants.put(46, Books.scavengerII);
		basic_enchants.put(47, Books.scavengerIII);
		basic_enchants.put(48, Books.scavengerIV);
		basic_enchants.put(49, Books.scavengerV);
		basic_enchants.put(50, Books.witherI);
		basic_enchants.put(51, Books.witherII);
		basic_enchants.put(52, Books.witherIII);
		basic_enchants.put(53, Books.witherIV);
		basic_enchants.put(54, Books.witherV);
		basic_enchants.put(55, Books.pineappleI);
		basic_enchants.put(56, Books.pineappleII);
		basic_enchants.put(57, Books.voltageI);
		basic_enchants.put(58, Books.voltageII);
		basic_enchants.put(59, Books.voltageIII);
		basic_enchants.put(60, Books.agilityI);
		basic_enchants.put(61, Books.agilityII);
		basic_enchants.put(62, Books.agilityIII);
		basic_enchants.put(63, Books.agilityIV);

		basicEnchantCount = basic_enchants.size();
		Bukkit.getLogger().info("Loaded " + basicEnchantCount + " Basic Enchantments");

		advanced_enchants.put(1, Books.shockI);
		advanced_enchants.put(2, Books.shockII);
		advanced_enchants.put(3, Books.shockIII);
		advanced_enchants.put(4, Books.shockIV);
		advanced_enchants.put(5, Books.shockV);
		advanced_enchants.put(6, Books.replenishI);
		advanced_enchants.put(7, Books.replenishII);
		advanced_enchants.put(8, Books.obsidiandestroyerI);
		advanced_enchants.put(9, Books.obsidiandestroyerII);
		advanced_enchants.put(10, Books.obsidiandestroyerIII);
		advanced_enchants.put(11, Books.obsidiandestroyerIV);
		advanced_enchants.put(12, Books.obsidiandestroyerV);
		advanced_enchants.put(13, Books.springsI);
		advanced_enchants.put(14, Books.springsII);
		advanced_enchants.put(15, Books.springsIII);
		advanced_enchants.put(16, Books.confusionI);
		advanced_enchants.put(17, Books.confusionII);
		advanced_enchants.put(18, Books.confusionIII);
		advanced_enchants.put(19, Books.confusionIV);
		advanced_enchants.put(20, Books.confusionV);
		advanced_enchants.put(21, Books.radioactiveI);
		advanced_enchants.put(22, Books.radioactiveII);
		advanced_enchants.put(23, Books.radioactiveIII);
		advanced_enchants.put(24, Books.selfdestructI);
		advanced_enchants.put(25, Books.selfdestructII);
		advanced_enchants.put(26, Books.selfdestructIII);
		advanced_enchants.put(27, Books.selfdestructI);
		advanced_enchants.put(28, Books.creeperI);
		advanced_enchants.put(29, Books.creeperII);
		advanced_enchants.put(30, Books.creeperIII);
		advanced_enchants.put(31, Books.shieldI);
		advanced_enchants.put(32, Books.shieldII);
		advanced_enchants.put(33, Books.shieldIII);
		advanced_enchants.put(34, Books.shieldIV);
		advanced_enchants.put(35, Books.ninjaI);
		advanced_enchants.put(36, Books.marshmallowI);
		advanced_enchants.put(37, Books.marshmallowII);
		advanced_enchants.put(38, Books.marshmallowIII);
		advanced_enchants.put(39, Books.marshmallowIV);
		advanced_enchants.put(40, Books.marshmallowV);
		advanced_enchants.put(41, Books.thiefI);
		advanced_enchants.put(42, Books.thiefII);
		advanced_enchants.put(43, Books.thiefIII);
		advanced_enchants.put(44, Books.counterI);
		advanced_enchants.put(45, Books.counterII);
		advanced_enchants.put(46, Books.counterIII);
		advanced_enchants.put(47, Books.woundI);
		advanced_enchants.put(48, Books.woundII);
		advanced_enchants.put(49, Books.woundIII);
		advanced_enchants.put(50, Books.woundIV);
		advanced_enchants.put(51, Books.safeguardI);
		advanced_enchants.put(52, Books.safeguardII);
		advanced_enchants.put(53, Books.safeguardIII);
		advanced_enchants.put(54, Books.safeguardIV);
		advanced_enchants.put(55, Books.safeguardV);
		advanced_enchants.put(56, Books.safeguardVI);
		advanced_enchants.put(57, Books.safeguardVII);
		advanced_enchants.put(58, Books.safeguardVIII);
		advanced_enchants.put(59, Books.safeguardIX);
		advanced_enchants.put(60, Books.safeguardX);
		advanced_enchants.put(61, Books.pushI);
		advanced_enchants.put(62, Books.pushII);
		advanced_enchants.put(63, Books.virusI);
		advanced_enchants.put(64, Books.virusII);
		advanced_enchants.put(65, Books.virusIII);
		advanced_enchants.put(66, Books.minerI);
		advanced_enchants.put(67, Books.minerII);
		advanced_enchants.put(68, Books.minerIII);
		advanced_enchants.put(69, Books.minerIV);
		advanced_enchants.put(70, Books.minerV);
		advanced_enchants.put(71, Books.blazeI);
		advanced_enchants.put(72, Books.wormholeI);
		advanced_enchants.put(73, Books.wormholeII);
		advanced_enchants.put(74, Books.wormholeIII);
		advanced_enchants.put(75, Books.fractureI);
		advanced_enchants.put(76, Books.fractureII);
		advanced_enchants.put(77, Books.fractureIII);
		advanced_enchants.put(78, Books.fractureIV);

		advancedEnchantCount = advanced_enchants.size();
		Bukkit.getLogger().info("Loaded " + advancedEnchantCount + " Advanced Enchantments");

		epic_enchants.put(1, Books.chickenI);
		epic_enchants.put(2, Books.chickenII);
		epic_enchants.put(3, Books.chickenIII);
		epic_enchants.put(4, Books.punctureI);
		epic_enchants.put(5, Books.punctureII);
		epic_enchants.put(6, Books.punctureIII);
		epic_enchants.put(7, Books.punctureIV);
		epic_enchants.put(8, Books.overloadI);
		epic_enchants.put(9, Books.overloadII);
		epic_enchants.put(10, Books.overloadIII);
		epic_enchants.put(11, Books.blessedI);
		epic_enchants.put(12, Books.blessedII);
		epic_enchants.put(13, Books.blessedIII);
		epic_enchants.put(14, Books.angelI);
		epic_enchants.put(15, Books.angelII);
		epic_enchants.put(16, Books.angelIII);
		epic_enchants.put(17, Books.trophyI);
		epic_enchants.put(18, Books.trophyII);
		epic_enchants.put(19, Books.trophyIII);
		epic_enchants.put(20, Books.flashbangI);
		epic_enchants.put(21, Books.flashbangII);
		epic_enchants.put(22, Books.flashbangIII);
		epic_enchants.put(23, Books.flashbangIV);
		epic_enchants.put(24, Books.flashbangV);
		epic_enchants.put(25, Books.flashbangVI);
		epic_enchants.put(26, Books.flashbangVII);
		epic_enchants.put(27, Books.flashbangVIII);
		epic_enchants.put(28, Books.archerI);
		epic_enchants.put(29, Books.archerII);
		epic_enchants.put(30, Books.archerIII);
		epic_enchants.put(31, Books.spectralI);
		epic_enchants.put(32, Books.spectralII);
		epic_enchants.put(33, Books.spectralIII);
		epic_enchants.put(34, Books.bruteI);
		epic_enchants.put(35, Books.bruteII);
		epic_enchants.put(36, Books.bruteIII);
		epic_enchants.put(37, Books.bruteIV);
		epic_enchants.put(38, Books.vestI);
		epic_enchants.put(39, Books.vestII);
		epic_enchants.put(40, Books.vestIII);
		epic_enchants.put(41, Books.vestIV);
		epic_enchants.put(42, Books.overdoseI);
		epic_enchants.put(43, Books.overdoseII);
		epic_enchants.put(44, Books.overdoseIII);
		epic_enchants.put(45, Books.muffleI);
		epic_enchants.put(46, Books.muffleII);
		epic_enchants.put(47, Books.muffleIII);
		epic_enchants.put(48, Books.muffleIV);
		epic_enchants.put(49, Books.pyroI);
		epic_enchants.put(50, Books.pyroII);
		epic_enchants.put(51, Books.pyroIII);
		epic_enchants.put(52, Books.luckyI);
		epic_enchants.put(53, Books.luckyII);
		epic_enchants.put(54, Books.luckyIII);
		epic_enchants.put(55, Books.luckyIV);
		epic_enchants.put(56, Books.luckyV);
		epic_enchants.put(57, Books.luckyVI);
		epic_enchants.put(58, Books.luckyVII);
		epic_enchants.put(59, Books.luckyVIII);
		epic_enchants.put(60, Books.luckyIX);
		epic_enchants.put(61, Books.luckyX);
		epic_enchants.put(62, Books.snareI);
		epic_enchants.put(63, Books.snareII);
		epic_enchants.put(64, Books.snareIII);
		//epic_enchants.put(34, Books.collectionI);
		//epic_enchants.put(35, Books.collectionII);
		//epic_enchants.put(36, Books.collectionIII);

		epicEnchantCount = epic_enchants.size();
		Bukkit.getLogger().info("Loaded " + epicEnchantCount + " Epic Enchantments");

		legendary_enchants.put(1, Books.juggernautI);
		legendary_enchants.put(2, Books.juggernautII);
		legendary_enchants.put(3, Books.juggernautIII);
		legendary_enchants.put(4, Books.juggernautIV);
		legendary_enchants.put(5, Books.greedI);
		legendary_enchants.put(6, Books.greedII);
		legendary_enchants.put(7, Books.greedIII);
		legendary_enchants.put(8, Books.greedIV);
		legendary_enchants.put(9, Books.lifestealI);
		legendary_enchants.put(10, Books.lifestealII);
		legendary_enchants.put(11, Books.lifestealIII);
		legendary_enchants.put(12, Books.lifestealIV);
		legendary_enchants.put(13, Books.lifestealV);
		legendary_enchants.put(14, Books.meteorI);
		legendary_enchants.put(15, Books.meteorII);
		legendary_enchants.put(16, Books.meteorIII);
		legendary_enchants.put(17, Books.meteorIV);
		legendary_enchants.put(18, Books.meteorV);
		legendary_enchants.put(19, Books.meteorVI);
		legendary_enchants.put(20, Books.meteorVII);
		legendary_enchants.put(21, Books.meteorVIII);
		legendary_enchants.put(22, Books.meteorIX);
		legendary_enchants.put(23, Books.meteorX);
		legendary_enchants.put(24, Books.auraI);
		legendary_enchants.put(25, Books.auraII);
		legendary_enchants.put(26, Books.auraIII);
		legendary_enchants.put(27, Books.auraIV);
		legendary_enchants.put(28, Books.auraV);
		legendary_enchants.put(29, Books.immolationI);
		legendary_enchants.put(30, Books.immolationII);
		legendary_enchants.put(31, Books.immolationIII);
		legendary_enchants.put(32, Books.immolationIV);
		legendary_enchants.put(33, Books.barbarianI);
		legendary_enchants.put(34, Books.barbarianII);
		legendary_enchants.put(35, Books.barbarianIII);
		legendary_enchants.put(36, Books.barbarianIV);
		legendary_enchants.put(37, Books.enrageI);
		legendary_enchants.put(38, Books.enrageII);
		legendary_enchants.put(39, Books.enrageIII);
		legendary_enchants.put(40, Books.lifelineI);
		legendary_enchants.put(41, Books.lifelineII);
		legendary_enchants.put(42, Books.lifelineIII);
		legendary_enchants.put(43, Books.hyperI);
		legendary_enchants.put(44, Books.hyperII);
		legendary_enchants.put(45, Books.hyperIII);
		legendary_enchants.put(46, Books.jetpackI);
		legendary_enchants.put(47, Books.jetpackII);
		legendary_enchants.put(48, Books.jetpackIII);
		legendary_enchants.put(49, Books.rageI);
		legendary_enchants.put(50, Books.rageII);
		legendary_enchants.put(51, Books.rageIII);
		legendary_enchants.put(52, Books.rageIV);
		legendary_enchants.put(53, Books.rageV);
		legendary_enchants.put(54, Books.rageVI);
		legendary_enchants.put(55, Books.reinforcedI);
		legendary_enchants.put(56, Books.reinforcedII);
		legendary_enchants.put(57, Books.reinforcedIII);
		legendary_enchants.put(58, Books.adrenalineI);
		legendary_enchants.put(59, Books.adrenalineII);
		legendary_enchants.put(60, Books.adrenalineIII);
		legendary_enchants.put(61, Books.adrenalineIV);
		legendary_enchants.put(62, Books.eyepatchI);
		legendary_enchants.put(63, Books.eyepatchII);
		legendary_enchants.put(64, Books.eyepatchIII);
		legendary_enchants.put(65, Books.bloodthirstyI);
		legendary_enchants.put(66, Books.bloodthirstyII);
		legendary_enchants.put(67, Books.bloodthirstyIII);
		

		legendaryEnchantCount = legendary_enchants.size();
		Bukkit.getLogger().info("Loaded " + legendaryEnchantCount + " Legendary Enchantments");

		ancient_enchants.put(1, Books.butcherI);
		ancient_enchants.put(2, Books.butcherII);
		ancient_enchants.put(3, Books.butcherIII);
		ancient_enchants.put(4, Books.butcherIV);
		ancient_enchants.put(5, Books.anvilI);
		ancient_enchants.put(6, Books.anvilII);
		ancient_enchants.put(7, Books.anvilIII);

		ancientEnchantCount = ancient_enchants.size();
		Bukkit.getLogger().info("Loaded " + ancientEnchantCount + " Ancient Enchantments");

	}

	public static void loadAllEnchants(){
		allEnchants.put(1, Books.venomI);
		allEnchants.put(2, Books.venomII);
		allEnchants.put(3, Books.venomIII);
		allEnchants.put(4, Books.blackoutI);
		allEnchants.put(5, Books.blackoutII);
		allEnchants.put(6, Books.blackoutIII);
		allEnchants.put(7, Books.hasteI);
		allEnchants.put(8, Books.hasteII);
		allEnchants.put(9, Books.hasteIII);
		allEnchants.put(10, Books.ravenousI);
		allEnchants.put(11, Books.ravenousII);
		allEnchants.put(12, Books.ravenousIII);
		allEnchants.put(13, Books.ravenousIV);
		allEnchants.put(14, Books.ravenousV);
		allEnchants.put(15, Books.explosiveI);
		allEnchants.put(16, Books.explosiveII);
		allEnchants.put(17, Books.explosiveIII);
		allEnchants.put(18, Books.explosiveIV);
		allEnchants.put(19, Books.furnaceI);
		allEnchants.put(20, Books.furnaceII);
		allEnchants.put(21, Books.furnaceIII);
		allEnchants.put(22, Books.glowingI);
		allEnchants.put(23, Books.diverI);
		allEnchants.put(24, Books.saturatedI);
		allEnchants.put(25, Books.saturatedII);
		allEnchants.put(26, Books.saturatedIII);
		allEnchants.put(27, Books.flashbackI);
		allEnchants.put(28, Books.flashbackII);
		allEnchants.put(29, Books.flashbackIII);
		allEnchants.put(30, Books.flashbackIV);
		allEnchants.put(31, Books.flashbackV);
		allEnchants.put(32, Books.flashbackVI);
		allEnchants.put(33, Books.flashbackVII);
		allEnchants.put(34, Books.flashbackVIII);
		allEnchants.put(35, Books.frozenI);
		allEnchants.put(36, Books.frozenII);
		allEnchants.put(37, Books.frozenIII);
		allEnchants.put(38, Books.bulletproofI);
		allEnchants.put(39, Books.bulletproofII);
		allEnchants.put(40, Books.bulletproofIII);
		allEnchants.put(41, Books.bulletproofIV);
		allEnchants.put(42, Books.ghastI);
		allEnchants.put(43, Books.ghastII);
		allEnchants.put(44, Books.ghastIII);
		allEnchants.put(45, Books.scavengerI);
		allEnchants.put(46, Books.scavengerII);
		allEnchants.put(47, Books.scavengerIII);
		allEnchants.put(48, Books.scavengerIV);
		allEnchants.put(49, Books.scavengerV);
		allEnchants.put(50, Books.shockI);
		allEnchants.put(51, Books.shockII);
		allEnchants.put(52, Books.shockIII);
		allEnchants.put(53, Books.shockIV);
		allEnchants.put(54, Books.shockV);
		allEnchants.put(55, Books.replenishI);
		allEnchants.put(56, Books.replenishII);
		allEnchants.put(57, Books.obsidiandestroyerI);
		allEnchants.put(58, Books.obsidiandestroyerII);
		allEnchants.put(59, Books.obsidiandestroyerIII);
		allEnchants.put(60, Books.obsidiandestroyerIV);
		allEnchants.put(61, Books.obsidiandestroyerV);
		allEnchants.put(62, Books.springsI);
		allEnchants.put(63, Books.springsII);
		allEnchants.put(64, Books.springsIII);
		allEnchants.put(65, Books.confusionI);
		allEnchants.put(66, Books.confusionII);
		allEnchants.put(67, Books.confusionIII);
		allEnchants.put(68, Books.confusionIV);
		allEnchants.put(69, Books.confusionV);
		allEnchants.put(70, Books.radioactiveI);
		allEnchants.put(71, Books.radioactiveII);
		allEnchants.put(72, Books.radioactiveIII);
		allEnchants.put(73, Books.selfdestructI);
		allEnchants.put(74, Books.selfdestructII);
		allEnchants.put(75, Books.selfdestructIII);
		allEnchants.put(76, Books.selfdestructI);
		allEnchants.put(77, Books.creeperI);
		allEnchants.put(78, Books.creeperII);
		allEnchants.put(79, Books.creeperIII);
		allEnchants.put(80, Books.shieldI);
		allEnchants.put(81, Books.shieldII);
		allEnchants.put(82, Books.shieldIII);
		allEnchants.put(83, Books.shieldIV);
		allEnchants.put(84, Books.ninjaI);
		allEnchants.put(85, Books.marshmallowI);
		allEnchants.put(86, Books.marshmallowII);
		allEnchants.put(87, Books.marshmallowIII);
		allEnchants.put(88, Books.marshmallowIV);
		allEnchants.put(89, Books.marshmallowV);
		allEnchants.put(90, Books.thiefI);
		allEnchants.put(91, Books.thiefII);
		allEnchants.put(92, Books.thiefIII);
		allEnchants.put(93, Books.counterI);
		allEnchants.put(94, Books.counterII);
		allEnchants.put(95, Books.counterIII);
		allEnchants.put(96, Books.woundI);
		allEnchants.put(97, Books.woundII);
		allEnchants.put(98, Books.woundIII);
		allEnchants.put(99, Books.woundIV);
		allEnchants.put(100, Books.safeguardI);
		allEnchants.put(101, Books.safeguardII);
		allEnchants.put(102, Books.safeguardIII);
		allEnchants.put(103, Books.safeguardIV);
		allEnchants.put(104, Books.safeguardV);
		allEnchants.put(105, Books.safeguardVI);
		allEnchants.put(106, Books.safeguardVII);
		allEnchants.put(107, Books.safeguardVIII);
		allEnchants.put(108, Books.safeguardIX);
		allEnchants.put(109, Books.safeguardX);
		allEnchants.put(110, Books.pushI);
		allEnchants.put(111, Books.pushII);
		allEnchants.put(112, Books.virusI);
		allEnchants.put(113, Books.virusII);
		allEnchants.put(114, Books.virusIII);
		allEnchants.put(115, Books.minerI);
		allEnchants.put(116, Books.minerII);
		allEnchants.put(117, Books.minerIII);
		allEnchants.put(118, Books.minerIV);
		allEnchants.put(119, Books.minerV);
		allEnchants.put(120, Books.blazeI);
		allEnchants.put(121, Books.chickenI);
		allEnchants.put(122, Books.chickenII);
		allEnchants.put(123, Books.chickenIII);
		allEnchants.put(124, Books.punctureI);
		allEnchants.put(125, Books.punctureII);
		allEnchants.put(126, Books.punctureIII);
		allEnchants.put(127, Books.punctureIV);
		allEnchants.put(128, Books.overloadI);
		allEnchants.put(129, Books.overloadII);
		allEnchants.put(130, Books.overloadIII);
		allEnchants.put(131, Books.blessedI);
		allEnchants.put(132, Books.blessedII);
		allEnchants.put(133, Books.blessedIII);
		allEnchants.put(134, Books.angelI);
		allEnchants.put(135, Books.angelII);
		allEnchants.put(136, Books.angelIII);
		allEnchants.put(137, Books.trophyI);
		allEnchants.put(138, Books.trophyII);
		allEnchants.put(139, Books.trophyIII);
		allEnchants.put(140, Books.flashbackI);
		allEnchants.put(140, Books.flashbackII);
		allEnchants.put(141, Books.flashbackIII);
		allEnchants.put(142, Books.flashbackIV);
		allEnchants.put(143, Books.flashbackV);
		allEnchants.put(144, Books.flashbackVI);
		allEnchants.put(145, Books.flashbackVII);
		allEnchants.put(146, Books.flashbackVIII);
		allEnchants.put(147, Books.flashbackVIII); //TODO
		allEnchants.put(148, Books.archerI);
		allEnchants.put(149, Books.archerI);
		allEnchants.put(150, Books.archerII);
		allEnchants.put(151, Books.archerIII);
		allEnchants.put(152, Books.spectralI);
		allEnchants.put(153, Books.spectralII);
		allEnchants.put(154, Books.spectralIII);
		allEnchants.put(155, Books.spectralIII); //TODO
		allEnchants.put(156, Books.juggernautI);
		allEnchants.put(157, Books.juggernautII);
		allEnchants.put(158, Books.juggernautIII);
		allEnchants.put(159, Books.juggernautIV);
		allEnchants.put(160, Books.greedI);
		allEnchants.put(161, Books.greedII);
		allEnchants.put(162, Books.greedIII);
		allEnchants.put(163, Books.greedIV);
		allEnchants.put(164, Books.lifestealI);
		allEnchants.put(165, Books.lifestealII);
		allEnchants.put(166, Books.lifestealIII);
		allEnchants.put(167, Books.lifestealIV);
		allEnchants.put(168, Books.lifestealV);
		allEnchants.put(169, Books.rageI);
		allEnchants.put(170, Books.rageII);
		allEnchants.put(171, Books.rageIII);
		allEnchants.put(172, Books.rageIV);
		allEnchants.put(173, Books.rageV);
		allEnchants.put(174, Books.rageVI);
		allEnchants.put(175, Books.meteorI);
		allEnchants.put(176, Books.meteorII);
		allEnchants.put(177, Books.meteorIII);
		allEnchants.put(178, Books.meteorIV);
		allEnchants.put(179, Books.meteorV);
		allEnchants.put(180, Books.meteorVI);
		allEnchants.put(181, Books.meteorVII);
		allEnchants.put(182, Books.meteorVIII);
		allEnchants.put(183, Books.meteorIX);
		allEnchants.put(184, Books.meteorX);
		allEnchants.put(185, Books.auraI);
		allEnchants.put(186, Books.auraII);
		allEnchants.put(187, Books.auraIII);
		allEnchants.put(188, Books.auraIV);
		allEnchants.put(189, Books.auraV);
		allEnchants.put(190, Books.immolationI);
		allEnchants.put(191, Books.immolationII);
		allEnchants.put(192, Books.immolationIII);
		allEnchants.put(193, Books.immolationIV);
		allEnchants.put(194, Books.barbarianI);
		allEnchants.put(195, Books.barbarianII);
		allEnchants.put(196, Books.barbarianIII);
		allEnchants.put(197, Books.barbarianIV);
		allEnchants.put(198, Books.enrageI);
		allEnchants.put(199, Books.enrageII);
		allEnchants.put(200, Books.enrageIII);
		allEnchants.put(201, Books.lifelineI);
		allEnchants.put(202, Books.lifelineII);
		allEnchants.put(203, Books.lifelineIII);
		allEnchants.put(204, Books.hyperI);
		allEnchants.put(205, Books.hyperII);
		allEnchants.put(206, Books.hyperIII);
		allEnchants.put(207, Books.jetpackI);
		allEnchants.put(208, Books.jetpackII);
		allEnchants.put(209, Books.jetpackIII);
		allEnchants.put(210, Books.butcherI);
		allEnchants.put(211, Books.butcherII);
		allEnchants.put(212, Books.butcherIII);
		allEnchants.put(213, Books.butcherIV);
		//allEnchants.put(214, Books.collectionI);
		//allEnchants.put(215, Books.collectionII);
		//allEnchants.put(216, Books.collectionIII);
		allEnchants.put(214, Books.bruteI);
		allEnchants.put(215, Books.bruteII);
		allEnchants.put(216, Books.bruteIII);
		allEnchants.put(217, Books.bruteIV);
		allEnchants.put(218, Books.vestI);
		allEnchants.put(219, Books.vestII);
		allEnchants.put(220, Books.vestIII);
		allEnchants.put(221, Books.vestIV);
		allEnchants.put(222, Books.witherI);
		allEnchants.put(223, Books.witherII);
		allEnchants.put(224, Books.witherIII);
		allEnchants.put(225, Books.witherIV);
		allEnchants.put(226, Books.witherV);
		allEnchants.put(227, Books.pineappleI);
		allEnchants.put(228, Books.pineappleII);
		allEnchants.put(229, Books.voltageI);
		allEnchants.put(230, Books.voltageII);
		allEnchants.put(231, Books.voltageIII);
		allEnchants.put(232, Books.agilityI);
		allEnchants.put(233, Books.agilityII);
		allEnchants.put(234, Books.agilityIII);
		allEnchants.put(235, Books.agilityIV);
		allEnchants.put(236, Books.wormholeI);
		allEnchants.put(237, Books.wormholeII);
		allEnchants.put(238, Books.wormholeIII);
		allEnchants.put(239, Books.fractureI);
		allEnchants.put(240, Books.fractureII);
		allEnchants.put(241, Books.fractureIII);
		allEnchants.put(242, Books.fractureIV);
		allEnchants.put(243, Books.overdoseI);
		allEnchants.put(244, Books.overdoseII);
		allEnchants.put(245, Books.overdoseIII);
		allEnchants.put(246, Books.muffleI);
		allEnchants.put(247, Books.muffleII);
		allEnchants.put(248, Books.muffleIII);
		allEnchants.put(249, Books.muffleIV);
		allEnchants.put(250, Books.pyroI);
		allEnchants.put(251, Books.pyroII);
		allEnchants.put(252, Books.pyroIII);
		allEnchants.put(253, Books.luckyI);
		allEnchants.put(254, Books.luckyII);
		allEnchants.put(255, Books.luckyIII);
		allEnchants.put(256, Books.luckyIV);
		allEnchants.put(257, Books.luckyV);
		allEnchants.put(258, Books.luckyVI);
		allEnchants.put(259, Books.luckyVII);
		allEnchants.put(260, Books.luckyVIII);
		allEnchants.put(261, Books.luckyIX);
		allEnchants.put(262, Books.luckyX);
		allEnchants.put(263, Books.reinforcedI);
		allEnchants.put(264, Books.reinforcedII);
		allEnchants.put(265, Books.reinforcedIII);
		allEnchants.put(266, Books.adrenalineI);
		allEnchants.put(267, Books.adrenalineII);
		allEnchants.put(268, Books.adrenalineIII);
		allEnchants.put(269, Books.adrenalineIV);
		allEnchants.put(270, Books.eyepatchI);
		allEnchants.put(271, Books.eyepatchII);
		allEnchants.put(272, Books.eyepatchIII);
		allEnchants.put(273, Books.bloodthirstyI);
		allEnchants.put(274, Books.bloodthirstyII);
		allEnchants.put(275, Books.bloodthirstyIII);
		allEnchants.put(276, Books.anvilI);
		allEnchants.put(277, Books.anvilII);
		allEnchants.put(278, Books.anvilIII);
		allEnchants.put(279, Books.snareI);
		allEnchants.put(280, Books.snareII);
		allEnchants.put(281, Books.snareIII);

		totalEnchantCount = allEnchants.size();
		Bukkit.getLogger().info("Loaded " + totalEnchantCount + " Total Enchantments");

	}


	public static void loadDischargeEnchants(){
		dischargeEnchants.put("Venom I", Books.venomI);
		dischargeEnchants.put("Venom II", Books.venomII);
		dischargeEnchants.put("Venom III", Books.venomIII);
		dischargeEnchants.put("Blackout I", Books.blackoutI);
		dischargeEnchants.put("Blackout II", Books.blackoutII);
		dischargeEnchants.put("Blackout III", Books.blackoutIII);
		dischargeEnchants.put("Haste I", Books.hasteI);
		dischargeEnchants.put("Haste II", Books.hasteII);
		dischargeEnchants.put("Haste III", Books.hasteIII);
		dischargeEnchants.put("Ravenous I", Books.ravenousI);
		dischargeEnchants.put("Ravenous II", Books.ravenousII);
		dischargeEnchants.put("Ravenous III", Books.ravenousIII);
		dischargeEnchants.put("Ravenous IV", Books.ravenousIV);
		dischargeEnchants.put("Ravenous V", Books.ravenousV);
		dischargeEnchants.put("Explosive I", Books.explosiveI);
		dischargeEnchants.put("Explosive II", Books.explosiveII);
		dischargeEnchants.put("Explosive III", Books.explosiveIII);
		dischargeEnchants.put("Explosive IV", Books.explosiveIV);
		dischargeEnchants.put("Furnace I", Books.furnaceI);
		dischargeEnchants.put("Furnace II", Books.furnaceII);
		dischargeEnchants.put("Furnace III", Books.furnaceIII);
		dischargeEnchants.put("Glowing I", Books.glowingI);
		dischargeEnchants.put("Diver I", Books.diverI);
		dischargeEnchants.put("Saturated I", Books.saturatedI);
		dischargeEnchants.put("Saturated II", Books.saturatedII);
		dischargeEnchants.put("Saturated III", Books.saturatedIII);
		dischargeEnchants.put("Flashback I", Books.flashbackI);
		dischargeEnchants.put("Flashback II", Books.flashbackII);
		dischargeEnchants.put("Flashback III", Books.flashbackIII);
		dischargeEnchants.put("Flashback IV", Books.flashbackIV);
		dischargeEnchants.put("Flashback V", Books.flashbackV);
		dischargeEnchants.put("Flashback VI", Books.flashbackVI);
		dischargeEnchants.put("Flashback VII", Books.flashbackVII);
		dischargeEnchants.put("Flashback VIII", Books.flashbackVIII);
		dischargeEnchants.put("Frozen I", Books.frozenI);
		dischargeEnchants.put("Frozen II", Books.frozenII);
		dischargeEnchants.put("Frozen III", Books.frozenIII);
		dischargeEnchants.put("Bulletproof I", Books.bulletproofI);
		dischargeEnchants.put("Bulletproof II", Books.bulletproofII);
		dischargeEnchants.put("Bulletproof III", Books.bulletproofIII);
		dischargeEnchants.put("Bulletproof IV", Books.bulletproofIV);
		dischargeEnchants.put("Ghast I", Books.ghastI);
		dischargeEnchants.put("Ghast II", Books.ghastII);
		dischargeEnchants.put("Ghast III", Books.ghastIII);
		dischargeEnchants.put("Scavenger I", Books.scavengerI);
		dischargeEnchants.put("Scavenger II", Books.scavengerII);
		dischargeEnchants.put("Scavenger III", Books.scavengerIII);
		dischargeEnchants.put("Scavenger IV", Books.scavengerIV);
		dischargeEnchants.put("Scavenger V", Books.scavengerV);
		dischargeEnchants.put("Wither I", Books.witherI);
		dischargeEnchants.put("Wither II", Books.witherII);
		dischargeEnchants.put("Wither III", Books.witherIII);
		dischargeEnchants.put("Wither IV", Books.witherIV);
		dischargeEnchants.put("Wither V", Books.witherV);
		dischargeEnchants.put("Pineapple I", Books.pineappleI);
		dischargeEnchants.put("Pineapple II", Books.pineappleII);
		dischargeEnchants.put("Voltage I", Books.voltageI);
		dischargeEnchants.put("Voltage II", Books.voltageII);
		dischargeEnchants.put("Voltage III", Books.voltageIII);
		dischargeEnchants.put("Agility I", Books.agilityI);
		dischargeEnchants.put("Agility II", Books.agilityII);
		dischargeEnchants.put("Agility III", Books.agilityIII);
		dischargeEnchants.put("Agility IV", Books.agilityIV);

		dischargeEnchants.put("Shock I", Books.shockI);
		dischargeEnchants.put("Shock II", Books.shockII);
		dischargeEnchants.put("Shock III", Books.shockIII);
		dischargeEnchants.put("Shock IV", Books.shockIV);
		dischargeEnchants.put("Shock V", Books.shockV);
		dischargeEnchants.put("Replenish I", Books.replenishI);
		dischargeEnchants.put("Replenish II", Books.replenishII);
		dischargeEnchants.put("Obsidian Destroyer I", Books.obsidiandestroyerI);
		dischargeEnchants.put("Obsidian Destroyer II", Books.obsidiandestroyerII);
		dischargeEnchants.put("Obsidian Destroyer III", Books.obsidiandestroyerIII);
		dischargeEnchants.put("Obsidian Destroyer IV", Books.obsidiandestroyerIV);
		dischargeEnchants.put("Obsidian Destroyer V", Books.obsidiandestroyerV);
		dischargeEnchants.put("Springs I", Books.springsI);
		dischargeEnchants.put("Springs II", Books.springsII);
		dischargeEnchants.put("Springs III", Books.springsIII);
		dischargeEnchants.put("Confusion I", Books.confusionI);
		dischargeEnchants.put("Confusion II", Books.confusionII);
		dischargeEnchants.put("Confusion III", Books.confusionIII);
		dischargeEnchants.put("Confusion IV", Books.confusionIV);
		dischargeEnchants.put("Confusion V", Books.confusionV);
		dischargeEnchants.put("Radioactive I", Books.radioactiveI);
		dischargeEnchants.put("Radioactive II", Books.radioactiveII);
		dischargeEnchants.put("Radioactive III", Books.radioactiveIII);
		dischargeEnchants.put("Selfdestruct I", Books.selfdestructI);
		dischargeEnchants.put("Selfdestruct II", Books.selfdestructII);
		dischargeEnchants.put("Selfdestruct III", Books.selfdestructIII);
		dischargeEnchants.put("Creeper I", Books.creeperI);
		dischargeEnchants.put("Creeper II", Books.creeperII);
		dischargeEnchants.put("Creeper III", Books.creeperIII);
		dischargeEnchants.put("Shield I", Books.shieldI);
		dischargeEnchants.put("Shield II", Books.shieldII);
		dischargeEnchants.put("Shield III", Books.shieldIII);
		dischargeEnchants.put("Shield IV", Books.shieldIV);
		dischargeEnchants.put("Ninja I", Books.ninjaI);
		dischargeEnchants.put("Marshmallow I", Books.marshmallowI);
		dischargeEnchants.put("Marshmallow II", Books.marshmallowII);
		dischargeEnchants.put("Marshmallow III", Books.marshmallowIII);
		dischargeEnchants.put("Marshmallow IV", Books.marshmallowIV);
		dischargeEnchants.put("Marshmallow V", Books.marshmallowV);
		dischargeEnchants.put("Thief I", Books.thiefI);
		dischargeEnchants.put("Thief II", Books.thiefII);
		dischargeEnchants.put("Thief III", Books.thiefIII);
		dischargeEnchants.put("Counter I", Books.counterI);
		dischargeEnchants.put("Counter II", Books.counterII);
		dischargeEnchants.put("Counter III", Books.counterIII);
		dischargeEnchants.put("Wound I", Books.woundI);
		dischargeEnchants.put("Wound II", Books.woundII);
		dischargeEnchants.put("Wound III", Books.woundIII);
		dischargeEnchants.put("Wound IV", Books.woundIV);
		dischargeEnchants.put("Safeguard I", Books.safeguardI);
		dischargeEnchants.put("Safeguard II", Books.safeguardII);
		dischargeEnchants.put("Safeguard III", Books.safeguardIII);
		dischargeEnchants.put("Safeguard IV", Books.safeguardIV);
		dischargeEnchants.put("Safeguard V", Books.safeguardV);
		dischargeEnchants.put("Safeguard VI", Books.safeguardVI);
		dischargeEnchants.put("Safeguard VII", Books.safeguardVII);
		dischargeEnchants.put("Safeguard VIII", Books.safeguardVIII);
		dischargeEnchants.put("Safeguard IX", Books.safeguardIX);
		dischargeEnchants.put("Safeguard X", Books.safeguardX);
		dischargeEnchants.put("Push I", Books.pushI);
		dischargeEnchants.put("Push II", Books.pushII);
		dischargeEnchants.put("Virus I", Books.virusI);
		dischargeEnchants.put("Virus II", Books.virusII);
		dischargeEnchants.put("Virus III", Books.virusIII);
		dischargeEnchants.put("Miner I", Books.minerI);
		dischargeEnchants.put("Miner II", Books.minerII);
		dischargeEnchants.put("Miner III", Books.minerIII);
		dischargeEnchants.put("Miner IV", Books.minerIV);
		dischargeEnchants.put("Miner V", Books.minerV);
		dischargeEnchants.put("Blaze I", Books.blazeI);
		dischargeEnchants.put("Wormhole I", Books.wormholeI);
		dischargeEnchants.put("Wormhole II", Books.wormholeII);
		dischargeEnchants.put("Wormhole III", Books.wormholeIII);
		dischargeEnchants.put("Fracture I", Books.fractureI);
		dischargeEnchants.put("Fracture II", Books.fractureII);
		dischargeEnchants.put("Fracture III", Books.fractureIII);
		dischargeEnchants.put("Fracture IV", Books.fractureIV);


		dischargeEnchants.put("Chicken I", Books.chickenI);
		dischargeEnchants.put("Chicken II", Books.chickenII);
		dischargeEnchants.put("Chicken III", Books.chickenIII);
		dischargeEnchants.put("Puncture I", Books.punctureI);
		dischargeEnchants.put("Puncture II", Books.punctureII);
		dischargeEnchants.put("Puncture III", Books.punctureIII);
		dischargeEnchants.put("Puncture IV", Books.punctureIV);
		dischargeEnchants.put("Overload I", Books.overloadI);
		dischargeEnchants.put("Overload II", Books.overloadII);
		dischargeEnchants.put("Overload III", Books.overloadIII);
		dischargeEnchants.put("Blessed I", Books.blessedI);
		dischargeEnchants.put("Blessed II", Books.blessedII);
		dischargeEnchants.put("Blessed III", Books.blessedIII);
		dischargeEnchants.put("Angel I", Books.angelI);
		dischargeEnchants.put("Angel II", Books.angelII);
		dischargeEnchants.put("Angel III", Books.angelIII);
		dischargeEnchants.put("Trophy I", Books.trophyI);
		dischargeEnchants.put("Trophy II", Books.trophyII);
		dischargeEnchants.put("Trophy III", Books.trophyIII);
		dischargeEnchants.put("Flashbang I", Books.flashbangI);
		dischargeEnchants.put("Flashbang II", Books.flashbangII);
		dischargeEnchants.put("Flashbang III", Books.flashbangIII);
		dischargeEnchants.put("Flashbang IV", Books.flashbangIV);
		dischargeEnchants.put("Flashbang V", Books.flashbangV);
		dischargeEnchants.put("Flashbang VI", Books.flashbangVI);
		dischargeEnchants.put("Flashbang VII", Books.flashbangVII);
		dischargeEnchants.put("Flashbang VIII", Books.flashbangVIII);
		dischargeEnchants.put("Archer I", Books.archerI);
		dischargeEnchants.put("Archer II", Books.archerII);
		dischargeEnchants.put("Archer III", Books.archerIII);
		dischargeEnchants.put("Spectral I", Books.spectralI);
		dischargeEnchants.put("Spectral II", Books.spectralII);
		dischargeEnchants.put("Spectral III", Books.spectralIII);
		dischargeEnchants.put("Brute I", Books.bruteI);
		dischargeEnchants.put("Brute II", Books.bruteII);
		dischargeEnchants.put("Brute III", Books.bruteIII);
		dischargeEnchants.put("Brute IV", Books.bruteIV);
		dischargeEnchants.put("Vest I", Books.vestI);
		dischargeEnchants.put("Vest II", Books.vestII);
		dischargeEnchants.put("Vest III", Books.vestIII);
		dischargeEnchants.put("Vest IV", Books.vestIV);
		dischargeEnchants.put("Overdose I", Books.overdoseI);
		dischargeEnchants.put("Overdose II", Books.overdoseII);
		dischargeEnchants.put("Overdose III", Books.overdoseIII);
		dischargeEnchants.put("Muffle I", Books.muffleI);
		dischargeEnchants.put("Muffle II", Books.muffleII);
		dischargeEnchants.put("Muffle III", Books.muffleIII);
		dischargeEnchants.put("Muffle IV", Books.muffleIV);
		dischargeEnchants.put("Pyro I", Books.pyroI);
		dischargeEnchants.put("Pyro II", Books.pyroII);
		dischargeEnchants.put("Pyro III", Books.pyroIII);
		dischargeEnchants.put("Lucky I", Books.luckyI);
		dischargeEnchants.put("Lucky II", Books.luckyII);
		dischargeEnchants.put("Lucky III", Books.luckyIII);
		dischargeEnchants.put("Lucky IV", Books.luckyIV);
		dischargeEnchants.put("Lucky V", Books.luckyV);
		dischargeEnchants.put("Lucky VI", Books.luckyVI);
		dischargeEnchants.put("Lucky VII", Books.luckyVII);
		dischargeEnchants.put("Lucky VIII", Books.luckyVIII);
		dischargeEnchants.put("Lucky IX", Books.luckyIX);
		dischargeEnchants.put("Lucky X", Books.luckyX);
		dischargeEnchants.put("Snare I", Books.snareI);
		dischargeEnchants.put("Snare II", Books.snareII);
		dischargeEnchants.put("Snare III", Books.snareIII);
		//dischargeEnchants.put("collectionI", Books.collectionI);
		//dischargeEnchants.put("collectionII", Books.collectionII);
		//dischargeEnchants.put("collectionIII", Books.collectionIII);


		dischargeEnchants.put("Juggernaut I", Books.juggernautI);
		dischargeEnchants.put("Juggernaut II", Books.juggernautII);
		dischargeEnchants.put("Juggernaut III", Books.juggernautIII);
		dischargeEnchants.put("Juggernaut IV", Books.juggernautIV);
		dischargeEnchants.put("Greed I", Books.greedI);
		dischargeEnchants.put("Greed II", Books.greedII);
		dischargeEnchants.put("Greed III", Books.greedIII);
		dischargeEnchants.put("Greed IV", Books.greedIV);
		dischargeEnchants.put("Lifesteal I", Books.lifestealI);
		dischargeEnchants.put("Lifesteal II", Books.lifestealII);
		dischargeEnchants.put("Lifesteal III", Books.lifestealIII);
		dischargeEnchants.put("Lifesteal IV", Books.lifestealIV);
		dischargeEnchants.put("Lifesteal V", Books.lifestealV);
		dischargeEnchants.put("Rage I", Books.rageI);
		dischargeEnchants.put("Rage II", Books.rageII);
		dischargeEnchants.put("Rage III", Books.rageIII);
		dischargeEnchants.put("Rage IV", Books.rageIV);
		dischargeEnchants.put("Rage V", Books.rageV);
		dischargeEnchants.put("Rage VI", Books.rageVI);
		dischargeEnchants.put("Meteor I", Books.meteorI);
		dischargeEnchants.put("Meteor II", Books.meteorII);
		dischargeEnchants.put("Meteor III", Books.meteorIII);
		dischargeEnchants.put("Meteor IV", Books.meteorIV);
		dischargeEnchants.put("Meteor V", Books.meteorV);
		dischargeEnchants.put("Meteor VI", Books.meteorVI);
		dischargeEnchants.put("Meteor VII", Books.meteorVII);
		dischargeEnchants.put("Meteor VIII", Books.meteorVIII);
		dischargeEnchants.put("Meteor IX", Books.meteorIX);
		dischargeEnchants.put("Meteor X", Books.meteorX);
		dischargeEnchants.put("Aura I", Books.auraI);
		dischargeEnchants.put("Aura II", Books.auraII);
		dischargeEnchants.put("Aura III", Books.auraIII);
		dischargeEnchants.put("Aura IV", Books.auraIV);
		dischargeEnchants.put("Aura V", Books.auraV);
		dischargeEnchants.put("Immolation I", Books.immolationI);
		dischargeEnchants.put("Immolation II", Books.immolationII);
		dischargeEnchants.put("Immolation III", Books.immolationIII);
		dischargeEnchants.put("Immolation IV", Books.immolationIV);
		dischargeEnchants.put("Barbarian I", Books.barbarianI);
		dischargeEnchants.put("Barbarian II", Books.barbarianII);
		dischargeEnchants.put("Barbarian III", Books.barbarianIII);
		dischargeEnchants.put("Barbarian IV", Books.barbarianIV);
		dischargeEnchants.put("Enrage I", Books.enrageI);
		dischargeEnchants.put("Enrage II", Books.enrageII);
		dischargeEnchants.put("Enrage III", Books.enrageIII);
		dischargeEnchants.put("Lifeline I", Books.lifelineI);
		dischargeEnchants.put("Lifeline II", Books.lifelineII);
		dischargeEnchants.put("Lifeline III", Books.lifelineIII);
		dischargeEnchants.put("Hyper I", Books.hyperI);
		dischargeEnchants.put("Hyper II", Books.hyperII);
		dischargeEnchants.put("Hyper III", Books.hyperIII);
		dischargeEnchants.put("Jetpack I", Books.jetpackI);
		dischargeEnchants.put("Jetpack II", Books.jetpackII);
		dischargeEnchants.put("Jetpack III", Books.jetpackIII);
		dischargeEnchants.put("Reinforced I", Books.reinforcedI);
		dischargeEnchants.put("Reinforced II", Books.reinforcedII);
		dischargeEnchants.put("Reinforced III", Books.reinforcedIII);
		dischargeEnchants.put("Adrenaline I", Books.adrenalineI);
		dischargeEnchants.put("Adrenaline II", Books.adrenalineII);
		dischargeEnchants.put("Adrenaline III", Books.adrenalineIII);
		dischargeEnchants.put("Adrenaline IV", Books.adrenalineIV);
		dischargeEnchants.put("Eyepatch I", Books.eyepatchI);
		dischargeEnchants.put("Eyepatch II", Books.eyepatchII);
		dischargeEnchants.put("Eyepatch III", Books.eyepatchIII);
		dischargeEnchants.put("Bloodthirsty I", Books.bloodthirstyI);
		dischargeEnchants.put("Bloodthirsty II", Books.bloodthirstyII);
		dischargeEnchants.put("Bloodthirsty III", Books.bloodthirstyIII);

		dischargeEnchants.put("Butcher I", Books.butcherI);
		dischargeEnchants.put("Butcher II", Books.butcherII);
		dischargeEnchants.put("Butcher III", Books.butcherIII);
		dischargeEnchants.put("Butcher IV", Books.butcherIV);
		dischargeEnchants.put("Anvil I", Books.anvilI);
		dischargeEnchants.put("Anvil II", Books.anvilII);
		dischargeEnchants.put("Anvil III", Books.anvilIII);

	}

	public static void giveEnchanterKitItems(Player p){
		int enchantAmt = API.randomInt(8, 12);
		for(int i = 0; i < enchantAmt; i++){
			API.giveEnchant(p, API.allEnchants.get(API.randomInt(1, totalEnchantCount)), API.randomInt(1, 100), API.randomInt(1, 100));
		}
		if(API.randomInt(1, 2) == 1){
			p.getInventory().addItem(CustomItems.dischargeOrb(API.randomInt(50, 100)));
		}
		else{
			p.getInventory().addItem(CustomItems.protectionOrb);
		}
		if(API.randomInt(1, 4) == 1){
			p.getInventory().addItem(CustomItems.ocdScroll);
		}
	}

}
