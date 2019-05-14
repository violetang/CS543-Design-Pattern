import java.util.ArrayList;

public class Case implements TaskIF {
    //businessCase
    public String caseName;
    public Client client;
    private CaseState currentState;
    private PlanIF plan;
    private int grade;
    public ArrayList<EmployeeIF> team;

    public CTO cto;
    public CEO ceo;
    public CFO cfo;
    public TechManager tm;
    public TechWorker tw;
    public MarketingWorker mw;
    public MarketingManager mm;
    public FinWorker fw;
    public FinManager fm;
    public HRWorker hw;
    public HRManager hm;

    public Case(String n, Client c, PlanIF p, CEO cc, CFO ff, CTO tt){
        caseName = n;
        client = c;
        plan = p;
        ceo = cc;
        cfo = ff;
        cto = tt;
        team = new ArrayList<>();
    }

    public void caseStart(){
        currentState = new NegotiateState(this);
        currentState.start();
    }

    public void updateCaseState(CaseState next){
        currentState = next;
    }

    public void caseContinue(){
        currentState.start();
    }

    public void caseFailed(){
        System.out.println("\nSorry, Cooperation Failed");
    }

    public void caseDone(){
        System.out.println("Done");
    }


    //Markeing team
    public void addMarketingWorker(MarketingWorker e){
        mw = e;
        team.add(mw);
        mw.isBusy(true);

    }
    public void addMarketingManager(MarketingManager n){
        mm = n;
        team.add(mm);
        mm.isBusy(true);
    }

    //Tech team
    public void addTechManager(TechManager e){
        tm = e;
        team.add(tm);
        tm.isBusy(true);

    }

    public void addTechWorker(TechWorker n){
        tw = n;
        team.add(tw);
        tw.isBusy(true);
    }

    //Finance team
    public void addFinManager(FinManager e){
        fm = e;
        team.add(fm);
        fm.isBusy(true);

    }

    public void addFinWorker(FinWorker n){
        fw = n;
        team.add(fw);
        fw.isBusy(true);
    }

    //HR team
    public void addHRManager(HRManager e){
        hm = e;
        team.add(hm);
        hm.isBusy(true);

    }

    public void addHRWorker(HRWorker n){
        hw = n;
        team.add(hw);
        hw.isBusy(true);
    }

    public void grade(int g){ grade = g;}

    public Client returnClient(){
        return client;
    }

    public PlanIF getPlan(){
        return plan;
    }

}
