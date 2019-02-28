package game;
/**
 * CharacterIntermediate implements CharacterIF to create a character under 
 * Intermediate model
 * @Group: 7
 */
public class CharacterIntermediate implements CharacterIF {
    //name of this character,in further development may use a Character object
    //to define more attributes
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
