package Practice.Algorithms.SDOT;
import java.util.*;
import utils.Main.*;
// Input 1: 5 -> 7, 4, 8, 2, 9
// Input 2: 5 -> 3, 4, 5, 8, 9
// Input 3: 6 -> 7, 5, 6, 2, 9, 9
public class CountLeadersElements {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        var list = new ArrayList<Integer>();
        int max = arr[0];
        list.add(arr[0]);
        for (int i : arr) {
            if (i > max) {
                max = i;
                list.add(i);
            }
        }
        System.out.println(list);
        System.out.println(list.size());
    }
}
