package game;
/**
 * IntermediateModeFactory implements ModeIf to create an intermediate factory
 * @Group: 7
 */
public class IntermediateModeFactory implements ModeIF {

    @Override
    public CharacterIF createCharacter() {
        String add = "New Intermediate Character added";
        System.out.println(add);
        return new CharacterIntermediate();
    }

    @Override
    public WeaponIF createWeapon() {
        String add = "New Intermediate weapon added";
        System.out.println(add);
        return new WeaponIntermediate();
    }


}
