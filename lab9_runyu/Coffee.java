/**
 * Coffee is an abstract class implements CoffeeIF
 * @author Group 7
 */
public abstract class Coffee implements CoffeeIF {
    private CoffeeProcessor_IF env;
    private double price;
    
    @Override
    public void setEnvironment(CoffeeProcessor_IF env) {
        this.env = env;
    }

    // method to get environment 
    protected CoffeeProcessor_IF getEnvironment(){
        return this.env;
    }
    
    @Override
    public abstract void start();

    //calculate total price of a cup of coffee
    @Override
    public void setPrice(double price){
        this.price += price;
    }

    @Override
    public double getPrice(){
        return price;
    }
    
}
