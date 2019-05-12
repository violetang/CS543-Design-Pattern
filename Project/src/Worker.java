import java.util.ArrayList;


public class Worker extends Employee {

    private Manager supervisor;
    private Worker colleague;
    private boolean isBusy = false;

    public Worker(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
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

    public void isBusy(boolean x){
        isBusy = x;
    }


}
