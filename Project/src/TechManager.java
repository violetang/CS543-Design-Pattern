import java.util.ArrayList;

public class TechManager extends Manager {

    private ArrayList<TechWorker> team = new ArrayList<>();

    public TechManager(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi, Company cc) {
        super(i, n, y, sex, d, p, permi,cc);
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

    public void work(Case c){

        scheduleAndPlan();
        ((CTO)getSupervisor()).approve(c);
        c.tw.development(c);

    }

    public void scheduleAndPlan(){
        System.out.println("Manager "+ getName()+ " scheduled the timeline and Development plan.");
    }
}
