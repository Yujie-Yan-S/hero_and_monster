/**
 * name, price, level, damage reduction value armor object
 */
public class Armor extends Item implements Cloneable, Usable {
    private int damageReduction;

    public Armor() {
    }

    public Armor(String name, int price, int level, int damageReduction) {
        super(name, price, level);
        this.damageReduction = damageReduction;
    }

    public Armor clone() throws CloneNotSupportedException {
        return (Armor) super.clone();
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    @Override
    public String toString() {
        return "Armor{" + "name: " + getName() + ", price: " + getPrice() + ", " + getLevel() + ", damage reduction: " + getDamageReduction() +
                '}';
    }


    @Override
    public boolean use(Character user, Character target) {
        return true;
    }

    @Override
    public boolean use(Character user) {
        if (((Hero) user).getArmor() != null) {
            return false;
        }
        user.setDefenseValue(user.getDefenseValue() + getDamageReduction());
        ((Hero) user).setArmor(this);
        return true;
    }

    @Override
    public Item unequipe(Character character) {
        if (((Hero) character).getArmor() == null) {
            return null;
        }
        character.setDefenseValue(character.getDefenseValue() - getDamageReduction());
        Armor armor = ((Hero) character).getArmor();
        ((Hero) character).setWeapon(null);
        return armor;
    }
}
