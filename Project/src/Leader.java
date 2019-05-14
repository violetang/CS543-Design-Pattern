

import java.util.ArrayList;

public class Leader extends Employee {


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

}
