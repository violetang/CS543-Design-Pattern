public interface CaseState {

    public void createTeam();
    public void start();
    public void finish();
    public void failed();
    public void changeState(CaseState nextone);
    public void releaseTeam();

}
