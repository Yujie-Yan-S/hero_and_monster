import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Valor {
    private Board board;
    private Controller controller;
    public void start() throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        board = new Board();
        controller = new Controller();
        HeroFactory heroFactory = new HeroFactory();
        System.out.println(heroFactory.getHeroList());
        System.out.println("Choose the hero: ");
        int s = scanner.nextInt();
        scanner.nextLine();
        Hero hero = heroFactory.getHero(s);
        System.out.println(hero.getTag());

        System.out.println(heroFactory.getHeroList());
        System.out.println("Choose the hero: ");
        s = scanner.nextInt();
        scanner.nextLine();
        Hero hero1 = heroFactory.getHero(s);
        System.out.println(hero1.getTag());


        System.out.println(heroFactory.getHeroList());
        System.out.println("Choose the hero: ");
        s = scanner.nextInt();
        scanner.nextLine();
        Hero hero2 = heroFactory.getHero(s);
        System.out.println(hero2.getTag());

        // add all heros into the board
        ArrayList<Hero> listOfHeros = new ArrayList<>();
        listOfHeros.add(hero);
        listOfHeros.add(hero1);
        listOfHeros.add(hero2);
        System.out.println(listOfHeros);
        controller.respawnAllHero(listOfHeros);
        //get the highest level
        List<Monster> monsterList = controller.respawnMonster(1);
        //print the board
        while (true) {

            //turn for hero
            for (Hero heroi : listOfHeros) {
                System.out.println(board.printBoardWithCharacter());
                System.out.println(prompt());
                int i = scanner.nextInt();
                scanner.nextLine();
                switch (i) {
                    case 1:
                        // change a weapon or armor
                        useItem(heroi);
                        break;
                    case 2:
                        useItem(heroi);
                        break;
                    case 3:
                        //attack
                        attack(heroi);
                        break;
                    case 4:
                        //cast spell
                        useItem(heroi);
                        break;
                    case 5:
                        //move
                        System.out.print("w for going up\n" +
                                "s for going down\n" +
                                "a for going left\n" +
                                "d for going right");
                        String command = scanner.nextLine();
                        controller.move(heroi, command, board);
                        if(CharacterLocation.anyCharacterReachedNexus(heroi)){
                            System.out.println("Hero win the game");
                            System.exit(0);
                        }
                        break;
                    case 6:
                        // teleport
                        int lane;
                        while (true) {
                            try {
                                System.out.print("Enter the lane you want to teleport to: ");
                                lane = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            } catch (Exception e) {
                                scanner.nextLine();
                                System.out.println("Invalid input for lane.");
                            }
                        }
                        String direction;
                        while (true) {
                            try {
                                System.out.print("Enter the direction you want to teleport to, enter s to going to side and b to go to back: ");
                                direction = scanner.nextLine();
                                if (!direction.equalsIgnoreCase("s") && !direction.equalsIgnoreCase("b")) {
                                    throw new Exception();
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid input for direction.");
                            }
                        }
                        System.out.println();
                        controller.teleport(heroi, lane, direction, board);
                        break;
                    case 7:
                        //recall
                        controller.recall(heroi, board);
                        break;
                }
            }
            //turn for monster
            for(Monster i:monsterList){
                if(i.getHP()<=0){
                    CharacterLocation.removeMonster(i);
                }
                moveOrAttack(i);
                if(CharacterLocation.anyCharacterReachedNexus(i)){
                    System.out.println("Hero win the game");
                    System.exit(0);
                }
            }
        }



    }

    public void moveOrAttack(Monster monster){
        Hero surroundingHero = CharacterLocation.getSurroundingHero(monster);
        if(surroundingHero==null){
         controller.moveDown(monster,board);
     }
     else {
         attackRandomHero(monster,surroundingHero);
     }
    }






    public boolean useItem(Hero hero) {
        InputCheck inputCheck = InputCheck.getInstance();
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

            Monster monster = CharacterLocation.getSurroundingMonster(hero);
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

    private boolean isDead(Character character) {
        return character.getHP() <= 0;
    }

    /**
     * monster pick a random hero to attack
     *
     * @param monster
     */
    private void attackRandomHero(Monster monster, Hero hero) {
        boolean b = landAttack(hero.calculateDodgeChacne());
        System.out.println("Monster attacked " + hero.getName());
        if (b) {
            System.out.println("Hero dodged the attack.");
        } else {
            hero.reduceHP(monster.calculateDagame() - hero.calculateDefense());
            System.out.println(monster.getName() + " attacked " + hero.getName() + " deals " + (monster.calculateDagame() - hero.calculateDefense()) + " damage");
        }
    }


    private void attack(Hero hero) {
        Monster monster = CharacterLocation.getSurroundingMonster(hero);
        if (landAttack(monster.getMonsterDodgeChacne())) {
            //attack missed
            System.out.println("Attack has been dodged, monster get no harm.");
        } else {
            monster.reduceHP(hero.calculateDagame());
            System.out.println("Hero attack make " + hero.calculateDagame() + " damage.");
            System.out.println("Monster has " + monster.getHP() + " health.");
            System.out.println();
            if (isDead(monster)) {
                System.out.println("Monster is dead.");

            }
        }


    }

    private boolean landAttack(double dodgeChance) {
        Random random = new Random();
        double v = random.nextDouble();
        if (v <= dodgeChance) {
            return true;
        }
        return false;
    }



    public String prompt(){
        return "1. Change Weapon or Armor\n" +
                "2. Use a Potion\n" +
                "3. Attack\n" +
                "4. Cast a Spell\n" +
                "5. Move\n" +
                "6. Teleport\n" +
                "7. Recall\n";
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        new Valor().start();
    }
}
