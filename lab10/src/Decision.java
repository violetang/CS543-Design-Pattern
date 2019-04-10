public class Decision {

    private String decision;

    public Decision(String x){
        decision = x;
    }

    public String getDecision(){ return decision; }

    public void doIt(){
        System.out.println(decision);
    }
}
