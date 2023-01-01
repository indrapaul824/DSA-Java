package Leetcode;

import utils.Main.*;
import java.util.*;
public class StonePiles {
    public static int minStoneSum(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : piles) {
            sum += i;
            maxHeap.offer(i);
        }
        while (k-- > 0) {
            int b = maxHeap.poll();
            int a = b - b/2;
            sum -= b/2;
            maxHeap.offer(a);
            if (a == 1)
                return piles.length;
        }
        return sum;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int[] a = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = in.nextInt();
        System.out.println(minStoneSum(a, n));
    }
}
