import java.util.ArrayList;

/**
 *
 * @author jayxu
 */
public interface EditPacketIF {

    public void editBase(double salary, int position, int stock);
    public void editCaseInvolve(TaskIF c);
    public double getSalary();
    public double getbonus();
    public int getStock();
    public int getPosition();
    public void getCase();

}
