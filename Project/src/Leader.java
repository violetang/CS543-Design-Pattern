

import java.util.ArrayList;

public class Leader extends Employee {

    private ArrayList<Manager> managers;
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
        managers.add(m);
    }
    public void removeManagers(Manager m) {
        managers.remove(m);
    }
    public ArrayList<Manager> getManager() {
        return this.managers;
    }

}
