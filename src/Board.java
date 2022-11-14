

import java.util.Random;

/**
 * class of world with two-dimensional array
 */
public class Board {
    private final int DEFAULT_SIZE = 8;
    private final double INACCESS_RATIO = 0.2;
    private final double MARKET_RATIO = 0.3;
    private final double COMMON_RATIO = 0.5;
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
     * initialize the board with the given seed and default board size and ratio of map
     */
    private void initializeWorld() {
        TileFactory tileFactory = new TileFactory(random, INACCESS_RATIO, MARKET_RATIO, COMMON_RATIO);
        board = new Tile[DEFAULT_SIZE][DEFAULT_SIZE];
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            for (int j = 0; j < DEFAULT_SIZE; j++) {
                board[i][j] = tileFactory.getTile();
            }
        }
        System.out.println(tileFactory.getStatistics());
    }

    /**
     * print the board with the player position
     *
     * @return String of board
     */
    public String printBoard(int r, int c) {
        String ANSI_RESET = "\u001B[0m";
        // Declaring the background color
        String ANSI_RED_TEXT
                = "\u001B[31m";
        String reuslt = "";
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            for (int j = 0; j < DEFAULT_SIZE; j++) {
                reuslt += "+---";
            }
            reuslt += "+\n";
            for (int j = 0; j < DEFAULT_SIZE; j++) {
                if (i == r && j == c) {
                    reuslt += "| " + ANSI_RED_TEXT + "T" + ANSI_RESET + " ";
                } else {
                    Tile tiles = board[i][j];
                    reuslt += "| " + tiles.print() + " ";
                }
            }
            reuslt += "|";
            reuslt += "\n";
        }
        for (int j = 0; j < DEFAULT_SIZE; j++) {
            reuslt += "+---";
        }
        reuslt += "+\n";
        reuslt += "You are in possition row " + r + " , column " + c;
        return reuslt;
    }

    /**
     * print the board without the player position
     *
     * @return String of board
     */
    public String printBoard() {
        String reuslt = "";
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            for (int j = 0; j < DEFAULT_SIZE; j++) {
                reuslt += "+---";
            }
            reuslt += "+\n";
            for (int j = 0; j < DEFAULT_SIZE; j++) {
                Tile tiles = board[i][j];
                reuslt += "| " + tiles.print() + " ";
            }
            reuslt += "|";
            reuslt += "\n";
        }
        for (int j = 0; j < DEFAULT_SIZE; j++) {
            reuslt += "+---";
        }
        reuslt += "+";
        return reuslt;
    }

    /**
     * @param i row value
     * @param j column value
     * @return tile
     */
    public Tile getTile(int i, int j) {
        return board[i][j];
    }

    public Market getMarket(int i, int j) {
        return ((MarketTile) (board[i][j])).getMarket();
    }


    public static void main(String[] args) {
        Board b = new Board();
        System.out.println(b.printBoard(3, 3));


    }


}
