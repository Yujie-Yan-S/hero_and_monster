

import java.util.Random;

/**
 * class of world with two-dimensional array
 */
public class Board {
    private final int DEFAULT_SIZE = 8;
    private final double PLAIN_RATIO = 0.4;
    private final double BUSH_RATIO = 0.2;
    private final double CAVE_RATIO = 0.2;
    private final double KOULOU_RATIO = 0.2;
    private final long seed = 1234;

    public int getDEFAULT_SIZE() {
        return DEFAULT_SIZE;
    }

    private final Random random;
    private Tile[][] board;

    public Board() {
        this.random = new Random(this.seed);
        initializeWorld();
    }

    /**
     * allow user to insert a seed to create different map
     *
     * @param seed
     */
    public Board(long seed) {
        this.random = new Random(seed);
        initializeWorld();
    }

    /**
     * initialize the map with the given seed and default board size and ratio of map
     */
    private void initializeWorld() {
        TileFactory tileFactory = new TileFactory(random, CAVE_RATIO, PLAIN_RATIO, BUSH_RATIO, KOULOU_RATIO);
        board = new Tile[DEFAULT_SIZE][DEFAULT_SIZE];
        // create the monster nexus row
        for (int i = 0; i < board.length; i++) {
            if (i != 2 && i != 5) {
                board[0][i] = new NexusTile(new RespawnMonster());
            } else {
                board[0][i] = new InaccessibleTile();
            }
        }
        // create the lane
        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j != 2 && j != 5) {
                    board[i][j] = tileFactory.getTile();
                } else {
                    board[i][j] = new InaccessibleTile();
                }
            }
        }
        //create the hero nexus
        for (int i = 0; i < board.length; i++) {
            if (i != 2 && i != 5) {
                board[board.length - 1][i] = new NexusTile(new RespawnHero());
            } else {
                board[board.length - 1][i] = new InaccessibleTile();
            }
        }

    }

    /**
     * print the board with the player position
     *
     * @return String of board
     */
    public String printBoard(CharacterBoardRelation cbr) {
        return null;
    }

    /**
     * print the board without the player position
     *
     * @return String of board
     */
    public String printBoard() {
        String result = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                result += board[i][j].print();
            }
            result += "\n";
        }
        return result;
    }

    /**
     * @param i row value
     * @param j column value
     * @return tile
     */
    public Tile getTile(int i, int j) {
        return board[i][j];
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.printBoard());
    }


}
