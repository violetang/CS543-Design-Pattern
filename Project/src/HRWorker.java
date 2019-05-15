import java.util.ArrayList;

public class HRWorker extends Worker {

    public HRWorker(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi, Company cc) {
        super(i, n, y, sex, d, p, permi,cc);
    }

    public void updateCaseInloved(Case temp){
        //update team's case invloved
        System.out.println("HR " + getName()+ " is Working on Update team case involved " );
        ((HRManager)getSupervisor()).approveUpdateCaseInlvoed();
        for(Employee e: temp.team){
            if(e.getDept() != "HR"){
                e.setPermission(true);
                e.involvedCase(temp);
                e.setPermission(false);
            }
            System.out.println(e.getDept()+":    "+ e.getName()+"    - case was updated - "+temp.caseName);
        }

    }
}
