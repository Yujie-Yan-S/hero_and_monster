/**
 * name, price, level, damage value, number of hands required to use it
 */
public class Weapon extends Item implements Cloneable, Usable {
    private int damageValue;

    private int hands;

    public int getDamageValue() {
        return damageValue;
    }

    public int getHands() {
        return hands;
    }

    public Weapon() {

    }

    public Weapon(String name, int price, int level, int damageValue, int hands) {
        super(name, price, level);
        this.damageValue = damageValue;
        this.hands = hands;
    }

    public Weapon clone() throws CloneNotSupportedException {
        return (Weapon) super.clone();
    }

    @Override
    public String toString() {
        return "Weapon{" + "name: " + getName() + ", price: " + getPrice() + ", level: " + getLevel() + ", damage value: " + getDamageValue() + ", hands required: " + getHands() + "}";
    }


    @Override
    public boolean use(Character character) {
        if (((Hero) character).getWeapon() != null) {
            return false;
        }
        character.setDamageValue(character.getDamageValue() + getDamageValue());
        ((Hero) character).setWeapon(this);
        return true;
    }

    @Override
    public boolean use(Character user, Character target) {
        if (((Hero) user).getWeapon() != null) {
            return false;
        }
        user.setDamageValue(user.getDamageValue() + getDamageValue());
        ((Hero) user).setWeapon(this);
        return true;
    }

    @Override
    public Item unequipe(Character character) {
        if (((Hero) character).getWeapon() == null) {
            return null;
        }
        character.setDamageValue(character.getDamageValue() - getDamageValue());
        Weapon weapon = ((Hero) character).getWeapon();
        ((Hero) character).setWeapon(null);
        return weapon;
    }


}
