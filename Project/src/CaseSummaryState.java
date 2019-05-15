import java.util.ArrayList;

public class CaseSummaryState implements CaseState {
    private Case mycase;

    //constructor
    public CaseSummaryState(Case c){
        mycase = c;
    }

    @Override
    public void createTeam() {
        System.out.println("\n--Creating HR team:");
        for(HRManager aa: mycase.cfo.getHRManager()){
            if(aa.getBusy() == false){
                mycase.addHRManager(aa);
                System.out.println("HR Manager: "+aa.getName());
                break;
            }
        }

        for(HRWorker bb: mycase.hm.getTeam()){
            if(bb.getBusy() == false){
                mycase.addHRWorker(bb);
                System.out.println("HR Worker: "+bb.getName());
                break;
            }
        }

    }

    @Override
    public void start() {

        System.out.println("\n############# 4. Case Summary State #############");
        createTeam();

        //update employee's case involved
        System.out.println("\n--Update all the team's case involved:");
        mycase.hw.updateCaseInloved(mycase);
        finish();

    }

    @Override
    public void failed() {

    }

    @Override
    public void finish() {
        releaseTeam();
        mycase.caseDone();
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
