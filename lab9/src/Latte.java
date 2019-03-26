public class Latte implements CoffeeIF {

    private CoffeeProcessorEnvironmentIF coffee;
    private String CoffeeType = "Latte";
    private double price = 3.0;
    private int grindtime = 10;
    private int temp = 200;
    private int hold = 1;
    private int wait = 10;
    private CondimentIF cream2 = new Cream();
    private CondimentIF cho = new Chocolate();

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
        coffee.setTypeLed(3);
        coffee.setCoffeeType(CoffeeType);
        coffee.setGrindingTime(grindtime);
        coffee.setTemperature(temp);
        coffee.holdTemperature(hold);
        coffee.addCondiment(cream2);
        coffee.addCondiment(cho);
        coffee.wait(wait);
    }

}

