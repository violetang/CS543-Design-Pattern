/**
 * CoffeeIF interface
 * @author Group 7
 */
public interface CoffeeIF {
    
    public void setEnvironment(CoffeeProcessor_IF env);
    public void start();
    public void setPrice(double price);
    public double getPrice();
}
