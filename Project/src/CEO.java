import java.util.ArrayList;

/**
 *
 * @author jayxu
 */
public class CEO extends Leader {

    public CEO(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }

    public void offerDecision(Client c){

        //get what's the plan
        //toto: plan type
        int plan = c.getPlan();
        int profit = cost - budget;

    }
}
