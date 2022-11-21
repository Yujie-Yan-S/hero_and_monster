public class Lane {
    private int x;
    private int y;

    public Lane(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getStartPosition() {
        return x + "," + y;
    }
}
