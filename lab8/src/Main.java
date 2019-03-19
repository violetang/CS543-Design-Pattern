public class Main {

    public static void main(String[] args) {

        //Create the Novel;
        NovelElementIF book_one = new Novel("How to learn Java");
        String input = "Design an archive system to store novels." +
                " A novel can have many pages. Within a page, there can be several columns and frames. " +
                "A column can contain frames, so can a frame contain columns. " +
                "Moreover, multiple images may be seen in a column or frame. " +
                "A column is very likely to contain several lines of text, " +
                "which can be a combination of characters and images. " +
                "The Novel class and its entity classes provide methods to manipulate contents " +
                "such as set(), get(), remove(). " +
                "A UML class diagram is shown below that depicts many composition relationships. " +
                "Please re-design it into a hierarchical representation to improve quality.";

        //create all the elements for book_one
        NovelElementIF page_one = new Page("page_1");
        NovelElementIF page_two = new Page("page_2");
        NovelElementIF column_left_one = new Column("left_column");
        NovelElementIF column_right_one = new Column("right_column");
        NovelElementIF text = new LineOfText("LineOfText_1");
        NovelElementIF chara = new Character("lab8",input);

        //text has charaters
        ((LineOfText) text).addChild(chara);

        //column left has line of text
        ((Column) column_left_one).addChild(text);

        //page_one has two columns
        ((Page) page_one).addChild(column_left_one);
        ((Page) page_two).addChild(column_right_one);

        //book_one add two pages
        ((Novel) book_one).addChild(page_one);
        ((Novel) book_one).addChild(page_two);

        //how many elements book_one should have?

        //char Length of book_one;
        int len = book_one.getCharLength();
        System.out.println("book_one has char : " + len);

    }
}
