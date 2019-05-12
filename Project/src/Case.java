import java.util.ArrayList;

public class Case implements TaskIF {
    //businessCase
    public String caseName;
    public Client client;
    private State currentState;
    private PlanIF plan;
    private int budeget;
    private int grade;
    public ArrayList<Employee> team;

    public String returnClient(){
        return client.name;
    }

}
