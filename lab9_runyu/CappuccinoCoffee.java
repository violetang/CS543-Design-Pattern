
/**
 *CappuccinoCoffee is a subclass of Coffee implements CoffeeIF
 * @author Group 7
 */
public class CappuccinoCoffee extends Coffee implements CoffeeIF {

    private double grindTime;
    private double temperature;
    private double holdT;
    private double waitTime;
    private CondimentIF vanilla = new Vanilla();
    private CondimentIF cream = new Cream();

    //initialize the coffee program with specific values
    public CappuccinoCoffee() {
        this.setPrice(5);
        this.grindTime = 5;
        this.temperature = 180;
        this.holdT = 5;
        this.waitTime = 15;
        
       
    }

    @Override
    public void start() {
        getEnvironment().setPowerLED(1);
        getEnvironment().setTypeLED(5);
        getEnvironment().setGrindingTime(this.grindTime);
        getEnvironment().setTemperature(this.temperature);
        getEnvironment().holdTemperature(this.holdT);
        getEnvironment().addCondiment(cream);
        getEnvironment().addCondiment(vanilla);
        //add extra condiments if there are
        while (getEnvironment().condiment() != null) {
            getEnvironment().computePrice(this);
        }
        getEnvironment().wait(this.waitTime);
        getEnvironment().setPowerLED(0);
        getEnvironment().done();
    }

    @Override
    public String toString() {
        return "Cappuccino Coffee";
    }
}
