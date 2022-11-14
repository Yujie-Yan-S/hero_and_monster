import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * generate random potions
 */
public class PotionFactory {

    private static PotionFactory potionFactory = null;

    private PotionFactory() {
    }

    public static PotionFactory getInstance() {
        if (potionFactory == null) {
            potionFactory = new PotionFactory();
        }

        return potionFactory;
    }

    private static List<Potion> list = new ArrayList<>();
    private static Random random;

    static {
        List<List<String>> data = FileParser.parseFile("resource/Potions.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            list.add(new Potion(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)), params.get(4)));
        }
        random = new Random();

    }

    /**
     * get a potion
     *
     * @return random potion
     */
    public Potion getPotion() throws CloneNotSupportedException {
        return list.get(getRandomIndex()).clone();
    }

    /**
     * get random index in the potion sample
     *
     * @return a random index of potion list
     */
    private int getRandomIndex() {
        return random.nextInt(list.size());
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PotionFactory potionFactory = new PotionFactory();
        System.out.println(potionFactory.getPotion());
        System.out.println(potionFactory.getPotion());
        System.out.println(potionFactory.getPotion());
        System.out.println(potionFactory.getPotion());
        System.out.println(potionFactory.getPotion());
        System.out.println(potionFactory.getPotion());
        System.out.println(potionFactory.getPotion());
        System.out.println(potionFactory.getPotion());
        System.out.println(potionFactory.getPotion());
        System.out.println(potionFactory.getPotion());
        System.out.println(potionFactory.getPotion());
    }
}
