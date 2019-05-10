import java.util.ArrayList;

public class Department {

    private String name;
    private ArrayList<Manager> managers;

    public Department(String name) {
        this.name = name;
    }

    public void addManager(Manager m) {
        this.managers.add(m);
    }

    public void addWorker(Worker w, Manager m) {
        if (this.managers.contains(m)) {
            m.addWorker(w);
        }
    }
    public void setTask(Case c){
        
    }
    
}
