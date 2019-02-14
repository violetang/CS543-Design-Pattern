package company;
import java.util.ArrayList;

public class Project {

    private int projectId;
    private String projectName;
    private ArrayList<Task> tasks;
    private int projectStatus; //0 - new; 1 - start; 2 - working on

    Project(int i, String n){
        projectId = i;
        projectName = n;
        projectStatus = 0;
        tasks = new ArrayList<>();
    }

    public int getProjectId(){ return projectId; };

    public String getProjectName(){ return projectName; };

    public int getProjectStatus(){ return projectStatus; };

    public void setProjectStatus(int a){ projectStatus = a; };

    public void addTasks(Task t){
        tasks.add(t);
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }
}