package Arrays;
import java.util.*;

public class Q3_LeadersArray {
    static ArrayList<Integer> leaders(int arr[], int n){
        int max = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                list.add(arr[i]);
            }
        }
        Collections.reverse(list);

        return list;
    }
}
