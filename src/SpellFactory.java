import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * generate random spell
 */
public class SpellFactory {
    private static SpellFactory spellFactory = null;

    private SpellFactory() {
    }

    public static SpellFactory getInstance() {
        if (spellFactory == null) {
            spellFactory = new SpellFactory();
        }

        return spellFactory;
    }

    private static List<Spell> list = new ArrayList<>();
    private static Random random = new Random();

    static {
        List<List<String>> data = FileParser.parseFile("resource/IceSpells.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            list.add(new Spell(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)), new IceStrategy()));
        }
        data = FileParser.parseFile("resource/FireSpells.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            list.add(new Spell(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)), new FireStrategy()));

        }
        data = FileParser.parseFile("resource/LightningSpells.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            list.add(new Spell(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)), new LightningStrategy()));
        }

    }

    /**
     * get a spell
     *
     * @return random spell
     */
    public Spell getSpell() throws CloneNotSupportedException {
        return list.get(getRandomIndex()).clone();
    }

    /**
     * get random index in the spell sample
     *
     * @return a random index of spell list
     */
    private int getRandomIndex() {
        return random.nextInt(list.size());
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SpellFactory spellFactory = new SpellFactory();


    }
}
