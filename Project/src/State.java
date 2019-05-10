public class State {

    //symbolic constants for events
    public static final int STATE_EVENT = 1;


    //symbolic constants for states
    private static ClientNegotiate clientNegotiate;   //getting client, sign contract...
    private static AppDevelop appDevelop;
    private static CaseFinish caseFinish;    //calculate profit, get money from client and pay for the cost
    private static InfoUpdate infoUpdate; //save the case into company infomation system, and update employee performance

    State(){
        clientNegotiate = new ClientNegotiate();
        appDevelop = new AppDevelop();
        caseFinish = new CaseFinish();
        infoUpdate = new InfoUpdate();

    }

    public static State start(){
        return null;
    }

    protected State nextState(int event){
        return null;

    }

    public final State processEvent(int event){
        return null;

    }


    protected void enter(){

    }

    //Class
    public class ClientNegotiate extends State {

        public State nextState(int event){
            switch(event){

            }
            return null;
        }

        //this method is called when this object becomes the current state
        protected void enter(){

        }
    }

    //Class
    public class AppDevelop extends State{
        public State nextState(int event){
            return null;

        }

        protected  void enter(){

        }
    }

    //Class
    public class CaseFinish extends State{
        public State nextState(int event){
            return null;

        }

        protected void enter(){

        }
    }

    //Class
    public class InfoUpdate extends State{
        public State nextState(int event){
            return null;

        }

        protected void enter(){

        }
    }
}