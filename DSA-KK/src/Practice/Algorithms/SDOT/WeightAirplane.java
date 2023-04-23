package Practice.Algorithms.SDOT;
import utils.Main.*;
public class WeightAirplane {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int t = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println("Case 1 --> Total Amount: " + weightMachine(arr, n, t));
        System.out.println("Case 2 --> Total Amount: " + weightMachine_II(arr, n, t));
    }

    private static int weightMachine(int[] arr, int n, int t) {
        int amount = 0;
        for (int i : arr) {
            if (i <= t)
                amount += 1;
            else
                amount += 2;
        }
        return amount;
    }

    private static int weightMachine_II(int[] arr, int n, int t) {
        int sum = 0;
        for (int i : arr)
            if (i <= t)
                sum += 1;
            else
                sum += i - t;
        return sum;
    }
}
