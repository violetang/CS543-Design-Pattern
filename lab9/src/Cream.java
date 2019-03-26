public class Cream implements CondimentIF {
    private String name = "Cream";
    private double price = 0.25;

    @Override
    public double getCondimentPrice() {
        return price;
    }

    public String getCondimentName() {
        return name;
    }
}
