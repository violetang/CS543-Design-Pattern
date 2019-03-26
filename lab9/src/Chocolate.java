public class Chocolate implements CondimentIF {
    private String name = "Chocolate";
    private double price = 1.00;

    @Override
    public double getCondimentPrice() {
        return price;
    }

    public String getCondimentName() {
        return name;
    }
}
