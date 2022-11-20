# CS611-<Assignment 3>
## <Hero and Monster>
---------------------------------------------------------------------------
<Yujie Yan>
<cdyyj@bu.edu>
<U13600938>

## Files
---------------------------------------------------------------------------
<The file Armor.java contains the armor object>
<The file ArmorFactory.java contains the factory to generate random items>
<The file Battle.java contains the battle object>
<The file Board.java contains the board of two-d array of world>
<The file Character.java contains base file of character>
<The file CommonTile.java contains tile object where can be walked and battle occur>
<The file Dragon.java contains dragon object>
<The file Exoskeleton.java contains exoskeleton object>
<The file FileParser.java contains parser to parse the txt to generate the objects>
<The file GameProcess.java contains class of the process of the game>
<The file Hero.java contains the hero obejct>
<The file HeroFactory.java generate the hero based on the hero name>
<The file IceStrategy.java contains strategy for ice spell>
<The file LightningStrategy.java contains strategy lightning spell>
<The file InaccessibleTile.java contains InaccessibleTile>
<The file InputCheck.java check all input is valid>
<The file Item.java is all items super class>
<The file ItemFactory.java generate random items>
<The file Main.java is entrance of the program>
<The file Market.java is market object>
<The file MarketTile.java is market tile object>
<The file Monster.java is monster>
<The file MonsterFactory.java generate monster with given level>
<The file PaladinStrategy.java contains update strategy for paladin>
<The file Party.java contains party object>
<The file Potion.java contains Potion object>
<The file PotionFactory.java generate random potions>
<The file SorcererStrategy.java contains upgrade strategy>
<The file Spell.java contains Spell object>
<The file SpellFactory.java contains SpellFactory generate random spells>
<The file Spirit.java contains Spirit  object>
<The file Tile.java contains tile interface>
<The file TileFactory.java generate tile with given probability>
<The file UpgradeStrategy.java contains UpgradeStrategy interface>
<The file Usable.java contains Usable interface>
<The file WarriorStrategy.java contains upgrade for Warrior>
<The file Weapon.java contains Weapon object>
<The file WeaponFactory.java generate random weapon>



## Notes
---------------------------------------------------------------------------
1. <Files to be parsed should be stored in resource file, for parser class to
read class>
2. <Bonus Done> print the world with red marker to show the player postition.
                parse the file to load the items, monsters, and heros
                able to automatically unequippe weapon
3. <Notes to grader> i used singleton pattern, strategy pattern, factory pattern in this project.
                     my factory can generate monster with given level.
                     The program allow user to use index to choose items and monster.
                     i use strategy to deal with different kinds of spell and heros
                     i tried to reduce the coupling by not letting board depend on the party and use index to connect them in the game process
                     and i use write the transaction process in the game process to trade between market and hero, and market and hero don't denpend on each other.

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "pa3"
2. Run the following instructions in terminal:
<Example below>
javac *.java
java -cp ./ Main

## Input/Output Example
---------------------------------------------------------------------------
<Place here an example of how the program runs. Include both its
outputs and correctly formatted inputs. Please clearly mark the inputs.>
PS C:\Users\17569\IdeaProjects\hero and monster\src> javac *.java
PS C:\Users\17569\IdeaProjects\hero and monster\src> java -cp ./ Main
Enter a seed to create a board (or enter nothing to create random board): 123
1. Number of Inaccessible tile 13.
2. Number of Common tile 34.
3. Number of Market tile 17.
+---+---+---+---+---+---+---+---+
|   |   | M |   |   |   |   | X |
+---+---+---+---+---+---+---+---+
|   |   |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| M |   |   | M | M | X | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
| M |   |   |   |   | M | X | X |
+---+---+---+---+---+---+---+---+
| X |   |   |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   | M |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
Enter number of player from 1-3: 2
1. Hero[name: Sehanine_Monnbow, HP100/100, mana: 600/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
2. Hero[name: Caliber_Heist, HP100/100, mana: 400/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
3. Hero[name: Rillifane_Rallathil, HP100/100, mana: 1300/1300, damage: 750/750, agility: 450/450, dexterityValue: 500/500, gold: 2500, Level: (9/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
4. Hero[name: Segojan_Earthcaller, HP100/100, mana: 900/900, damage: 800/800, agility: 500/500, dexterityValue: 650/650, gold: 2500, Level: (5/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
5. Hero[name: Gaerdal_Ironhand, HP100/100, mana: 100/100, damage: 700/700, agility: 500/500, dexterityValue: 600/600, gold: 1354, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
6. Hero[name: Muamman_Duathall, HP100/100, mana: 300/300, damage: 900/900, agility: 500/500, dexterityValue: 750/750, gold: 2546, Level: (6/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
7. Hero[name: Flandal_Steelskin, HP100/100, mana: 200/200, damage: 750/750, agility: 650/650, dexterityValue: 700/700, gold: 2500, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
8. Hero[name: Kalabar, HP100/100, mana: 800/800, damage: 850/850, agility: 400/400, dexterityValue: 600/600, gold: 2500, Level: (6/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
9. Hero[name: Sehanine_Moonbow, HP100/100, mana: 300/300, damage: 750/750, agility: 700/700, dexterityValue: 700/700, gold: 2500, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
10. Hero[name: Garl_Glittergold, HP100/100, mana: 100/100, damage: 600/600, agility: 500/500, dexterityValue: 400/400, gold: 2500, Level: (5/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
11. Hero[name: Skye_Soar, HP100/100, mana: 1000/1000, damage: 700/700, agility: 400/400, dexterityValue: 500/500, gold: 2500, Level: (5/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
12. Hero[name: Skoraeus_Stonebones, HP100/100, mana: 250/250, damage: 650/650, agility: 600/600, dexterityValue: 350/350, gold: 2500, Level: (4/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
13. Hero[name: Eunoia_Cyn, HP100/100, mana: 400/400, damage: 700/700, agility: 800/800, dexterityValue: 600/600, gold: 2500, Level: (6/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
14. Hero[name: Parzival, HP100/100, mana: 300/300, damage: 750/750, agility: 650/650, dexterityValue: 700/700, gold: 2500, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
15. Hero[name: Reign_Havoc, HP100/100, mana: 800/800, damage: 800/800, agility: 800/800, dexterityValue: 800/800, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
16. Hero[name: Reverie_Ashels, HP100/100, mana: 900/900, damage: 800/800, agility: 700/700, dexterityValue: 400/400, gold: 2500, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
17. Hero[name: Undefeated_Yoj, HP100/100, mana: 400/400, damage: 800/800, agility: 400/400, dexterityValue: 700/700, gold: 2500, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
18. Hero[name: Amaryllis_Astra, HP100/100, mana: 500/500, damage: 500/500, agility: 500/500, dexterityValue: 500/500, gold: 2500, Level: (5/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

Enter your choice from 1 to 18: 1
1. Hero[name: Sehanine_Monnbow, HP100/100, mana: 600/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
2. Hero[name: Caliber_Heist, HP100/100, mana: 400/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
3. Hero[name: Rillifane_Rallathil, HP100/100, mana: 1300/1300, damage: 750/750, agility: 450/450, dexterityValue: 500/500, gold: 2500, Level: (9/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
4. Hero[name: Segojan_Earthcaller, HP100/100, mana: 900/900, damage: 800/800, agility: 500/500, dexterityValue: 650/650, gold: 2500, Level: (5/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
5. Hero[name: Gaerdal_Ironhand, HP100/100, mana: 100/100, damage: 700/700, agility: 500/500, dexterityValue: 600/600, gold: 1354, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
6. Hero[name: Muamman_Duathall, HP100/100, mana: 300/300, damage: 900/900, agility: 500/500, dexterityValue: 750/750, gold: 2546, Level: (6/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
7. Hero[name: Flandal_Steelskin, HP100/100, mana: 200/200, damage: 750/750, agility: 650/650, dexterityValue: 700/700, gold: 2500, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
8. Hero[name: Kalabar, HP100/100, mana: 800/800, damage: 850/850, agility: 400/400, dexterityValue: 600/600, gold: 2500, Level: (6/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
9. Hero[name: Sehanine_Moonbow, HP100/100, mana: 300/300, damage: 750/750, agility: 700/700, dexterityValue: 700/700, gold: 2500, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
10. Hero[name: Garl_Glittergold, HP100/100, mana: 100/100, damage: 600/600, agility: 500/500, dexterityValue: 400/400, gold: 2500, Level: (5/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
11. Hero[name: Skye_Soar, HP100/100, mana: 1000/1000, damage: 700/700, agility: 400/400, dexterityValue: 500/500, gold: 2500, Level: (5/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
12. Hero[name: Skoraeus_Stonebones, HP100/100, mana: 250/250, damage: 650/650, agility: 600/600, dexterityValue: 350/350, gold: 2500, Level: (4/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
13. Hero[name: Eunoia_Cyn, HP100/100, mana: 400/400, damage: 700/700, agility: 800/800, dexterityValue: 600/600, gold: 2500, Level: (6/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
14. Hero[name: Parzival, HP100/100, mana: 300/300, damage: 750/750, agility: 650/650, dexterityValue: 700/700, gold: 2500, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
15. Hero[name: Reign_Havoc, HP100/100, mana: 800/800, damage: 800/800, agility: 800/800, dexterityValue: 800/800, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
16. Hero[name: Reverie_Ashels, HP100/100, mana: 900/900, damage: 800/800, agility: 700/700, dexterityValue: 400/400, gold: 2500, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
17. Hero[name: Undefeated_Yoj, HP100/100, mana: 400/400, damage: 800/800, agility: 400/400, dexterityValue: 700/700, gold: 2500, Level: (7/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
18. Hero[name: Amaryllis_Astra, HP100/100, mana: 500/500, damage: 500/500, agility: 500/500, dexterityValue: 500/500, gold: 2500, Level: (5/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

Enter your choice from 1 to 18: 2
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Heros in the party:
Hero[name: Sehanine_Monnbow, HP100/100, mana: 600/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
Hero[name: Caliber_Heist, HP100/100, mana: 400/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
+---+---+---+---+---+---+---+---+
| T |   | M |   |   |   |   | X |
+---+---+---+---+---+---+---+---+
|   |   |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| M |   |   | M | M | X | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
| M |   |   |   |   | M | X | X |
+---+---+---+---+---+---+---+---+
| X |   |   |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   | M |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
You are in possition row 0 , column 0
? W/w: move up
? A/a: move left
? S/s: move down
? D/d: move right
? Q/q: quit game
? I/i: show information
? M/m: enter market
? K/k: show map
? B/b: show inventory
d
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP100/100, mana: 600/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
Hero[name: Caliber_Heist, HP100/100, mana: 400/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

1. Exoskeleton{name: BigBad-Wolf, level: 1, HP: 100, damage value: 150, defense value: 250, dodge chance: 15}

2. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP100/100, mana: 600/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: a
1. Exoskeleton{name: BigBad-Wolf, level: 1, HP: 100, damage value: 150, defense value: 250, dodge chance: 15}

2. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

Enter the target you want to attack: 1
Hero attack make 35 damage.
Monster has 65 health.

Hero[name: Caliber_Heist, HP100/100, mana: 400/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: i
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP100/100, mana: 600/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
Hero[name: Caliber_Heist, HP100/100, mana: 400/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

1. Exoskeleton{name: BigBad-Wolf, level: 1, HP: 65, damage value: 150, defense value: 250, dodge chance: 15}

2. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Caliber_Heist, HP100/100, mana: 400/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: a
1. Exoskeleton{name: BigBad-Wolf, level: 1, HP: 65, damage value: 150, defense value: 250, dodge chance: 15}

2. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

Enter the target you want to attack: 1
Attack has been dodged, monster get no harm.
Monster attacked Sehanine_Monnbow
Hero dodged the attack.
Monster attacked Sehanine_Monnbow
Blinky attacked Sehanine_Monnbow deals 22 damage
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP85/100, mana: 660/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
Hero[name: Caliber_Heist, HP110/100, mana: 440/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

1. Exoskeleton{name: BigBad-Wolf, level: 1, HP: 65, damage value: 150, defense value: 250, dodge chance: 15}

2. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP85/100, mana: 660/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: a
1. Exoskeleton{name: BigBad-Wolf, level: 1, HP: 65, damage value: 150, defense value: 250, dodge chance: 15}

2. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

Enter the target you want to attack: 1
Hero attack make 35 damage.
Monster has 30 health.

Hero[name: Caliber_Heist, HP110/100, mana: 440/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: a
1. Exoskeleton{name: BigBad-Wolf, level: 1, HP: 30, damage value: 150, defense value: 250, dodge chance: 15}

2. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

Enter the target you want to attack: 1
Attack has been dodged, monster get no harm.
Monster attacked Sehanine_Monnbow
Hero dodged the attack.
Monster attacked Caliber_Heist
Hero dodged the attack.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP93/100, mana: 726/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
Hero[name: Caliber_Heist, HP121/100, mana: 484/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

1. Exoskeleton{name: BigBad-Wolf, level: 1, HP: 30, damage value: 150, defense value: 250, dodge chance: 15}

2. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP93/100, mana: 726/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: i
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP93/100, mana: 726/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
Hero[name: Caliber_Heist, HP121/100, mana: 484/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

1. Exoskeleton{name: BigBad-Wolf, level: 1, HP: 30, damage value: 150, defense value: 250, dodge chance: 15}

2. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP93/100, mana: 726/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: a
1. Exoskeleton{name: BigBad-Wolf, level: 1, HP: 30, damage value: 150, defense value: 250, dodge chance: 15}

2. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

Enter the target you want to attack: 1
Hero attack make 35 damage.
Monster has 0 health.

Monster is dead.
Hero[name: Caliber_Heist, HP121/100, mana: 484/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: a
1. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

Enter the target you want to attack: 1
Attack has been dodged, monster get no harm.
Monster attacked Sehanine_Monnbow
Blinky attacked Sehanine_Monnbow deals 22 damage
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP78/100, mana: 798/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
Hero[name: Caliber_Heist, HP133/100, mana: 532/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

1. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP78/100, mana: 798/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: a
1. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

Enter the target you want to attack: 1
Attack has been dodged, monster get no harm.
Hero[name: Caliber_Heist, HP133/100, mana: 532/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: i
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP78/100, mana: 798/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
Hero[name: Caliber_Heist, HP133/100, mana: 532/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

1. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Caliber_Heist, HP133/100, mana: 532/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: a
1. Spirit{name: Blinky, level: 1, HP: 100, damage value: 450, defense value: 350, dodge chance: 35}

Enter the target you want to attack: 1
Hero attack make 20 damage.
Monster has 80 health.

Monster attacked Caliber_Heist
Blinky attacked Caliber_Heist deals 22 damage
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP85/100, mana: 877/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
Hero[name: Caliber_Heist, HP122/100, mana: 585/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

1. Spirit{name: Blinky, level: 1, HP: 80, damage value: 450, defense value: 350, dodge chance: 35}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP85/100, mana: 877/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: a
1. Spirit{name: Blinky, level: 1, HP: 80, damage value: 450, defense value: 350, dodge chance: 35}

Enter the target you want to attack: 1
Hero attack make 35 damage.
Monster has 45 health.

Hero[name: Caliber_Heist, HP122/100, mana: 585/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: a
1. Spirit{name: Blinky, level: 1, HP: 45, damage value: 450, defense value: 350, dodge chance: 35}

Enter the target you want to attack: 1
Hero attack make 20 damage.
Monster has 25 health.

Monster attacked Caliber_Heist
Blinky attacked Caliber_Heist deals 22 damage
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP93/100, mana: 964/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]
Hero[name: Caliber_Heist, HP110/100, mana: 643/400, damage: 400/400, agility: 400/400, dexterityValue: 400/400, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

1. Spirit{name: Blinky, level: 1, HP: 25, damage value: 450, defense value: 350, dodge chance: 35}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Hero[name: Sehanine_Monnbow, HP93/100, mana: 964/600, damage: 700/700, agility: 800/800, dexterityValue: 500/500, gold: 2500, Level: (8/10) Level 1, Equipped Weapon: null, Equipped Armor: null]

a/A to attack
u/U to use item in bag
i/I to list
q/Q to quit the gameEnter your input: a
1. Spirit{name: Blinky, level: 1, HP: 25, damage value: 450, defense value: 350, dodge chance: 35}

Enter the target you want to attack: 1
Hero attack make 35 damage.
Monster has 0 health.

Monster is dead.
Sehanine_Monnbow get 100 gold!
Sehanine_Monnbow get 16 experience
Caliber_Heist get 100 gold!
Caliber_Heist get 16 experience
+---+---+---+---+---+---+---+---+
|   | T | M |   |   |   |   | X |
+---+---+---+---+---+---+---+---+
|   |   |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| M |   |   | M | M | X | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
| M |   |   |   |   | M | X | X |
+---+---+---+---+---+---+---+---+
| X |   |   |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   | M |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
You are in possition row 0 , column 1
? W/w: move up
? A/a: move left
? S/s: move down
? D/d: move right
? Q/q: quit game
? I/i: show information
? M/m: enter market
? K/k: show map
? B/b: show inventory
d
+---+---+---+---+---+---+---+---+
|   |   | T |   |   |   |   | X |
+---+---+---+---+---+---+---+---+
|   |   |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| M |   |   | M | M | X | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
| M |   |   |   |   | M | X | X |
+---+---+---+---+---+---+---+---+
| X |   |   |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   | M |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
You are in possition row 0 , column 2
? W/w: move up
? A/a: move left
? S/s: move down
? D/d: move right
? Q/q: quit game
? I/i: show information
? M/m: enter market
? K/k: show map
? B/b: show inventory
m
Market items
1. Armor{name: Breastplate, price: 350, 3, damage reduction: 600}
2. LightningSpell{name: Breath_of_Fire,price: 350,level: 1,damage: 450,manacost: 100,reduce agility: , spell type: FireStrategy@aec6354}
3. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}
4. Potion{name: Mermaid_Tears, price: 850, level: 5, effectiveAmount: 100, affecttedAttrubutes:[Health, Mana, Strength, Agility]}
5. Weapon{name: Dagger, price: 200, level: 1, damage value: 250, hands required: 1}
6. Armor{name: Breastplate, price: 350, 3, damage reduction: 600}
7. Potion{name: Mermaid_Tears, price: 850, level: 5, effectiveAmount: 100, affecttedAttrubutes:[Health, Mana, Strength, Agility]}
8. Weapon{name: TSwords, price: 1400, level: 8, damage value: 1600, hands required: 2}
9. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}
10. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}

Enter the index you want to buy or 0 to quit.2
Market items
1. Armor{name: Breastplate, price: 350, 3, damage reduction: 600}
2. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}
3. Potion{name: Mermaid_Tears, price: 850, level: 5, effectiveAmount: 100, affecttedAttrubutes:[Health, Mana, Strength, Agility]}
4. Weapon{name: Dagger, price: 200, level: 1, damage value: 250, hands required: 1}
5. Armor{name: Breastplate, price: 350, 3, damage reduction: 600}
6. Potion{name: Mermaid_Tears, price: 850, level: 5, effectiveAmount: 100, affecttedAttrubutes:[Health, Mana, Strength, Agility]}
7. Weapon{name: TSwords, price: 1400, level: 8, damage value: 1600, hands required: 2}
8. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}
9. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}

Enter the index you want to buy or 0 to quit.o
Exception in getItemIndex.
Enter the index you want to buy or 0 to quit.o
Exception in getItemIndex.
Enter the index you want to buy or 0 to quit.0
Hero bag items
1. LightningSpell{name: Breath_of_Fire,price: 350,level: 1,damage: 450,manacost: 100,reduce agility: , spell type: FireStrategy@aec6354}

Enter the index you want to sell or 0 to quit.0
Market items
1. Armor{name: Breastplate, price: 350, 3, damage reduction: 600}
2. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}
3. Potion{name: Mermaid_Tears, price: 850, level: 5, effectiveAmount: 100, affecttedAttrubutes:[Health, Mana, Strength, Agility]}
4. Weapon{name: Dagger, price: 200, level: 1, damage value: 250, hands required: 1}
5. Armor{name: Breastplate, price: 350, 3, damage reduction: 600}
6. Potion{name: Mermaid_Tears, price: 850, level: 5, effectiveAmount: 100, affecttedAttrubutes:[Health, Mana, Strength, Agility]}
7. Weapon{name: TSwords, price: 1400, level: 8, damage value: 1600, hands required: 2}
8. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}
9. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}

Hero items
1. LightningSpell{name: Breath_of_Fire,price: 350,level: 1,damage: 450,manacost: 100,reduce agility: , spell type: FireStrategy@aec6354}

Market items
1. Armor{name: Breastplate, price: 350, 3, damage reduction: 600}
2. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}
3. Potion{name: Mermaid_Tears, price: 850, level: 5, effectiveAmount: 100, affecttedAttrubutes:[Health, Mana, Strength, Agility]}
4. Weapon{name: Dagger, price: 200, level: 1, damage value: 250, hands required: 1}
5. Armor{name: Breastplate, price: 350, 3, damage reduction: 600}
6. Potion{name: Mermaid_Tears, price: 850, level: 5, effectiveAmount: 100, affecttedAttrubutes:[Health, Mana, Strength, Agility]}
7. Weapon{name: TSwords, price: 1400, level: 8, damage value: 1600, hands required: 2}
8. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}
9. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}

Enter the index you want to buy or 0 to quit.0
Hero bag items

Enter the index you want to sell or 0 to quit.i
Exception in getItemIndex.
Enter the index you want to sell or 0 to quit.0
Market items
1. Armor{name: Breastplate, price: 350, 3, damage reduction: 600}
2. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}
3. Potion{name: Mermaid_Tears, price: 850, level: 5, effectiveAmount: 100, affecttedAttrubutes:[Health, Mana, Strength, Agility]}
4. Weapon{name: Dagger, price: 200, level: 1, damage value: 250, hands required: 1}
5. Armor{name: Breastplate, price: 350, 3, damage reduction: 600}
6. Potion{name: Mermaid_Tears, price: 850, level: 5, effectiveAmount: 100, affecttedAttrubutes:[Health, Mana, Strength, Agility]}
7. Weapon{name: TSwords, price: 1400, level: 8, damage value: 1600, hands required: 2}
8. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}
9. Armor{name: Full_Body_Armor, price: 1000, 8, damage reduction: 1100}

Hero items

+---+---+---+---+---+---+---+---+
|   |   | T |   |   |   |   | X |
+---+---+---+---+---+---+---+---+
|   |   |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| M |   |   | M | M | X | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
| M |   |   |   |   | M | X | X |
+---+---+---+---+---+---+---+---+
| X |   |   |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   | M |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
You are in possition row 0 , column 2
? W/w: move up
? A/a: move left
? S/s: move down
? D/d: move right
? Q/q: quit game
? I/i: show information
? M/m: enter market
? K/k: show map
? B/b: show inventory
i
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Heros in the party:
Hero[name: Sehanine_Monnbow, HP200/200, mana: 660/660, damage: 846/846, agility: 881/881, dexterityValue: 604/604, gold: 2250, Level: (12/20) Level 2, Equipped Weapon: null, Equipped Armor: null]
Hero[name: Caliber_Heist, HP200/200, mana: 440/440, damage: 483/483, agility: 440/440, dexterityValue: 483/483, gold: 2600, Level: (12/20) Level 2, Equipped Weapon: null, Equipped Armor: null]
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
+---+---+---+---+---+---+---+---+
|   |   | T |   |   |   |   | X |
+---+---+---+---+---+---+---+---+
|   |   |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| M |   |   | M | M | X | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
| M |   |   |   |   | M | X | X |
+---+---+---+---+---+---+---+---+
| X |   |   |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   | M |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
You are in possition row 0 , column 2
? W/w: move up
? A/a: move left
? S/s: move down
? D/d: move right
? Q/q: quit game
? I/i: show information
? M/m: enter market
? K/k: show map
? B/b: show inventory
b
Hero bag items
1. LightningSpell{name: Breath_of_Fire,price: 350,level: 1,damage: 450,manacost: 100,reduce agility: , spell type: FireStrategy@aec6354}

Enter the index you want to use 0 to quit the bag: 0
Exit bag.
Hero bag items

Enter the index you want to use 0 to quit the bag: 0
Exit bag.
+---+---+---+---+---+---+---+---+
|   |   | T |   |   |   |   | X |
+---+---+---+---+---+---+---+---+
|   |   |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| M |   |   | M | M | X | M | M |
+---+---+---+---+---+---+---+---+
| M | M |   | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
| M |   |   |   |   | M | X | X |
+---+---+---+---+---+---+---+---+
| X |   |   |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   | M |   | M |
+---+---+---+---+---+---+---+---+
| M |   | M | X |   |   | X |   |
+---+---+---+---+---+---+---+---+
You are in possition row 0 , column 2
? W/w: move up
? A/a: move left
? S/s: move down
? D/d: move right
? Q/q: quit game
? I/i: show information
? M/m: enter market
? K/k: show map
? B/b: show inventory
q
quit the game
