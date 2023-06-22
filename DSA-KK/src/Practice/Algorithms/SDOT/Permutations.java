package Practice.Algorithms.SDOT;
import utils.Main.*;
import java.util.*;


public class Permutations {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String s = in.nextLine();
        char[] arr = s.toCharArray();

        List<String> list = new ArrayList<>();
        permutations(0, arr, list);
        for (String c : list)
            System.out.println(c);
    }

    private static void permutations(int ind, char[] arr, List<String> list) {
        if (ind == arr.length) {
            list.add(Arrays.toString(arr));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            swap(i, ind, arr);
            permutations(ind+1, arr, list);
            swap(i, ind, arr);
        }
    }

    private static void swap(int i, int ind, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[ind];
        arr[ind] = temp;
    }
}
