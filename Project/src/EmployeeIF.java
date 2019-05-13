public interface EmployeeIF {

    public int getID();
    public String getName();
    public String getSexual();
    public String getDept();
    public int getYear();
    public double getSalary();

    public double getBonus();
    public int getStock();
    public int getPosition();
    public void getCase();
    public void editBase(double s, int p, int stock);
    public void involvedCase(TaskIF t);
}
