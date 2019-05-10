import java.util.ArrayList;

public class Company {
    private String name;
    private String address;
    private CEO ceo;
    private CFO cfo;
    private CTO cto;
    private double stockPrice;
    private ArrayList<People> staffs;
    
    public Company(String name, String address){
        this.name = name;
        this.address = address;
    }
    public String getName(){
        return this.name;
    }
    public void setCEO(CEO ceo){
        this.ceo = ceo;
    }
    public void setCFO(CFO cfo){
        this.cfo = cfo;
    }
    public void setCTO(CTO cto){
        this.cto = cto;
    }
    public CEO getCEO(){
        return this.ceo;
    }
    public CTO getCTO(){
        return this.cto;
    }
    public CFO getCFO(){
        return this.cfo;
    }
    
    public void addStaff(People p){
        staffs.add(p);
    }
    public void initalStaffList(){
       if(ceo != null){
           staffs.add(ceo);
           ArrayList<Manager> managers = ceo.getManager();
           for(Manager m: managers){
               staffs.add(m);
               ArrayList<Worker> workers = m.getTeam();
               for(Worker w:workers){
                   staffs.add(w);
               }
           }
       }
       if(cfo != null){
           staffs.add(cfo);
           ArrayList<Manager> managers = cfo.getManager();
           for(Manager m: managers){
               staffs.add(m);
               ArrayList<Worker> workers = m.getTeam();
               for(Worker w:workers){
                   staffs.add(w);
               }
           }
       }
       if(cto != null){
           staffs.add(cto);
           ArrayList<Manager> managers = cto.getManager();
           for(Manager m: managers){
               staffs.add(m);
               ArrayList<Worker> workers = m.getTeam();
               for(Worker w:workers){
                   staffs.add(w);
               }
           }
       }
    }
}
