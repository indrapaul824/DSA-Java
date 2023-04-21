package Practice.Algorithms.PLA1001;

import utils.Main.*;
import java.util.*;

public class MajorityElementArray {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = in.nextInt();
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }
        
    }
}
