
/**
 * Chocolate implements CondimentIF 
 * @author Group 7
 */
public class Chocolate implements CondimentIF {

    private double price;

    //iniitalize chocolate with price $1.00
    public Chocolate() {
        this.price = 1.00;
    }

    //if want to change the price later, using setPrice to achieve this
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "chocolate";
    }
}
