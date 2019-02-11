import java.util.ArrayList;

class Worker extends Employee{
    private ArrayList<Task> jobs;
    private boolean workStatus;

    Worker(String n, int p){
        super(n,p);
        jobs = new ArrayList<>();
        workStatus = false;
    }

    public void addJobs(Task i){
        jobs.add(i);
    }

    public void work(){
        for(int i = 0 ; i < jobs.size(); i++){
            jobs.get(i).setStatus(1); //1 means working one
        }
    }

    public void isOnVacation(){
        workStatus = true;
    }

    public void getTasksDone(){
        //change all his jobs.status to 2;
        for(int i = 0 ; i < jobs.size(); i++){
            jobs.get(i).setStatus(2); //2 means completed
        }
    }
}
