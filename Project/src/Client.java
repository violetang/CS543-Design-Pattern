import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public String name;
    public int id;
    private Company c;
    private Employee e;
    private Manager m;
    private CEO ceo;
    private int budget;
    private String choice;
    private int index;
    private int number;
    public int totalProfit;
    private int totalIncome;
    int cost = 0;

    //Scanner reader = new Scanner(System.in);
    public Client(Company c, Employee e) {
        this.c = c;
        this.e = e;
    }

    public Manager chooseDevelopManager(Scanner s) {
        System.out.println("Let's choose your developing manager: ");
        CTO cto = new CTO("John", 4);
        Manager m1 = new Manager("Ted", 5);
        Manager m2 = new Manager("Bob", 6);
        Manager m3 = new Manager("Devid", 7);
        System.out.println("1. " + m1.getName());
        System.out.println("2. " + m2.getName());
        System.out.println("3. " + m3.getName());
        index = s.nextInt();
        Manager m = null;
        switch (index) {
            case 1:
                m = m1;
            case 2:
                m = m2;
            case 3:
                m = m3;
        }
        System.out.println("You choose manager " + m.getName());
        return m;
    }

    public void provideBudget(Scanner s) {
        budget = s.nextInt();
        if (budget >= 3000000) {
            System.out.println("Suggestion: Plan A");
        } else if (budget < 3000000 && budget >= 2000000) {
            System.out.println("Suggestion: Plan B");
        } else if (budget < 2000000 && budget >= 1000000) {
            System.out.println("Suggetsion: Plan C");
        } else if (budget >= 750000) {
            System.out.println("Suggetsion: Plan C, but need to ask my manager");
        } else {
            System.out.println("Sorry, your budget is not enough, please enter again");
            provideBudget(s);
        }
    }

    public void selectPlan(Scanner s) {
        choice = s.next();

        if ("A".equals(choice) || "a".equals(choice)) {
            System.out.println("Consumer choose Plan A");
            cost = 1000000;
        } else if ("B".equals(choice) || "b".equals(choice)) {
            System.out.println("Consumer choose Plan B");
            cost = 500000;
        } else if ("C".equals(choice) || "c".equals(choice)) {
            System.out.println("Consumer choose Plan C");
            cost = 300000;
        } else {
            System.out.println("Sorry, we don't have this plan");
        }
        decision(budget, choice);

    }

    public void decision(int budget, String c) {
        if (e.decision(budget, choice)) {
            Manager m = this.chooseDevelopManager(new Scanner(System.in));
            int profit = budget - cost;
            totalIncome = totalIncome + budget;
            totalProfit = totalProfit + profit;
            number++;
            m.assginTask();
            done();
            report();
        }
        /*if (budget >= 3000000 && ("A".equals(choice) || "a".equals(choice))) {
         System.out.println("Accept your offer, let's discuss details");
         } else if (budget < 3000000 && budget >= 2000000
         && ("A".equals(choice) || "a".equals(choice))) {
         System.out.println("Your budget is not enough, asking supervisor");
         e.decision(budget,choice);
         } else if (budget < 3000000 && budget >= 2000000
         && ("B".equals(choice) || "b".equals(choice))) {
         System.out.println("Accept your offer, let's discuss details");
         } else if (budget < 2000000 && budget >= 1000000
         && ("B".equals(choice) || "b".equals(choice))) {
         System.out.println("Your budget is not enough, asking supervisor");
         e.decision(budget,choice);
         } else if (budget < 2000000 && budget >= 1000000
         && ("C".equals(choice) || "c".equals(choice))) {
         System.out.println("Accept your offer, let's discuss details");
         } else if (budget < 1000000 && ("B".equals(choice) || "b".equals(choice))) {
         System.out.println("Your budget is not enough, asking supervisor");
         e.decision(budget,choice);
         }*/
    }

    public void done() {
        if ("A".equals(choice) || "a".equals(choice)) {
            System.out.println("\nDeveloping for 4 months");
        } else if ("B".equals(choice) || "b".equals(choice)) {
            System.out.println("\nDeveloping for 3 months");
        } else if ("C".equals(choice) || "c".equals(choice)) {
            System.out.println("\nDeveloping for 2 months");
        }
        System.out.println("The project is done \n");
    }

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

    }
}
