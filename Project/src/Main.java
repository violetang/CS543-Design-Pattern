
import static java.lang.System.exit;
import java.util.*;

public class Main {

    static Company b = new Company("ABC", "San marcos");
    static Worker e = new Worker("Man", 10);
    static Manager m = new Manager("TT", 2);
    static CEO ceo = new CEO("Mike", 1);

    static Scanner reader = new Scanner(System.in);
    private static Client c = new Client(b, e);

    public static void main(String[] args) {
        m.setSupervisor(ceo);
        e.setSupervisor(m);
        int count = 0;
        while (true) {
            count++;
            c.printMenu();
            System.out.println("Enter your budget (integer): ");
            c.provideBudget(reader);
            System.out.println("Enter your choice: ");
            c.selectPlan(reader);
            if(count >= 2){
                exit(1);
            }
        }
        //setCompany();
    }

    protected static void setCompany() {

        System.out.println(b.toString());
        CEO c = (CEO) new CEO("Mike", 1);
        Manager a = new Manager("John", 2);
        a.setSupervisor(c);
        a.getSupervisor();

    }
    //create the company
    //create the four department of the company
    //add the employment

    //create a client
    //company shows/print out our serveices: Plan A, Plan B, Plan C.
    //client show their choice
    //base on client's choice to create a task
    //start the task
    //6 months, employee performance evaluation
    //hr start to evaluate and print out the results.
}
