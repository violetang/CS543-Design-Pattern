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

    public void evaluation(){
        ArrayList<CaseForDatabase> cases = company.getCaseDatabases().returnDatabase();
        for(CaseForDatabase theCase: cases){
            int grade = theCase.getGrade();
            int profit = theCase.getProfit();
            double bonus = (grade/100)*profit;
            ArrayList<Manager> managers = theCase.getManagers();
            for(Manager m: managers){
                m.setPermission(true);
                System.out.println("Can get bonus from the Case "+ theCase.getCaseName()+ " is "+ bonus * m.getBonus() * 0.1);
                double SalaryThisYear = m.getSalary() + bonus* m.getBonus()* 0.1;
                m.setPermission(false);
                System.out.println(m.getName() + ": After add your contribution to those cases, your salary of this year is :" + SalaryThisYear+"\n");
            }
            ArrayList<Worker> workers = theCase.getWorkers();
            for(Worker m: workers){
                System.out.println("Can get bonus from the Case "+ theCase.getCaseName()+ " is "+ bonus * m.getBonus() * 0.05);
                m.setPermission(true);
                double SalaryThisYear = m.getSalary() + bonus* m.getBonus()* 0.05;
                m.setPermission(false);
                System.out.println(m.getName() + ": After add your contribution to those cases, your salary of this year is :" + SalaryThisYear+"\n");
            }
        }

    }
}
