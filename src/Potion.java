import java.util.Arrays;

/**
 * name, price, level, effect amount
 */
public class Potion extends Item implements Cloneable, Usable {

    private int effectiveAmount;

    public int getEffectiveAmount() {
        return effectiveAmount;
    }

    @Override
    public String toString() {
        return "Potion{" + "name: " + getName() + ", price: " + getPrice() + ", level: " + getLevel() + ", effectiveAmount: " + getEffectiveAmount() + ", affecttedAttrubutes:" + Arrays.toString(getAffecttedAttrubutes()) +
                '}';
    }

    public String[] getAffecttedAttrubutes() {
        String[] split = affecttedAttrubutes.split("/( *)");
        return split;
    }

    /**
     * concatenated affected attributes with "/" to deal with shallow clone
     */
    private String affecttedAttrubutes;

    public Potion() {
    }

    public Potion(String name, int price, int level, int effectiveAmount, String affecttedAttrubutes) {
        super(name, price, level);
        this.effectiveAmount = effectiveAmount;
        this.affecttedAttrubutes = affecttedAttrubutes;
    }

    public Potion clone() throws CloneNotSupportedException {
        return (Potion) super.clone();

    }


    @Override
    public boolean use(Character user, Character target) {
        return false;
    }

    private String[] getAttributes() {
        return affecttedAttrubutes.split("/( *)");
    }

    @Override
    public boolean use(Character user) {
        Hero hero = (Hero) user;
        String[] attributes = getAttributes();
        for (String i : attributes) {
            switch (i) {
                case "Health":
                    hero.setBattleHP(hero.getBattleHP() + effectiveAmount);
                    break;
                case "Mana":
                    hero.setBattleMana(hero.getBattleMana() + effectiveAmount);
                    break;
                case "Strength":
                    hero.setBattleStrength(hero.getBattleStrength() + effectiveAmount);
                    break;
                case "Dexterity":
                    hero.setBattleDexterity(hero.getBattleDexterity() + effectiveAmount);
                    break;
                case "Defense":
                    hero.setBattleDefense(hero.getBattleDefense() + effectiveAmount);
                    break;
                case "Agility":
                    hero.setBattleAgility(hero.getBattleAgility() + effectiveAmount);
                    break;
                default:
                    return false;
            }
        }
        return true;

    }

    @Override
    public Item unequipe(Character user) {
        return null;
    }
}
