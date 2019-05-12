public class MarketingWorker extends Worker {

    public MarketingWorker(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }

    public boolean offerDecision(Client c, int cost){

        int profit = c.getBudget() - cost;
        if(profit/cost > 0.30) return true;
        else{
            MarketingManager s = (MarketingManager) getSupervisor();
            return s.offerDecision(c,cost);
        }
    }
}
