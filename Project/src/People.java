
import java.util.ArrayList;

public class People implements Response_IF {

    private String name;
    private int ID;
    private double baseSalary;
    private int year;

    public People(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public void setSalary(double salary) {
        this.baseSalary = salary;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setServeYear(int year) {
        this.year = year;
    }

    @Override
    public void judge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

}
