import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * the  class hero
 */
public class Hero extends Character implements Cloneable {


    private int experience;


    private int mana;


    //spell value
    private int dexterityValue;

    private int gold;

    private List<Item> inventory;

    private UpgradeStrategy upgradeStrategy;

    /**
     * current equipped armor
     */
    private Armor armor;

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * current equipped weapon
     */
    private Weapon weapon;

    private int battleMana;
    private int battleHP;
    private int battleStrength;
    private int battleDexterity;
    private int battleDefense;
    private int battleAgility;

    public int getBattleMana() {
        return battleMana;
    }

    public void setBattleMana(int battleMana) {
        this.battleMana = battleMana;
    }

    public int getBattleHP() {
        return battleHP;
    }

    public void setBattleHP(int battleHP) {
        this.battleHP = battleHP;
    }

    public int getBattleStrength() {
        return battleStrength;
    }

    public void setBattleStrength(int battleStrength) {
        this.battleStrength = battleStrength;
    }

    public int getBattleDexterity() {
        return battleDexterity;
    }

    public void setBattleDexterity(int battleDexterity) {
        this.battleDexterity = battleDexterity;
    }

    public int getBattleDefense() {
        return battleDefense;
    }

    public void setBattleDefense(int battleDefense) {
        this.battleDefense = battleDefense;
    }

    public int getBattleAgility() {
        return battleAgility;
    }

    public void setBattleAgility(int battleAgility) {
        this.battleAgility = battleAgility;
    }

    /**
     * reset stats after the battle
     */
    public void resetBattleStats() {
        battleMana = mana;
        battleHP = getHP();
        battleStrength = getDamageValue();
        battleDexterity = dexterityValue;
        battleDefense = getDefenseValue();
        battleAgility = getDodgeChance();
    }

    /**
     * revive the hero
     */
    public void reviveHero() {
        battleMana = mana;
        battleHP = getHP() / 2;
        battleStrength = getDamageValue();
        battleDexterity = dexterityValue;
        battleDefense = getDefenseValue();
        battleAgility = getDodgeChance();
    }

    public Hero(String name, int mana, int damageValue, int dodgeChance, int dexterityValue, int gold, int experience, UpgradeStrategy upgradeStrategy) {
        super(name, experience / 10 + 1, damageValue, 0, dodgeChance);
        this.experience = experience;
        this.mana = mana;
        this.dexterityValue = dexterityValue;
        this.gold = gold;
        this.inventory = new LinkedList<>();
        this.upgradeStrategy = upgradeStrategy;
        battleMana = mana;
        battleHP = getHP();
        battleStrength = getDamageValue();
        battleDexterity = dexterityValue;
        battleDefense = getDefenseValue();
        battleAgility = getDodgeChance();
    }

    public UpgradeStrategy getUpgradeStrategy() {
        return upgradeStrategy;
    }

    public Hero clone() throws CloneNotSupportedException {
        return (Hero) super.clone();
    }

    public int getExperience() {
        return experience;
    }

    public int getMana() {
        return mana;
    }

    public int getDexterityValue() {
        return dexterityValue;
    }

    public int getGold() {
        return gold;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setDexterityValue(int dexterityValue) {
        this.dexterityValue = dexterityValue;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void setUpgradeStrategy(UpgradeStrategy upgradeStrategy) {
        this.upgradeStrategy = upgradeStrategy;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void reduceMoney(int i) {
        gold -= i;
    }

    public void increaseMoney(int i) {
        gold += i;
    }

    public String displayItems() {
        String items = "";
        for (int i = 0; i < inventory.size(); i++) {
            items += (i + 1) + ". " + inventory.get(i) + "\n";
        }
        return items;
    }

    public int getNumberOfItems() {
        return inventory.size();
    }

    public void setExperience(int experience) {
        this.experience = experience;
        setLevel(experience / 10 + 1);
        setHP(getLevel() * 100);
        setMana((int) (getMana() * Math.pow(1.1, getLevel() - 1)));
        upgradeStrategy.upgrade(this);
    }

    @Override
    public void reduceHP(int i) {
        battleHP -= i;
        battleHP = battleHP < 0 ? 0 : battleHP;

    }

    public double calculateDodgeChacne() {
        return getBattleAgility() * 0.0002;
    }

    public int calculateDagame() {
        return (int) (getBattleStrength() * 0.05);
    }

    private String getLevelExperience() {
        return "(" + getExperience() + "/" + 10 * (getLevel()) + ")" + " Level " + getLevel();
    }

    @Override
    public String toString() {
        return "Hero[" + "name: " + getName() + ", HP" + battleHP + "/" + getHP() + ", mana: " + battleMana + "/" + getMana() +
                ", damage: " + getBattleStrength() + "/" + getDamageValue() + ", agility: " + getBattleAgility() + "/" + getDodgeChance() + ", dexterityValue: "
                + getBattleDexterity() + "/" + getDexterityValue() + ", gold: " + getGold() + ", Level: " + getLevelExperience() + ", Equipped Weapon: " + getWeapon()
                + ", Equipped Armor: " + getArmor() +
                ']'+"Tag: "+ getTag();
    }

}
