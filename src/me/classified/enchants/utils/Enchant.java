package me.classified.enchants.utils;

import org.bukkit.Material;

public class Enchant {

	Material material;
	Short data;
	String name;
	String[] lore;
	String applyLore;
	int success;
	int destroy;
	String targets;
	String color;

	public Enchant(Material material, Short data, String name, String[] lore, String applyLore, int success, int destroy, String targets, String color){
		this.material = material;
		this.data = data;
		this.name = name;
		this.lore = lore;
		this.applyLore = applyLore;
		this.success = success;
		this.destroy = destroy;
		this.targets = targets;
		this.color = color;
	}

	public Material getMaterial(){
		return material;
	}

	public Short getData(){ 
		return data; 
	}

	public String getName(){
		return name;
	}

	public String[] getLore(){
		return lore;
	}

	public String getApplyLore(){
		return applyLore;
	}

	public int getSuccess(){
		return success;
	}

	public void setSuccess(int s){
		success = s;
	}

	public int getDestroy(){
		return destroy;
	}

	public void setDestroy(int d){
		destroy = d;
	}

	public String getTargets(){
		return targets;
	}

	public String getColor(){
		return color;
	}


}
