/**
 * common tile object
 */
public class CommonTile implements Tile {
    @Override
    public String print() {
        return "    ";
    }

    @Override
    public String print(String characterIdentifier) {
        return characterIdentifier;
    }

    public void increaseAttribute(Hero hero) {

    }

}
