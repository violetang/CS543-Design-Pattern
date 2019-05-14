import java.util.ArrayList;

public class AppDevelopState implements CaseState {

    private Case mycase;
    private ArrayList<EmployeeIF> team = new ArrayList<>();

    //constructor
    public AppDevelopState(Case c){
        mycase = c;
    }

    //create Tech team (one manager + one worker)
    @Override
    public void createTeam() {
        System.out.println("\nCreating Technology team:");
        for(TechManager aa: mycase.cto.getManager()){
            if(aa.getBusy() == false){
                mycase.addTechManager(aa);
                System.out.println("Tech Manager: "+aa.getName());
                break;
            }
        }

        for(TechWorker bb: mycase.tm.getTeam()){
            if(bb.getBusy() == false){
                mycase.addTechWorker(bb);
                System.out.println("Tech Worker: "+bb.getName());
                break;
            }
        }

    }

    /*Negotiate state start
        - create the tech team (one manager + one worker)
        - Manager set the schdule and plan, then report to CTO
        - CTO say yes, then worker start to work
        - finish or failed(need more time)
        todo: let the client input their choice
     */
    @Override
    public void start() {

        System.out.println("\n#2. Software development State:");

        //create a tech team
        createTeam();

        //a tech worker start to work on it



    }

    @Override
    public void failed() {
        System.out.println("");
    }

    @Override
    public void finish() {

    }

    @Override
    public void changeState(CaseState nextStage) {

    }

    @Override
    public void releaseTeam() {
        for(EmployeeIF e: team){
            e.isBusy(false);
        }
    }
}
