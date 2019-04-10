/**
 * LatteCoffee extends Coffee and implements CoffeeIF
 * @author Group 7
 */
public class LatteCoffee extends Coffee implements CoffeeIF {

    private double grindTime;
    private double temperature;
    private double holdT;
    private double waitTime;
    
    public LatteCoffee() {
        this.setPrice(3);
        this.grindTime = 8;
        this.temperature = 150;
        this.holdT = 5;
        this.waitTime = 15;
    }

    @Override
    public void start() {
        getEnvironment().setPowerLED(1);
        getEnvironment().setTypeLED(3);
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
        return "Latte Coffee";
    }
}
