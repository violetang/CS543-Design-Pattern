import java.util.ArrayList;

public class Manager implements Employee {
    private String name;
    private ArrayList<Employee> leaders = new ArrayList<>();
    public Employee supervisor;
    public Decision[] suggestions;

    public Manager(String n, Employee e){
        name = n;
        supervisor = e;
    }

    public void addPeople(Employee e){
        leaders.add(e);
    }

    public String getName() {
        return name;
    }

    @Override
    public void seeDanger(){


        //getfeedback from all supervisors
        System.out.println("\n"+getName()+": Get feedback from all my supervisors: ");
        for(int i = 0 ; i < leaders.size(); i++){
            Leader temp = (Leader)leaders.get(i);
            System.out.println(temp.getFeedback());
        }

        //report to CEO
        System.out.println("Report to CEO");
        supervisor.seeDanger();
    }

    @Override
    public void evacuate(){
        for(int i = 0 ; i < leaders.size(); i++){
            Employee temp = leaders.get(i);
            temp.evacuate();
        }

        System.out.println("The employee(Manager) "+name+" is evacuating. "+"\n");
    }

    public Decision[] suggestDecision(String[] x){
        //create decisions
        ArrayList<Decision> des = new ArrayList<>();
        for(int i = 0 ; i < x.length ;i++){
            //System.out.println(x[i]);
            Decision temp = new Decision(x[i]);
            des.add(temp);

        }

        //return decisions
        int size = des.size();
        suggestions = des.toArray(new Decision[size]);
        return suggestions;
    }

    public Decision[] getSuggesions() {
        return suggestions;
    }
}
