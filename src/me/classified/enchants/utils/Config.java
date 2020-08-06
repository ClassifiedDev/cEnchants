package me.classified.enchants.utils;

import me.classified.enchants.cEnchants;
import org.bukkit.Material;

import java.util.List;

public class Config {

    //Enchanter Menu
    public static String enchanterTitle = cEnchants.getConfigF().getString("enchanterMenu.title");
    public static int enchanterSize = cEnchants.getConfigF().getInt("enchanterMenu.size");

    public static Material enchanterSpacerMaterial = Material.getMaterial(cEnchants.getConfigF().getString("enchanterMenu.spacer.material"));
    public static short enchanterSpacerData = (short) cEnchants.getConfigF().getInt("enchanterMenu.spacer.data");
    public static String enchanterSpacerName = cEnchants.getConfigF().getString("enchanterMenu.spacer.name");
    public static boolean enchanterSpacerGlowing = cEnchants.getConfigF().getBoolean("enchanterMenu.spacer.glowing");

    public static Material enchanterBook1Material = Material.getMaterial(cEnchants.getConfigF().getString("enchanterMenu.tier1Book.material"));
    public static short enchanterBook1Data = (short) cEnchants.getConfigF().getInt("enchanterMenu.tier1Book.data");
    public static String enchanterBook1Name = cEnchants.getConfigF().getString("enchanterMenu.tier1Book.name");
    public static List<String> eb1l = cEnchants.getConfigF().getStringList("enchanterMenu.tier1Book.lore");
    public static String[] enchanterBook1Lore = eb1l.toArray(new String[eb1l.size()]);
    public static boolean enchanterBook1Glowing = cEnchants.getConfigF().getBoolean("enchanterMenu.tier1Book.glowing");
    public static int enchanterBook1Price = cEnchants.getConfigF().getInt("enchanterMenu.tier1Book.price");
    public static int enchanterBook1InvSlot = cEnchants.getConfigF().getInt("enchanterMenu.tier1Book.inventorySlot");

    public static Material enchanterBook2Material = Material.getMaterial(cEnchants.getConfigF().getString("enchanterMenu.tier2Book.material"));
    public static short enchanterBook2Data = (short) cEnchants.getConfigF().getInt("enchanterMenu.tier2Book.data");
    public static String enchanterBook2Name = cEnchants.getConfigF().getString("enchanterMenu.tier2Book.name");
    public static List<String> eb2l = cEnchants.getConfigF().getStringList("enchanterMenu.tier2Book.lore");
    public static String[] enchanterBook2Lore = eb2l.toArray(new String[eb2l.size()]);
    public static boolean enchanterBook2Glowing = cEnchants.getConfigF().getBoolean("enchanterMenu.tier2Book.glowing");
    public static int enchanterBook2Price = cEnchants.getConfigF().getInt("enchanterMenu.tier2Book.price");
    public static int enchanterBook2InvSlot = cEnchants.getConfigF().getInt("enchanterMenu.tier2Book.inventorySlot");

    public static Material enchanterBook3Material = Material.getMaterial(cEnchants.getConfigF().getString("enchanterMenu.tier3Book.material"));
    public static short enchanterBook3Data = (short) cEnchants.getConfigF().getInt("enchanterMenu.tier3Book.data");
    public static String enchanterBook3Name = cEnchants.getConfigF().getString("enchanterMenu.tier3Book.name");
    public static List<String> eb3l = cEnchants.getConfigF().getStringList("enchanterMenu.tier3Book.lore");
    public static String[] enchanterBook3Lore = eb3l.toArray(new String[eb3l.size()]);
    public static boolean enchanterBook3Glowing = cEnchants.getConfigF().getBoolean("enchanterMenu.tier3Book.glowing");
    public static int enchanterBook3Price = cEnchants.getConfigF().getInt("enchanterMenu.tier3Book.price");
    public static int enchanterBook3InvSlot = cEnchants.getConfigF().getInt("enchanterMenu.tier3Book.inventorySlot");

    public static Material enchanterBook4Material = Material.getMaterial(cEnchants.getConfigF().getString("enchanterMenu.tier4Book.material"));
    public static short enchanterBook4Data = (short) cEnchants.getConfigF().getInt("enchanterMenu.tier4Book.data");
    public static String enchanterBook4Name = cEnchants.getConfigF().getString("enchanterMenu.tier4Book.name");
    public static List<String> eb4l = cEnchants.getConfigF().getStringList("enchanterMenu.tier4Book.lore");
    public static String[] enchanterBook4Lore = eb4l.toArray(new String[eb4l.size()]);
    public static boolean enchanterBook4Glowing = cEnchants.getConfigF().getBoolean("enchanterMenu.tier4Book.glowing");
    public static int enchanterBook4Price = cEnchants.getConfigF().getInt("enchanterMenu.tier4Book.price");
    public static int enchanterBook4InvSlot = cEnchants.getConfigF().getInt("enchanterMenu.tier4Book.inventorySlot");

    //Enchants Menu
    public static String enchantsTitle = cEnchants.getConfigF().getString("enchantsMenu.title");
    public static int enchantsSize = cEnchants.getConfigF().getInt("enchantsMenu.size");

    public static String enchants1Title = cEnchants.getConfigF().getString("enchantsMenu.tier1MenuTitle");
    public static String enchants2Title = cEnchants.getConfigF().getString("enchantsMenu.tier2MenuTitle");
    public static String enchants3Title = cEnchants.getConfigF().getString("enchantsMenu.tier3MenuTitle");
    public static String enchants4Title = cEnchants.getConfigF().getString("enchantsMenu.tier4MenuTitle");
    public static String enchants5Title = cEnchants.getConfigF().getString("enchantsMenu.tier5MenuTitle");

    public static Material enchantsBook1Material = Material.getMaterial(cEnchants.getConfigF().getString("enchantsMenu.tier1Book.material"));
    public static short enchantsBook1Data = (short) cEnchants.getConfigF().getInt("enchantsMenu.tier1Book.data");
    public static String enchantsBook1Name = cEnchants.getConfigF().getString("enchantsMenu.tier1Book.name");
    public static List<String> esb1l = cEnchants.getConfigF().getStringList("enchantsMenu.tier1Book.lore");
    public static String[] enchantsBook1Lore = esb1l.toArray(new String[esb1l.size()]);
    public static boolean enchantsBook1Glowing = cEnchants.getConfigF().getBoolean("enchantsMenu.tier1Book.glowing");
    public static int enchantsBook1InvSlot = cEnchants.getConfigF().getInt("enchantsMenu.tier1Book.inventorySlot");

    public static Material enchantsBook2Material = Material.getMaterial(cEnchants.getConfigF().getString("enchantsMenu.tier2Book.material"));
    public static short enchantsBook2Data = (short) cEnchants.getConfigF().getInt("enchantsMenu.tier2Book.data");
    public static String enchantsBook2Name = cEnchants.getConfigF().getString("enchantsMenu.tier2Book.name");
    public static List<String> esb2l = cEnchants.getConfigF().getStringList("enchantsMenu.tier2Book.lore");
    public static String[] enchantsBook2Lore = esb2l.toArray(new String[esb2l.size()]);
    public static boolean enchantsBook2Glowing = cEnchants.getConfigF().getBoolean("enchantsMenu.tier2Book.glowing");
    public static int enchantsBook2InvSlot = cEnchants.getConfigF().getInt("enchantsMenu.tier2Book.inventorySlot");

    public static Material enchantsBook3Material = Material.getMaterial(cEnchants.getConfigF().getString("enchantsMenu.tier3Book.material"));
    public static short enchantsBook3Data = (short) cEnchants.getConfigF().getInt("enchantsMenu.tier3Book.data");
    public static String enchantsBook3Name = cEnchants.getConfigF().getString("enchantsMenu.tier3Book.name");
    public static List<String> esb3l = cEnchants.getConfigF().getStringList("enchantsMenu.tier3Book.lore");
    public static String[] enchantsBook3Lore = esb3l.toArray(new String[esb3l.size()]);
    public static boolean enchantsBook3Glowing = cEnchants.getConfigF().getBoolean("enchantsMenu.tier3Book.glowing");
    public static int enchantsBook3InvSlot = cEnchants.getConfigF().getInt("enchantsMenu.tier3Book.inventorySlot");

    public static Material enchantsBook4Material = Material.getMaterial(cEnchants.getConfigF().getString("enchantsMenu.tier4Book.material"));
    public static short enchantsBook4Data = (short) cEnchants.getConfigF().getInt("enchantsMenu.tier4Book.data");
    public static String enchantsBook4Name = cEnchants.getConfigF().getString("enchantsMenu.tier4Book.name");
    public static List<String> esb4l = cEnchants.getConfigF().getStringList("enchantsMenu.tier4Book.lore");
    public static String[] enchantsBook4Lore = esb4l.toArray(new String[esb4l.size()]);
    public static boolean enchantsBook4Glowing = cEnchants.getConfigF().getBoolean("enchantsMenu.tier4Book.glowing");
    public static int enchantsBook4InvSlot = cEnchants.getConfigF().getInt("enchantsMenu.tier4Book.inventorySlot");

    public static Material enchantsBook5Material = Material.getMaterial(cEnchants.getConfigF().getString("enchantsMenu.tier5Book.material"));
    public static short enchantsBook5Data = (short) cEnchants.getConfigF().getInt("enchantsMenu.tier5Book.data");
    public static String enchantsBook5Name = cEnchants.getConfigF().getString("enchantsMenu.tier5Book.name");
    public static List<String> esb5l = cEnchants.getConfigF().getStringList("enchantsMenu.tier5Book.lore");
    public static String[] enchantsBook5Lore = esb5l.toArray(new String[esb5l.size()]);
    public static boolean enchantsBook5Glowing = cEnchants.getConfigF().getBoolean("enchantsMenu.tier5Book.glowing");
    public static int enchantsBook5InvSlot = cEnchants.getConfigF().getInt("enchantsMenu.tier5Book.inventorySlot");

    //Tinkerer Menu
    public static String tinkererTitle = cEnchants.getConfigF().getString("tinkererTitle");

    //Enchant Admin Menu
    public static String enchantAdminTitle = cEnchants.getConfigF().getString("enchantAdminTitle");


    //Books
    public static Material enchantmentBook1Material = Material.getMaterial(cEnchants.getConfigF().getString("enchantmentBook1Material"));
    public static short enchantmentBook1Data = (short) cEnchants.getConfigF().getInt("enchantmentBook1Data");
    public static boolean enchantmentBookGlowing = cEnchants.getConfigF().getBoolean("enchantmentBook1Glowing");

    public static Material enchantmentBook2Material = Material.getMaterial(cEnchants.getConfigF().getString("enchantmentBook2Material"));
    public static short enchantmentBook2Data = (short) cEnchants.getConfigF().getInt("enchantmentBook2Data");

    public static Material enchantmentBook3Material = Material.getMaterial(cEnchants.getConfigF().getString("enchantmentBook3Material"));
    public static short enchantmentBook3Data = (short) cEnchants.getConfigF().getInt("enchantmentBook3Data");

    public static Material enchantmentBook4Material = Material.getMaterial(cEnchants.getConfigF().getString("enchantmentBook4Material"));
    public static short enchantmentBook4Data = (short) cEnchants.getConfigF().getInt("enchantmentBook4Data");

    public static Material enchantmentBook5Material = Material.getMaterial(cEnchants.getConfigF().getString("enchantmentBook5Material"));
    public static short enchantmentBook5Data = (short) cEnchants.getConfigF().getInt("enchantmentBook5Data");

    public static String tier1BookName = cEnchants.getConfigF().getString("tier1Book.name");
    public static String tier2BookName = cEnchants.getConfigF().getString("tier2Book.name");
    public static String tier3BookName = cEnchants.getConfigF().getString("tier3Book.name");
    public static String tier4BookName = cEnchants.getConfigF().getString("tier4Book.name");
    public static String tier5BookName = cEnchants.getConfigF().getString("tier5Book.name");

    public static List<String> t1bl = cEnchants.getConfigF().getStringList("tier1Book.lore");
    public static String[] tier1BookLore = t1bl.toArray(new String[t1bl.size()]);

    public static List<String> t2bl = cEnchants.getConfigF().getStringList("tier2Book.lore");
    public static String[] tier2BookLore = t2bl.toArray(new String[t2bl.size()]);

    public static List<String> t3bl = cEnchants.getConfigF().getStringList("tier3Book.lore");
    public static String[] tier3BookLore = t3bl.toArray(new String[t3bl.size()]);

    public static List<String> t4bl = cEnchants.getConfigF().getStringList("tier4Book.lore");
    public static String[] tier4BookLore = t4bl.toArray(new String[t4bl.size()]);

    public static List<String> t5bl = cEnchants.getConfigF().getStringList("tier5Book.lore");
    public static String[] tier5BookLore = t5bl.toArray(new String[t5bl.size()]);

    public static String tier1BookColor = cEnchants.getConfigF().getString("tier1Book.color");
    public static String tier2BookColor = cEnchants.getConfigF().getString("tier2Book.color");
    public static String tier3BookColor = cEnchants.getConfigF().getString("tier3Book.color");
    public static String tier4BookColor = cEnchants.getConfigF().getString("tier4Book.color");
    public static String tier5BookColor = cEnchants.getConfigF().getString("tier5Book.color");

    //Protection Scroll
    public static Material protectionScrollMaterial = Material.getMaterial(cEnchants.getConfigF().getString("protectionScroll.material"));
    public static short protectionScrollData = (short) cEnchants.getConfigF().getInt("protectionScroll.data");
    public static String protectionScrollName = cEnchants.getConfigF().getString("protectionScroll.name");
    public static List<String> psl = cEnchants.getConfigF().getStringList("protectionScroll.lore");
    public static String[] protectionScrollLore = psl.toArray(new String[psl.size()]);
    public static boolean protectionScrollGlowing = cEnchants.getConfigF().getBoolean("protectionScroll.glowing");
    public static String protectedLore = cEnchants.getConfigF().getString("protectionScroll.protectedLore");

    //Organization Scroll
    public static Material organizationScrollMaterial = Material.getMaterial(cEnchants.getConfigF().getString("organizationScroll.material"));
    public static short organizationScrollData = (short) cEnchants.getConfigF().getInt("organizationScroll.data");
    public static String organizationScrollName = cEnchants.getConfigF().getString("organizationScroll.name");
    public static List<String> osl = cEnchants.getConfigF().getStringList("organizationScroll.lore");
    public static String[] organizationScrollLore = osl.toArray(new String[osl.size()]);
    public static boolean organizationScrollGlowing = cEnchants.getConfigF().getBoolean("organizationScroll.glowing");

    //Rename Scroll
    public static Material renameScrollMaterial = Material.getMaterial(cEnchants.getConfigF().getString("renameScroll.material"));
    public static short renameScrollData = (short) cEnchants.getConfigF().getInt("renameScroll.data");
    public static String renameScrollName = cEnchants.getConfigF().getString("renameScroll.name");
    public static List<String> rsl = cEnchants.getConfigF().getStringList("renameScroll.lore");
    public static String[] renameScrollLore = rsl.toArray(new String[rsl.size()]);
    public static boolean renameScrollGlowing = cEnchants.getConfigF().getBoolean("renameScroll.glowing");

    //Removal Scroll
    public static Material removalScrollMaterial = Material.getMaterial(cEnchants.getConfigF().getString("removalScroll.material"));
    public static short removalScrollData = (short) cEnchants.getConfigF().getInt("removalScroll.data");
    public static String removalScrollName = cEnchants.getConfigF().getString("removalScroll.name");
    public static boolean removalScrollGlowing = cEnchants.getConfigF().getBoolean("removalScroll.glowing");
}
