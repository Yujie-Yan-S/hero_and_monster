import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * class of the process of the game
 */
public class GameProcess {

    public GameProcess() {
        heroFactory = new HeroFactory();
    }

    private final String line = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";

    private Board board;

    private Party party;

    private HeroFactory heroFactory;

    private InputCheck inputCheck = InputCheck.getInstance();

    private Random random = new Random();

    private final double BATTLE_RATIO = 0.2;

    public void startGame() {
        createBoard();
        printBoard();
        createParty();
        printParty();
        controlParty();
    }


    private void controlParty() {
        // case of displaying information
        while (true) {
            printBoard(party.getI(), party.getJ());

            String controlInput = inputCheck.getControlInput();
            if (controlInput.equalsIgnoreCase("q")) {
                System.out.println("quit the game");
                System.exit(0);
            }
            if (Pattern.matches("^[i|I|m|M|k|K|B|b]$", controlInput)) {
                displayInformationAction(controlInput);
            } else {
                if (controlInput.equalsIgnoreCase("w")) {
                    moveUp();
                } else if (controlInput.equalsIgnoreCase("s")) {
                    moveDown();
                } else if (controlInput.equalsIgnoreCase("a")) {
                    moveLeft();
                } else if (controlInput.equalsIgnoreCase("d")) {
                    moveRight();
                }

                // generate battle
                if (board.getTile(party.getI(), party.getJ()) instanceof CommonTile) {
                    randomBattle();
                }
            }
        }

    }

    /**
     * prompt use to use item
     *
     * @param hero
     */
    public void useItem(Hero hero) {
        System.out.println("Hero bag items");
        System.out.println(hero.displayItems());
        int itemIndex = inputCheck.getUseItemIndex(hero.getNumberOfItems());
        if (itemIndex == 0) {
            System.out.println("Exit bag.");
            return;
        }
        List<Item> inventory = hero.getInventory();
        // get the item want to use
        Item item = inventory.get(itemIndex - 1);
        if (item instanceof Potion) {
            ((Potion) item).use(hero);
        } else if (item instanceof Spell) {
            System.out.println("Can't use spell out side of battle");
        } else if (item instanceof Weapon) {
            ((Weapon) item).use(hero);
        } else if (item instanceof Armor) {
            ((Armor) item).use(hero);
        }

    }

    private void randomBattle() {
        double v = random.nextDouble();
        if (v <= BATTLE_RATIO) {
            new Battle(party).start();
        } else {
            System.out.println("No monster here.\n");
        }
    }

    private void displayInformationAction(String input) {
        if (input.equalsIgnoreCase("m")) {
            enterMarket();
        } else if (input.equalsIgnoreCase("i")) {
            printParty();
        } else if (input.equalsIgnoreCase("k")) {
            printBoard(party.getI(), party.getJ());
        } else {
            List<Hero> heros = party.getHeros();
            for (Hero hero : heros) {
                useItem(hero);
            }
        }
    }


    private void enterMarket() {
        Tile tile = board.getTile(party.getI(), party.getJ());
        if (!isMarket(tile)) {
            System.out.println("not on the market tile");
        } else {
            Market market = board.getMarket(party.getI(), party.getJ());
            for (Hero i : party.getHeros()) {
                trade(market, i);
            }
        }
    }

    private void trade(Market market, Hero hero) {
        buy(market, hero);
        sell(market, hero);
        System.out.println("Market items");
        System.out.println(market.displayItems());
        System.out.println("Hero items");
        System.out.println(hero.displayItems());
    }

    private void buy(Market market, Hero hero) {
        while (true) {
            System.out.println("Market items");
            System.out.println(market.displayItems());
            int itemIndex = inputCheck.getItemIndex(market.getNumberOfItems());
            if (itemIndex == 0) break;
            Item item = market.getInventory().get(itemIndex - 1);
            if (item.getPrice() <= hero.getGold() && item.getLevel() <= hero.getLevel()) {
                hero.addItem(item);
                hero.reduceMoney(item.getPrice());
                market.removeItem(item);
            } else {
                System.out.println("Hero can't buy this item.");
            }

        }
    }

    private void sell(Market market, Hero hero) {
        while (true) {
            System.out.println("Hero bag items");
            System.out.println(hero.displayItems());
            int itemIndex = inputCheck.getHeroItemIndex(hero.getNumberOfItems());
            if (itemIndex == 0) break;
            Item item = hero.getInventory().get(itemIndex - 1);
            hero.removeItem(item);
            hero.increaseMoney(item.getPrice() / 2);
            market.addItem(item);

        }

    }


    private void moveUp() {
        if (party.getI() > 0 && !isInaccessible(board.getTile(party.getI() - 1, party.getJ()))) {
            party.setI(party.getI() - 1);
        } else {
            System.out.println("Not able to move up.");
        }
    }

    private void moveDown() {
        if (party.getI() < board.getDEFAULT_SIZE() - 1 && !isInaccessible(board.getTile(party.getI() + 1, party.getJ()))) {
            party.setI(party.getI() + 1);
        } else {
            System.out.println("Not able to move down.");
        }
    }

    private void moveLeft() {
        if (party.getJ() > 0 && !isInaccessible(board.getTile(party.getI(), party.getJ() - 1))) {
            party.setJ(party.getJ() - 1);
        } else {
            System.out.println("Not able to move left.");
        }
    }

    private void moveRight() {
        if (party.getJ() < board.getDEFAULT_SIZE() - 1 && !isInaccessible(board.getTile(party.getI(), party.getJ() + 1))) {
            party.setJ(party.getJ() + 1);
        } else {
            System.out.println("Not able to move right.");
        }
    }


    /**
     * print out the heroes in the party
     */
    private void printParty() {
        System.out.println(line);
        System.out.println("Heros in the party:");
        for (Hero i : party.getHeros()) {
            System.out.println(i);
        }
        System.out.println(line);
    }

    private boolean isInaccessible(Tile tile) {
        return tile instanceof InaccessibleTile;
    }

    private boolean isMarket(Tile tile) {
        return tile instanceof MarketTile;
    }

    private void createBoard() {
        int seed = inputCheck.getBoardSeed();
        if (seed == 0) {
            board = new Board();
        } else {
            board = new Board(seed);
        }
    }

    /**
     * print the board without play position
     */
    private void printBoard() {
        System.out.println(board.printBoard());
    }

    /**
     * print board with current player position
     *
     * @param i
     * @param j
     */
    private void printBoard(int i, int j) {
        System.out.println(board.printBoard(i, j));
    }

    private void createParty() {
        party = new Party();
        int partySize = inputCheck.getPartyNum();
        for (int i = 0; i < partySize; i++) {
            printHeroMenu();
            //get the index in the herofactory
            int index = inputCheck.getHeroIndex(heroFactory.getNumOfHero());
            // return the hero corresponding to the index
            Hero hero = null;
            try {

                hero = heroFactory.getHero(index);
            } catch (Exception e) {
                System.out.println("Clone not support in create hero with index in GameProcess");
            }
            party.addHero(hero);
        }
    }

    private void printHeroMenu() {
        String heroList = heroFactory.getHeroList();
        System.out.println(heroList);
    }


}
