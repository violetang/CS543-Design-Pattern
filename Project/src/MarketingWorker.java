public class MarketingWorker extends Worker {

    public MarketingWorker(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi, Company cc) {
        super(i, n, y, sex, d, p, permi, cc);
    }

    public boolean offerDecision(Client c, int cost){

        double profit = c.getBudget() - cost;
        if((double)(profit/cost) > 0.3) return true;
        else{
            System.out.println("Need Manager decide");
            MarketingManager s = (MarketingManager) getSupervisor();
            return s.offerDecision(c,cost);
        }
    }


}
