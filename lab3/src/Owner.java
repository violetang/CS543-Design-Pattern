package company;

import java.util.ArrayList;
import java.util.List;

/**
 * Owner class to define an Owner of a company and relations with employees
 *
 * @author Jiali Tang and Runyu Xu
 */
public class Owner extends People {

    // variable field;
    private List<Company> companies; // the companys that owned by owner
    private List<Employee> contactList; // the contactList of all employees
    private List<Manager> managers; // the list of managers

    //constructor
    public Owner(String n, int p) {
        super(n, p);
        contactList = new ArrayList<>();
        managers = new ArrayList<>();
        companies = new ArrayList<>();
    }

    //method to add company to owner
    public void addCompany(Company c) {
        this.companies.add(c);
        c.setOwner(this);
    }

    //method to get owner's companies
    public List<Company> getCompany() {
        for (Company c : companies) {
            System.out.println("the owner of " + c.getName()
                    + " is " + c.getOwner().getName());
        }
        return companies;
    }

    //method to initial or overwrite contactList
    public void initialContacts(List<Employee> contacts) {
        this.contactList = contacts;
    }

    //add contacts to existing contactList 
    //Use case: contacts from another company
    public void addContacts(List<Employee> contacts) {
        contactList.addAll(contacts);
    }

    //method to add new employee into contactList
    public void addContacts(Employee e) {
        contactList.add(e);
    }

    //method to remove an employee from contact list
    public void deleteContact(Employee e) {
        contactList.remove(e);
    }

    //method to add new manager into manager list
    public void addManager(Manager m) {
        managers.add(m);
    }

    //method to initial or overrite manager list
    public void addManager(List<Manager> ms) {
        this.managers = ms;
    }
    
    //method to remove a manager
    public void deleteManager(Manager m) {
        contactList.remove(m);
    }

    //method to get managers
    public List<Manager> getManagers() {
        System.out.print("Managers under boss " + getName()+": ");
        for (Manager m: managers){
            System.out.print(m.getName() + ",");
        }
        System.out.println();
        return managers;
    }

    //owner start a project and set it's status to 1
    public void startProject(Project x, Manager y) {
        x.setProjectStatus(1);
        y.addProject(x);
    }

    //owner evaluates manager's performance
    public void evaluateManagersPerformance(Manager a, int b) {
        a.setPerformanceScale(b);
    }

    //renew salary for a manager
    public void updateSalary(Manager m, int inc) {
        int curr = m.getSalary();
        m.setSalary(curr + inc);
    }

    //owner announces something and gets response from each employee 
    //in a company
    public void announceNews(String news, Company c) {
        System.out.println(news);
        for (Employee e : contactList) {
            if (e.getCompany().equals(c.getName())) {
                e.storeAnnouncement(news);
                System.out.println(e.replyToAnnouncement());
            }
        }
    }

}