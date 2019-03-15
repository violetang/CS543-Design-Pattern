public class Character extends AbtractNovelElement {

    private String string;

    public Character(String s){
        string = s;
    }

    @Override
    public int getCharLength() {
        return string.length();
    }

}
