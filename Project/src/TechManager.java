import java.util.ArrayList;

public class TechManager extends Manager {

    private ArrayList<TechWorker> team = new ArrayList<>();

    public TechManager(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }


    public void addWorker(TechWorker w) {
        team.add(w);
        w.setSupervisor(this);
    }

    public void removeWorker(TechWorker w) {
        if (team.contains(w)) {
            team.remove(w);
        }
    }

    public ArrayList<TechWorker> getTeam() {
        return this.team;
    }
}
