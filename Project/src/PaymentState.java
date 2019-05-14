import java.util.ArrayList;

public class PaymentState implements CaseState {

    private Case mycase;
    private ArrayList<EmployeeIF> team = new ArrayList<>();

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
    public void start() {

        System.out.println("\n############# 3. Payment and survey State #############");
        createTeam();

        //calculate how much client need pay and ask them pay
        //ask client grade it. save the grade
        //if client pay it -> finish
        //if they deesn't pay -> failed

        //create Case for casedatabase
        //save it to company's case database

        changeState(new CaseSummaryState(mycase));
        releaseTeam();
        mycase.caseContinue();

    }

    @Override
    public void failed() {

    }

    @Override
    public void finish() {

    }

    @Override
    public void changeState(CaseState nextone) {
        mycase.updateCaseState(nextone);
    }

    @Override
    public void releaseTeam() {
        for(EmployeeIF e: team){
            e.isBusy(false);
        }
    }

    public ArrayList<EmployeeIF> getTeam() {
        return team;
    }
}
