public class Controller {
    public void move(Hero hero, String command) {
        if (command.equalsIgnoreCase("w")) {
            //check valid move
            hero.setY(hero.getY() - 1);
        } else if (command.equalsIgnoreCase("s")) {
            hero.setY(hero.getY() + 1);

        } else if (command.equalsIgnoreCase("a")) {
            hero.setX(hero.getX() - 1);
        } else if (command.equalsIgnoreCase("d")) {
            hero.setX(hero.getX() + 1);

        }
    }
}
