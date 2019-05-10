

import java.util.ArrayList;

public class Leader extends People {

    private ArrayList<Manager> managers;

    public Leader(String name, int ID) {
        super(name, ID);
    }

    public void addManager(Manager m) {
        managers.add(m);
    }

    public void removeManagers(Manager m) {
        managers.remove(m);
    }

    public ArrayList<Manager> getManager() {
        return this.managers;
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
        
        if (profit >= (charge - cost) * 0.3) {
            
            System.out.println("Accept your offer, let's discuss details");
            return true;
        } else {
             System.out.println("Sorry, your budget is not enough, we cannot accpet this offer");
            return false;
        }
    }

}
