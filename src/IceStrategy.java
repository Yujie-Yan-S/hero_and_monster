/**
 * ice strategy for ice spell
 */
public class IceStrategy implements SpellStrategy {

    @Override
    public void cast(Character character, double affectRatio) {
        int damageValue = character.getDamageValue();
        character.setDamageValue((int) (damageValue * (1 - affectRatio)));
    }
}
