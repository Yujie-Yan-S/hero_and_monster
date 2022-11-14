/**
 * implementing this interface require the class to be used
 */
public interface Usable {
    // item used by user and target is target
    boolean use(Character user, Character target);

    boolean use(Character user);

    // item unequipped by user
    Item unequipe(Character user);

}
