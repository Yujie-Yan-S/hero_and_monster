public class CaveTile extends CommonTile {
    @Override
    public String print(String characterIdentifier) {
        return Utils.getGrayCaveString(characterIdentifier);
    }

    @Override
    public String print() {

        return Utils.getGrayCaveString("    ");
    }

    @Override
    public void increaseAttribute(Hero hero) {

    }
}
