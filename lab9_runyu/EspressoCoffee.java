/**
 * EspressoCoffee extends Coffee and implements CoffeeIF
 * @author Group 7
 */
public class EspressoCoffee extends Coffee implements CoffeeIF {

    private double grindTime;
    private double temperature;
    private double holdT;
    private double waitTime;

    public EspressoCoffee() {
        this.setPrice(4);
        this.grindTime = 16;
        this.temperature = 150;
        this.holdT = 5;
        this.waitTime = 20;
    }

    @Override
    public void start() {
        getEnvironment().setPowerLED(1);
        getEnvironment().setTypeLED(4);
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
        return "Espresso Coffee";
    }
}
