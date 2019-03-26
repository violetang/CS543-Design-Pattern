public class Vanilla implements CondimentIF {
    private String name = "Vanilla";
    private double price = 0.50;

    @Override
    public double getCondimentPrice() {
        return price;
    }

    public String getCondimentName() {
        return name;
    }
}
