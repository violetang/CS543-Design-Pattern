
class Owner extends People{

    //constructor
    public Owner(String n, int p){
        super(n,p);
    }
    
    //owner start a project and set it's status to 1
    public void startProject(Project x, Manager y){
        x.setProjectStatus(1);
        y.addProject(x);
    }

    //owner grades manager's performance
    public void evaluateManagersPerformance(Manager a, int b){
        a.setPerformanceScale(b);
    }

    //increase the salary by $500
    public void updateSalary(Manager m, int inc){
        int curr = m.getSalary();
        m.setSalary(curr + inc);
    }

    public void announceNews(String news){
        System.out.println(news);
    }
    
}