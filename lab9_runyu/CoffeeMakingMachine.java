
/**
 * CoffeeMakingMachine is the main class to run the OS class
 * @author Group 7
 */
public class CoffeeMakingMachine {

    private static CoffeeProcessorOS os = new CoffeeProcessorOS();
    private static CondimentIF cream = new Cream();
    private static CondimentIF chocolate = new Chocolate();
    private static CondimentIF vanilla = new Vanilla();
    public static void main(String arg[]) {
        
        System.out.println("******************************");
        System.out.println("           Menu ");
        System.out.println("1. Regular    $ 1.00 / cup ");
        System.out.println("2. Mocha      $ 2.00 / cup ");
        System.out.println("3. Latte      $ 3.00 / cup ");
        System.out.println("4. Espresso   $ 4.00 / cup ");
        System.out.println("5. Cappuccino $ 5.00 / cup\n");
        System.out.println("    Additional condiments  ");
        System.out.println("cream         $ 0.25 / time");
        System.out.println("vanilla       $ 0.50 / time");
        System.out.println("chocolate     $ 1.00 / time");
        System.out.println("******************************\n");
        //Three test cases
        // Regular coffee  
        os.setCoffeeType("RegularCoffee");
        os.run();
        
        //Mocha coffee with extra chocolate
        os.setCoffeeType("MochaCoffee");
        os.extraCondiment(chocolate);
        os.run();
        
        //Espresso coffee with cream, vanilla and double chocolates
        os.setCoffeeType("EspressoCoffee");
        os.extraCondiment(cream);
        os.extraCondiment(vanilla);
        os.extraCondiment(chocolate);
        os.extraCondiment(chocolate);
        os.run();

    }
}
