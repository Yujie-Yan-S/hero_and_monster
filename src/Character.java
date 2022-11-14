/**
 * class of Character containing base information shared.
 */
public class Character {

    private String name;

    private int level;

    private int HP;

    private int damageValue;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }

    private int defenseValue;


    private int dodgeChance;

    public Character(String name, int level, int damageValue, int defenseValue, int dodgeChance) {
        this.name = name;
        this.level = level;
        this.HP = level * 100;
        this.damageValue = damageValue;
        this.defenseValue = defenseValue;
        this.dodgeChance = dodgeChance;

    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHP() {
        return HP;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public void reduceHP(int i) {
        HP -= i;
        HP = HP < 0 ? 0 : HP;
    }

    public int calculateDagame() {
        return (int) (damageValue * 0.05);
    }

    public int calculateDefense() {
        return (int) (defenseValue * 0.05);
    }


}
