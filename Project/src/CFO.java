import java.util.ArrayList;

public class CFO extends Leader {

    private ArrayList<HRManager> myHRManagers = new ArrayList<>();
    private ArrayList<FinManager> myFinManagers = new ArrayList<>();

    public CFO(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi) {
        super(i, n, y, sex, d, p, permi);
    }

    //About Fin Manager
    public void addFinManager(FinManager m) {
        myFinManagers.add(m);
        m.setSupervisor(this);
    }

    public ArrayList<FinManager> getFinManager() {
        return myFinManagers;
    }

    public void removeFinManagers(Manager m) {
        myFinManagers.remove(m);
    }

    //About HR Manager
    public void addHRManager(HRManager m) {
        myHRManagers.add(m);
        m.setSupervisor(this);
    }

    public ArrayList<HRManager> getHRManager() {
        return myHRManagers;
    }

    public void removeHRManagers(Manager m) {
        myHRManagers.remove(m);
    }

    
}
