import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * armor factory returns radom armor
 */
public class ArmorFactory {

    private static ArmorFactory armorFactory = null;

    private ArmorFactory() {
    }

    public static ArmorFactory getInstance() {
        if (armorFactory == null) {
            armorFactory = new ArmorFactory();
        }

        return armorFactory;
    }

    private static List<Armor> list = new ArrayList<>();
    private static Random random;

    static {
        List<List<String>> data = FileParser.parseFile("resource/Armory.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            list.add(new Armor(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3))));
        }
        random = new Random();

    }

    /**
     * get a armor
     *
     * @return random armor
     */
    public Armor getArmor() throws CloneNotSupportedException {
        return list.get(getRandomIndex()).clone();
    }

    /**
     * get random index in the weapons sample
     *
     * @return a random index of weapon list
     */
    private int getRandomIndex() {
        return random.nextInt(list.size());
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ArmorFactory armorFactory = new ArmorFactory();
        System.out.println(armorFactory.getArmor());
        System.out.println(armorFactory.getArmor());
        System.out.println(armorFactory.getArmor());
        System.out.println(armorFactory.getArmor());
        System.out.println(armorFactory.getArmor());
        System.out.println(armorFactory.getArmor());
        System.out.println(armorFactory.getArmor());
        System.out.println(armorFactory.getArmor());
        System.out.println(armorFactory.getArmor());
    }
}
