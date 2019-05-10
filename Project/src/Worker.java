import java.util.ArrayList;


public class Worker extends Employee {

    private Manager m;
    private Worker w;
    private Worker colleague;

    public Worker(String name, int ID) {
        super(name, ID);
    }

    public void setSupervisor(Manager m) {
        this.m = m;
    }

    public Manager getSupervisor() {
        return this.m;
    }

    public void setDelegate(Worker w) {
        this.w = w;
    }

    public void addTask(Case c) {

    }

    public boolean decision(int budget, String choice) {
        int cost = 0;
        int charge = 0;
        if(choice.equals("A") || choice.equals("a")){
                cost = 1000000;
                charge = 3000000;
        }
        if(choice.equals("B") || choice.equals("b")){
                cost = 500000;
                charge = 2000000;
        }
        if(choice.equals("C") || choice.equals("c")){
                cost = 300000;
                charge = 1000000;
        }
        int profit = budget - cost;
        
        if (profit >= charge - cost) {
            System.out.println("Accept your offer, let's discuss details");
            return true;
        } else {
            System.out.println("Your budget is not enough, asking manager");
            return m.decision(budget, choice);
        }
    }
}
