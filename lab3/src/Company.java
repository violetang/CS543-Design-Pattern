package company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Company class to define a company with some basic attributes
 *
 * @author Jiali Tang and Runyu Xu
 */
public class Company {

    //variable field

    private String name; // name of the company
    private String address; // address of the company
    private List<Employee> employees; // list of all employees in the company
    private Owner owner; // the boss of the company

    //Constructor to create a company 
    Company(String n, String addr) {
        name = n;
        address = addr;
        employees = new ArrayList<>();
    }
    
    //Method to set and get owner of the company
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public Owner getOwner() {
        return owner;
    }
    
    //method to get address of the company
    public String getAddr() {
        return address;
    }
    //method to get the name of the company
    public String getName() {
        return name;
    }
    
    //method to add new employee 
    public void addEmployee(Employee e) {
        employees.add(e);
    }
    //method to initial or redefine employee list
    public void initialEmployee(List<Employee> e){
        this.employees = e;
    }
    //method to get the employee list
    public List<Employee> getEmployees() {
       /* Comparator c = new Comparator<Employee>(){
            @Override
            public int compare(Employee e1, Employee e2) { 
                return e1.getID()-e2.getID();
            }
        };
        employees.sort(c);*/
        for (Employee e: employees) {
            System.out.println(e);
        }
        System.out.println();
        return employees;
    }
    //method to delete an employee
    public void deleteEmployee(Employee e){
        employees.remove(e);
    }
    
}