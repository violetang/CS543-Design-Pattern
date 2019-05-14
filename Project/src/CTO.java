import java.util.ArrayList;

/**
 *
 * @author jayxu
 */
public class CTO extends Leader {


    private ArrayList<TechManager> myManagers = new ArrayList<>();

    public CTO(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }

    //About Manager
    public void addManager(TechManager m) {
        myManagers.add(m);
        m.setSupervisor(this);
    }

    public ArrayList<TechManager> getManager() {
        return myManagers;
    }

    public void removeManagers(Manager m) {
        myManagers.remove(m);
    }
}
