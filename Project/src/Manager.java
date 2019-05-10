import java.util.ArrayList;


/**
 *
 * @author jayxu
 */
public class Manager extends Employee {

    private double salary;
    private double performance;
    private ArrayList<Worker> team;
    private Manager colleague;
    private Leader l;
    private int charge;

    public Manager(String name, int ID) {
        super(name, ID);
    }

    public void setSalary(double salary) {
        this.salary = salary;

    }

    public void addWorker(Worker w) {
        team.add(w);
        w.setSupervisor(this);
    }

    public void removeWorker(Worker w) {
        if (team.contains(w)) {
            team.remove(w);
        }
    }

    public void setSupervisor(Leader l) {
        this.l = l;
        //this.l.addManager(this);
    }

    public Leader getSupervisor() {
        return this.l;
    }

    public void delegation(Manager m) {
        this.colleague = m;
    }

    public ArrayList<Worker> getTeam() {
        return this.team;
    }

    public void assignTask(Case c) {

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
        
        if (profit >= (charge - cost) * 0.8) {
            System.out.println("Manager accepts your offer, let's discuss details");
            return true;
        } else {
            System.out.println("Your budget is not enough, asking our leader");
            return l.decision(budget, choice);
        }
    }
    
    public void assginTask(){
        System.out.println("Manager " + this.getName() + " assgins task to team memebers." );
        System.out.println("Employee Lucky, John, Web are working on System design");
        System.out.println("Employee Bob, Ann,Ted, Luice are working on Development");
        System.out.println("Employee Jay, Martine are working on Test");
    }

}
