import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class CoffeeProcessorEnvironment implements CoffeeProcessorEnvironmentIF {

    //private static final List<CoffeeIF> record;
    private String CoffeeType;
    private int GringdingTime;
    private int temperature;
    private int holdTemp;
    private int wait;
    private int PowerLED;
    private int TypeLED;
    private double price = 0;
    private CoffeeIF clf;
    private List<CondimentIF> condiments = new ArrayList<>();
    private List<CoffeeIF> records = new ArrayList<>();

    private static final URL[] classPath;
    static{
        try{
            classPath = new URL[]{new URL("file:///bin")};
        }catch(java.net.MalformedURLException e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public void setCoffeeType(String str){
        CoffeeType = str;
        System.out.print("Making " + CoffeeType + ": \n");
    }

    public void setGrindingTime(int secs){
        GringdingTime = secs;
        System.out.print("-Need Grinding " + GringdingTime + " Seconds"+ "\n");
    }

    @Override
    public void addCondiment(CondimentIF type) {
        condiments.add(type);
        System.out.print("-Adding " + type.getCondimentName()+ " +$" + type.getCondimentPrice()+"\n");
    }

    @Override
    public void setTemperature(int degree) {
        temperature = degree;
        System.out.print("-Need Temperature " + temperature + " Degree"+ "\n");
    }

    @Override
    public void holdTemperature(int seconds) {
        holdTemp = seconds;
        System.out.print("-Need hold temperature for " + holdTemp + " Seconds"+ "\n");
    }

    public void wait(int seconds){
        wait = seconds;
        System.out.print("-Need wait " + wait + " Seconds"+ "\n");
    }

    @Override
    public void setPowerLED(int num) {
        PowerLED = num;
        if(PowerLED == 1){
            System.out.print("Coffee Machine powerful on"+ "\n");
        }else
            System.out.print("Coffee Machine powerful off"+ "\n");
    }

    @Override
    public void setTypeLed(int num) {
        TypeLED = num;
        System.out.print("LED type " + num + "\n");
    }

    @Override
    public double computePrice(CoffeeIF clf) {
        //add the coffee price
        price += clf.getCoffeePrice();

        //add the all the condiments price
        for(int i = 0 ; i < condiments.size(); i++){
            price += condiments.get(i).getCondimentPrice();
        }

        return price;
    }

    public void updateRecords(CoffeeIF clf){
        records.add(clf);
    }


    @Override
    public void done() {
        setPowerLED(0);
        setTypeLed(0);

        double cost = computePrice(clf);
        System.out.print("Charge: $ " + cost+ "\n");

        updateRecords(clf);
        price = 0;
        while(!condiments.isEmpty()){
            condiments.clear();
        }
    }

    public void run(String programName){
        URLClassLoader classLoader;
        classLoader = new URLClassLoader(classPath);
        Class programClass;
        try{
            programClass = classLoader.loadClass(programName);
        }catch(ClassNotFoundException e){
            return;
        }
        try{
            clf = (CoffeeIF)programClass.newInstance();
        }catch(Exception e){
            return;
        }
        clf.setCoffeEnvironment(this);
        System.out.print("\n");
        clf.start();
    }

    public void displayRecord(){
        System.out.println("\n");
        System.out.println("---------sold coffee records---------");
        for(int i = 0 ; i < records.size(); i++){
            System.out.println(records.get(i).getCoffeeType());
        }
    }

}
