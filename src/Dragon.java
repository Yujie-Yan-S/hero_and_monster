/**
 * dragon object
 */
public class Dragon extends Monster implements Cloneable {
    public Dragon(String name, int level, int damageValue, int defenseValue, int dodgeChance) {
        super(name, level, damageValue, defenseValue, dodgeChance);
    }

    public Dragon clone() throws CloneNotSupportedException {
        return (Dragon) super.clone();
    }

    @Override
    public String toString() {
        return "Dragon{" + "name: " + getName() + ", level: " + getLevel() + ", HP: " + getHP() + ", damage value: " + getDamageValue() + ", defense value: " + getDefenseValue() + ", dodge chance: " + getDodgeChance() + "}";
    }
}
