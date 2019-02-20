
import java.util.List;

/**
 * QuickSort class implements quick sort algorithm
 *
 * @author Runyu Xu
 */
public class QuickSort extends Sort {

    /**
     * sort method implements quickSort algorithm
     *
     * @param p -- the list to sort
     */
    @Override
    public void sort(List<Product> p) {
        quickSort(p, 0, p.size() - 1);
    }

    /**
     * Quick sort method to sort the list in recursions
     *
     * @param p -- the list to sort
     * @param first -- the start index
     * @param last -- the end index
     */
    private void quickSort(List<Product> p, int first, int last) {
        if (first < last) {
            //get the pivot index to divide list in two parts
            int pivIndex = partition(p, first, last);
            quickSort(p, first, pivIndex - 1); // sort left part
            quickSort(p, pivIndex + 1, last); // sort right part
        }
    }

    /**
     * partition method to divide the list
     *
     * @param p -- list to sort
     * @param first -- the first index to sort
     * @param last -- the last index to sort
     * @return the partition of the list
     */
    private int partition(List<Product> p, int first, int last) {
        sortMid(p, first, last); // sort first, mid and last in order
        swap(p, first, (first + last) / 2); // swap first and mid elements
        Product pivot = p.get(first); // get the element on first index
        int head = first; // pointer to go through from head to tail
        int tail = last; //pointer to go through from tail to head
        while (head < tail) {
            while (head < last && pivot.getID() >= p.get(head).getID()) {
                head++;//find the most right index where the ID <= pivot.getID()
            }
            while (pivot.getID() < p.get(tail).getID()) {
                tail--; // find the most left index where the ID > pivot.getID()
            }
           //if head < tail, swap elements on these two indexes, and continue to
           //find the partition
            if (head < tail) {
                swap(p, head, tail);
            }
        }
        //after comparisons, tail will be the correct index to put pivot element
        swap(p, first, tail);
        return tail; // now tail is the partition of the list
    }

    /**
     * sortMid to sort first, mid, and last elements in order
     *
     * @param p -- the list of products
     * @param first -- the first index of the list
     * @param last -- the last index of the list
     * @description: this method is to find the most middle partition of the
     * list to optimize the performance of the sort algorithm (balance left and
     * right sides)
     */
    private void sortMid(List<Product> p, int first, int last) {
        int mid = (first + last) / 2; // get the mid index
        // compare IDs of first product and mid product,
        // make sure ID of first is less than ID of mid
        if (p.get(mid).getID() < p.get(first).getID()) {
            swap(p, first, mid);
        }
        // compare IDs of last product and mid prodcut
        // make sure ID of mid is less than ID of last
        if (p.get(last).getID() < p.get(mid).getID()) {
            swap(p, mid, last);
        }
        // compare IDs of first product and mid product again
        // make sure at last we have ID of first < ID of mid < ID of last
        if (p.get(mid).getID() < p.get(first).getID()) {
            swap(p, first, mid);
        }

    }

    //swap method to swap indexes of two objects
    private void swap(List<Product> p, int index1, int index2) {
        Product temp = p.get(index1);
        p.set(index1, p.get(index2));
        p.set(index2, temp);
    }

    @Override
    public void display(List<Product> p) {
        System.out.println("Using QuickSort to sort the product list: ");
        System.out.printf("%s %12s %11s\n", "Name:", "Price:", "ID:");
        for (Product item : p) {
            System.out.printf("%2s %14.2f %12s", item.getName(),
                    item.getPrice(), item.getID() + "\n");
        }
    }
}
