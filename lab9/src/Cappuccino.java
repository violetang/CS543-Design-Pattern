public class Cappuccino implements CoffeeIF {
    private CoffeeProcessorEnvironmentIF coffee;
    private String CoffeeType = "Cappuccino";
    private double price = 5.0;
    private int grindtime = 5;
    private int temp = 200;
    private int hold = 8;
    private int wait = 15;
    private CondimentIF cream1 = new Cream();
    private CondimentIF cream2 = new Cream();

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
        coffee.setTypeLed(5);
        coffee.setCoffeeType(CoffeeType);
        coffee.setGrindingTime(grindtime);
        coffee.setTemperature(temp);
        coffee.holdTemperature(hold);
        coffee.addCondiment(cream1);
        coffee.addCondiment(cream2);
        coffee.wait(wait);
    }
}
