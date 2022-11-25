import java.util.*;

/**
 * generate monster with given level and name
 */
public class MonsterFactory {
    private int tag=1;
    /**
     * list of monsters
     */
    private static List<Monster> list = new ArrayList<>();

    /**
     * key is the level and list is monsters in this level
     */
    private static Map<Integer, List<Monster>> map = new HashMap<>();
    private static Random random;

    /**
     * load the monster of files into the list and created monster list with level
     */
    static {
        generateMonsterList();
        random = new Random();
        generateMap();
    }

    private static void generateMonsterList() {
        List<List<String>> data = FileParser.parseFile("resource/Dragons.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            list.add(new Dragon(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4))));
        }
        data = FileParser.parseFile("resource/Exoskeletons.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            list.add(new Exoskeleton(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4))));
        }
        data = FileParser.parseFile("resource/Spirits.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            list.add(new Spirit(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4))));
        }
    }

    private static void generateMap() {
        for (int i = 0; i < list.size(); i++) {
            Monster monster = list.get(i);
            if (map.containsKey(monster.getLevel())) {
                int level = monster.getLevel();
                map.get(level).add(monster);
            } else {
                int level = monster.getLevel();
                ArrayList<Monster> monsters = new ArrayList<>();
                monsters.add(monster);
                map.put(level, monsters);
            }
        }
    }

    /**
     * get a monster
     *
     * @return random monster
     */
    public Monster getMonster() throws CloneNotSupportedException {
        Monster clone = list.get(getRandomIndex(list.size())).clone();
        clone.setTag("M"+tag++);
        return clone;
    }


    /**
     * generate one monster
     *
     * @param level
     * @return
     * @throws CloneNotSupportedException
     */
    public Monster getMonster(int level) throws CloneNotSupportedException {
        if (!map.containsKey(level)) {
            getMonster(10);
        }
        List<Monster> monsters = map.get(level);
        Monster clone = monsters.get(getRandomIndex(monsters.size())).clone();
        clone.setTag("M"+tag++);
        return clone;
    }

    public List<Monster> generateMonsterList(int number, int level) {
        List<Monster> monsters = new ArrayList<>();
        try {
            for (int j = 0; j < number; j++) {
                monsters.add(getMonster(level));
            }
        } catch (Exception e) {
            System.out.println("Exception in generateMonsterList in monster factory.");
        }
        return monsters;

    }

    /**
     * get random index in the monster sample
     *
     * @return a random index of monster list
     */
    private int getRandomIndex(int size) {
        return random.nextInt(size);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        MonsterFactory monsterFactory = new MonsterFactory();
        monsterFactory.getMonster(11);


    }
}
