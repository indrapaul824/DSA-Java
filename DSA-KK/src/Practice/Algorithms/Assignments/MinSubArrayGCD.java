package Practice.Algorithms.Assignments;

import java.util.*;

public class MinSubArrayGCD {
    static int gcd (int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static int findGCD(int[] arr) {
        int res = arr[0];
        for (int i : arr) {
            res = gcd(res, i);

            if (res == 1)
                return 1;
        }
        return res;
    }

    static int lenMinArray(int[] arr, int n, int g) {
        int m = 2;
        while (m <= n) {
            int i = 0;
            int[] temp = new int[m];
            while (i < n-m) {
                System.arraycopy(arr, i, temp, 0, m);
                if (findGCD(temp) == g)
                    return m;
                i++;
            }
            m++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int g = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(lenMinArray(arr, n, g));
        }
    }
}
