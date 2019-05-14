import java.util.ArrayList;

/**
 *
 * @author jayxu
 */
public class CEO extends Leader {

    private ArrayList<MarketingManager> myManagers = new ArrayList<>();

    public CEO(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }

    public boolean offerDecision(Client c,int cost){

        int profit = c.getBudget() - cost;
        if(profit/cost > 0.1) return true;
        else return false;
    }

    //About Manager
    public void addManager(MarketingManager m) {
        myManagers.add(m);
        m.setSupervisor(this);
    }

    public ArrayList<MarketingManager> getManager() {
        return myManagers;
    }

    public void removeManagers(Manager m) {
        myManagers.remove(m);
    }


}
