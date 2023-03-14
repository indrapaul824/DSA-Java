package Practice.Algorithms.TCS_Training;

import utils.Main.*;
public class AdjacentHeight {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(adjHeight(arr, n));
    }

    private static int adjHeight(int[] arr, int n) {
        int cnt = 0;
        for (int i = 1; i < n-1; i++) {
            if (arr[i] < arr[i-1] && arr[i] > arr[i+1])
                cnt++;
        }
        return cnt;
    }
}
