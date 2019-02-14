package company;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Employee {

    private List<Task> jobs;
    private boolean workStatus;
    private Worker w;
    private List<Worker> colleagues;
    private Manager m;

    Worker(String n, int p, int ID, Company c, int s) {
        super(n, p, ID, c, s);
        jobs = new ArrayList<>();
        workStatus = false;
        colleagues = new ArrayList<>();
    }

    //add task i
    public void addJobs(Task i) {
        System.out.println(getName() + "Tasks "+ i.returnId());
        jobs.add(i);
    }

    /**
     * Des: printout what job was working on and change it's status to 1
     */
    public void work() {
        for (Task t : jobs) {
            System.out.println(t.returnId());
            t.setStatus(1); //1 means working on
        } 
        delegateWork();
    }
    
    /**
     * Des: printout what job was working on and change it's status to 1
     */
    public void delegateWork(){
            if(getColleagues().contains(w)){
            System.out.println(w.getName()+" is on vacation, "+
                    getName() + " will do his/her jobs");
            w.work();
        }
    }

    //add a colleague
    public void addColleague(Worker w) {
        if (getSuperior().equals(w.getSuperior())) {
            colleagues.add(w);
        }
    }

    //initialize colleagues
    public void initialColleagues(List<Worker> ws) {
        colleagues = ws;
    }

    //return colleagues list
    public List<Worker> getColleagues(){
        return this.colleagues;
    }

    //remove a worker from colleague
    public void deleteColleague(Worker w) {
        colleagues.remove(w);
    }

    //set superior 
    public void setSuperior(Manager m) {
        System.out.println(getName() + " boss " + m.getName());
        this.m = m;
    }

    //get superior
    public Manager getSuperior() {
        return m;
    }

    //delegate job to another worker
    public void setDelegateBy(Worker w) {
        if (getSuperior().getMyWorkers().contains(w)) {
            if (getColleagues().contains(w) && w.isOnVacation()) { 
                this.w = w;              
            }
        }
    }

    //set the worker on vacation
    public void setVacation() {
        workStatus = true;
    }

    //return workStation
    public boolean isOnVacation() {
        return workStatus;
    }

    //set a jobs was done, change jobs' status to 2.
    public void getTaskDone(Task t) {
        for (Task i : jobs) {
            if (i.equals(t)) {
                i.setStatus(2);
            }
        }
    }

    //set all jobs were done
    public void getTasksDone() {
        for (Task t : jobs) {
            t.setStatus(2);
        }
    }

    //reply to the owner
    @Override
    public String replyToAnnouncement() {
        if (isOnVacation()) {
            return getName() + " is on vacation";
        }
        return getName() + " get your message";
    }
}