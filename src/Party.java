import java.util.ArrayList;
import java.util.List;

/**
 * party object
 */
public class Party {
    private int i = 0;
    private int j = 0;
    private List<Hero> party = new ArrayList<>();

    public Party() {

    }

    public void addHero(Hero hero) {
        party.add(hero);
    }

    public List<Hero> getHeros() {
        return party;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
