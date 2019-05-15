import java.util.ArrayList;

public class FinWorker extends Worker {

    public FinWorker(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi, Company cc) {
        super(i, n, y, sex, d, p, permi,cc);
    }

    public void calculatePayment(Case C){
        System.out.println("Finance " + getName()+ "is Working on calculating the bill" );
        int profit = C.client.getBudget() - C.getPlan().getCost();
        if(((FinManager)getSupervisor()).doubleCheck(C,profit)){
            System.out.println("Client "+ C.client.name+ " Bill $ "+ profit);
        }
    }

    public void caseSurvey(Case C, int grade){
        C.grade(grade);
    }

    public void uploadCase(Case c){

        int profit = c.client.getBudget() - c.getPlan().getCost();
        ArrayList<Manager> m = new ArrayList<>();
        ArrayList<Worker> w = new ArrayList<>();
        m.add(c.tm);
        m.add(c.fm);
        m.add(c.hm);
        m.add(c.mm);

        w.add(c.fw);
        w.add(c.hw);
        w.add(c.mw);
        w.add(c.tw);

        System.out.println("Finance " + getName()+ " is Working on Case update" );
        CaseForDatabase temp = new CaseForDatabase(c.caseName,c.client,c.getPlan(),2020, profit, m, w);
        company.getCaseDatabases().addCase(temp);
        //company.getCaseDatabases().print();
    }
}
