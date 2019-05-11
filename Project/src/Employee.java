

public abstract class Employee implements EmployeeIF, EditPacketIF {

    private int id;
    private String name;
    private int year;
    private String sexual;
    private Department dept;
    private EditPacket privatePacket;
    private EditPacketProtectionProxy editPacket;
    private static boolean permission;


    //private static boolean permission;

    public Employee(int i, String n, int y, String sex, Department d, Packet p, boolean permi) {
        id = i;
        name = n;
        year = y;
        sexual = sex;
        dept = d;
        privatePacket = new EditPacket(p);
        editPacket = new EditPacketProtectionProxy(privatePacket);
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

}
