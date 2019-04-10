import java.util.ArrayList;

public class Leader implements Employee {

    private String name;
    private ArrayList<Employee> workers = new ArrayList<>();
    public Employee supervisor;

    public Leader(String n, Employee e){
        name = n;
        supervisor = e;
    }

    public String getName() {
        return name;
    }

    public void addPeople(Employee e){
        workers.add(e);
    }

    @Override
    public void seeDanger(){
        //announce all the members to perform fix
        System.out.println("\n"+getName() + ": Announce all my workers to fix it: ");
        for(int i = 0 ; i<workers.size(); i++){
            Worker temp = (Worker)workers.get(i);
            temp.fixIt();
        }

        //report to the manager
        System.out.println("Report to my Manager -> "+ supervisor.getName());
        supervisor.seeDanger();
    }

    @Override
    public void evacuate(){
        for(int i = 0 ; i < workers.size(); i++){
            Employee temp = workers.get(i);
            temp.evacuate();
        }

        System.out.println("The employee(Supervisor) "+name+" is evacuating. "+"\n");
    }


    public String getFeedback(){
        String feedback = "FeedBack from " + name;
        return feedback;
    }

}
