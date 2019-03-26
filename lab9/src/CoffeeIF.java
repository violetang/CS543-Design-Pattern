public interface CoffeeIF {

    public void setCoffeEnvironment(CoffeeProcessorEnvironmentIF e);

    public String getCoffeeType();
    public double getCoffeePrice();

    public void start();
}
