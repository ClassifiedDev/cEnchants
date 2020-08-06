package me.classified.enchants.enchants;

public class EnchantList {

}
/*

// TO ADD ENCHANTMENT
//
// 1. Create new Enchant object(s) in Books class.
// 2. Add item to /enchants in InventoryClickListener (onEnchantsClick).
// 3. Add to loadEnchants(), loadNumberedEnchants(), loadAllEnchants(), loadDischargeEnchants() in API class.
// 4. Add functionality in appropriate [TIER]Enchants class.
//


p.playSound(p.getLocation(), Sound.ORB_PICKUP, 100, 0); DING SOUND
p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 100, 0); PAPER SOUND

Enchants (66 TOTAL)


Venom - Chance to strike your enemy with poison
Tier: Basic
Level: 1-3
Tool: Weapon

Blackout - Chance to blind your enemy
Tier: Basic
Level: 1-3
Tool: Weapon

Haste - Gives you permanent haste effect..
Tier: Basic
Level: 1-3
Tool: Weapon, Pickaxe

Ravenous - Chance to effect your enemy with hunger. 
Tier: Basic
Level: 1-5
Tool: Weapon, Bow

Explosive - Chance to cause an explosion on impact.
Tier: Basic
Level: 1-4
Tool: Bow

Furnace - Automatically smelts ores while mining.
Tier: Basic
Level: 1-3
Tool: Pickaxe

Glowing - Gives you permenant night vision effect.
Tier: Basic
Level: 1-1
Tool: Helmet

Diver - Ability to breathe underwater.
Tier: Basic
Level: 1-1
Tool: Helmet

Saturated - Chance to gain hunger whle sprinting.
Tier: Basic
Level: 1-3
Tool: Any Armor

Flashback - Chance to be teleported behind your opponent. 
Tier: Basic
Level: 1-5
Tool: Weapon
Particle Effect When Activate: SmokeCloud

Frozen - Chance to freeze your opponent in place.
Tier: Basic
Level: 1-3
Tool: Weapon

Bullet Proof - Chance to reflect arrows.
Tier: Basic
Level: 1-4
Tool: Leggings

Ghast - Chance to shoot fireballs instead of arrows.
Tier: Basic
Level: 1-3
Tool: Bow

Scavenger - Chance to drop extra ores while mining.
Tier: Basic
Level: 1-5
Tool: Pickaxe






Shock - Chance to strike your opponent with lightning.
Tier: Advanced
Level: 1-5
Tool: Weapon, Bow

Obsidian Destroyer - Chance to insta-break obsidian.
Tier: Advanced
Level: 1-5
Tool: Pickaxe

Springs - Gives you permanent jump boost effect.
Tier: Advanced
Level: 1-3
Tool: Boots

Replenish - Gives you permanent resistance effect if it is on all 4 armour pieces.
Tier: Advanced
Level: 1-2
Tool: All Armor

Confusion - Chance to give your enemy nausea effect.
Tier: Advanced
Level: 1-5
Tool: Any Armor

Radioactive - Chance to give nearby players debuff effects.
Tier: Advanced
Level: 1-3
Tool: Any Armor

SelfDestruct - Chance to drop a tnt whereever you die.
Tier: Advanced
Level: 1-3
Tool: Any Armor

Creeper - Makes you immune to all explosions.
Tier: Advanced
Level: 1-3
Tool: Any Armor

Shield - Chance to block damage from attacks.
Tier: Advanced
Level: 1-4
Tool: Chestplate
Particle Effect When Activate: a cool particle effect

Ninja - Chance to give a burst of Speed IV on low HP.
Tier: Advanced
Level: 1-1
Tool: Boots

Marshmellow - Chance to gain resistance while being attacked.
Tier: Advanced
Level: 1-5
Tool: Weapon

Thief - Chance to steal a small portion of you opponent's xp or money.
Tier: Advanced
Level: 1-3
Tool: Weapon
Particle Effect When Activate: a Green effect

Counter - Chance to redirect an opponent's attack onto themselves.
Tier: Advanced
Level: 1-3
Tool: Leggings
Particle Effect When Activate: flame

Wound - Chance to cause the bleed effect on your opponent.
Tier: Advanced
Level: 1-4
Tool: Weapon

Hero - Chance to summon Iron Golems to help defend you in battle.
Tier: Advanced
Level: 1-10
Tool: Chestplate, Leggings

Pushed - Chance to cause extreme knockback.
Tier: Advanced
Level: 1-2
Tool: Weapon

Virus - Chance to give your opponent weakness. 
Tier: Advanced
Level: 1-3
Tool: Axe

Miner - Chance to give more xp and loot when breaking ores.
Tier: Advanced
Level: 1-5
Tool: Pickaxe

Blaze - gives permanent fire resistance.
Tier: Advanced
Level: 1-1
Tool: Armour







Chicken - Chance to negate all fall damage.
Tier: Epic
Level: 1-3
Tool: Boots

Penetrate - Increases the amount of armor damage you do per hit.
Tier: Epic
Level: 1-4
Tool: Weapon

Overload - Gives you permanent health boost effect.
Tier: Epic
Level: 1-3
Tool: Chestplate

Blessed - Low chance to remove all negative potion effects when attacking someone.
Tier: Epic
Level: 1-3
Tool: Axe

Angel - Chance to give Regeneration 3 on low HP.
Tier: Epic
Level: 1-3
Tool: Helmet

Behead - Chance to drop your opponent's head upon death.
Tier: Epic
Level: 1-3
Tool: Weapon

Flashbang - Chance to blind enemies with particles.
Tier: Epic
Level: 1-8
Tool: Helmet
Particle Effect When Activate: rainbow and white cloud

Frost Walker - Walk on water leaving behind an icy trail.
Tier: Epic
Level: 1-1
Tool: Boots

Lava Walker - Walk on lava leaving behind an glass trail.
Tier: Epic
Level: 1-1
Tool: Boots

Archer - Chance to do double damage with a bow.
Tier: Epic
Level: 1-3
Tool: Bow

Ghost - Chance to go invisible for 5 seconds.
Tier: Epic
Level: 1-3
Tool: Helmet

Weight - Move faster in water.
Tier: Epic
Level: 1-1
Tool: Boots





Juggernaut - Gives permanent Strength according to level but always gives slowness 3 and mining fatige 3.
Tier: Legendary
Level: 1-3
Tool: Helmet

EXP - Increases the amount of experience dropped from mobs.
Tier: Legendary
Level: 1-4
Tool: Sword
Particle Effect When Activate: rainbow

Lifesteal - Chance to steal a heart from your opponent.
Tier: Legendary
Level: 1-5
Tool: Weapon

Rage - Multiplies the damage dealt based on your combo.
Tier: Legendary
Level: 1-6
Tool: Weapon
Particle Effect When Activate: blood looking

Meteor - Chance to have overpowered fireballs hit your opponent.
Tier: Legendary
Level: 1-10
Tool: Bow

Kill Aura - Chance to deal damage to all nearby players.
Tier: Legendary
Level: 1-5
Tool: Axe

Immolation - Chance to do insane damage and set all nearby players on fire.
Tier: Legendary
Level: 1-4
Tool: Weapon

Barbarian - Does more damage if your opponent is holding an axe.
Tier: Legendary
Level: 1-4
Tool: Weapon

Enrage - Do more damage at lower health.
Tier: Legendary
Level: 1-3
Tool: Weapon

Enlighted - Chance to heal while being attacked.
Tier: Legendary
Level: 1-3
Tool: Armour









NEWER ENCHANTS NOT IN OLD VERSION

    Poisoned
    Tier: Basic
    Target: Chestplate, Leggings
    Lvl: 1-4
    Description: Chance to give attacker poison
       
    Ender Walker
    Tier: Basic
    Target: Boots
    Lvl: 1-5
    Description: Chance to remove wither and poison
        
    Reforged
    Tier: Basic
    Target: Weapons, Tools
    Lvl: 1- 10
    Description: Chance to partialy repair your weapon
    
    
    
    
    
    
 
    
    Lava
    Tier: Advanced
    Target: Chestplate
    Lvl: 1- 4
    Description: Chance to set your attacker on fire
    
    Infestation
    Tier: Advanced
    Target: helmet
    Lvl: 1-3
    Description: - Spawns endermites and silver at low hp
        
    Wither
    Tier: Advanced
    Target: Armor
    Lvl: 1-5
    Description: Chance to give your attacker wither
    
    
    
    
    
    
    
    
    
    Savior
    Tier: Epic
    Target: Leggings
    Lvl: 1- 3
    Description:  - Chance to cut incoming damage in half
    
    Indestructible
    Tier: Epic
    Target: Armor
    Lvl: 1-3
    Description: Chance for your armour to take less durability damage
   

    
    
    
    
    
    
    
    
    
    Disarmor
	Tier: Legendary
	Target: Sword
    Lvl: 1- 8
    Description: Chance to remove a piece of your enemys armor
	  
    Brute
    Tier: Legendary
    Target: Armor
    Lvl: 1 -4
    Description: Take less damage from axes
    
    
    Vest
    Tier: Legendary
    Target: Armor
    Lvl: 1 - 4
    Description: Take less damage from swords
    
    

    
    
    
    */
