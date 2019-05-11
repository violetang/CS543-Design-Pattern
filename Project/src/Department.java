import java.util.ArrayList;

public class Department {

    private String name;
    private Leader leader;
    private ArrayList<Manager> managers;
    private ArrayList<Worker> workers;

    public Department(String name, Leader lead) {
        this.leader = lead;
        this.name = name;
        managers = new ArrayList<>();
        workers = new ArrayList<>();
    }

    //add a manager to this team
    public void addManager(Manager m) {
        this.managers.add(m);
    }

    //add a worker to this team, also assign the worker to a manager
    public void addWorker(Worker w, Manager m) {
        if (this.managers.contains(m)) {
            m.addWorker(w);
            workers.add(w);
        }
    }

    //get who's leader
    public Leader getLeader(){
        return leader;
    }

    //get department name
    public String returnDepartmentName(){
        return name;
    }

    public ArrayList<Manager> getManagers(){
        return managers;
    }

    public ArrayList<Worker> getWorkers(){
        return workers;
    }

    /*
    public void setTask(Case c){
        
    }
    */
    
}
