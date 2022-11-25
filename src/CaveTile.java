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
        System.out.println("activate cave called");
       hero.setBattleAgility((int) (hero.getBattleAgility()+ (increasedValue=hero.getDodgeChance()*0.1)));
    }

    @Override
    public void deactivate(Hero hero) {
        System.out.println("deactivate cave called");
        hero.setBattleAgility((int) (hero.getBattleAgility()-increasedValue));
    }
}
