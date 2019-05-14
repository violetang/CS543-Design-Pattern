import java.util.ArrayList;

/**
 *
 * @author jayxu
 */
public class CTO extends Leader {


    private ArrayList<TechManager> myManagers = new ArrayList<>();

    public CTO(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi, Company cc) {
        super(i, n, y, sex, d, p, permi,cc);
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

    public void approve(Case c){

        System.out.println("CTO Approved it");
    }
}
