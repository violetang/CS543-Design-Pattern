
import java.util.List;

/**
 * SortingUtility class to sort a list of items and return the sorted list
 * without displaying any sorted result
 *
 * @author Runyu and Jiali
 */
public class SortingUtility implements SortingIF {

    private Sort s;
    private List<Product> p;

    public SortingUtility() {
        //do nothing
    }

    //method to sort the list of items
    @Override
    public List<Product> sort(List<Product> items, int sortingApproach) {
        this.p = items;
        if (sortingApproach == 1) { // if choice 1, use bubble sort algorithm
            bubbleSort(items);
        } else if (sortingApproach == 2) { // if choice 2, use quick sort
            quickSort(items);
        }
        return items;
    }

    // buublesort method 
    private void bubbleSort(List<Product> items) {
        s = new BubbleSort();
        s.sort(items);
    }

    // quicksort method
    private void quickSort(List<Product> items) {
        s = new QuickSort();
        s.sort(items);
    }

}
