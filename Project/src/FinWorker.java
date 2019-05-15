import java.util.ArrayList;

public class FinWorker extends Worker {

    public FinWorker(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi, Company cc) {
        super(i, n, y, sex, d, p, permi,cc);
    }

    public void calculatePayment(Case C){
        System.out.println("Finance " + getName()+ "is Working on calculating the bill" );
        int profit = C.client.getBudget() - C.getPlan().getCost();
        if(((FinManager)getSupervisor()).doubleCheck(C,profit)){
            System.out.println("Client "+ C.client.name+ " Bill $ "+ C.getPlan().getCost());
        }
    }

    public void caseSurvey(Case C, int grade){
        C.grade(grade);
    }

    public void uploadCase(Case c){

        int profit = c.client.getBudget() - c.getPlan().getCost();
        ArrayList<Manager> m = new ArrayList<>();
        ArrayList<Worker> w = new ArrayList<>();
        m.add(c.mm);
        m.add(c.tm);
        m.add(c.fm);
        for(Manager mm: m){
            System.out.println(mm.getName());
        }

        w.add(c.fw);
        w.add(c.mw);
        w.add(c.tw);

        System.out.println("Finance " + getName()+ " is Working on Case update" );
        CaseForDatabase temp = new CaseForDatabase(c.caseName,c.client,c.getPlan(),2020, profit, c.getGrade(),m, w);

        company.getCaseDatabases().addCase(temp);
        //company.getCaseDatabases().print();
    }
}
