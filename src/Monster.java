/**
 * class of monsters
 */
public class Monster extends Character {

    public Monster(String name, int level, int damageValue, int defenseValue, int dodgeChance) {
        super(name, level, damageValue, defenseValue, dodgeChance);
    }


    public Monster clone() throws CloneNotSupportedException {
        return (Monster) super.clone();
    }

    @Override
    public String toString() {
        return "Monster{" + "name: " + getName() + ", level: " + getLevel() + ", HP: " + getHP() + ", damage value: " + getDamageValue() + ", defense value: " + getDefenseValue() + ", dodge chance: " + getDodgeChance() + "}";
    }

    public double getMonsterDodgeChacne() {
        return getDodgeChance() * 0.01;
    }


}
