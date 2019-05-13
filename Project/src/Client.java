import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public String name;
    private int budget;
    private char plan;

    //Scanner reader = new Scanner(System.in);
    public Client(String n, int b, char choice) {
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
    public char getPlan(){ return plan;}
    public int changeBudeget(int newB){ return budget = newB; }



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

    */
}
