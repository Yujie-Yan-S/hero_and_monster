/**
 * class of item with price and level requiremnt
 */
public abstract class Item {
    private String name;

    private int price;

    private int level;

    public Item() {

    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", level=" + level +
                '}';
    }

    public Item(String name, int price, int level) {
        this.name = name;
        this.price = price;
        this.level = level;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
