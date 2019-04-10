import java.util.ArrayList;

public class CEO implements Employee {

    private String name;
    private ArrayList<Employee> managers = new ArrayList<>();

    public CEO(String n){
        name = n;
    }

    public void addPeople(Employee e){
        managers.add(e);
    }

    public String getName() {
        return name;
    }

    @Override
    public void seeDanger(){
        //set up an meeting for all managers
        System.out.println("\n"+"CEO Meeting with Managers");

        //collect decisions from managers
        ArrayList<Decision> decisions = new ArrayList<>();

        for(int i = 0 ; i < managers.size(); i++){
            Manager tmp = (Manager)managers.get(i);
            for(Decision d : tmp.getSuggesions()){
                decisions.add(d);
                //maybe print out all the decision
            }
        }

        int size = decisions.size();
        Decision[] res = grand(decisions.toArray(new Decision[size]));

        System.out.println("Decisions granted from CEO: ");
        for(int j = 0 ;j < res.length ;j++){
            res[j].doIt();
            if(res[j].getDecision() == "evacute"){
                evacuate();
            }
        }


    }

    @Override
    public void evacuate(){

        System.out.println("Broadcast from CEO "+name+": everybody starts evacuating. "+"\n");

        for(int i = 0 ; i < managers.size(); i++){
            Employee temp = managers.get(i);
            temp.evacuate();
        }

        System.out.println("The employee(CEO) "+name+" is evacuating. ");
    }

    public Decision[] grand(Decision[] d){
        Decision[] finalDecision = new Decision[2];
        finalDecision[0] = d[1];
        finalDecision[1] = d[2];
        //maybe print out the granted decision
        return finalDecision;
    }
}
