public class FinWorker extends Worker {

    public FinWorker(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi, Company cc) {
        super(i, n, y, sex, d, p, permi,cc);
    }

    public void calculatePayment(Case C){
        int profit = C.client.getBudget() - C.getPlan().getCost();
        if(((FinManager)getSupervisor()).doubleCheck(C,profit)){
            System.out.println("Client "+ C.client.name+ " Bill $ "+ profit);
        }
    }

    public void caseSurvey(Case C, int grade){
        C.grade(grade);
    }

    public void uploadCase(Case c){

    }
}
