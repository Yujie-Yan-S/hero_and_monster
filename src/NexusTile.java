public class NexusTile extends MarketTile {



    private Position position;
    public NexusTile() {

    }

    @Override
    public String print() {
        return Utils.getBlueNexusString("    ");
    }

    @Override
    public String print(String characterIdentifier) {
        return Utils.getBlueNexusString(characterIdentifier);
    }


}
