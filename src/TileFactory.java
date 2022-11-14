import java.util.Random;

/**
 * tile factory generate random tile with given probability
 */
public class TileFactory {
    private Random random;

    private double INACCESS_RATIO;
    private double MARKET_RATIO;
    private double COMMON_RATIO;

    private int numOfCommon = 0;
    private int numOfMarket = 0;

    public int getNumOfCommon() {
        return numOfCommon;
    }

    public int getNumOfMarket() {
        return numOfMarket;
    }

    public int getNumOfInaccessible() {
        return numOfInaccessible;
    }

    private int numOfInaccessible = 0;

    public TileFactory() {
    }

    public TileFactory(Random random, double inaccess, double market, double common) {
        this.random = random;
        COMMON_RATIO = common;
        INACCESS_RATIO = inaccess;
        MARKET_RATIO = market;
    }

    /**
     * get tile with specific type
     *
     * @param tileType
     * @return tile
     */
    public Tile getTile(String tileType) {
        if (tileType == null) {
            return null;
        }
        if (tileType.equalsIgnoreCase("common")) {
            numOfCommon++;
            return new CommonTile();
        } else if (tileType.equalsIgnoreCase("market")) {
            numOfMarket++;
            return new MarketTile();
        } else if (tileType.equalsIgnoreCase("inaccessible")) {
            numOfInaccessible++;
            return new InaccessibleTile();
        } else {
            return null;
        }
    }

    /**
     * return random tile with given probability
     *
     * @return tile
     */
    public Tile getTile() {
        double i = random.nextDouble();
        if (i <= INACCESS_RATIO) {
            numOfInaccessible++;
            return new InaccessibleTile();
        } else if (i <= INACCESS_RATIO + MARKET_RATIO) {
            numOfMarket++;
            return new MarketTile();
        } else {
            numOfCommon++;
            return new CommonTile();
        }
    }

    /**
     * get how many kinds of tiles are created
     *
     * @return String
     */
    public String getStatistics() {
        return "1. Number of Inaccessible tile " + numOfInaccessible + ".\n" + "2. Number of Common tile " + numOfCommon + ".\n" + "3. Number of Market tile " + numOfMarket + ".";
    }
}
