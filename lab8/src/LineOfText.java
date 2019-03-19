public class LineOfText extends NovelCompositeElement {
    private String type = "LineOfText";
    private String name;

    public LineOfText(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }
}
