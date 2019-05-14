import java.util.ArrayList;

public class Manager extends Employee {


    private Manager colleague;
    private Leader supervisor;

    public Manager(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }



    public Leader getSupervisor(){ return supervisor;}

    public void setSupervisor(Leader l) {
        this.supervisor = l;
    }

    //todo
    public void delegation(Manager m) {
        this.colleague = colleague;
    }


}
