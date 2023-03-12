package Practice.Algorithms.TCS_Training;
import utils.Main.*;
import java.util.*;
public class Segregate01 {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(segregate(arr)));
    }

    private static int[] segregate(int[] arr) {
        int c = 0;
        for (int i : arr)
            if (i == 0)
                c++;

        for (int i = 0; i < arr.length; i++) {
            if (c > 0) {
                arr[i] = 0;
                c--;
            }
            else
                arr[i] = 1;
        }
        return arr;
    }
}
