package Practice.Algorithms.SDOT;
import utils.Main.*;
import java.util.*;

public class HireChefMeatball {
    static class Pair {
        int val, ind;

        public Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int d = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(hireBestChef(arr, n, d));
        System.out.println(hireBest_Jugaad(arr, n, d));
    }

    private static int hireBest_Jugaad(int[] arr, int n, int d) {
        int max = arr[0], max_i = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                max_i = i;
            }
        }
        return max_i+1;
    }

    private static int hireBestChef(int[] arr, int n, int d) {
        Queue<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Pair(arr[i], i));
        }
        while (queue.size() != 1) {
            Pair p = queue.poll();
            if ((p.val - d) >= d)
                queue.offer(new Pair(p.val-d, p.ind));
        }
        return queue.peek().ind + 1;
    }


}
