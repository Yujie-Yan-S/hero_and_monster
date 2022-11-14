/**
 * warrior strategy
 */
public class WarriorStrategy implements UpgradeStrategy {
    @Override
    public void upgrade(Hero hero) {
        hero.setDamageValue((int) (hero.getDamageValue() * Math.pow(1.1, hero.getLevel()) - 1));
        hero.setDexterityValue((int) (hero.getDexterityValue() * Math.pow(1.05, hero.getLevel()) - 1));
        hero.setDodgeChance((int) (hero.getDodgeChance() * Math.pow(1.1, hero.getLevel()) - 1));

    }
}
