public class LightningStrategy implements SpellStrategy {

    @Override
    public void cast(Character character, double affectRatio) {
        int dodgeChance = character.getDodgeChance();
        character.setDodgeChance((int) (dodgeChance * (1 - affectRatio)));
    }
}
