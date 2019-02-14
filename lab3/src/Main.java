package company;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //initialize company, owner, managers, workers
        Company company = new Company("ABCCO", "CSUSM, San Marcos, CA, 92069");
        Company company2 = new Company("AA", "SAN");
        Owner owner = new Owner("Graig", 0000);
        Manager John = new Manager("John", 1234, 002, company, 10000);
        Manager Mary = new Manager("Mary", 2345, 003, company, 10000);
        Worker Jack = new Worker("Jack", 3456, 017, company, 5000);
        Worker Katie = new Worker("Katie", 4567, 012, company, 4000);
        Worker Amy = new Worker("Amy", 5678, 013, company, 4000);
        Worker Jim = new Worker("Jim", 6789, 014, company, 4000);
        Worker Greg = new Worker("Greg", 7890, 015, company, 4000);
        Worker Greg2 = new Worker("Greg2", 7890, 015, company, 4000);
        //build the company with owner, employee
        owner.addCompany(company);
        owner.addCompany(company2);
        company.addEmployee(John);
        company.addEmployee(Mary);
        company.addEmployee(Jack);
        company.addEmployee(Jim);
        company.addEmployee(Katie);
        company.addEmployee(Amy);
        company.addEmployee(Greg);

        owner.getCompany();
        owner.initialContacts(company.getEmployees());
        owner.addManager(Mary);
        owner.addManager(John);
        owner.getManagers();
        //assign workers to managers
        John.addWorkers(Jack);
        John.addWorkers(Jim);
        John.addColleague(Mary);
        Mary.addColleague(John);
        Mary.addWorkers(Katie);
        Mary.addWorkers(Amy);
        Mary.addWorkers(Greg);
        Amy.addColleague(Greg);
        Greg.addColleague(Amy);

        Mary.setVacation();
        John.setDelegateBy(Mary);

        John.updateSalary(Greg, 500);

        //Create a Project, assign a manager John to it
        owner.announceNews("New Project STAR WAR \n", company);
        Project starWar = new Project(1, "Star War");
        owner.startProject(starWar, John);

        //John set tasks for the projects and assign tasks to his workers;
        John.setTasksforProject(starWar);
        John.assignTask(starWar.getTasks().get(0), John.getMyWorkers().get(0));
        John.assignTask(starWar.getTasks().get(1), John.getMyWorkers().get(0));
        John.assignTask(starWar.getTasks().get(2), John.getMyWorkers().get(1));

        //Create a Project, assign a manager Mary to it
        owner.announceNews("New Project GOD FATHER \n", company);
        Project godFather = new Project(2, "God Father");
        owner.startProject(godFather, Mary);

        //Mary set tasks for the projects and assign tasks to his workers;
        Mary.setTasksforProject(godFather);
        Mary.assignTask(godFather.getTasks().get(0), Mary.getMyWorkers().get(0));
        Mary.assignTask(godFather.getTasks().get(1), Mary.getMyWorkers().get(1));
        Mary.assignTask(godFather.getTasks().get(2), Mary.getMyWorkers().get(2));

        
        
        //Amy on vocation, give job to Greg
        //call Greg.work(), both job.status changed
        //mary on vocation, let John increase Greg's salary
        Amy.setVacation();
        Greg.setDelegateBy(Amy);
        Greg.work();
        
    }
}