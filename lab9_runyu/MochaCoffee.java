
/**
 * MochaCoffee extends Coffee and implements CoffeeIF
 * @author Group 7
 */
public class MochaCoffee extends Coffee implements CoffeeIF {
    
    private double grindTime;
    private double temperature;
    private double holdT;
    private double waitTime;
    private CondimentIF cream = new Cream();
    private CondimentIF vanilla = new Vanilla();
    
    public MochaCoffee() {
        this.setPrice(2);
        this.grindTime = 5;
        this.temperature = 200;
        this.holdT = 5;
        this.waitTime = 15;
    }
    
    @Override
    public void start() {
        getEnvironment().setPowerLED(1);
        getEnvironment().setTypeLED(2);
        getEnvironment().setGrindingTime(this.grindTime);
        getEnvironment().setTemperature(this.temperature);
        getEnvironment().holdTemperature(this.holdT);
        getEnvironment().addCondiment(cream);
        getEnvironment().addCondiment(vanilla);
        while (getEnvironment().condiment() != null) {
            getEnvironment().computePrice(this);
        }
        getEnvironment().wait(this.waitTime);
        getEnvironment().computePrice(this);
        getEnvironment().setPowerLED(0);
        getEnvironment().done();
    }
    
    @Override
    public String toString() {
        return "Mocha Coffee";
    }
    
}
