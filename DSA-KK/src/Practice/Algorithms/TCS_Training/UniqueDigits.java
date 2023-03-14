package Practice.Algorithms.TCS_Training;
import utils.Main.*;

import java.util.*;

public class UniqueDigits {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int m = in.nextInt();
        int cnt = 0;
        for (int i = n; i <= m; i++) {
            if (unique(i))
                cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean unique(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;
        while (n > 0) {
            int r = n % 10;
            map.put(r, map.getOrDefault(r, 0) + 1);
            n /= 10;
            len++;
        }
        return map.size() == len;
    }
}
