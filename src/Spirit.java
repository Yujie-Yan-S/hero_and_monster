/**
 * Spirit object
 */
public class Spirit extends Monster implements Cloneable {
    public Spirit(String name, int level, int damageValue, int defenseValue, int dodgeChance) {
        super(name, level, damageValue, defenseValue, dodgeChance);
    }

    public Spirit clone() throws CloneNotSupportedException {
        return (Spirit) super.clone();
    }

    @Override
    public String toString() {
        return "Spirit{" + "name: " + getName() + ", level: " + getLevel() + ", HP: " + getHP() + ", damage value: " + getDamageValue() + ", defense value: " + getDefenseValue() + ", dodge chance: " + getDodgeChance() + "}";
    }
}
