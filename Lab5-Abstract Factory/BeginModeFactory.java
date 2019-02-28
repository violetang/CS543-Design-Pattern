package game;
/**
 * BeginModeFactory implements ModeIf to create a beginner factory
 * @Group: 7
 */
public class BeginModeFactory implements ModeIF {

    @Override
    public CharacterIF createCharacter() {
        String add = "New Beginner Character added";
        System.out.println(add);
        return new CharacterBeginner();
    }

    @Override
    public WeaponIF createWeapon() {
        String add = "New Beginner Weapon added";
        System.out.println(add);
        return new WeaponBeginner();
    }

}
