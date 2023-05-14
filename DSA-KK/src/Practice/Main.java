package Practice;

import java.util.*;

public class Main {
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(Arrays.toString(circularGameLosers(5, 2)));
    }

    public static int[] circularGameLosers(int n, int k) {
        int[] cnt = new int[n];
        int p = 1;

        cnt[0] = 1;
        int i = p*k % n;
        while (true) {
            cnt[i] += 1;

            if (cnt[i] == 2)
                break;
            p++;
            i += ((p*k) % n);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (cnt[j] == 0)
                list.add(j+1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
