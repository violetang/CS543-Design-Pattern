/**
 * Vanilla implements CondimentIF
 * @author Group 7
 */
public class Vanilla implements CondimentIF{

   private double price;

    public Vanilla(){
        this.price = 0.5;
    }
    
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
   @Override
    public String toString(){
        return "vanilla";
    }
}
