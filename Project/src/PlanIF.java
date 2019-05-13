public interface PlanIF {

    public String getName();
    public int getCost();
    public int getPrice();
    public String[] getContext();

    public void development();
    public void test();
    public void deployment();

}
