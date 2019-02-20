
import java.util.List;

/**
 * SortingServiceProxy is a proxy of SortingUtility that sort and display the
 * list of items
 *
 * @author Runyu Xu and Jiali Tang
 * 
 */
public class SortingServiceProxy implements SortingIF {
    //attributes fields
    private Sort s; // the sort algorithm to use
    private SortingIF ss; //create a sortingUtility object 

    public SortingServiceProxy() {
        this.ss = new SortingUtility();
    }

    @Override
    public List<Product> sort(List<Product> items, int sortingApproach) {
        /* if (sortingApproach == 1) {
         s = new BubbleSort();
         s.sort(items);
         } else {
         s = new QuickSort();
         s.sort(items);
         }
         s.display(items);
         return items;*/
        ss.sort(items, sortingApproach);//sort the list of items
        //based on the sort algorithm, display info of items in different order
        if (sortingApproach == 1) {
            s = new BubbleSort();
        } else if (sortingApproach == 2) {
            s = new QuickSort();
        }
        s.display(items);
        return items;
    }
}
