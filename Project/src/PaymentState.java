import java.util.ArrayList;

public class PaymentState implements CaseState {

    private Case mycase;

    //constructor
    public PaymentState(Case c){
        mycase = c;
    }

    @Override
    public void createTeam() {
        System.out.println("\n--Creating Finance team:");
        for(FinManager aa: mycase.cfo.getFinManager()){
            if(aa.getBusy() == false){
                mycase.addFinManager(aa);
                System.out.println("Finance Manager: "+aa.getName());
                break;
            }
        }

        for(FinWorker bb: mycase.fm.getTeam()){
            if(bb.getBusy() == false){
                mycase.addFinWorker(bb);
                System.out.println("Finance Worker: "+bb.getName());
                break;
            }
        }
    }

    @Override
    //todo: let the client grade it.
    public void start() {

        System.out.println("\n############# 3. Payment and survey State #############");
        createTeam();

        //calculate how much client need pay and ask them pay
        System.out.println("\n--Calculate the bill");
        mycase.fw.calculatePayment(mycase);

        System.out.println("\n--Client grade our job");
        mycase.fw.caseSurvey(mycase,100);

        System.out.println("\n--Please pay for the bill: yes - 1 or no - 0 ");
        int payment = 1;
        if(payment == 1){
            System.out.println("Payment Received!");
            finish();
            changeState(new CaseSummaryState(mycase));
            mycase.caseContinue();
        }else failed();

        releaseTeam();


    }

    @Override
    public void failed() {
        System.out.println("Client didn't pay. Payment failed");
        mycase.caseFailed();
    }

    @Override
    public void finish() {
        System.out.println("\n--upload the case to Company case databse ");
        mycase.fw.uploadCase(mycase);
        System.out.println("Case update done！" );
    }

    @Override
    public void changeState(CaseState nextone) {
        mycase.updateCaseState(nextone);
    }

    @Override
    public void releaseTeam() {
        for(EmployeeIF e: mycase.team){
            e.isBusy(false);
        }
    }
}
