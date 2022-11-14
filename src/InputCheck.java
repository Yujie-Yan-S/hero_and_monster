import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * class to do the input checking
 */
public class InputCheck {
    private static InputCheck inputCheck = null;

    private InputCheck() {
    }

    public static InputCheck getInstance() {
        if (inputCheck == null) {
            inputCheck = new InputCheck();
        }
        return inputCheck;
    }

    private static Scanner s = new Scanner(System.in);

    public int getBoardSeed() {
        String input;

        while (true) {
            try {
                System.out.print("Enter a seed to create a board (or enter nothing to create random board): ");
                input = s.nextLine();
                if (input.isEmpty()) {
                    input = "0";
                }
                Integer.parseInt(input);
                break;
            } catch (Exception e) {
                System.out.println("Not a valid seed.");
            }
        }
        return Integer.parseInt(input);
    }

    public int getPartyNum() {

        int input;
        while (true) {
            try {
                System.out.print("Enter number of player from 1-3: ");
                input = s.nextInt();
                if (input <= 3 && input >= 1) {
                    s.nextLine();
                    return input;
                }
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Invalid number of players.");
            }
        }
    }

    /**
     * prompt to choose the hero
     *
     * @param heroSize
     * @return
     */
    public int getHeroIndex(int heroSize) {
        int index;
        while (true) {
            try {
                System.out.print("Enter your choice from 1 to " + heroSize + ": ");
                int i = s.nextInt();
                if (i >= 1 && i <= heroSize) {
                    s.nextLine();
                    return i;
                } else {
                    System.out.println("The index is not in the range.");
                }

            } catch (Exception e) {
                s.nextLine();
                System.out.println("Not valid hero index.");
            }
        }
    }

    /**
     * get the control input
     *
     * @return
     */
    public String getControlInput() {
        String input = null;
        while (true) {
            try {
                System.out.println("• W/w: move up\n" +
                        "• A/a: move left\n" +
                        "• S/s: move down\n" +
                        "• D/d: move right\n" +
                        "• Q/q: quit game\n" +
                        "• I/i: show information\n" +
                        "• M/m: enter market\n" +
                        "• K/k: show map\n" +
                        "• B/b: show inventory");
                input = s.nextLine();
                if (Pattern.matches("^[w|W|A|a|S|s|D|d|q|Q|i|I|m|M|k|KB|b]$", input)) {
                    return input;
                } else {
                    System.out.println("Input control not valid");
                }
            } catch (Exception e) {
                System.out.println("Exception in controll input in input check");
            }
        }
    }

    /**
     * choose the item in the bag
     *
     * @param num
     * @return
     */
    public int getUseItemIndex(int num) {
        int input;
        while (true) {
            try {
                System.out.print("Enter the index you want to use 0 to quit the bag: ");
                input = s.nextInt();
                if (input >= 0 && input <= num) {
                    s.nextLine();
                    return input;
                } else {
                    System.out.println("Index not in range.");
                }
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Exception in getItemIndex.");
            }

        }

    }

    /**
     * choose the item want to buy
     *
     * @param num
     * @return
     */
    public int getItemIndex(int num) {
        int input;
        while (true) {
            try {
                System.out.print("Enter the index you want to buy or 0 to quit.");
                input = s.nextInt();
                if (input >= 0 && input <= num) {
                    s.nextLine();
                    return input;
                } else {
                    System.out.println("Index not in range.");
                }
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Exception in getItemIndex.");
            }

        }

    }

    /**
     * choose the item want to sell
     *
     * @param num
     * @return
     */
    public int getHeroItemIndex(int num) {
        int input;
        while (true) {
            try {

                System.out.print("Enter the index you want to sell or 0 to quit.");
                input = s.nextInt();
                if (input >= 0 && input <= num) {
                    s.nextLine();
                    return input;
                } else {
                    System.out.println("Index not in range.");
                }
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Exception in getItemIndex.");
            }

        }

    }

    /**
     * get hero action in the battle
     *
     * @return
     */
    public String getHeroAction() {
        String input;

        while (true) {
            System.out.print("\na/A to attack\n" +
                    "u/U to use item in bag\n" +
                    "i/I to list \n" +
                    "q/Q to quit the game" +
                    "Enter your input: ");
            input = s.nextLine();
            if (input.equalsIgnoreCase("u") || input.equalsIgnoreCase("a") || input.equalsIgnoreCase("i") || input.equalsIgnoreCase("q")) {
                return input;
            } else {
                System.out.println("Not valid action.");
            }
        }
    }

    /**
     * choose the target want to attack
     *
     * @param size
     * @return
     */
    public int getTarget(int size) {
        int input;
        while (true) {
            try {
                System.out.print("Enter the target you want to attack: ");
                input = s.nextInt();
                if (input >= 1 && input <= size) {
                    s.nextLine();
                    return input;
                } else {
                    System.out.println("Index not in range.");
                }
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Exception in getTarget.");
            }

        }
    }
}
