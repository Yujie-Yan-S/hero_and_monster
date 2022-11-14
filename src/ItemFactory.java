import java.util.Random;

public class ItemFactory {
    private SpellFactory spellFactory;
    private WeaponFactory weaponFactory;
    private ArmorFactory armorFactory;
    private PotionFactory potionFactory;

    private static ItemFactory itemFactory = null;

    private static final double SPELL_RATIO = 0.25;
    private static final double WEAPON_RATIO = 0.25;
    private static final double ARMOR_RATIO = 0.25;
    private static final double POTION_RATIO = 0.25;

    private Random random;

    public static ItemFactory getInstance() {
        if (itemFactory == null) {
            itemFactory = new ItemFactory();
        }
        return itemFactory;
    }


    private ItemFactory() {
        spellFactory = SpellFactory.getInstance();
        weaponFactory = WeaponFactory.getInstance();
        armorFactory = ArmorFactory.getInstance();
        potionFactory = PotionFactory.getInstance();
        random = new Random();
    }

    public Item getItem() {
        double v = random.nextDouble();
        Item item = null;

        try {
            if (v <= 0.25) {
                item = spellFactory.getSpell();
            } else if (v <= 0.5) {
                item = weaponFactory.getWeapon();
            } else if (v <= 0.75) {
                item = armorFactory.getArmor();
            } else if (v <= 1) {
                item = potionFactory.getPotion();
            }
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone not support in file item factory.");
        }
        return item;
    }


}
