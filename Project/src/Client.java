import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public String name;
    private int budget;
    private int plan;

    //Scanner reader = new Scanner(System.in);
    //todo: int plan ==> Plan plan
    public Client(String n, int b, int choice) {
        name = n;
        budget = b;
        plan = choice;
    }

    //client sign on the contract
    public boolean sign(int n){
        if(n == 1) return true;
        return false;
    }

    public int getBudget(){ return budget;}
    public int getPlan(){ return plan;}
    public int changeBudeget(int newB){ budget = newB; }


    /*
    public void report() {
        System.out.println("********************************");
        System.out.println("Total number of Projects have done " + number);
        System.out.println("Total income is " + totalIncome);
        System.out.println("Total profit is " + totalProfit);
        Double rate = Double.valueOf(totalProfit)/Double.valueOf(totalIncome) * 100;
        System.out.printf("Total profit rate %.2f",rate);
        System.out.println("%\n********************************");
    }

    public void printMenu() {
        System.out.println("Welcome to Company " + c.getName());
        System.out.println("Marketing advisor " + e.getName() + " will serve for you");
        System.out.println("Our company provides following plans: ");
        System.out.println("********************************");
        System.out.println("Plan A: $ 3 million \n"
                + "Including: \nConsulting " + "\nSystem design (2 versions)"
                + "\nDevelopment (5 versions)" + "\nTest" + "\nMaintain (12 months)");
        System.out.println("********************************");
        System.out.println("Plan B: $ 2 million \n"
                + "Including: \nConsulting " + "\nSystem design"
                + "\nDevelopment (3 versions)" + "\nTest" + "\nMaintain (6 months)");
        System.out.println("********************************");
        System.out.println("Plan C: $ 1 million \n"
                + "Including: \nConsulting " + "\nSystem design"
                + "\nDevelopment (1 version)" + "\nTest");
        System.out.println("********************************");
        System.out.println("Additional function: $ 10 k per each");
        System.out.println("********************************");

    }*/
}
