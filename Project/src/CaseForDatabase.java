import java.util.ArrayList;

public class CaseForDatabase {
    private String CaseName;
    private Client client;
    private PlanIF plan;
    private int year;
    private int profit;
    private ArrayList<Manager> managers;
    private ArrayList<Worker> workers;

    //constructor
    public CaseForDatabase(String n, Client c, PlanIF p, int y, int pro, ArrayList<Manager> m, ArrayList<Worker> w){
        CaseName = n;
        client = c;
        plan = p;
        year = y;
        profit = pro;
        managers = m;
        workers = w;
    }

    public String getCaseName(){return CaseName;}
    public String getClient(){return client.name;}
    public String getPlan(){ return plan.getName();}
    public int getYear(){return year;};
    public int getProfit(){return profit;}


}
