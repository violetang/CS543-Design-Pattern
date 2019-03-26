public class Regular implements CoffeeIF {

    private CoffeeProcessorEnvironmentIF coffee;
    private String CoffeeType = "Regular";
    private double price = 1.0;
    private int grindtime = 8;
    private int temp = 150;
    private int hold = 2;
    private int wait = 15;

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
        coffee.setTypeLed(1);
        coffee.setCoffeeType(CoffeeType);
        coffee.setGrindingTime(grindtime);
        coffee.setTemperature(temp);
        coffee.holdTemperature(hold);
        coffee.wait(wait);
    }
}
