public class Mocha implements CoffeeIF{

    private CoffeeProcessorEnvironmentIF coffee;
    private String CoffeeType = "Mocha";
    private double price = 2.0;
    private int grindtime = 5;
    private int temp = 200;
    private int hold = 5;
    private int wait = 15;
    private CondimentIF cream1 = new Cream();
    private CondimentIF vanilla = new Vanilla();

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
        coffee.setTypeLed(2);
        coffee.setCoffeeType(CoffeeType);
        coffee.setGrindingTime(grindtime);
        coffee.setTemperature(temp);
        coffee.holdTemperature(hold);
        coffee.addCondiment(cream1);
        coffee.addCondiment(vanilla);
        coffee.wait(wait);
    }

}
