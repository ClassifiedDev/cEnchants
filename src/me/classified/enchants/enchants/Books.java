package me.classified.enchants.enchants;

import me.classified.enchants.utils.Config;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.classified.enchants.utils.API;
import me.classified.enchants.utils.Enchant;

public class Books {

    public static String convertColor(String colorCode){
        String color = "white";
        switch (colorCode.toLowerCase()){
            case "&a":
                color = "green";
                break;
            case "&b":
                color = "blue";
                break;
            case "&c":
                color = "red";
                break;
            case "&d":
                color = "pink";
                break;
            case "&e":
                color = "yellow";
                break;
            case "&f":
                color = "white";
                break;
            case "&1":
                color = "deepblue";
                break;
            case "&2":
                color = "darkgreen";
                break;
            case "&3":
                color = "teal";
                break;
            case "&4":
                color = "darkred";
                break;
            case "&5":
                color = "purple";
                break;
            case "&6":
                color = "orange";
                break;
            case "&7":
                color = "lightgray";
                break;
            case "&8":
                color = "darkgray";
                break;
            case "&9":
                color = "darkblue";
                break;
            case "&0":
                color = "black";
                break;
            default:
                color = "white";
                break;
        }
        return color;
    }

	//BASIC
	public static Enchant venomI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lVenom I Enchant Orb", new String[]{"&7Chance to give your opponent", "&7poison for a limited time."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant venomII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lVenom II Enchant Orb", new String[]{"&7Chance to give your opponent", "&7poison for a limited time."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant venomIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lVenom III Enchant Orb", new String[]{"&7Chance to give your opponent", "&7poison for a limited time."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	
	public static Enchant blackoutI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lBlackout I Enchant Orb", new String[]{"&7Chance to give your opponent", "&7blindness for a limited time."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant blackoutII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lBlackout II Enchant Orb", new String[]{"&7Chance to give your opponent", "&7blindness for a limited time."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant blackoutIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lBlackout III Enchant Orb", new String[]{"&7Chance to give your opponent", "&7blindness for a limited time."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	
	public static Enchant hasteI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lHaste I Enchant Orb", new String[]{"&7Chance to get a burst of", "&7haste for a limited time."}, " ", 0, 0, "Sword, Axe, Pickaxe", convertColor(Config.tier1BookColor));
	public static Enchant hasteII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lHaste II Enchant Orb", new String[]{"&7Chance to get a burst of", "&7haste for a limited time."}, " ", 0, 0, "Sword, Axe, Pickaxe", convertColor(Config.tier1BookColor));
	public static Enchant hasteIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lHaste III Enchant Orb", new String[]{"&7Chance to get a burst of", "&7haste for a limited time."}, " ", 0, 0, "Sword, Axe, Pickaxe", convertColor(Config.tier1BookColor));

	public static Enchant ravenousI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lRavenous I Enchant Orb", new String[]{"&7Chance to give your opponent", "&7hunger for a limited time."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant ravenousII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lRavenous II Enchant Orb", new String[]{"&7Chance to give your opponent", "&7hunger for a limited time."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant ravenousIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lRavenous III Enchant Orb", new String[]{"&7Chance to give your opponent", "&7hunger for a limited time."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant ravenousIV = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lRavenous IV Enchant Orb", new String[]{"&7Chance to give your opponent", "&7hunger for a limited time."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant ravenousV = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lRavenous V Enchant Orb", new String[]{"&7Chance to give your opponent", "&7hunger for a limited time."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	
	public static Enchant explosiveI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lExplosive I Enchant Orb", new String[]{"&7Chance to cause an explosion", "&7where your arrow lands."}, " ", 0, 0, "Bow", convertColor(Config.tier1BookColor));
	public static Enchant explosiveII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lExplosive II Enchant Orb", new String[]{"&7Chance to cause an explosion", "&7where your arrow lands."}, " ", 0, 0, "Bow", convertColor(Config.tier1BookColor));
	public static Enchant explosiveIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lExplosive III Enchant Orb", new String[]{"&7Chance to cause an explosion", "&7where your arrow lands."}, " ", 0, 0, "Bow", convertColor(Config.tier1BookColor));
	public static Enchant explosiveIV = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lExplosive IV Enchant Orb", new String[]{"&7Chance to cause an explosion", "&7where your arrow lands."}, " ", 0, 0, "Bow", convertColor(Config.tier1BookColor));
	
	public static Enchant furnaceI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFurnace I Enchant Orb", new String[]{"&7Chance to automatically smelt", "&7ores."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier1BookColor));
	public static Enchant furnaceII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFurnace II Enchant Orb", new String[]{"&7Chance to automatically smelt", "&7ores."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier1BookColor));
	public static Enchant furnaceIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFurnace III Enchant Orb", new String[]{"&7Chance to automatically smelt", "&7ores."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier1BookColor));
	
	public static Enchant glowingI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lGlowing I Enchant Orb", new String[]{"&7Gives you permanent night", "&7vision effect."}, " ", 0, 0, "Helmet", convertColor(Config.tier1BookColor));
	
	public static Enchant diverI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lDiver I Enchant Orb", new String[]{"&7Gives you permanent water", "&7breathing effect."}, " ", 0, 0, "Helmet", convertColor(Config.tier1BookColor));
	
	public static Enchant saturatedI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lSaturated I Enchant Orb", new String[]{"&7Chance to give you food", "&7bars while sprinting."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier1BookColor));
	public static Enchant saturatedII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lSaturated II Enchant Orb", new String[]{"&7Chance to give you food", "&7bars while sprinting."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier1BookColor));
	public static Enchant saturatedIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lSaturated III Enchant Orb", new String[]{"&7Chance to give you food", "&7bars while sprinting."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier1BookColor));
	
	public static Enchant frozenI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFrozen I Enchant Orb", new String[]{"&7Chance to freeze your opponent", "&7in their place for limited time."}, " ", 0, 0, "Sword", convertColor(Config.tier1BookColor));
	public static Enchant frozenII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFrozen II Enchant Orb", new String[]{"&7Chance to freeze your opponent", "&7in their place for limited time."}, " ", 0, 0, "Sword", convertColor(Config.tier1BookColor));
	public static Enchant frozenIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFrozen III Enchant Orb", new String[]{"&7Chance to freeze your opponent", "&7in their place for limited time."}, " ", 0, 0, "Sword", convertColor(Config.tier1BookColor));
	
	public static Enchant bulletproofI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lBulletProof I Enchant Orb", new String[]{"&7Chance to deflect arrows."}, " ", 0, 0, "Leggings", convertColor(Config.tier1BookColor));
	public static Enchant bulletproofII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lBulletProof II Enchant Orb", new String[]{"&7Chance to deflect arrows."}, " ", 0, 0, "Leggings", convertColor(Config.tier1BookColor));
	public static Enchant bulletproofIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lBulletProof III Enchant Orb", new String[]{"&7Chance to deflect arrows."}, " ", 0, 0, "Leggings", convertColor(Config.tier1BookColor));
	public static Enchant bulletproofIV = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lBulletProof IV Enchant Orb", new String[]{"&7Chance to deflect arrows."}, " ", 0, 0, "Leggings", convertColor(Config.tier1BookColor));
	
	public static Enchant ghastI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lGhast I Enchant Orb", new String[]{"&7Chance to shoot fireballs", "&7instead of arrows."}, " ", 0, 0, "Bow", convertColor(Config.tier1BookColor));
	public static Enchant ghastII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lGhast II Enchant Orb", new String[]{"&7Chance to shoot fireballs", "&7instead of arrows."}, " ", 0, 0, "Bow", convertColor(Config.tier1BookColor));
	public static Enchant ghastIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lGhast III Enchant Orb", new String[]{"&7Chance to shoot fireballs", "&7instead of arrows."}, " ", 0, 0, "Bow", convertColor(Config.tier1BookColor));

	public static Enchant scavengerI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lScavenger I Enchant Orb", new String[]{"&7Chance to receive more loot", "&7while mining ores."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier1BookColor));
	public static Enchant scavengerII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lScavenger II Enchant Orb", new String[]{"&7Chance to receive more loot", "&7while mining ores."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier1BookColor));
	public static Enchant scavengerIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lScavenger III Enchant Orb", new String[]{"&7Chance to receive more loot", "&7while mining ores."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier1BookColor));
	public static Enchant scavengerIV = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lScavenger IV Enchant Orb", new String[]{"&7Chance to receive more loot", "&7while mining ores."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier1BookColor));
	public static Enchant scavengerV = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lScavenger V Enchant Orb", new String[]{"&7Chance to receive more loot", "&7while mining ores."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier1BookColor));
	
	public static Enchant flashbackI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFlashback I Enchant Orb", new String[]{"&7Chance to teleport behind", "&7your opponent."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant flashbackII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFlashback II Enchant Orb", new String[]{"&7Chance to teleport behind", "&7your opponent."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant flashbackIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFlashback III Enchant Orb", new String[]{"&7Chance to teleport behind", "&7your opponent."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant flashbackIV = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFlashback IV Enchant Orb", new String[]{"&7Chance to teleport behind", "&7your opponent."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant flashbackV = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFlashback V Enchant Orb", new String[]{"&7Chance to teleport behind", "&7your opponent."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant flashbackVI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFlashback VI Enchant Orb", new String[]{"&7Chance to teleport behind", "&7your opponent."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant flashbackVII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFlashback VII Enchant Orb", new String[]{"&7Chance to teleport behind", "&7your opponent."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	public static Enchant flashbackVIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data, Config.tier1BookColor + "&n&lFlashback VIII Enchant Orb", new String[]{"&7Chance to teleport behind", "&7your opponent."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier1BookColor));
	
	public static Enchant witherI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nWither I Enchant Orb", new String[]{"&7Chance to give wither effect", "&7to your attacker."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier1BookColor));
	public static Enchant witherII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nWither II Enchant Orb", new String[]{"&7Chance to give wither effect", "&7to your attacker."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier1BookColor));
	public static Enchant witherIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nWither III Enchant Orb", new String[]{"&7Chance to give wither effect", "&7to your attacker."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier1BookColor));
	public static Enchant witherIV = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nWither IV Enchant Orb", new String[]{"&7Chance to give wither effect", "&7to your attacker."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier1BookColor));
	public static Enchant witherV = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nWither V Enchant Orb", new String[]{"&7Chance to give wither effect", "&7to your attacker."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier1BookColor));
	
	public static Enchant pineappleI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nPineapple I Enchant Orb", new String[]{"&7Chance to give your attacker", "&7a tick of damage."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier1BookColor));
	public static Enchant pineappleII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nPineapple II Enchant Orb", new String[]{"&7Chance to give your attacker", "&7a tick of damage."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier1BookColor));
	
	public static Enchant voltageI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nVoltage I Enchant Orb", new String[]{"&7Chance to strike your attacker", "&7with lightning."}, " ", 0, 0, "Sword", convertColor(Config.tier1BookColor));
	public static Enchant voltageII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nVoltage II Enchant Orb", new String[]{"&7Chance to strike your attacker", "&7with lightning."}, " ", 0, 0, "Sword", convertColor(Config.tier1BookColor));
	public static Enchant voltageIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nVoltage III Enchant Orb", new String[]{"&7Chance to strike your attacker", "&7with lightning."}, " ", 0, 0, "Sword", convertColor(Config.tier1BookColor));
	
	public static Enchant agilityI = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nAgility I Enchant Orb", new String[]{"&7Chance negate the slowness", "&7effect."}, " ", 0, 0, "Boots", convertColor(Config.tier1BookColor));
	public static Enchant agilityII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nAgility II Enchant Orb", new String[]{"&7Chance negate the slowness", "&7effect."}, " ", 0, 0, "Boots", convertColor(Config.tier1BookColor));
	public static Enchant agilityIII = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nAgility III Enchant Orb", new String[]{"&7Chance negate the slowness", "&7effect."}, " ", 0, 0, "Boots", convertColor(Config.tier1BookColor));
	public static Enchant agilityIV = new Enchant(Config.enchantmentBook1Material, Config.enchantmentBook1Data,Config.tier1BookColor + "&l&nAgility IV Enchant Orb", new String[]{"&7Chance negate the slowness", "&7effect."}, " ", 0, 0, "Boots", convertColor(Config.tier1BookColor));
	
	
	
	//ADVANCED
	
	public static Enchant replenishI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lReplenish I Enchant Orb", new String[]{"&7Chance to get regeneration effect", "&7while being attacked."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant replenishII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lReplenish II Enchant Orb", new String[]{"&7Chance to get regeneration effect", "&7while being attacked."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	
	public static Enchant shockI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lShock I Enchant Orb", new String[]{"&7Chance to smite your opponent."}, " ", 0, 0, "Axe, Bow", convertColor(Config.tier2BookColor));
	public static Enchant shockII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lShock II Enchant Orb", new String[]{"&7Chance to smite your opponent."}, " ", 0, 0, "Axe, Bow", convertColor(Config.tier2BookColor));
	public static Enchant shockIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lShock III Enchant Orb", new String[]{"&7Chance to smite your opponent."}, " ", 0, 0, "Axe, Bow", convertColor(Config.tier2BookColor));
	public static Enchant shockIV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lShock IV Enchant Orb", new String[]{"&7Chance to smite your opponent."}, " ", 0, 0, "Axe, Bow", convertColor(Config.tier2BookColor));
	public static Enchant shockV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lShock V Enchant Orb", new String[]{"&7Chance to smite your opponent."}, " ", 0, 0, "Axe, Bow", convertColor(Config.tier2BookColor));
	
	public static Enchant obsidiandestroyerI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lObsidian Destroyer I Enchant Orb", new String[]{"&7Chance to insta break obsidian."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier2BookColor));
	public static Enchant obsidiandestroyerII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lObsidian Destroyer II Enchant Orb", new String[]{"&7Chance to insta break obsidian."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier2BookColor));
	public static Enchant obsidiandestroyerIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lObsidian Destroyer III Enchant Orb", new String[]{"&7Chance to insta break obsidian."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier2BookColor));
	public static Enchant obsidiandestroyerIV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lObsidian Destroyer IV Enchant Orb", new String[]{"&7Chance to insta break obsidian."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier2BookColor));
	public static Enchant obsidiandestroyerV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lObsidian Destroyer V Enchant Orb", new String[]{"&7Chance to insta break obsidian."}, " ", 0, 0, "Pickaxe", convertColor(Config.tier2BookColor));
	
	public static Enchant springsI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSprings I Enchant Orb", new String[]{"&7Gives permanent jump according to", "&7the level of enchant."}, " ", 0, 0, "Boots", convertColor(Config.tier2BookColor));
	public static Enchant springsII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSprings II Enchant Orb", new String[]{"&7Gives permanent jump according to", "&7the level of enchant."}, " ", 0, 0, "Boots", convertColor(Config.tier2BookColor));
	public static Enchant springsIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSprings III Enchant Orb", new String[]{"&7Gives permanent jump according to", "&7the level of enchant."}, " ", 0, 0, "Boots", convertColor(Config.tier2BookColor));
	
	public static Enchant confusionI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lConfusion I Enchant Orb", new String[]{"&7Chance to give your opponent", "&7nausea effect for limited time."}, " ", 0, 0, "Axe", convertColor(Config.tier2BookColor));
	public static Enchant confusionII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lConfusion II Enchant Orb", new String[]{"&7Chance to give your opponent", "&7nausea effect for limited time."}, " ", 0, 0, "Axe", convertColor(Config.tier2BookColor));
	public static Enchant confusionIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lConfusion III Enchant Orb", new String[]{"&7Chance to give your opponent", "&7nausea effect for limited time."}, " ", 0, 0, "Axe", convertColor(Config.tier2BookColor));
	public static Enchant confusionIV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lConfusion IV Enchant Orb", new String[]{"&7Chance to give your opponent", "&7nausea effect for limited time."}, " ", 0, 0, "Axe", convertColor(Config.tier2BookColor));
	public static Enchant confusionV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lConfusion V Enchant Orb", new String[]{"&7Chance to give your opponent", "&7nausea effect for limited time."}, " ", 0, 0, "Axe", convertColor(Config.tier2BookColor));
	
	public static Enchant radioactiveI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lRadioactive I Enchant Orb", new String[]{"&7Chance to give nearby opponents", "&7negative debuffs for limited time."}, " ", 0, 0, "Leggings", convertColor(Config.tier2BookColor));
	public static Enchant radioactiveII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lRadioactive II Enchant Orb", new String[]{"&7Chance to give nearby opponents", "&7negative debuffs for limited time."}, " ", 0, 0, "Leggings", convertColor(Config.tier2BookColor));
	public static Enchant radioactiveIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lRadioactive III Enchant Orb", new String[]{"&7Chance to give nearby opponents", "&7negative debuffs for limited time."}, " ", 0, 0, "Leggings", convertColor(Config.tier2BookColor));
	
	public static Enchant selfdestructI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSelf Destruct I Enchant Orb", new String[]{"&7Chance to drop tnt when you die."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant selfdestructII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSelf Destruct II Enchant Orb", new String[]{"&7Chance to drop tnt when you die."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant selfdestructIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSelf Destruct III Enchant Orb", new String[]{"&7Chance to drop tnt when you die."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	
	public static Enchant creeperI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lCreeper I Enchant Orb", new String[]{"&7Immune to explosions depending on level."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant creeperII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lCreeper II Enchant Orb", new String[]{"&7Immune to explosions depending on level."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant creeperIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lCreeper III Enchant Orb", new String[]{"&7Immune to explosions depending on level."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	
	public static Enchant shieldI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lShield I Enchant Orb", new String[]{"&7Chance to block damage from", "&7your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier2BookColor));
	public static Enchant shieldII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lShield II Enchant Orb", new String[]{"&7Chance to block damage from", "&7your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier2BookColor));
	public static Enchant shieldIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lShield III Enchant Orb", new String[]{"&7Chance to block damage from", "&7your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier2BookColor));
	public static Enchant shieldIV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lShield IV Enchant Orb", new String[]{"&7Chance to block damage from", "&7your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier2BookColor));
	
	public static Enchant ninjaI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lNinja I Enchant Orb", new String[]{"&7Chance get a burst of speed 4", "&7when low on hp."}, " ", 0, 0, "Boots", convertColor(Config.tier2BookColor));
	
	public static Enchant marshmallowI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lMarshmallow I Enchant Orb", new String[]{"&7Chance to gain resistance for a", "&7limited time."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier2BookColor));
	public static Enchant marshmallowII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lMarshmallow II Enchant Orb", new String[]{"&7Chance to gain resistance for a", "&7limited time."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier2BookColor));
	public static Enchant marshmallowIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lMarshmallow III Enchant Orb", new String[]{"&7Chance to gain resistance for a", "&7limited time."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier2BookColor));
	public static Enchant marshmallowIV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lMarshmallow IV Enchant Orb", new String[]{"&7Chance to gain resistance for a", "&7limited time."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier2BookColor));
	public static Enchant marshmallowV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lMarshmallow V Enchant Orb", new String[]{"&7Chance to gain resistance for a", "&7limited time."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier2BookColor));
	
	public static Enchant thiefI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lThief I Enchant Orb", new String[]{"&7Chance to steal your opponents", "&7xp or money."}, " ", 0, 0, "Sword", convertColor(Config.tier2BookColor));
	public static Enchant thiefII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lThief II Enchant Orb", new String[]{"&7Chance to steal your opponents", "&7xp or money."}, " ", 0, 0, "Sword", convertColor(Config.tier2BookColor));
	public static Enchant thiefIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lThief III Enchant Orb", new String[]{"&7Chance to steal your opponents", "&7xp or money."}, " ", 0, 0, "Sword", convertColor(Config.tier2BookColor));
	
	public static Enchant counterI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lCounter I Enchant Orb", new String[]{"&7Chance to redirect an attack back", "&7onto your opponent."}, "", 0, 0, "Leggings", convertColor(Config.tier2BookColor));
	public static Enchant counterII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lCounter II Enchant Orb", new String[]{"&7Chance to redirect an attack back", "&7onto your opponent."}, "", 0, 0, "Leggings", convertColor(Config.tier2BookColor));
	public static Enchant counterIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lCounter III Enchant Orb", new String[]{"&7Chance to redirect an attack back", "&7onto your opponent."}, "", 0, 0, "Leggings", convertColor(Config.tier2BookColor));
	
	public static Enchant woundI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lWound I Enchant Orb", new String[]{"&7Chance to give the bleed effect", "&7to your opponent."}, "", 0, 0, "Sword, Axe", convertColor(Config.tier2BookColor));
	public static Enchant woundII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lWound II Enchant Orb", new String[]{"&7Chance to give the bleed effect", "&7to your opponent."}, "", 0, 0, "Sword, Axe", convertColor(Config.tier2BookColor));
	public static Enchant woundIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lWound III Enchant Orb", new String[]{"&7Chance to give the bleed effect", "&7to your opponent."}, "", 0, 0, "Sword, Axe", convertColor(Config.tier2BookColor));
	public static Enchant woundIV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lWound IV Enchant Orb", new String[]{"&7Chance to give the bleed effect", "&7to your opponent."}, "", 0, 0, "Sword, Axe", convertColor(Config.tier2BookColor));
	
	public static Enchant safeguardI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSafeguard I Enchant Orb", new String[]{"&7Chance to spawn iron golems to", "&7defend you"}, "", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant safeguardII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSafeguard II Enchant Orb", new String[]{"&7Chance to spawn iron golems to", "&7defend you"}, "", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant safeguardIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSafeguard III Enchant Orb", new String[]{"&7Chance to spawn iron golems to", "&7defend you"}, "", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant safeguardIV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSafeguard IV Enchant Orb", new String[]{"&7Chance to spawn iron golems to", "&7defend you"}, "", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant safeguardV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSafeguard V Enchant Orb", new String[]{"&7Chance to spawn iron golems to", "&7defend you"}, "", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant safeguardVI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSafeguard VI Enchant Orb", new String[]{"&7Chance to spawn iron golems to", "&7defend you"}, "", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant safeguardVII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSafeguard VII Enchant Orb", new String[]{"&7Chance to spawn iron golems to", "&7defend you"}, "", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant safeguardVIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSafeguard VIII Enchant Orb", new String[]{"&7Chance to spawn iron golems to", "&7defend you"}, "", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant safeguardIX = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSafeguard IX Enchant Orb", new String[]{"&7Chance to spawn iron golems to", "&7defend you"}, "", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	public static Enchant safeguardX = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lSafeguard X Enchant Orb", new String[]{"&7Chance to spawn iron golems to", "&7defend you"}, "", 0, 0, "Chestplate, Leggings", convertColor(Config.tier2BookColor));
	
	public static Enchant pushI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lPush I Enchant Orb", new String[]{"&7Chance to cause extreme knockback", "&7to your opponent."}, "", 0, 0, "Sword, Axe", convertColor(Config.tier2BookColor));
	public static Enchant pushII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lPush II Enchant Orb", new String[]{"&7Chance to cause extreme knockback", "&7to your opponent."}, "", 0, 0, "Sword, Axe", convertColor(Config.tier2BookColor));
	
	public static Enchant virusI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lVirus I Enchant Orb", new String[]{"&7Chance to give your opponent", "&7weakness for a limited time."}, "", 0, 0, "Axe", convertColor(Config.tier2BookColor));
	public static Enchant virusII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lVirus II Enchant Orb", new String[]{"&7Chance to give your opponent", "&7weakness for a limited time."}, "", 0, 0, "Axe", convertColor(Config.tier2BookColor));
	public static Enchant virusIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lVirus III Enchant Orb", new String[]{"&7Chance to give your opponent", "&7weakness for a limited time."}, "", 0, 0, "Axe", convertColor(Config.tier2BookColor));
	
	public static Enchant minerI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lMiner I Enchant Orb", new String[]{"&7Chance to get more xp from", "&7mining ores."}, "", 0, 0, "Pickaxe", convertColor(Config.tier2BookColor));
	public static Enchant minerII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lMiner II Enchant Orb", new String[]{"&7Chance to get more xp from", "&7mining ores."}, "", 0, 0, "Pickaxe", convertColor(Config.tier2BookColor));
	public static Enchant minerIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lMiner III Enchant Orb", new String[]{"&7Chance to get more xp from", "&7mining ores."}, "", 0, 0, "Pickaxe", convertColor(Config.tier2BookColor));
	public static Enchant minerIV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lMiner IV Enchant Orb", new String[]{"&7Chance to get more xp from", "&7mining ores."}, "", 0, 0, "Pickaxe", convertColor(Config.tier2BookColor));
	public static Enchant minerV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lMiner V Enchant Orb", new String[]{"&7Chance to get more xp from", "&7mining ores."}, "", 0, 0, "Pickaxe", convertColor(Config.tier2BookColor));
	
	public static Enchant blazeI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lBlaze I Enchant Orb", new String[]{"&7Gives permanent fire resistance."}, "", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier2BookColor));
	
	public static Enchant wormholeI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lWormhole I Enchant Orb", new String[]{"&7On low hp receive high levels of", "&7speed, regeneration and blindness", "&7to escape your attacker."}, "", 0, 0, "Helmet", convertColor(Config.tier2BookColor));
	public static Enchant wormholeII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lWormhole II Enchant Orb", new String[]{"&7On low hp receive high levels of", "&7speed, regeneration and blindness", "&7to escape your attacker."}, "", 0, 0, "Helmet", convertColor(Config.tier2BookColor));
	public static Enchant wormholeIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lWormhole III Enchant Orb", new String[]{"&7On low hp receive high levels of", "&7speed, regeneration and blindness", "&7to escape your attacker."}, "", 0, 0, "Helmet", convertColor(Config.tier2BookColor));
	
	public static Enchant fractureI = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lFracture I Enchant Orb", new String[]{"&7Chance to give your opponent slowness,", "&7slow swinging and strike lightning ", "&7on your enemy."}, "", 0, 0, "Sword", convertColor(Config.tier2BookColor));
	public static Enchant fractureII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lFracture II Enchant Orb", new String[]{"&7Chance to give your opponent slowness,", "&7slow swinging and strike lightning ", "&7on your enemy."}, "", 0, 0, "Sword", convertColor(Config.tier2BookColor));
	public static Enchant fractureIII = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lFracture III Enchant Orb", new String[]{"&7Chance to give your opponent slowness,", "&7slow swinging and strike lightning ", "&7on your enemy."}, "", 0, 0, "Sword", convertColor(Config.tier2BookColor));
	public static Enchant fractureIV = new Enchant(Config.enchantmentBook2Material, Config.enchantmentBook2Data, Config.tier2BookColor + "&n&lFracture IV Enchant Orb", new String[]{"&7Chance to give your opponent slowness,", "&7slow swinging and strike lightning ", "&7on your enemy."}, "", 0, 0, "Sword", convertColor(Config.tier2BookColor));
	//EPIC
	
	public static Enchant chickenI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lChicken I Enchant Orb", new String[]{"&7Chance to negate fall damage."}, " ", 0, 0, "Boots", convertColor(Config.tier3BookColor));
	public static Enchant chickenII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lChicken II Enchant Orb", new String[]{"&7Chance to negate fall damage."}, " ", 0, 0, "Boots", convertColor(Config.tier3BookColor));
	public static Enchant chickenIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lChicken III Enchant Orb", new String[]{"&7Chance to negate fall damage."}, " ", 0, 0, "Boots", convertColor(Config.tier3BookColor));
	
	public static Enchant punctureI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lPuncture I Enchant Orb", new String[]{"&7Chance to deal more damage to", "&7your opponents armor."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant punctureII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lPuncture II Enchant Orb", new String[]{"&7Chance to deal more damage to", "&7your opponents armor."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant punctureIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lPuncture III Enchant Orb", new String[]{"&7Chance to deal more damage to", "&7your opponents armor."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant punctureIV = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lPuncture IV Enchant Orb", new String[]{"&7Chance to deal more damage to", "&7your opponents armor."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	
	public static Enchant overloadI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lOverload I Enchant Orb", new String[]{"&7Gives permanent health boost."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier3BookColor));
	public static Enchant overloadII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lOverload II Enchant Orb", new String[]{"&7Gives permanent health boost."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier3BookColor));
	public static Enchant overloadIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lOverload III Enchant Orb", new String[]{"&7Gives permanent health boost."}, " ", 0, 0, "Chestplate, Leggings", convertColor(Config.tier3BookColor));
	
	public static Enchant blessedI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lBlessed I Enchant Orb", new String[]{"&7Chance to remove all negative", "&7potion effects."}, " ", 0, 0, "Axe", convertColor(Config.tier3BookColor));
	public static Enchant blessedII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lBlessed II Enchant Orb", new String[]{"&7Chance to remove all negative", "&7potion effects."}, " ", 0, 0, "Axe", convertColor(Config.tier3BookColor));
	public static Enchant blessedIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lBlessed III Enchant Orb", new String[]{"&7Chance to remove all negative", "&7potion effects."}, " ", 0, 0, "Axe", convertColor(Config.tier3BookColor));
	
	public static Enchant angelI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lAngel I Enchant Orb", new String[]{"&7Chance to get regeneration 3", "&7on low hp."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	public static Enchant angelII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lAngel II Enchant Orb", new String[]{"&7Chance to get regeneration 3", "&7on low hp."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	public static Enchant angelIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lAngel III Enchant Orb", new String[]{"&7Chance to get regeneration 3", "&7on low hp."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	
	public static Enchant trophyI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lTrophy I Enchant Orb", new String[]{"&7Chance for your opponents head", "&7to drop when they die."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier3BookColor));
	public static Enchant trophyII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lTrophy II Enchant Orb", new String[]{"&7Chance for your opponents head", "&7to drop when they die."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier3BookColor));
	public static Enchant trophyIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lTrophy III Enchant Orb", new String[]{"&7Chance for your opponents head", "&7to drop when they die."}, " ", 0, 0, "Sword, Axe", convertColor(Config.tier3BookColor));
	
	public static Enchant flashbangI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lFlashbang I Enchant Orb", new String[]{"&7Chance to blind your opponent", "&7with particle effects."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	public static Enchant flashbangII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lFlashbang II Enchant Orb", new String[]{"&7Chance to blind your opponent", "&7with particle effects."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	public static Enchant flashbangIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lFlashbang III Enchant Orb", new String[]{"&7Chance to blind your opponent", "&7with particle effects."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	public static Enchant flashbangIV = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lFlashbang IV Enchant Orb", new String[]{"&7Chance to blind your opponent", "&7with particle effects."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	public static Enchant flashbangV = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lFlashbang V Enchant Orb", new String[]{"&7Chance to blind your opponent", "&7with particle effects."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	public static Enchant flashbangVI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lFlashbang VI Enchant Orb", new String[]{"&7Chance to blind your opponent", "&7with particle effects."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	public static Enchant flashbangVII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lFlashbang VII Enchant Orb", new String[]{"&7Chance to blind your opponent", "&7with particle effects."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	public static Enchant flashbangVIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lFlashbang VIII Enchant Orb", new String[]{"&7Chance to blind your opponent", "&7with particle effects."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	
	public static Enchant archerI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lArcher I Enchant Orb", new String[]{"&7Chance for arrows to deal", "&7double damage."}, " ", 0, 0, "Bow", convertColor(Config.tier3BookColor));
	public static Enchant archerII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lArcher II Enchant Orb", new String[]{"&7Chance for arrows to deal", "&7double damage."}, " ", 0, 0, "Bow", convertColor(Config.tier3BookColor));
	public static Enchant archerIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lArcher III Enchant Orb", new String[]{"&7Chance for arrows to deal", "&7double damage."}, " ", 0, 0, "Bow", convertColor(Config.tier3BookColor));
	
	public static Enchant spectralI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lSpectral I Enchant Orb", new String[]{"&7Chance to go invisible for a limited time."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	public static Enchant spectralII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lSpectral II Enchant Orb", new String[]{"&7Chance to go invisible for a limited time."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	public static Enchant spectralIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lSpectral III Enchant Orb", new String[]{"&7Chance to go invisible for a limited time."}, " ", 0, 0, "Helmet", convertColor(Config.tier3BookColor));
	
	public static Enchant bruteI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lBrute I Enchant Orb", new String[]{"&7Chance to decrease damage from axes", "&7by 1.85x per level."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant bruteII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lBrute II Enchant Orb", new String[]{"&7Chance to decrease damage from axes", "&7by 1.85x per level."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant bruteIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lBrute III Enchant Orb", new String[]{"&7Chance to decrease damage from axes", "&7by 1.85x per level."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant bruteIV = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lBrute IV Enchant Orb", new String[]{"&7Chance to decrease damage from axes", "&7by 1.85x per level."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	
	public static Enchant vestI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lVest I Enchant Orb", new String[]{"&7Chance to decrease damage from swords", "&7by 1.85x per level."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant vestII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lVest II Enchant Orb", new String[]{"&7Chance to decrease damage from swords", "&7by 1.85x per level."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant vestIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lVest III Enchant Orb", new String[]{"&7Chance to decrease damage from swords", "&7by 1.85x per level."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant vestIV = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lVest IV Enchant Orb", new String[]{"&7Chance to decrease damage from swords", "&7by 1.85x per level."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	
	public static Enchant collectionI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lCollection I Enchant Orb", new String[]{"&7Chance to put all the items from", "&7your opponents inventory into", "&7a bag instead of dropping all", "&7items on death."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant collectionII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lCollection II Enchant Orb", new String[]{"&7Chance to put all the items from", "&7your opponents inventory into", "&7a bag instead of dropping all", "&7items on death."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant collectionIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lCollection III Enchant Orb", new String[]{"&7Chance to put all the items from", "&7your opponents inventory into", "&7a bag instead of dropping all", "&7items on death."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	
	public static Enchant overdoseI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lOverdose I Enchant Orb", new String[]{"&7Chance to deal extra damage."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant overdoseII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lOverdose II Enchant Orb", new String[]{"&7Chance to deal extra damage."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant overdoseIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lOverdose III Enchant Orb", new String[]{"&7Chance to deal extra damage."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	
	public static Enchant muffleI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lMuffle I Enchant Orb", new String[]{"&7Chance to stop your opponents", "&7enchants from activating for", "&7a limited time."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant muffleII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lMuffle II Enchant Orb", new String[]{"&7Chance to stop your opponents", "&7enchants from activating for", "&7a limited time."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant muffleIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lMuffle III Enchant Orb", new String[]{"&7Chance to stop your opponents", "&7enchants from activating for", "&7a limited time."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant muffleIV = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lMuffle IV Enchant Orb", new String[]{"&7Chance to stop your opponents", "&7enchants from activating for", "&7a limited time."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	
	public static Enchant pyroI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lPyro I Enchant Orb", new String[]{"&7Chance to deal more damage while", "&7your opponent is on fire."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant pyroII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lPyro II Enchant Orb", new String[]{"&7Chance to deal more damage while", "&7your opponent is on fire."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant pyroIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lPyro III Enchant Orb", new String[]{"&7Chance to deal more damage while", "&7your opponent is on fire."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	
	public static Enchant luckyI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lLucky I Enchant Orb", new String[]{"&7You will find yourself lucky in", "&7certain situations."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant luckyII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lLucky II Enchant Orb", new String[]{"&7You will find yourself lucky in", "&7certain situations."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant luckyIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lLucky III Enchant Orb", new String[]{"&7You will find yourself lucky in", "&7certain situations."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant luckyIV = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lLucky IV Enchant Orb", new String[]{"&7You will find yourself lucky in", "&7certain situations."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant luckyV = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lLucky V Enchant Orb", new String[]{"&7You will find yourself lucky in", "&7certain situations."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant luckyVI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lLucky VI Enchant Orb", new String[]{"&7You will find yourself lucky in", "&7certain situations."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant luckyVII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lLucky VII Enchant Orb", new String[]{"&7You will find yourself lucky in", "&7certain situations."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant luckyVIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lLucky VIII Enchant Orb", new String[]{"&7You will find yourself lucky in", "&7certain situations."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant luckyIX = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lLucky IX Enchant Orb", new String[]{"&7You will find yourself lucky in", "&7certain situations."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	public static Enchant luckyX = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data, Config.tier3BookColor + "&n&lLucky X Enchant Orb", new String[]{"&7You will find yourself lucky in", "&7certain situations."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier3BookColor));
	
	public static Enchant snareI = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data,Config.tier3BookColor + "&l&nSnare I Enchant Orb", new String[]{"&7Chance give your enemy the slowness", "&7effect."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant snareII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data,Config.tier3BookColor + "&l&nSnare II Enchant Orb", new String[]{"&7Chance give your enemy the slowness", "&7effect."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	public static Enchant snareIII = new Enchant(Config.enchantmentBook3Material, Config.enchantmentBook3Data,Config.tier3BookColor + "&l&nSnare III Enchant Orb", new String[]{"&7Chance give your enemy the slowness", "&7effect."}, " ", 0, 0, "Sword", convertColor(Config.tier3BookColor));
	
	//LEGENDARY
	
	public static Enchant juggernautI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lJuggernaut I Enchant Orb", new String[]{"&7Gives permanent strength, slowness",  "&7and mining fatigue."}, " ", 0, 0, "Helmet", convertColor(Config.tier4BookColor));
	public static Enchant juggernautII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lJuggernaut II Enchant Orb", new String[]{"&7Gives permanent strength, slowness",  "&7and mining fatigue."}, " ", 0, 0, "Helmet", convertColor(Config.tier4BookColor));
	public static Enchant juggernautIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lJuggernaut III Enchant Orb", new String[]{"&7Gives permanent strength, slowness",  "&7and mining fatigue."}, " ", 0, 0, "Helmet", convertColor(Config.tier4BookColor));
	public static Enchant juggernautIV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lJuggernaut IV Enchant Orb", new String[]{"&7Gives permanent strength, slowness",  "&7and mining fatigue."}, " ", 0, 0, "Helmet", convertColor(Config.tier4BookColor));
	
	public static Enchant greedI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lGreed I Enchant Orb", new String[]{"&7Chance to get more xp from",  "&7killing mobs."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant greedII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lGreed II Enchant Orb", new String[]{"&7Chance to get more xp from",  "&7killing mobs."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant greedIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lGreed III Enchant Orb", new String[]{"&7Chance to get more xp from",  "&7killing mobs."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant greedIV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lGreed IV Enchant Orb", new String[]{"&7Chance to get more xp from",  "&7killing mobs."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	
	public static Enchant lifestealI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lLifesteal I Enchant Orb", new String[]{"&7Chance to steal health from",  "&7your opponent."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant lifestealII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lLifesteal II Enchant Orb", new String[]{"&7Chance to steal health from",  "&7your opponent."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant lifestealIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lLifesteal III Enchant Orb", new String[]{"&7Chance to steal health from",  "&7your opponent."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant lifestealIV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lLifesteal IV Enchant Orb", new String[]{"&7Chance to steal health from",  "&7your opponent."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant lifestealV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lLifesteal V Enchant Orb", new String[]{"&7Chance to steal health from",  "&7your opponent."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	
	public static Enchant rageI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lRage I Enchant Orb", new String[]{"&7Chance to multiply damage by 1.1x",  "&7for every combo you land."}, " ", 0, 0, "Sword, Axe, Bow", convertColor(Config.tier4BookColor));
	public static Enchant rageII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lRage II Enchant Orb", new String[]{"&7Chance to multiply damage by 1.1x",  "&7for every combo you land."}, " ", 0, 0, "Sword, Axe, Bow", convertColor(Config.tier4BookColor));
	public static Enchant rageIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lRage III Enchant Orb", new String[]{"&7Chance to multiply damage by 1.1x",  "&7for every combo you land."}, " ", 0, 0, "Sword, Axe, Bow", convertColor(Config.tier4BookColor));
	public static Enchant rageIV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lRage IV Enchant Orb", new String[]{"&7Chance to multiply damage by 1.1x",  "&7for every combo you land."}, " ", 0, 0, "Sword, Axe, Bow", convertColor(Config.tier4BookColor));
	public static Enchant rageV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lRage V Enchant Orb", new String[]{"&7Chance to multiply damage by 1.1x",  "&7for every combo you land."}, " ", 0, 0, "Sword, Axe, Bow", convertColor(Config.tier4BookColor));
	public static Enchant rageVI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lRage VI Enchant Orb", new String[]{"&7Chance to multiply damage by 1.1x",  "&7for every combo you land."}, " ", 0, 0, "Sword, Axe, Bow", convertColor(Config.tier4BookColor));
	
	public static Enchant meteorI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lMeteor I Enchant Orb", new String[]{"&7Chance to launch op fireballs",  "&7at your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier4BookColor));
	public static Enchant meteorII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lMeteor II Enchant Orb", new String[]{"&7Chance to launch op fireballs",  "&7at your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier4BookColor));
	public static Enchant meteorIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lMeteor III Enchant Orb", new String[]{"&7Chance to launch op fireballs",  "&7at your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier4BookColor));
	public static Enchant meteorIV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lMeteor IV Enchant Orb", new String[]{"&7Chance to launch op fireballs",  "&7at your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier4BookColor));
	public static Enchant meteorV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lMeteor V Enchant Orb", new String[]{"&7Chance to launch op fireballs",  "&7at your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier4BookColor));
	public static Enchant meteorVI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lMeteor VI Enchant Orb", new String[]{"&7Chance to launch op fireballs",  "&7at your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier4BookColor));
	public static Enchant meteorVII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lMeteor VII Enchant Orb", new String[]{"&7Chance to launch op fireballs",  "&7at your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier4BookColor));
	public static Enchant meteorVIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lMeteor VIII Enchant Orb", new String[]{"&7Chance to launch op fireballs",  "&7at your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier4BookColor));
	public static Enchant meteorIX = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lMeteor IX Enchant Orb", new String[]{"&7Chance to launch op fireballs",  "&7at your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier4BookColor));
	public static Enchant meteorX = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lMeteor X Enchant Orb", new String[]{"&7Chance to launch op fireballs",  "&7at your opponent."}, " ", 0, 0, "Chestplate", convertColor(Config.tier4BookColor));
	
	public static Enchant auraI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lAura I Enchant Orb", new String[]{"&7Chance to damage nearby opponents."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	public static Enchant auraII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lAura II Enchant Orb", new String[]{"&7Chance to damage nearby opponents."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	public static Enchant auraIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lAura III Enchant Orb", new String[]{"&7Chance to damage nearby opponents."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	public static Enchant auraIV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lAura IV Enchant Orb", new String[]{"&7Chance to damage nearby opponents."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	public static Enchant auraV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lAura V Enchant Orb", new String[]{"&7Chance to damage nearby opponents."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	
	public static Enchant immolationI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lImmolation I Enchant Orb", new String[]{"&7Chance to deal insane damage and", "&7light all nearby opponents on fire."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant immolationII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lImmolation II Enchant Orb", new String[]{"&7Chance to deal insane damage and", "&7light all nearby opponents on fire."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant immolationIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lImmolation III Enchant Orb", new String[]{"&7Chance to deal insane damage and", "&7light all nearby opponents on fire."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant immolationIV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lImmolation IV Enchant Orb", new String[]{"&7Chance to deal insane damage and", "&7light all nearby opponents on fire."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	
	public static Enchant barbarianI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lBarbarian I Enchant Orb", new String[]{"&7Chance deal more damage when your", "&7opponent is holding an axe."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	public static Enchant barbarianII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lBarbarian II Enchant Orb", new String[]{"&7Chance deal more damage when your", "&7opponent is holding an axe."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	public static Enchant barbarianIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lBarbarian III Enchant Orb", new String[]{"&7Chance deal more damage when your", "&7opponent is holding an axe."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	public static Enchant barbarianIV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lBarbarian IV Enchant Orb", new String[]{"&7Chance deal more damage when your", "&7opponent is holding an axe."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	
	public static Enchant enrageI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lEnrage I Enchant Orb", new String[]{"&7Chance deal more damage when you", "&7have low hp."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	public static Enchant enrageII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lEnrage II Enchant Orb", new String[]{"&7Chance deal more damage when you", "&7have low hp."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	public static Enchant enrageIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lEnrage III Enchant Orb", new String[]{"&7Chance deal more damage when you", "&7have low hp."}, " ", 0, 0, "Axe", convertColor(Config.tier4BookColor));
	
	public static Enchant lifelineI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lLifeline I Enchant Orb", new String[]{"&7Chance to heal while taking", "&7damage."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier4BookColor));
	public static Enchant lifelineII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lLifeline II Enchant Orb", new String[]{"&7Chance to heal while taking", "&7damage."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier4BookColor));
	public static Enchant lifelineIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lLifeline III Enchant Orb", new String[]{"&7Chance to heal while taking", "&7damage."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier4BookColor));
	
	public static Enchant hyperI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lHyper I Enchant Orb", new String[]{"&7Gives permanent speed according to", "&7the level of enchant."}, " ", 0, 0, "Boots", convertColor(Config.tier4BookColor));
	public static Enchant hyperII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lHyper II Enchant Orb", new String[]{"&7Gives permanent speed according to", "&7the level of enchant."}, " ", 0, 0, "Boots", convertColor(Config.tier4BookColor));
	public static Enchant hyperIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lHyper III Enchant Orb", new String[]{"&7Gives permanent speed according to", "&7the level of enchant."}, " ", 0, 0, "Boots", convertColor(Config.tier4BookColor));
	
	public static Enchant jetpackI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lJetpack I Enchant Orb", new String[]{"&7Chance to shoot into the sky to", "&7escape death on low hp."}, " ", 0, 0, "Boots", convertColor(Config.tier4BookColor));
	public static Enchant jetpackII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lJetpack II Enchant Orb", new String[]{"&7Chance to shoot into the sky to", "&7escape death on low hp."}, " ", 0, 0, "Boots", convertColor(Config.tier4BookColor));
	public static Enchant jetpackIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lJetpack III Enchant Orb", new String[]{"&7Chance to shoot into the sky to", "&7escape death on low hp."}, " ", 0, 0, "Boots", convertColor(Config.tier4BookColor));
	
	public static Enchant reinforcedI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lReinforced I Enchant Orb", new String[]{"&7Chance for your armor to", "&7take less durability damage."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier4BookColor));
	public static Enchant reinforcedII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lReinforced II Enchant Orb", new String[]{"&7Chance for your armor to", "&7take less durability damage."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier4BookColor));
	public static Enchant reinforcedIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lReinforced III Enchant Orb", new String[]{"&7Chance for your armor to", "&7take less durability damage."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier4BookColor));
	
	public static Enchant adrenalineI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lAdrenaline I Enchant Orb", new String[]{"&7Chance to cancel an attack and", "&7gain 1-3 hp instead."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant adrenalineII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lAdrenaline II Enchant Orb", new String[]{"&7Chance to cancel an attack and", "&7gain 1-3 hp instead."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant adrenalineIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lAdrenaline III Enchant Orb", new String[]{"&7Chance to cancel an attack and", "&7gain 1-3 hp instead."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	public static Enchant adrenalineIV = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lAdrenaline IV Enchant Orb", new String[]{"&7Chance to cancel an attack and", "&7gain 1-3 hp instead."}, " ", 0, 0, "Sword", convertColor(Config.tier4BookColor));
	
	public static Enchant eyepatchI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lEyepatch I Enchant Orb", new String[]{"&7Chance to negate the blindness", "&7effect."}, " ", 0, 0, "Helmet", convertColor(Config.tier4BookColor));
	public static Enchant eyepatchII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lEyepatch II Enchant Orb", new String[]{"&7Chance to negate the blindness", "&7effect."}, " ", 0, 0, "Helmet", convertColor(Config.tier4BookColor));
	public static Enchant eyepatchIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lEyepatch III Enchant Orb", new String[]{"&7Chance to negate the blindness", "&7effect."}, " ", 0, 0, "Helmet", convertColor(Config.tier4BookColor));
	
	public static Enchant bloodthirstyI = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lBloodthirsty I Enchant Orb", new String[]{"&7Chance deal extra damage to", "&7your enemy."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier4BookColor));
	public static Enchant bloodthirstyII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lBloodthirsty II Enchant Orb", new String[]{"&7Chance deal extra damage to", "&7your enemy."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier4BookColor));
	public static Enchant bloodthirstyIII = new Enchant(Config.enchantmentBook4Material, Config.enchantmentBook4Data, Config.tier4BookColor + "&n&lBloodthirsty III Enchant Orb", new String[]{"&7Chance deal extra damage to", "&7your enemy."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier4BookColor));
	
	
	//ANCIENT
	public static Enchant butcherI = new Enchant(Config.enchantmentBook5Material, Config.enchantmentBook5Data, Config.tier5BookColor + "&n&lButcher I Enchant Orb", new String[]{"&7Chance to temporarily disable hit", "&7delay, adds 1.5 seconds per level.", "&7Costs 100 artifacts per proc."}, " ", 0, 0, "Axe", convertColor(Config.tier5BookColor));
	public static Enchant butcherII = new Enchant(Config.enchantmentBook5Material, Config.enchantmentBook5Data, Config.tier5BookColor + "&n&lButcher II Enchant Orb", new String[]{"&7Chance to temporarily disable hit", "&7delay, adds 1.5 seconds per level.", "&7Costs 100 artifacts per proc."}, " ", 0, 0, "Axe", convertColor(Config.tier5BookColor));
	public static Enchant butcherIII = new Enchant(Config.enchantmentBook5Material, Config.enchantmentBook5Data, Config.tier5BookColor + "&n&lButcher III Enchant Orb", new String[]{"&7Chance to temporarily disable hit", "&7delay, adds 1.5 seconds per level.", "&7Costs 100 artifacts per proc."}, " ", 0, 0, "Axe", convertColor(Config.tier5BookColor));
	public static Enchant butcherIV = new Enchant(Config.enchantmentBook5Material, Config.enchantmentBook5Data, Config.tier5BookColor + "&n&lButcher IV Enchant Orb", new String[]{"&7Chance to temporarily disable hit", "&7delay, adds 1.5 seconds per level.", "&7Costs 100 artifacts per proc."}, " ", 0, 0, "Axe", convertColor(Config.tier5BookColor));
	
	public static Enchant anvilI = new Enchant(Config.enchantmentBook5Material, Config.enchantmentBook5Data, Config.tier5BookColor + "&n&lAnvil I Enchant Orb", new String[]{"&7Chance to slightly repair your armor.", "&7Costs 75 artifacts per proc."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier5BookColor));
	public static Enchant anvilII = new Enchant(Config.enchantmentBook5Material, Config.enchantmentBook5Data, Config.tier5BookColor + "&n&lAnvil II Enchant Orb", new String[]{"&7Chance to slightly repair your armor.", "&7Costs 75 artifacts per proc."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier5BookColor));
	public static Enchant anvilIII = new Enchant(Config.enchantmentBook5Material, Config.enchantmentBook5Data, Config.tier5BookColor + "&n&lAnvil III Enchant Orb", new String[]{"&7Chance to slightly repair your armor.", "&7Costs 75 artifacts per proc."}, " ", 0, 0, "Helmet, Chestplate, Leggings, Boots", convertColor(Config.tier5BookColor));
	
	//SPECIAL
	
	public static ItemStack lootingIV = API.itemBuilder(Material.ENCHANTED_BOOK, (short) 0, 1, "&6&l&nLooting IV Enchant Book", new String[]{" ", "&7Applies Looting IV to your gear, this", "&7is a vanilla enchantment.", " ", "&9Enchant Target(s): &7Sword, Axe"}, false);
	public static ItemStack lootingV = API.itemBuilder(Material.ENCHANTED_BOOK, (short) 0, 1, "&6&l&nLooting V Enchant Book", new String[]{" ", "&7Applies Looting V to your gear, this", "&7is a vanilla enchantment.", " ", "&9Enchant Target(s): &7Sword, Axe"}, false);

	public static ItemStack depthStriderI = API.itemBuilder(Material.ENCHANTED_BOOK, (short) 0, 1, "&6&l&nDepth Strider I Enchant Book", new String[]{" ", "&7Applies Depth Strider I to your gear, this", "&7is a vanilla enchantment.", " ", "&9Enchant Target(s): &7Boots"}, false);
	public static ItemStack depthStriderII = API.itemBuilder(Material.ENCHANTED_BOOK, (short) 0, 1, "&6&l&nDepth Strider II Enchant Book", new String[]{" ", "&7Applies Depth Strider II to your gear, this", "&7is a vanilla enchantment.", " ", "&9Enchant Target(s): &7Boots"}, false);
	public static ItemStack depthStriderIII = API.itemBuilder(Material.ENCHANTED_BOOK, (short) 0, 1, "&6&l&nDepth Strider III Enchant Book", new String[]{" ", "&7Applies Depth Strider III to your gear, this", "&7is a vanilla enchantment.", " ", "&9Enchant Target(s): &7Boots"}, false);
}

