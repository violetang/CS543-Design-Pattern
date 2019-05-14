import java.util.ArrayList;

public class CaseSummaryState implements CaseState {
    private Case mycase;
    private ArrayList<EmployeeIF> team = new ArrayList<>();

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
        //calculate how much client need pay and ask them pay
        //ask client grade it. save the grade
        //if client pay it -> finish
        //if they deesn't pay -> failed

        //create Case for casedatabase
        //save it to company's case database

        //move to the last state
        //release the team
        //contiue

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
