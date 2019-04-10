import java.util.ArrayList;

public class Worker implements Employee{

    private String name;
    public Employee supervisor;


    public Worker(String n, Employee s){
        name = n;
        supervisor = s;
    }

    public String getName() {
        return name;
    }

    @Override
    public void seeDanger(){
        //report to supervisor or leaders
        System.out.println("\n"+getName()+ ": See Danger! Report to my supervisor -> " + supervisor.getName());
        supervisor.seeDanger();
    }

    @Override
    public void evacuate(){

        System.out.println("The employee(Worker) "+name+" is evacuating. ");
    }

    public void fixIt(){
        System.out.println("The employee(Worker) "+name+" is fixing it. ");
    }
}
