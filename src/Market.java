import java.util.LinkedList;
import java.util.List;

/**
 * the market object
 */
public class Market {
    private List<Item> inventory;

    /**
     * the initial size of the items in the market
     */
    private final int initialItemSize = 10;

    public Market() {
        inventory = new LinkedList<>();
        initializeMarket();
    }

    private void initializeMarket() {
        ItemFactory itemFactory = ItemFactory.getInstance();
        for (int i = 0; i < initialItemSize; i++) {
            inventory.add(itemFactory.getItem());
        }
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public int getNumberOfItems() {
        return inventory.size();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public String displayItems() {
        String items = "";
        for (int i = 0; i < inventory.size(); i++) {
            items += (i + 1) + ". " + inventory.get(i) + "\n";
        }
        return items;
    }

    public static void main(String[] args) {
        Market market = new Market();
        for (Item item : market.getInventory()) {
            System.out.println(item);
        }
    }
}
