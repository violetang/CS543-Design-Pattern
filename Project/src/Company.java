import java.util.ArrayList;

public class Company {
    private String name;
    private String address;
    private double stockPrice;
    private CaseDatabase caseDatabases;
    private ArrayList<People> staffs;
    
    public Company(String name, String address){
        this.name = name;
        this.address = address;
        caseDatabases = new CaseDatabase();
        staffs = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

}
