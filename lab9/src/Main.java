public class Main {

    public static void main(String[] args) {

        System.out.println("---------------Coffee Menu--------------- ");
        System.out.println("1. Regular Coffee:      $1.0");
        System.out.println("2. Mocha:               $2.0");
        System.out.println("3. Latte:               $1.0");
        System.out.println("4. Espresso:            $1.0");
        System.out.println("5. Cappuccino:          $1.0");
        System.out.println("---------------Condiments--------------- ");
        System.out.println("1. Cream:               $0.25");
        System.out.println("2. Vanilla:             $0.5");
        System.out.println("3. Chocolate:           $1.0");

        CondimentIF chocolate1 = new Chocolate();
        CondimentIF cream = new Cream();
        CondimentIF vanilla = new Vanilla();
        CoffeeProcessorEnvironmentIF coffeeMaker = new CoffeeProcessorEnvironment();

        ((CoffeeProcessorEnvironment) coffeeMaker).run("Regular");
        coffeeMaker.done();

        ((CoffeeProcessorEnvironment) coffeeMaker).run("Mocha");
        coffeeMaker.addCondiment(chocolate1);
        coffeeMaker.done();

        ((CoffeeProcessorEnvironment) coffeeMaker).run("Espresso");
        coffeeMaker.addCondiment(cream);
        coffeeMaker.addCondiment(vanilla);
        coffeeMaker.addCondiment(chocolate1);
        coffeeMaker.addCondiment(chocolate1);
        coffeeMaker.done();

        coffeeMaker.displayRecord();


       return ;
    }
}
