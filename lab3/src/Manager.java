import java.util.ArrayList;

class Manager extends Employee {

    private ArrayList<Worker> myWorkers;
    private boolean workStatus;
    private ArrayList<Project> projects;

    Manager(String n, int p){
        super(n,p);
        myWorkers = new ArrayList<>();
        projects = new ArrayList<>();
        workStatus = false;
    }

    public void addWorkers(Worker e){
        myWorkers.add(e);
    }

    public void addProject(Project p){
        projects.add(p);
    }

    public void setTasksforProject(Project a){
        a.setProjectStatus(2); //2 - start to work on project
        Task t1 = new Task(1,"begin");
        Task t2 = new Task(2,"running");
        Task t3 = new Task(3,"test");
        a.addTasks(t1);
        a.addTasks(t2);
        a.addTasks(t3);
    }

    public void assignTask(Task t, Worker e){
        e.addJobs(t);
    }

    public ArrayList<Worker> getMyWorkers(){
        return myWorkers;
    }

    public void isOnVacation(){
        workStatus = true;
    }

    public ArrayList<Task> collectCompletedTask(){
        ArrayList<Task> completedTasks = new ArrayList<>();

        for(int i = 0 ; i < projects.size(); i++){
            for(int j = 0 ; j < projects.get(i).getTasks().size(); j++){
                Task tmp = projects.get(i).getTasks().get(j);
                if(tmp.getStatus() == 2){
                    completedTasks.add(tmp);
                }
            }
        }

        return completedTasks;
    }

    public void evaluateEmployeesPerformance(){
        for(int i = 0 ; i < myWorkers.size(); i++){
            myWorkers.get(i).setPerformanceScale(4);
        }
    }

    public void updateSalary(Employee e, int increase){
        int curr = e.getSalary();
        e.setSalary(curr + increase);
    }
}
