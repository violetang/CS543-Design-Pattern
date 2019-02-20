import java.util.List;

/**
 * Company class to create a company and let the company run the sorting service
 * @author Runyu Xu and Jiali Tang
 */
public class Company {

    //attributes field
    private String name; // name of the company
    private String address; // address of the company 
    private SortingIF s; // sorting service to use
    private List<Product> products; // list of products to use

    //constructors
    public Company(String name, String address) {
        this.name = name;
        this.address = address;
        this.products = null;
    }

    public Company(String name, String address, List<Product> products) {
        this.name = name;
        this.address = address;
        this.products = products;
    }

    //set service and algorithm to sort products
    public void sortService(SortingIF s,int sortingApproach) {
        this.s = s;
        s.sort(products, sortingApproach);

    }
    //set the list of products
    public void setProducts(List<Product> p) {
        this.products = p;
    }
    //get the list of products
    public List<Product> getProducts() {
        return this.products;
    }
}
