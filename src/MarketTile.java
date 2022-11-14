/**
 * market tile on the board
 */
public class MarketTile implements Tile {
    private Market market;

    public Market getMarket() {
        return market;
    }

    public MarketTile() {
        market = new Market();
    }

    @Override
    public String print() {
        return "M";
    }
}
