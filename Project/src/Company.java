import java.util.ArrayList;

public class Company {
    private String name;
    private String address;
    private double stockPrice;
    private CaseDatabase caseDatabases;
    private ArrayList<EmployeeIF> staffs;

    public Company(String name, String address){
        this.name = name;
        this.address = address;
        caseDatabases = new CaseDatabase();
        staffs = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void addEmployee(EmployeeIF e){
        staffs.add(e);
    }

    public ArrayList<EmployeeIF> getEmployee(){
        return staffs;
    }

    /*
    Here is using Abstract Factory
    In the future, the company may add more business and more service
    then can add more service here.

    eg.
    public enum ServiceType {
      App, video ...
    }

    how to use in main:
    Company techCom = new Company();
    planIF a = techCom.createService('A');
    planIF b = techCom.createService('B');
    planIF c = techCom.createService('C');
     */
    public static class BusinessMaker{

        public static ServiceFatory createService(){
            //if there more service type,then use switch to create different object, by the input type.
            return new AppDevelopment();
        }
    }

    public PlanIF createService(char c){
       return BusinessMaker.createService().createPlan(c);
    }


}
