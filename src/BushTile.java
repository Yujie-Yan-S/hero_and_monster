public class BushTile extends CommonTile {
    @Override
    public void increaseAttribute(Hero hero) {

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
