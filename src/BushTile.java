public class BushTile extends CommonTile {
    private double increasedValue=0;
    @Override
    public void activate(Hero hero) {
        hero.setBattleDexterity((int) (hero.getBattleDexterity()+(increasedValue=hero.getDexterityValue()*0.1)));
    }


    @Override
    public void deactivate(Hero hero) {
        hero.setBattleDexterity((int) (hero.getBattleDexterity()-increasedValue));
    }


    @Override
    public String print() {
        return Utils.getGreenBushString("    ");
    }

    @Override
    public String print(String characterIdentifier) {
        return Utils.getGreenBushString(characterIdentifier);
    }

    public static void main(String[] args) {
        CommonTile commonTile = new BushTile();
        System.out.println(commonTile.print("M1111"));

    }
}
