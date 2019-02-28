package game;

/**
 * Main class to test this factory design pattern
 * This project is a simple demo that using abstract factory design pattern
 * As you see in the code, we just simply using String to represent character
 * and weapon. In further development, we may use character objects to give more
 * attributes of a character like name, hair, eye color,HP,MP,etc; using weapon 
 * object to give more attributes like Attack power, speed and so on.
 * @Group: 7
 */
public class Main {

    private CharacterIF character;
    private WeaponIF weapon;

    /**
     * createMode to create a mode with character name and weapon
     * @param mode -- the mode to build
     * @param name -- the character name
     * @param weapon -- the weapon
     */
    public void createMode(final ModeIF mode, final String name, final String weapon) {
        setCharacter(mode.createCharacter(), name);
        setWeapon(mode.createWeapon(), weapon);
    }

    public CharacterIF getCharacter() {
        return character;
    }

    public WeaponIF getWeapon() {
        return weapon;
    }

    public void setCharacter(final CharacterIF character, final String name) {
        this.character = character;
        character.addCharacter(name);
    }

    public void setWeapon(final WeaponIF weapon, final String weaponName) {
        this.weapon = weapon;
        weapon.addWeapon(weaponName);
    }

    public static void main(String[] args) {
        Main test = new Main();
        System.out.println("*****************************************");
        System.out.println("Beginner: ");
        test.createMode(FactoryMaker.makeFactory(FactoryMaker.ModeType.BEGINNER),
                "Jay", "Sword");
        System.out.println(test.getCharacter().getCharacter());
        System.out.println(test.getWeapon().getWeapon());
        System.out.println("*****************************************");
        System.out.println("Intermediate: ");
        test.createMode(FactoryMaker.makeFactory(FactoryMaker.ModeType.INTERMEDIATE),
                "Tang", "Bow");
        System.out.println(test.getCharacter().getCharacter());
        System.out.println(test.getWeapon().getWeapon());
        System.out.println("*****************************************");
        System.out.println("Advanced: ");
        test.createMode(FactoryMaker.makeFactory(FactoryMaker.ModeType.ADVANCED),
                "Jay", "Saber");
        System.out.println(test.getCharacter().getCharacter());
        System.out.println(test.getWeapon().getWeapon());
        System.out.println("*****************************************");
    }
}
