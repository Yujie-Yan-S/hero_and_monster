public class CaveTile extends CommonTile {
    private double increasedValue=0;
    @Override
    public String print(String characterIdentifier) {
        return Utils.getGrayCaveString(characterIdentifier);
    }

    @Override
    public String print() {

        return Utils.getGrayCaveString("    ");
    }

    @Override
    public void activate(Hero hero) {
       hero.setBattleAgility((int) (hero.getBattleAgility()+ (increasedValue=hero.getDodgeChance()*0.1)));
    }

    @Override
    public void deactivate(Hero hero) {
        hero.setBattleAgility((int) (hero.getBattleAgility()-increasedValue));
    }
}
