import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * class to handle the battle
 */
public class Battle {
    private final String line = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
    private Party party;
    private MonsterFactory monsterFactory = new MonsterFactory();

    private List<Hero> fainted = new ArrayList<>();

    private List<Monster> monsters;

    private List<Hero> heros;

    private InputCheck inputCheck = InputCheck.getInstance();

    private Random random = new Random();

    private int heigestLevel;

    private int numOfEnemy;

    public Battle(Party party) {
        this.party = party;
        heros = party.getHeros();
        // generate monsters with coresponding level
        monsters = monsterFactory.generateMonsterList(heros.size(), getHighestLevel(heros));
        heigestLevel = getHighestLevel(heros);
        numOfEnemy = heros.size();
    }

    public void start() {


        while (heros.size() > 0 && monsters.size() > 0) {
            fight();
        }
        // revive hero, add gold and experience to hero
        if (heros.size() <= 0) {
            System.out.println("Your team loose, game is end.");
            System.exit(0);
        } else {
            for (Hero hero : heros) {
                addGold(hero);
                addExperience(hero);
                hero.resetBattleStats();
            }
            for (Hero hero : fainted) {
                hero.reviveHero();
            }
            heros.addAll(fainted);
            fainted.clear();
        }
    }

    /**
     * add gold to the hero
     *
     * @param hero
     */
    private void addGold(Hero hero) {
        hero.setGold(heigestLevel * 100 + hero.getGold());
        System.out.println(hero.getName() + " get " + (heigestLevel * 100) + " gold!");
    }


    /**
     * add experience to the hero
     *
     * @param hero
     */
    private void addExperience(Hero hero) {
        hero.setExperience(numOfEnemy * 2 + hero.getExperience());
        System.out.println(hero.getName() + " get " + (numOfEnemy * 2 + hero.getExperience()) + " experience");
    }

    /**
     * get highest level in the party
     *
     * @param list
     * @return
     */
    public int getHighestLevel(List<Hero> list) {
        int i = 0;
        for (Hero hero : list) {
            i = hero.getLevel() > i ? hero.getLevel() : i;
        }
        return i;
    }

    private void fight() {
        // hero turn
        System.out.println(line);
        displayHeroInfo();
        System.out.println();
        displayMonsterInfo();
        System.out.println(line);
        for (int i = 0; i < heros.size(); i++) {
            Hero hero = heros.get(i);
            System.out.println(hero);
            String input = inputCheck.getHeroAction();
            if (input.equalsIgnoreCase("a")) {
                attack(hero);
            } else if (input.equalsIgnoreCase("u")) {

                boolean used = useItem(hero);
                if (!used) {
                    i--;
                }
            } else if (input.equalsIgnoreCase("i")) {
                System.out.println(line);
                displayHeroInfo();
                System.out.println();
                displayMonsterInfo();
                System.out.println(line);
                i--;
            } else {
                System.out.println("Quit the game, thank you for playing");
                System.exit(0);
            }
            if (monsters.size() <= 0) break;
        }
        // monster turn
        for (Monster monster : monsters) {
            attackRandomHero(monster);
            if (heros.size() <= 0) {
                break;
            }
        }

        // regain mana and health
        for (Hero hero : heros) {
            addManaHP(hero);
        }
    }


    /**
     * add mana and hp after each round
     *
     * @param hero
     */
    private void addManaHP(Hero hero) {
        hero.setBattleHP((int) (hero.getBattleHP() * 1.1));
        hero.setBattleMana((int) (hero.getBattleMana() * 1.1));
    }

    /**
     * monster pick a random hero to attack
     *
     * @param monster
     */
    private void attackRandomHero(Monster monster) {
        int i = random.nextInt(heros.size());
        Hero hero = heros.get(i);
        boolean b = landAttack(hero.calculateDodgeChacne());
        System.out.println("Monster attacked " + hero.getName());
        if (b) {
            System.out.println("Hero dodged the attack.");
        } else {
            hero.reduceHP(monster.calculateDagame() - hero.calculateDefense());
            System.out.println(monster.getName() + " attacked " + hero.getName() + " deals " + (monster.calculateDagame() - hero.calculateDefense()) + " damage");
        }
        if (hero.getBattleHP() <= 0) {
            faintHero(hero);
        }
    }


    private void faintHero(Hero hero) {
        fainted.add(hero);
        heros.remove(hero);
    }

    /**
     * prompt user to use item
     *
     * @param hero
     */
    public boolean useItem(Hero hero) {
        System.out.println(hero.displayItems());
        int itemIndex = inputCheck.getUseItemIndex(hero.getNumberOfItems());
        if (itemIndex == 0) {
            return false;
        }
        List<Item> inventory = hero.getInventory();
        // get the item want to use
        Item item = inventory.get(itemIndex - 1);
        if (item instanceof Potion) {
            ((Potion) item).use(hero);
            inventory.remove(item);
        } else if (item instanceof Spell) {
            displayMonsterInfo();
            // choose a monster to attack
            int target = inputCheck.getTarget(monsters.size());
            Monster monster = monsters.get(target - 1);
            if (landAttack(monster.getMonsterDodgeChacne())) {

                ((Spell) item).use(hero, monster);
            } else {
                System.out.println("The spell is dodged by monster.");
            }
            inventory.remove(item);
        } else if (item instanceof Weapon) {
            if (!((Weapon) item).use(hero)) {
                Item weapon = ((Weapon) item).unequipe(hero);
                inventory.add(weapon);

            }
            ((Weapon) item).use(hero);
            inventory.remove(item);

        } else if (item instanceof Armor) {
            if (!((Armor) item).use(hero)) {
                System.out.println("Already equipped a armor");
            } else {
                inventory.remove(item);
            }
        }
        return true;

    }

    /**
     * chhose the monster to attack
     *
     * @param hero
     */
    private void attack(Hero hero) {
        displayMonsterInfo();
        // choose a monster to attack
        int target = inputCheck.getTarget(monsters.size());
        Monster monster = monsters.get(target - 1);
        if (landAttack(monster.getMonsterDodgeChacne())) {
            //attack missed
            System.out.println("Attack has been dodged, monster get no harm.");
        } else {
            monster.reduceHP(hero.calculateDagame());
            System.out.println("Hero attack make " + hero.calculateDagame() + " damage.");
            System.out.println("Monster has " + monster.getHP() + " health.");
            System.out.println();
            if (isDead(monster)) {
                monsters.remove(monster);
                System.out.println("Monster is dead.");

            }
        }


    }


    private boolean isDead(Character character) {
        return character.getHP() <= 0;
    }


    /**
     * randomize if attack get dodged
     *
     * @param dodgeChance
     * @return
     */
    private boolean landAttack(double dodgeChance) {
        double v = random.nextDouble();
        if (v <= dodgeChance) {
            return true;
        }
        return false;
    }


    private void displayMonsterInfo() {
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println((i + 1) + ". " + monsters.get(i));
            System.out.println();
        }
    }

    private void displayHeroInfo() {
        for (Hero hero : heros) {
            System.out.println(hero);
        }
    }
}
