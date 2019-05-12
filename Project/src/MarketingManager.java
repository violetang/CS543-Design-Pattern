public class MarketingManager extends Manager {

    public MarketingManager(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }

    public boolean offerDecision(Client c, int cost){

        int profit = c.getBudget() - cost;
        if(profit/cost > 0.15) return true;
        else{
            CEO ceo = (CEO)getSupervisor();
            return ceo.offerDecision(c,cost);
        }
    }
}
