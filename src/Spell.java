/**
 * name, price, level, damage value, mana cost spell type.
 */
public class Spell extends Item implements Cloneable, Usable {

    private int manaCost;

    private int damage;

    private SpellStrategy spellStrategy;

    private final double AFFECTIVE_RATIO = 0.1;

    public int getManaCost() {
        return manaCost;
    }

    public int getDamage() {
        return damage;
    }

    public Spell() {
    }

    public Spell(String name, int price, int level, int damage, int manaCost, SpellStrategy spellStrategy) {
        super(name, price, level);
        this.manaCost = manaCost;
        this.damage = damage;
        this.spellStrategy = spellStrategy;
    }

    public Spell clone() throws CloneNotSupportedException {
        return (Spell) super.clone();
    }

    public SpellStrategy getSpellStrategy() {
        return spellStrategy;
    }


    @Override
    public String toString() {
        return "LightningSpell{" + "name: " + getName() + "," + "price: " + getPrice() + "," + "level: " + getLevel() + "," + "damage: " + getDamage() + "," + "manacost: " + getManaCost() + "," + "reduce agility: " + ", spell type: " + getSpellStrategy() + "}";
    }


    @Override
    public boolean use(Character user, Character target) {
        Hero hero = (Hero) user;
        int mana = hero.getMana();
        if (mana >= getManaCost()) {
            mana -= getManaCost();
            hero.setMana(mana);
            int hp = target.getHP();
            hp -= (getDamage() + (hero.getBattleDexterity() / 10000) * getDamage());
            target.setHP(hp);
            getSpellStrategy().cast(target, AFFECTIVE_RATIO);
            System.out.println("Use spell " + getName() + " deal " + (getDamage() + (hero.getBattleDexterity() / 10000) * getDamage()) + "damage");
            System.out.println(target.getHP() + " has " + target.getHP() + " health.");
            return true;
        }
        System.out.println("Mana not enough");
        return false;
    }

    @Override
    public boolean use(Character user) {
        return false;
    }

    @Override
    public Item unequipe(Character character) {
        return null;
    }


}
