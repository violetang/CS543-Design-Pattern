/**
 * Image.java
 */
public class Image extends AbtractNovelElement {
    private String name;
    private String type = "Image";

    public Image(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public int getCharLength(){
        return 1;
    }

    public int getElementCount(){ return 0; }

    public void displayChildren(String x){}
}
