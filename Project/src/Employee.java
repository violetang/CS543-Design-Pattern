import java.util.ArrayList;

public abstract class Employee implements EmployeeIF{

    private int id;
    private String name;
    private int year;
    private String sexual;
    private Department dept;
    private EditPacketIF editPacket;
    private static boolean permission;
    private boolean isBusy = false;
    public Company company;


    //private static boolean permission;

    public Employee(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi, Company cc) {
        id = i;
        name = n;
        year = y;
        sexual = sex;
        dept = d;
        editPacket = p;
        permission = permi;
        company = cc;
    }


    public static boolean hasPermission(){
        return permission;
    }
    public void setPermission(boolean n){
        permission = n;
    }

    public int getID(){ return id; }
    public String getName(){ return name; }
    public String getSexual(){ return sexual;}
    public String getDept(){ return dept.returnDepartmentName();}
    public int getYear(){ return year;}

    public double getSalary(){
        return editPacket.getSalary();
    }

    public double getBonus(){
        return editPacket.getbonus();
    }

    public int getStock(){
        return editPacket.getStock();
    }

    public int getPosition(){
        return editPacket.getPosition();
    }

    public void getCase(){
        editPacket.getCase();
    }

    public void editBase(double s, int p, int stock){ editPacket.editBase(s,p,stock); }

    public void involvedCase(Case t){editPacket.editCaseInvolve(t);}

    public void isBusy(boolean x){
        isBusy = x;
    }

    public boolean getBusy(){
        return isBusy;
    }

}
