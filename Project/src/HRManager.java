import java.util.ArrayList;

public class HRManager extends Manager {
    private ArrayList<HRWorker> team = new ArrayList<>();

    public HRManager(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }

    public void addWorker(HRWorker w) {
        team.add(w);
        w.setSupervisor(this);
    }

    public void removeWorker(HRWorker w) {
        if (team.contains(w)) {
            team.remove(w);
        }
    }

    public ArrayList<HRWorker> getTeam() {
        return this.team;
    }
}
