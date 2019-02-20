/**
 * Product Class to define a product
 * @author Runyu Xu and Jiali Tang
 */
public class Product {

    //attributes field
    private final String name; // name of the product
    private final int ID; // ID of the product
    private final double price; // price of the product

    //constructor to create a product with name, ID and price
    public Product(String name, int ID, double price) {
        this.name = name;
        this.ID = ID;
        this.price = price;
    }

    //getters to get these attributes
    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.ID;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return getID() + " " + getName() + " " + getPrice();
    }
}
