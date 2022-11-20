public class KoulouTile extends CommonTile {
    @Override
    public String print() {
        return Utils.getRedKoulouString("    ");
    }

    @Override
    public String print(String characterIdentifier) {
        return Utils.getRedKoulouString(characterIdentifier);
    }

    @Override
    public void increaseAttribute(Hero hero) {

    }
}
