public interface CoffeeProcessorEnvironmentIF {

    public void setCoffeeType(String str);
    public void setGrindingTime(int secs);
    public void addCondiment(CondimentIF type);
    public void setTemperature(int degree);
    public void holdTemperature(int seconds);
    public void wait(int seconds);
    public void setPowerLED(int num);
    public void setTypeLed(int num);
    public double computePrice(CoffeeIF clf);
    public void updateRecords(CoffeeIF clf);
    public void done();
    public void displayRecord();

}
