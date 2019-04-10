/**
 * CoffeeProcessor_IF provides an environment for CoffeeIF 
 * @author Group 7
 */
public interface CoffeeProcessor_IF {
    
    public void setCoffeeType(String type);
    public void setGrindingTime(double secs);
    public void addCondiment(CondimentIF type);
    public void setTemperature(double degree);
    public void holdTemperature(double secs);
    public void wait(double secs);
    public void setPowerLED(int num);
    public void setTypeLED(int num);
    public double computePrice(CoffeeIF coffee);
    public void done();
    public CondimentIF condiment();
    
}
