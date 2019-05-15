import java.util.ArrayList;

public class MarketingManager extends Manager {

    private ArrayList<MarketingWorker> team = new ArrayList<>();

    public MarketingManager(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi, Company cc) {
        super(i, n, y, sex, d, p, permi,cc);
    }

    public boolean offerDecision(Client c, int cost){

        int profit = c.getBudget() - cost;
        if(profit/cost > 0.3) return true;
        else{
            System.out.println("Need CEO decide");
            CEO ceo = (CEO)getSupervisor();
            return ceo.offerDecision(c,cost);
        }
    }

    public void addWorker(MarketingWorker w) {
        team.add(w);
        w.setSupervisor(this);
    }

    public void removeWorker(MarketingWorker w) {
        if (team.contains(w)) {
            team.remove(w);
        }
    }

    public ArrayList<MarketingWorker> getTeam() {
        return this.team;
    }
}
