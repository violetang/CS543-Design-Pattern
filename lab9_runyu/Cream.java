/**
 * Cream implements CondimentIF
 * @author Group 7
 */
public class Cream implements CondimentIF {

    private double price;

    public Cream(){
        this.price = 0.25;
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
        return "cream";
    }
}
