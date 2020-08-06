package me.classified.enchants;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import me.classified.enchants.commands.EnchantAdminCommand;
import me.classified.enchants.commands.EnchanterCommand;
import me.classified.enchants.commands.EnchantsCommand;
import me.classified.enchants.commands.GiveCommand;
import me.classified.enchants.commands.TinkererCommand;
import me.classified.enchants.enchants.AdvancedEnchants;
import me.classified.enchants.enchants.AncientEnchants;
import me.classified.enchants.enchants.BasicEnchants;
import me.classified.enchants.enchants.EpicEnchants;
import me.classified.enchants.enchants.LegendaryEnchants;
import me.classified.enchants.listeners.DustApplyListener;
import me.classified.enchants.listeners.DustOpenListener;
import me.classified.enchants.listeners.InventoryClickListener;
import me.classified.enchants.listeners.OrbApplyListener;
import me.classified.enchants.listeners.OrbOpenListener;
import me.classified.enchants.listeners.RenameScrollListener;
import me.classified.enchants.listeners.TinkererClickListener;
import me.classified.enchants.utils.API;
import net.milkbowl.vault.economy.Economy;

//Project created in 2017-2018.

public class cEnchants extends JavaPlugin implements Listener{

	public static Plugin instance;

	public static Economy econ = null;
	
	public static File fileF;
	public static FileConfiguration file;

	public static File configF;
	public static FileConfiguration config;
	
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		instance = this;
		generateConfigs();
		loadPotions();
		registerEvents();
		registerCommands();
		API.loadEnchants();
		loadRomanNumerals();
		API.loadAllEnchants();
		API.loadNumberedEnchants();
		API.loadDischargeEnchants();
		if(!setupEconomy()){
			logger.severe(String.format("[%s] - Disabled due to no Vault dependency found!", pdfFile.getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		logger.info(pdfFile.getName() + " has been Enabled v" + pdfFile.getVersion() + "(Developed by: " + pdfFile.getAuthors() + ")");
	}

	public void onDisable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + " has been Disabled v" + pdfFile.getVersion() + "(Developed by: " + pdfFile.getAuthors() + ")");
	}

	public static Plugin getInstance(){
		return instance;
	}
	
	private boolean setupEconomy(){
		if(getServer().getPluginManager().getPlugin("Vault") == null){
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if(rsp == null){			
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	public static ArrayList<PotionEffectType> positivePotions = new ArrayList<>();
	public static ArrayList<PotionEffectType> negativePotions = new ArrayList<>();

	public void registerCommands(){
		getCommand("giveenchant").setExecutor(new GiveCommand());
		getCommand("tinkerer").setExecutor(new TinkererCommand());
		getCommand("enchants").setExecutor(new EnchantsCommand());
		getCommand("enchanter").setExecutor(new EnchanterCommand());
		getCommand("giveenchantitem").setExecutor(new GiveCommand());
		getCommand("enchantadmin").setExecutor(new EnchantAdminCommand());
	}

	public void registerEvents(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(this, this);		
		pm.registerEvents(new EpicEnchants(), this);
		pm.registerEvents(new BasicEnchants(), this);
		pm.registerEvents(new OrbOpenListener(), this);
		pm.registerEvents(new AncientEnchants(), this);
		pm.registerEvents(new AdvancedEnchants(), this);
		pm.registerEvents(new DustOpenListener(), this);
		pm.registerEvents(new OrbApplyListener(), this);
		pm.registerEvents(new LegendaryEnchants(), this);
		pm.registerEvents(new DustApplyListener(), this);
		pm.registerEvents(new RenameScrollListener(), this);
		pm.registerEvents(new TinkererClickListener(), this);
		pm.registerEvents(new InventoryClickListener(), this);
	}

	public static void loadPotions(){
		positivePotions.add(PotionEffectType.JUMP);
		positivePotions.add(PotionEffectType.SPEED);
		positivePotions.add(PotionEffectType.REGENERATION);
		positivePotions.add(PotionEffectType.FAST_DIGGING);
		positivePotions.add(PotionEffectType.INVISIBILITY);
		positivePotions.add(PotionEffectType.NIGHT_VISION);
		positivePotions.add(PotionEffectType.WATER_BREATHING);
		positivePotions.add(PotionEffectType.FIRE_RESISTANCE);
		positivePotions.add(PotionEffectType.INCREASE_DAMAGE);

		negativePotions.add(PotionEffectType.SLOW);
		negativePotions.add(PotionEffectType.POISON);
		negativePotions.add(PotionEffectType.HUNGER);
		negativePotions.add(PotionEffectType.WITHER);
		negativePotions.add(PotionEffectType.WEAKNESS);
		negativePotions.add(PotionEffectType.BLINDNESS);
		negativePotions.add(PotionEffectType.CONFUSION);
		negativePotions.add(PotionEffectType.SLOW_DIGGING);
	}

	public static void loadRomanNumerals(){
		API.romanNumerals.put(1, "I");
		API.romanNumerals.put(2, "II");
		API.romanNumerals.put(3, "III");
		API.romanNumerals.put(4, "IV");
		API.romanNumerals.put(5, "V");
		API.romanNumerals.put(6, "VI");
		API.romanNumerals.put(7, "VII");
		API.romanNumerals.put(8, "VIII");
		API.romanNumerals.put(9, "IX");
		API.romanNumerals.put(10, "X");

		API.romanNumerals2.put("I", 1);
		API.romanNumerals2.put("II", 2);
		API.romanNumerals2.put("III", 3);
		API.romanNumerals2.put("IV", 4);
		API.romanNumerals2.put("V", 5);
		API.romanNumerals2.put("VI", 6);
		API.romanNumerals2.put("VII", 7);
		API.romanNumerals2.put("VIII", 8);
		API.romanNumerals2.put("IX", 9);
		API.romanNumerals2.put("X", 10);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){

	}

	private void generateConfigs(){
		saveDefaultConfig();

		configF = new File(getDataFolder(), "config.yml");
		config = new YamlConfiguration();

		for (int i = 1; i <= 2; i++){
			if (i == 1){
				fileF = configF;
				file = config;
			}

            if (!fileF.exists()){
                fileF.getParentFile().mkdirs();saveResource(fileF.getName(), false);
            }
            try{
                file.load(fileF);
            }
            catch (IOException|InvalidConfigurationException e){
                e.printStackTrace();
            }
		}
	}

	public static FileConfiguration getConfigF(){
		return config;
	}

	public static void saveConfigF(){
		try{
			config.save(configF);
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

}
