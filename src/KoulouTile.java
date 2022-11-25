public class KoulouTile extends CommonTile {
    private double increasedValue=0;
    @Override
    public String print() {
        return Utils.getRedKoulouString("    ");
    }

    @Override
    public String print(String characterIdentifier) {
        return Utils.getRedKoulouString(characterIdentifier);
    }

    @Override
    public void activate(Hero hero) {
        System.out.println("activate koulou called");

        hero.setBattleStrength((int) (hero.getBattleStrength()+(increasedValue=hero.getBattleStrength()*0.1)));
    }

    @Override
    public void deactivate(Hero hero) {
        System.out.println("deactivate koulou called");

        hero.setBattleStrength((int) (hero.getBattleStrength()-increasedValue));
    }
}
