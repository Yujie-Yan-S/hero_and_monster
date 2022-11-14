import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * generate random weapons
 */
public class WeaponFactory {
    private static WeaponFactory weaponFactory = null;

    private WeaponFactory() {
    }

    public static WeaponFactory getInstance() {
        if (weaponFactory == null) {
            weaponFactory = new WeaponFactory();
        }

        return weaponFactory;
    }

    private static List<Weapon> list = new ArrayList<>();
    private static Random random;

    static {
        List<List<String>> data = FileParser.parseFile("resource/Weaponry.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            list.add(new Weapon(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4))));
        }
        random = new Random();

    }

    /**
     * get a weapon
     *
     * @return random weapon
     */
    public Weapon getWeapon() throws CloneNotSupportedException {
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
        WeaponFactory weaponFactory = new WeaponFactory();
        System.out.println(weaponFactory.getWeapon());
        System.out.println(weaponFactory.getWeapon());
        System.out.println(weaponFactory.getWeapon());
        System.out.println(weaponFactory.getWeapon());
        System.out.println(weaponFactory.getWeapon());
        System.out.println(weaponFactory.getWeapon());
        System.out.println(weaponFactory.getWeapon());
        System.out.println(weaponFactory.getWeapon());
        System.out.println(weaponFactory.getWeapon());
    }
}
