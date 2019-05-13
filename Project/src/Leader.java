

import java.util.ArrayList;

public class Leader extends Employee {

    private ArrayList<Manager> myManagers = new ArrayList<>();
    /* from super class
    private int id;
    private String name;
    private int year;
    private String sexual;
    private Department dept;
    private EditPacketIF editPacket;
    private static boolean permission;
     */


    //construtor
    public Leader(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }

    //About Manager
    public void addManager(Manager m) {
        myManagers.add(m);
        m.setSupervisor(this);
    }
    public void removeManagers(Manager m) {
        myManagers.remove(m);
    }
    public ArrayList<Manager> getManager() {
        return this.myManagers;
    }



}
