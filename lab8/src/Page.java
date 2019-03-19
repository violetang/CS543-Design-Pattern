public class Page extends NovelCompositeElement {
    private String type = "Page";
    private String name;

    public Page(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }
}
