public class Espresso implements CoffeeIF {
    private CoffeeProcessorEnvironmentIF coffee;
    private String CoffeeType = "Espresso";
    private double price = 4.0;
    private int grindtime = 11;
    private int temp = 250;
    private int hold = 5;
    private int wait = 10;

    @Override
    public void setCoffeEnvironment(CoffeeProcessorEnvironmentIF e) {
        coffee = e;
    }

    @Override
    public String getCoffeeType() {
        return CoffeeType;
    }

    public double getCoffeePrice(){
        return price;
    }

    @Override
    public void start() {
        coffee.setPowerLED(1);
        coffee.setTypeLed(4);
        coffee.setCoffeeType(CoffeeType);
        coffee.setGrindingTime(grindtime);
        coffee.setTemperature(temp);
        coffee.holdTemperature(hold);
        coffee.wait(wait);
    }

}
