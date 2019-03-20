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
        ((Page) page_one).addChild(column_right_one);

        //book_one add two pages
        ((Novel) book_one).addChild(page_one);
        ((Novel) book_one).addChild(page_two);

        //char Length of book_one;
        int len = book_one.getCharLength();
        System.out.println(book_one.getType()+" : <<"+ book_one.getName()+">> has char : " + len);

        int count = book_one.getElementCount();
        System.out.println(book_one.getType()+" : <<"+ book_one.getName()+ ">> totally has " + count + " elements");

        System.out.println("including: ");
        book_one.displayChildren("");

        System.out.println("--------------------------------------------");
        NovelElementIF book_two = new Novel("How to learn C++");
        String input2 = "Who am I? Where am I from? Where I wanna go!";

        //create all the elements for book_one
        NovelElementIF page_a = new Page("Abstract");
        NovelElementIF page_b = new Page("Table of content");
        NovelElementIF column_one = new Column("aab");
        NovelElementIF column_two = new Column("bbc");
        NovelElementIF column_three = new Column("ccd");
        NovelElementIF column_four = new Column("dde");
        NovelElementIF frame_one = new Frame("front-end");
        NovelElementIF  line_one = new LineOfText("Head");
        NovelElementIF  line_two = new LineOfText("Head1.1");
        NovelElementIF  text1 = new Character("question",input2);

        ((LineOfText) line_one).addChild(text1);
        ((Frame) frame_one).addChild(line_one);
        ((Frame) frame_one).addChild(line_two);
        ((Frame) frame_one).addChild(column_four);

        ((Page) page_a).addChild(frame_one);

        ((Page) page_b).addChild(column_one);
        ((Page) page_b).addChild(column_two);
        ((Page) page_b).addChild(column_three);

        ((Novel) book_two).addChild(page_a);
        ((Novel) book_two).addChild(page_b);


        int count_2 = book_two.getElementCount();
        System.out.println(book_two.getType()+" : <<"+ book_two.getName()+ ">> totally has " + count_2 + " elements");

        System.out.println("including: ");
        book_two.displayChildren("");

    }
}
