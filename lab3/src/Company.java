import java.util.HashSet;

public class Company{
    private String name;
    private String address;
    private HashSet<Employee> employees;
    private Owner owner;

    Company(String n, String addr){
        name = n;
        address = addr;
        employees = new HashSet<>();
    }

    public Owner getOwner(){
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getAddr(){
        return address;
    }

    public String getName(){
        return name;
    }

    public void addEmployee(Employee e){
        employees.add(e);
    }

}