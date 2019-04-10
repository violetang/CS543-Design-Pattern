
/**
 * RegularCoffee extends Coffee and implements CoffeeIF
 * @author Group 7
 */
public class RegularCoffee extends Coffee implements CoffeeIF {

    private double grindTime;
    private double temperature;
    private double holdT;
    private double waitTime;

    public RegularCoffee() {
        this.setPrice(1);
        this.grindTime = 8;
        this.temperature = 150;
        this.holdT = 2;
        this.waitTime = 15;
    }

    @Override
    public void start() {
        getEnvironment().setPowerLED(1);
        getEnvironment().setTypeLED(1);
        getEnvironment().setGrindingTime(this.grindTime);
        getEnvironment().setTemperature(this.temperature);
        getEnvironment().holdTemperature(this.holdT);
        while (getEnvironment().condiment() != null) {
            getEnvironment().computePrice(this);
        }
        getEnvironment().wait(this.waitTime);
        getEnvironment().setPowerLED(0);
        getEnvironment().done();
    }

    @Override
    public String toString() {
        return "Regular Coffee";
    }
}
