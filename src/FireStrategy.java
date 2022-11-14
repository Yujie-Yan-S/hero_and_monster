/**
 * strategy for fire spell
 */
public class FireStrategy implements SpellStrategy {

    @Override
    public void cast(Character character, double affectRatio) {
        int defenseValue = character.getDefenseValue();
        character.setDefenseValue((int) (defenseValue * (1 - affectRatio)));
    }
}
