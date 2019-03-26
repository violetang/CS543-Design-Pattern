public abstract class AbstractCoffee implements CoffeeIF {

    private CoffeeProcessorEnvironmentIF coffee;

    public void setCoffeEnvironment(CoffeeProcessorEnvironmentIF e){
        coffee = e;
    }

    protected CoffeeProcessorEnvironmentIF getCoffeEnvironment(){
        return coffee;
    }

}
