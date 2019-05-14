

public abstract class Employee implements EmployeeIF{

    private int id;
    private String name;
    private int year;
    private String sexual;
    private Department dept;
    private EditPacketIF editPacket;
    private static boolean permission;
    private boolean isBusy = false;


    //private static boolean permission;

    public Employee(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        id = i;
        name = n;
        year = y;
        sexual = sex;
        dept = d;
        editPacket = p;
        permission = permi;
    }


    public static boolean hasPermission(){
        return permission;
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

    public void editBase(double s, int p, int stock){ editPacket.editBase(s,p,stock);}

    public void involvedCase(TaskIF t){editPacket.editCaseInvolve(t);}

    public void isBusy(boolean x){
        isBusy = x;
    }

    public boolean getBusy(){
        return isBusy;
    }

}
