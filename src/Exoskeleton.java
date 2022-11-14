/**
 * exoskeleton obejct
 */
public class Exoskeleton extends Monster implements Cloneable {
    public Exoskeleton(String name, int level, int damageValue, int defenseValue, int dodgeChance) {
        super(name, level, damageValue, defenseValue, dodgeChance);
    }

    public Exoskeleton clone() throws CloneNotSupportedException {
        return (Exoskeleton) super.clone();
    }

    @Override
    public String toString() {
        return "Exoskeleton{" + "name: " + getName() + ", level: " + getLevel() + ", HP: " + getHP() + ", damage value: " + getDamageValue() + ", defense value: " + getDefenseValue() + ", dodge chance: " + getDodgeChance() + "}";
    }
}
