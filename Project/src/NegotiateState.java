import java.util.ArrayList;
import java.util.Scanner;

public class NegotiateState implements CaseState {

    private Case mycase;
    private ArrayList<EmployeeIF> team = new ArrayList<>();

    //constructor
    public NegotiateState(Case c){
        mycase = c;
    }

    //create Marketing team
    @Override
    public void createTeam() {

        System.out.println("\n--Creating Marketing team:");

        //get a not busy manager
        for(MarketingManager aa: mycase.ceo.getManager()){
            if(aa.getBusy() == false){
                mycase.addMarketingManager(aa);
                System.out.println("Marketing Manager: "+aa.getName());
                break;
            }
        }

        //get a not busy worker
        for(MarketingWorker bb: mycase.mm.getTeam()){
            if(bb.getBusy() == false){
                mycase.addMarketingWorker(bb);
                System.out.println("Marketing Worker: "+bb.getName());
                break;
            }
        }
    }

    /*Negotiate state start
        - create the marketing team (one manager + one worker)
        - make decision by client budget
        - if do it -> next state
        - if not - > case failed
        todo: let the client input their choice
     */
    @Override
    public void start() {

        System.out.println("\n############# 1. Negotiate State #############");

        //create the team
        createTeam();

        //a marketing worker make a decision
        System.out.println("\n--Evaluate Client offer");
        boolean decision= mycase.mw.offerDecision(mycase.client,mycase.getPlan().getCost());
        if(decision == true){
            finish();
        }else {
            failed();
        }

        System.out.println("\n");
    }

    /*negotiate failed:
        - call case failed
        - show the reason
        - marketing team not busy
     */
    @Override
    public void failed() {
        mycase.caseFailed();
        System.out.println("Reason: low budget!");
        releaseTeam();
    }

    /* negotiate sucess:
        - gongradulation words
        - marketing team not busy
     */
    @Override
    public void finish() {
        System.out.println("Yes, we can do it. Here is the contract, please sign it: (1 = sign or 0 = not sign)");
        Scanner scanner = new Scanner(System.in);
        int ans = scanner.nextInt();
        if(ans == 1){
            System.out.println("Great! Hope we can have a great cooperation experience");
            changeState(new AppDevelopState(mycase));
            mycase.caseContinue();
        }else if(ans == 0){
            mycase.caseFailed();
        }else{
            System.out.println("Invalid Input");
        }
        releaseTeam();
    }

    //ask Case to change to another state
    @Override
    public void changeState(CaseState nextStage) {
        mycase.updateCaseState(nextStage);
    }

    //set all team busy = false;
    public void releaseTeam(){
        for(EmployeeIF e: mycase.team){
            e.isBusy(false);
        }
    }

}
