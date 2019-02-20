
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Main class to test proxy and utility class
 *
 * @author Runyu and Jiali
 */
public class Main {

    public static void main(String[] args) {
        List<Product> items = genrateList();

        Company ABC = new Company("ABC", "San Marcos", items);
        System.out.println("******************************************");
        System.out.println("The orignal list of items is: ");
        System.out.println(ABC.getProducts());
        System.out.println("******************************************");

        //Using sorting proxy and quick sort to sort and display the list
        System.out.println("test sorting proxy with quick sort");
        SortingIF service = new SortingServiceProxy();
        ABC.sortService(service, 2);

        //Using sorting proxy and bubble sort to sort and display the list
        System.out.println("******************************************");
        items = genrateList();
        ABC.setProducts(items);
        System.out.println("The orignal list of items is: ");
        System.out.println(ABC.getProducts());
        System.out.println("******************************************");
        System.out.println("test sorting proxy with bubble sort:");
        ABC.sortService(service, 1);
        //System.out.println(ABC.getProducts());

        System.out.println("******************************************");
        System.out.println("test sorting Utility:");
        service = new SortingUtility();

        System.out.println("The orignal list of items is: ");
        items = genrateList();
        ABC.setProducts(items);
        System.out.println(ABC.getProducts());
        ABC.sortService(service, 1);
        System.out.println("After sorting: ");
        System.out.println(ABC.getProducts());
    }

    private static List<Product> genrateList() {
        String names = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        //create some products and add to list
        List<Product> items = new ArrayList();
        int totalNum = 10;
        for (int i = 0; i < totalNum; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(names.charAt(r.nextInt(names.length())));
            String name = sb.toString();
            int ID = r.nextInt(50);
            double price = 0.0 + (r.nextDouble() * (100.0 - 0.0));
            price = (double) Math.round(price * 100) / 100;
            items.add(new Product(name, ID, price));
        }
        return items;
    }
}
