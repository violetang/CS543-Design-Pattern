//package company;

import java.util.Stack;

/**
 * abstract Employee class to define a general employee
 *
 * @author Jiali Tang and Runyu Xu
 */
public abstract class Employee extends People {

    //variable field

    private int performanceScale; //the performanceScale of an employee
    private int salary; // the salary of an employee
    private Stack<String> announces; // the stack to store announcements  
    private int ID; // the ID of an employee
    private Company c; // the company that employee works for

    //constructor
    public Employee(String n, int p, int ID, Company c, int salary) {
        super(n, p);
        this.ID = ID;
        this.c = c;
        this.salary = salary;
        announces = new Stack<>();
    }

    //method to set and get salary

    public void setSalary(int sal) {
        this.salary = sal;
    }

    public int getSalary() {
        return salary;
    }

    //method to set and get performance scale
    public void setPerformanceScale(int grade) {
        performanceScale = grade;
    }

    public int getPerformanceScale() {
        return performanceScale;
    }

    //method to store and get announcements
    public void storeAnnouncement(String news) {
        announces.add(news);
    }

    public Stack<String> getAnnoucements() {
        return announces;
    }

    //method to get ID
    public int getID() {
        return ID;
    }

    //method to get the company
    public void changeCompany(Company c){
        this.c = c;
    }
    public String getCompany() {
        return c.getName();
    }

    //abstract method to reply an announcement
    public abstract String replyToAnnouncement();

    //toString return a string of employee's info
    @Override
    public String toString() {
        return "[" + getName() + ", ID: " + getID() + ", phone: "
                + getPhone() + ", Salary: " + getSalary()
                + ", Company: " + getCompany() + "]";
    }
}