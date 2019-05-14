import java.util.ArrayList;


public class Worker extends Employee {

    private Manager supervisor;
    private Worker colleague;

    public Worker(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi, Company cc) {
        super(i, n, y, sex, d, p, permi,cc);
    }

    public void setSupervisor(Manager m) {
        this.supervisor = m;
    }

    public Manager getSupervisor() {
        return this.supervisor;
    }

    public void setDelegate(Worker w) {
        this.colleague = w;
    }




}
