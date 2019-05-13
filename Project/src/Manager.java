import java.util.ArrayList;

public class Manager extends Employee {

    private ArrayList<Worker> team = new ArrayList<>();
    private Manager colleague;
    private Leader supervisor;
    private boolean isBusy = false;

    public Manager(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }

    public void addWorker(Worker w) {
        team.add(w);
        w.setSupervisor(this);
    }

    public void removeWorker(Worker w) {
        if (team.contains(w)) {
            team.remove(w);
        }
    }

    public ArrayList<Worker> getTeam() {
        return this.team;
    }

    public Leader getSupervisor(){ return supervisor;}

    public void setSupervisor(Leader l) {
        this.supervisor = l;
    }

    //todo
    public void delegation(Manager m) {
        this.colleague = colleague;
    }

    public void isBusy(boolean x){
        isBusy = x;
    }

}
