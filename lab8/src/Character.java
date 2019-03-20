/**
 * Character.java
 */
public class Character extends AbtractNovelElement {

    private String string;
    private String name;
    private String type = "Character";

    public Character(String name,String s){
        this.name = name;
        string = s;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }


    @Override
    public int getCharLength() {
        return string.length();
    }

    public int getElementCount(){ return 0; }

    public void displayChildren(String x){ }

}
