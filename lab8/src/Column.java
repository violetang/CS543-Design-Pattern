public class Column extends NovelCompositeElement {

    private String type = "Column";
    private String name;

    public Column(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

}
