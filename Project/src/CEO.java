import java.util.ArrayList;

/**
 *
 * @author jayxu
 */
public class CEO extends Leader {

    public CEO(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }

    public boolean offerDecision(Client c,int cost){

        int profit = c.getBudget() - cost;
        if(profit/cost > 0.1) return true;
        else return false;
    }


}
