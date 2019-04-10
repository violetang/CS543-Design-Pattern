
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * CoffeeProcessorOS implements CoffeeProcessor_IF, this is the OS class to run
 * program from CoffeeIF
 * @author Group 7
 */
public class CoffeeProcessorOS implements CoffeeProcessor_IF {
    
    private static final URL[] classPath;
    private String type;
    private double grindingTime;
    private double degree;
    private double holdTime;
    private double waitTime;
    private int powerLED;
    private int typeLED;
    private CoffeeIF cif;
    private final ArrayList<CondimentIF> extraCondiments = new ArrayList();
    private final ArrayList<CoffeeIF> soldCoffee = new ArrayList();

    //method to read in programs
    static {
        try {
            classPath = new URL[]{new URL("file:///bin")};
        } catch (java.net.MalformedURLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    @Override
    public void setCoffeeType(String type) {
        this.type = type;
        System.out.println("Customer ordered " + this.type);
    }
    
    @Override
    public void setGrindingTime(double secs) {
        this.grindingTime = secs;
        System.out.printf("Grinding for %.1f seconds\n", grindingTime);
    }
    
    @Override
    public void addCondiment(CondimentIF type) {
        System.out.println("Adding " + type.toString());
    }
    
    /**
     * method to add extra condiment, it will add these condiments into a list
     * @param type - a condiment
     */
    public void extraCondiment(CondimentIF type) {
        this.extraCondiments.add(type);
    }
    
    /**
     * method to get an extra condiment from condiments list
     * @return a condiment
     */
    @Override
    public CondimentIF condiment() {
        if (this.extraCondiments.isEmpty()) {
            return null;
        }
        return this.extraCondiments.get(0);
    }
    
    @Override
    public void setTemperature(double degree) {
        this.degree = degree;
        System.out.printf("Heating up the water to %.1f degree \n", this.degree);
    }
    
    @Override
    public void holdTemperature(double secs) {
        this.holdTime = secs;
        System.out.printf("Holding temperature for %.1f seconds \n", this.holdTime);
    }
    
    @Override
    public void wait(double secs) {
        this.waitTime = secs;
        System.out.printf("Waiting for %.1f seconds \n", waitTime);
    }
    
    @Override
    public void setPowerLED(int num) {
        this.powerLED = num;
        if (this.powerLED == 1) {
            System.out.println("Making coffee ...");
        } else {
            System.out.println("Coffee is ready");
        }
    }
    
    @Override
    public void setTypeLED(int num) {
        this.typeLED = num;
        System.out.printf("LED display: %d %d \n", powerLED, typeLED);
    }
    
    @Override
    public double computePrice(CoffeeIF coffee) {
        //check if there are some extra condiments to add 
        if (this.condiment() != null) {
            addCondiment(this.condiment());//add condiment
            //add condiment's price to coffee price
            coffee.setPrice(extraCondiments.remove(0).getPrice());
        }
        return coffee.getPrice();
    }
    
    @Override
    public void done() {
        //store this cup of coffee into slodCoffee list
        this.soldCoffee.add(cif);
        System.out.println("The price is: $" + this.computePrice(cif));
        System.out.println("\n             Sale Records");
        System.out.println("****************************************");
        System.out.println("NO.           Type               Price ");
        for (int i = 0; i < this.soldCoffee.size(); i++) {
            CoffeeIF c = soldCoffee.get(i);
            System.out.printf("%1d.      %-24s $%.2f \n",
                    i + 1, c.toString(), c.getPrice());
        }
        System.out.println("*****************************************\n");
    }
    
    public void run() {
        ClassLoader classLoader = new URLClassLoader(classPath);
        Class c;
        //URL cd= classLoader.getResource("");
        //System.out.println(cd);
        try {
            c = classLoader.loadClass(type);
        } catch (ClassNotFoundException e) {
            System.out.println("Not found");
            return;
        }
        CoffeeIF coffee;
        try {
            cif = (CoffeeIF) c.newInstance();
        } catch (Exception e) {
            System.out.println("Unable to run");
            return;
        }
        cif.setEnvironment(this);
        cif.start();
    }
}
