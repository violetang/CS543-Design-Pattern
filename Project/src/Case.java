import java.util.ArrayList;

public class Case implements TaskIF {
    //businessCase
    public int id;
    public String client;
    private State currentState;
    private int budeget;
    private int cost;
    private int grade;
    public ArrayList<Employee> team;

    public String returnClient(){
        return client;
    }

}
