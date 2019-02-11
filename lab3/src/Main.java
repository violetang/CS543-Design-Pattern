public class Main {

    public static void main(String[] args) {

        //initialize company, owner, managers, workers
        Company company = new Company("ABCCO","CSUSM, San Marcos, CA, 92069");
        Owner owner = new Owner("Graig",0000);
        Manager John = new Manager("John", 1234);
        Manager Mary = new Manager("Mary", 2345);
        Worker Jack = new Worker("Jack", 3456);
        Worker Katie = new Worker("Katie", 4567);
        Worker Amy = new Worker("Amy", 5678);
        Worker Jim = new Worker("Jim", 6789);
        Worker Greg = new Worker("Greg", 7890);

        //build the company with owner, employee
        company.setOwner(owner);
        company.addEmployee(John);
        company.addEmployee(Mary);
        company.addEmployee(Jack);
        company.addEmployee(Jim);
        company.addEmployee(Katie);
        company.addEmployee(Amy);
        company.addEmployee(Greg);

        //assign workers to managers
        John.addWorkers(Jack);
        John.addWorkers(Jim);
        Mary.addWorkers(Katie);
        Mary.addWorkers(Amy);
        Mary.addWorkers(Greg);

        //owner announce news to all employee
        owner.announceNews("Good Job\n");

        //Create a Project, assign a manager John to it
        owner.announceNews("New Project STAR WAR \ns");
        Project starWar = new Project(1, "Star War");
        owner.startProject(starWar, John);

        //John set tasks for the projects and assign tasks to his workers;
        John.setTasksforProject(starWar);
        John.assignTask(starWar.getTasks().get(0), John.getMyWorkers().get(0));
        John.assignTask(starWar.getTasks().get(1), John.getMyWorkers().get(0));
        John.assignTask(starWar.getTasks().get(2), John.getMyWorkers().get(1));

        //Create a Project, assign a manager Mary to it
        owner.announceNews("New Project GOD FATHER \n");
        Project godFather = new Project(2, "God Father");
        owner.startProject(godFather,Mary);

        //Mary set tasks for the projects and assign tasks to his workers;
        Mary.setTasksforProject(godFather);
        Mary.assignTask(godFather.getTasks().get(0), Mary.getMyWorkers().get(0));
        Mary.assignTask(godFather.getTasks().get(1), Mary.getMyWorkers().get(1));
        Mary.assignTask(godFather.getTasks().get(2), Mary.getMyWorkers().get(2));

        //Amy on vocation, give job to Greg

        //call Greg.work(), both job.status changed

        //mary on vocation, let John increase Greg's salary












    }
}
