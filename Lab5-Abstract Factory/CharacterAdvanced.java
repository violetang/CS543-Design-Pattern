package game;
/**
 * CharacterAdvanced implements CharacterIF to create a character under advanced
 * model
 *
 * @Group: 7
 */
public class CharacterAdvanced implements CharacterIF {

    String name;
    
    @Override
    public void addCharacter(String c) {
        this.name = c;
    }

    @Override
    public String getCharacter() {
        return "The character is " + this.name;
    }
    
}
