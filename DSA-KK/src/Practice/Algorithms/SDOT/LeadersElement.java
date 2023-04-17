package Practice.Algorithms.SDOT;
import utils.Main.*;

import java.util.ArrayList;

public class LeadersElement {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        var list = new ArrayList<Integer>();
        int max = arr[n-1];
        list.add(max);
        for (int i = n-1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                list.add(max);
            }
        }
        System.out.println(list.size());
        System.out.println(list);
    }
}
