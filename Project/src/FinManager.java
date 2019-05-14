import java.util.ArrayList;

public class FinManager extends Manager {

    private ArrayList<FinWorker> team = new ArrayList<>();

    public FinManager(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }


    public void addWorker(FinWorker w) {
        team.add(w);
        w.setSupervisor(this);
    }

    public void removeWorker(FinWorker w) {
        if (team.contains(w)) {
            team.remove(w);
        }
    }

    public ArrayList<FinWorker> getTeam() {
        return this.team;
    }
}
