
import java.util.List;

/**
 * BubbleSort class implements bubble sort algorithm
 *
 * @author Jiali Tang
 */
public class BubbleSort extends Sort {

    /**
     * sort method implements bubbleSort algorithm
     * @param p -- the list to sort
     */
    @Override
    public void sort(List<Product> p) {
        int n = p.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (p.get(j).getID() > p.get(j + 1).getID()) {
                    Product temp = p.get(j);
                    p.set(j, p.get(j + 1));
                    p.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public void display(List<Product> p) {
        System.out.println("Using BubbleSort to sort the product list: ");
        System.out.printf("%s %12s %11s", "ID:", "Name:", "Price: \n");
        p.stream().forEach((item) -> {
            System.out.printf("%-2s %10s %12s", item.getID(),
                    item.getName(), item.getPrice() + "\n");
        });
    }
}
