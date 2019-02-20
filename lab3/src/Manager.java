package company;

import java.util.ArrayList;
import java.util.List;

/**
 * Manager class extends Employee to define a general manager
 *
 * @author Jiali Tang and Runyu Xu
 */
public class Manager extends Employee {

    // variable field
    private List<Worker> myWorkers;// the workers under a manager
    private boolean workStatus; // the status of a manager
    private List<Project> projects; // the projects a manger has
    private Owner o; // the owner of the company
    private List<Manager> colleagues; // the colleagues of a manager
    private Manager m; // a manager that want to delegate

    //constructor
    public Manager(String n, int p, int ID, Company c, int s) {
        super(n, p, ID, c, s);
        myWorkers = new ArrayList<>();
        projects = new ArrayList<>();
        colleagues = new ArrayList<>();
        workStatus = false;
    }

    //methods to add worker or remove worker
    public void addWorkers(Worker e) {
        myWorkers.add(e);
        e.setSuperior(this);
    }

    public void addWorkers(List<Worker> w) {
        this.myWorkers = w;

    }

    public void removeWorker(Worker e) {
        myWorkers.remove(e);
    }

    public List<Worker> getMyWorkers() {
        return myWorkers;
    }

    //method to add, get or remove colleagues
    public void addColleague(Manager m) {
        colleagues.add(m);
    }

    public void addColleagues(List<Manager> m) {
        this.colleagues = m;
    }

    public void removeColleagues(Manager m) {
        colleagues.remove(m);
    }

    public List<Manager> getColleagues() {
        return colleagues;
    }

    //method to set and check work status of a manager
    public void setVacation() {
        workStatus = true;
    }

    public boolean isOnVacation() {
        return workStatus;
    }

    //method to set delegation from Manager m to current manager
    public void setDelegateBy(Manager m) {
        if (getColleagues().contains(m) && m.isOnVacation()) {
            this.m = m;
        }
    }

    //method to add project
    public void addProject(Project p) {
        projects.add(p);
    }

    //method to set tasks for a project
    public void setTasksforProject(Project a) {
        if (projects.contains(a)) {
            a.setProjectStatus(2); //2 - start to work on project
            Task t1 = new Task(1, "begin");
            Task t2 = new Task(2, "running");
            Task t3 = new Task(3, "test");
            a.addTasks(t1);
            a.addTasks(t2);
            a.addTasks(t3);
        }
    }

    //method to assign tasks to workers 
    public void assignTask(Task t, Worker e) {
        if (getMyWorkers().contains(e)) {
            e.addJobs(t);
        }
        delegateAssignTask(t, e);
    }

    public void delegateAssignTask(Task t, Worker e) {
        if (getColleagues().contains(m) && m.getMyWorkers().contains(e)) {
            System.out.print(m.getName() + " is on vacation, ");
            System.out.print(getName() + " assign task to " + e.getName());
            m.assignTask(t, e);
        }
    }

    public ArrayList<Task> collectCompletedTask() {
        ArrayList<Task> completedTasks = new ArrayList<>();
        for (int i = 0; i < projects.size(); i++) {
            for (int j = 0; j < projects.get(i).getTasks().size(); j++) {
                Task tmp = projects.get(i).getTasks().get(j);
                if (tmp.getStatus() == 2) {
                    completedTasks.add(tmp);
                }
            }
        }
        return completedTasks;
    }

    public void evaluateEmployeesPerformance(Worker w, int grade) {
        if (getMyWorkers().contains(w)) {
            w.setPerformanceScale(grade);
        }
        delegateEvaluate(w, grade);

    }

    public void delegateEvaluate(Worker w, int grade) {
        if (getColleagues().contains(m) && m.getMyWorkers().contains(w)) {
            System.out.print(m.getName() + " is on vacation, ");
            System.out.print(getName() + " evaluate " + w.getName());
            m.evaluateEmployeesPerformance(w, grade);
            System.out.println(" " + w.getPerformanceScale());
        }
    }

    public void updateSalary(Employee e, int increase) {
        //if this worker is in myWorkers list, update his/her salary
        if (getMyWorkers().contains(e)) {
            int curr = e.getSalary();
            System.out.println("the current salary for " + e.getName()
                    + "is " + e.getSalary());
            e.setSalary(curr + increase);
            System.out.println("the new salary for " + e.getName()
                    + "is " + e.getSalary());
        } 
        delegateUpdateSalary(e,increase);
    }

    public void delegateUpdateSalary(Employee e, int increase) {
     if (getColleagues().contains(m) && m.getMyWorkers().contains(e)) {
     System.out.print(m.getName() + " is on vacation, ");
     System.out.println(getName() + " update salary for " + e.getName());
     m.updateSalary(e, increase);
     }
     }
    //reply to the owner
    @Override
    public String replyToAnnouncement() {
        if (isOnVacation()) {
            return "Manager " + getName() + " is on vacation, ";
        }
        return "Manager " + getName() + " get your message";
    }
}