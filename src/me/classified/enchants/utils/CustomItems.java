package me.classified.enchants.utils;

import me.classified.enchants.cEnchants;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CustomItems {


	public static ItemStack getReaperShard(String type) {
		String shardType = "Helmet";
		switch(type.toLowerCase()) {
		case "helmet":
			shardType = "Helmet";
			break;
		case "chestplate":
			shardType = "Chestplate";
			break;
		case "leggings":
			shardType = "Leggings";
			break;
		case "boots":
			shardType = "Boots";
			break;
		default:
			shardType = "Helmet";
			break;
		}
		ItemStack shard = API.itemBuilder(Material.EYE_OF_ENDER, (short) 0, 1, "&c&lReaper Set Shard &7(Apply)", new String[] {"&7Apply this shard to a piece of gear", "&7to upgrade it to a Reaper set piece.", " ", "&c&lShard Type: &7" + shardType, " ", "&c&lNOTE: &7You must have all 4 pieces of the", "&7Reaper set to receive its bonus.", " ", "&7&oDrag n drop onto item to apply."}, false);
		return shard;
	}
	
	public static ItemStack getGoblinShard(String type) {
		String shardType = "Helmet";
		switch(type.toLowerCase()) {
		case "helmet":
			shardType = "Helmet";
			break;
		case "chestplate":
			shardType = "Chestplate";
			break;
		case "leggings":
			shardType = "Leggings";
			break;
		case "boots":
			shardType = "Boots";
			break;
		default:
			shardType = "Helmet";
			break;
		}
		ItemStack shard = API.itemBuilder(Material.EYE_OF_ENDER, (short) 0, 1, "&a&lGoblin Set Shard &7(Apply)", new String[] {"&7Apply this shard to a piece of gear", "&7to upgrade it to a Goblin set piece.", " ", "&a&lShard Type: &7" + shardType, " ", "&c&lNOTE: &7You must have all 4 pieces of the", "&7Goblin set to receive its bonus.", " ", "&7&oDrag n drop onto item to apply."}, false);
		return shard;
	}
	
	public static ItemStack getPheonixShard(String type) {
		String shardType = "Helmet";
		switch(type.toLowerCase()) {
		case "helmet":
			shardType = "Helmet";
			break;
		case "chestplate":
			shardType = "Chestplate";
			break;
		case "leggings":
			shardType = "Leggings";
			break;
		case "boots":
			shardType = "Boots";
			break;
		default:
			shardType = "Helmet";
			break;
		}
		ItemStack shard = API.itemBuilder(Material.EYE_OF_ENDER, (short) 0, 1, "&b&lPheonix Set Shard &7(Apply)", new String[] {"&7Apply this shard to a piece of gear", "&7to upgrade it to a Pheonix set piece.", " ", "&b&lShard Type: &7" + shardType, " ", "&c&lNOTE: &7You must have all 4 pieces of the", "&7Pheonix set to receive its bonus.", " ", "&7&oDrag n drop onto item to apply."}, false);
		return shard;
	}


	public static ItemStack protectionOrb = API.itemBuilder(Config.protectionScrollMaterial, Config.protectionScrollData, 1,  Config.protectionScrollName, Config.protectionScrollLore, Config.protectionScrollGlowing);
	public static ItemStack ocdScroll = API.itemBuilder(Config.organizationScrollMaterial, Config.organizationScrollData, 1,  Config.organizationScrollName, Config.organizationScrollLore, Config.organizationScrollGlowing);
    public static ItemStack renameScroll = API.itemBuilder(Config.renameScrollMaterial, Config.renameScrollData, 1, Config.renameScrollName, Config.renameScrollLore, Config.renameScrollGlowing);
    public static ItemStack dischargeOrb(int percent){
		ItemStack is = API.itemBuilder(Config.removalScrollMaterial, Config.removalScrollData, 1, Config.removalScrollName, new String[]{"&7Removes a random enchantment", "&7from an item and converts it", "&7into a &f" + percent + "% &7enchantment.", " ", "&7&oDrag n drop onto item to use."}, Config.removalScrollGlowing);
		return is;
	}

	public static ItemStack basicOrb = API.itemBuilder(Config.enchantmentBook1Material, Config.enchantmentBook1Data, 1, Config.tier1BookName, Config.tier1BookLore, Config.enchantmentBookGlowing);
	public static ItemStack advancedOrb = API.itemBuilder(Config.enchantmentBook2Material, Config.enchantmentBook2Data, 1, Config.tier2BookName, Config.tier2BookLore, Config.enchantmentBookGlowing);
	public static ItemStack epicOrb = API.itemBuilder(Config.enchantmentBook3Material, Config.enchantmentBook3Data, 1, Config.tier3BookName, Config.tier3BookLore, Config.enchantmentBookGlowing);
	public static ItemStack legendaryOrb = API.itemBuilder(Config.enchantmentBook4Material, Config.enchantmentBook4Data, 1, Config.tier4BookName, Config.tier4BookLore, Config.enchantmentBookGlowing);
	public static ItemStack ancientOrb = API.itemBuilder(Config.enchantmentBook5Material, Config.enchantmentBook5Data, 1, Config.tier5BookName, Config.tier5BookLore, Config.enchantmentBookGlowing);


	public static ItemStack  basicMagicOrb = API.itemBuilder(Material.FIREBALL, (short) 0, 1, "&aCommon Dust Pouch &7(Right-Click)", new String[]{"&7Right click to reveal a either", "&aCommon &7magical dust or useless", "&7black powder."}, false);
	public static ItemStack advancedMagicOrb = API.itemBuilder(Material.FIREBALL, (short) 0, 1, "&3Uncommon Dust Pouch &7(Right-Click)", new String[]{"&7Right click to reveal a either", "&3Uncommon &7magical dust or useless", "&7black powder."}, false);
	public static ItemStack epicMagicOrb = API.itemBuilder(Material.FIREBALL, (short) 0, 1, "&eRare Dust Pouch &7(Right-Click)", new String[]{"&7Right click to reveal a either", "&eRare &7magical dust or useless", "&7black powder."}, false);
	public static ItemStack legendaryMagicOrb = API.itemBuilder(Material.FIREBALL, (short) 0, 1, "&cLegendary Dust Pouch &7(Right-Click)", new String[]{"&7Right click to reveal a either", "&cLegendary &7magical dust or useless", "&7black powder."}, false);
	public static ItemStack ancientMagicOrb = API.itemBuilder(Material.FIREBALL, (short) 0, 1, "&dUltimate Dust Pouch &7(Right-Click)", new String[]{"&7Right click to reveal a either", "&dUltimate &7magical dust or useless", "&7black powder."}, false);

	public static ItemStack uselessPowder = API.itemBuilder(Material.SULPHUR, (short) 0, 1, "&8Useless Black Powder", new String[]{"&7Useless black powder is the failed", "&7bi product from a magical orb."}, false);

	public static ItemStack dust(String tier, int percent){
		ItemStack is = null;
		switch(tier.toLowerCase()){
		case "basic":
			ItemStack basicDust = API.itemBuilder(Material.SUGAR, (short) 0, 1, "&aCommon Enchantment Dust", new String[]{"&7Apply this &aCommon &7enchantment dust", "&7dust to increase a &aCommon &7enchant", "&7orb's success rate by &f" + percent + "%", " ", "&7&oDrag n drop onto orb to apply."}, false);
			is = basicDust;
			break;
		case "advanced":
			ItemStack advancedDust = API.itemBuilder(Material.SUGAR, (short) 0, 1, "&3Uncommon Enchantment Dust", new String[]{"&7Apply this &3Uncommon &7enchantment dust", "&7dust to increase a &3Uncommon &7enchant", "&7orb's success rate by &f" + percent + "%", " ", "&7&oDrag n drop onto orb to apply."}, false);
			is = advancedDust;
			break;
		case "epic":
			ItemStack epicDust = API.itemBuilder(Material.SUGAR, (short) 0, 1, "&eRare Enchantment Dust", new String[]{"&7Apply this &eRare &7enchantment dust", "&7dust to increase a &eRare &7enchant", "&7orb's success rate by &f" + percent + "%", " ", "&7&oDrag n drop onto orb to apply."}, false);
			is = epicDust;
			break;
		case "legendary":
			ItemStack legendaryDust = API.itemBuilder(Material.SUGAR, (short) 0, 1, "&cLegendary Enchantment Dust", new String[]{"&7Apply this &cLegendary &7enchantment dust", "&7dust to increase a &cLegendary &7enchant", "&7orb's success rate by &f" + percent + "%", " ", "&7&oDrag n drop onto orb to apply."}, false);
			is = legendaryDust;
			break;
		case "ancient":
			ItemStack ancientDust = API.itemBuilder(Material.SUGAR, (short) 0, 1, "&dUltimate Enchantment Dust", new String[]{"&7Apply this &dUltimate &7enchantment dust", "&7dust to increase a &dUltimate &7enchant", "&7orb's success rate by &f" + percent + "%", " ", "&7&oDrag n drop onto orb to apply."}, false);
			is = ancientDust;
			break;
		default:
			break;

		}
		return is;
	}

}
