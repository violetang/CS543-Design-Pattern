package game;
/**
 * CharacterBeginner implements CharacterIF to create a character under Beginner
 * model
 * @Group: 7
 */
public class CharacterBeginner implements CharacterIF {
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
