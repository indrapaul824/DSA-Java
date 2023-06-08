package Day2_Arrays_II;
import java.util.*;

public class Q5_RepeatingMissingNumber {
    // Optimal Solution 1 : Maths-based
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long n = A.size();

        long s = 0;
        long s2 = 0;

        for (int x : A) {
            s += x;
            s2 += (long) x * x;
        }

        long sn = n * (n + 1) / 2;
        long s2n = sn * (2 * n + 1) / 3;

        long sub = s - sn;
        long add = (s2 - s2n);
        add /= sub;

        int b = (int) ((sub + add) / 2);
        int a = (int) (b - sub);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(b);
        ans.add(a);
        return ans;
    }

    // Optimal Solution 2 - XOR-based
    public ArrayList<Integer> repeatedNumber_xor(final List<Integer> A) {
        long n = A.size();

        // Take XOR of array and value range
        int xr = 0;
        for (int i = 0; i < n; i++) {
            xr ^= A.get(i);
            xr ^= (i+1);
        }

        // Find difference bit position (bit == 1)
        int bitNo = 0;
        while ((xr & (1 << bitNo)) == 0) {
            bitNo++;
        }

        // Seggregate the array and value range into 0 or 1 bit
        int zero = 0, one = 0;

        for (int i = 0; i < n; i++) {
            // # Array Nums
            // Part of 1
            if ((A.get(i) & (1 << bitNo)) != 0)
                one ^= A.get(i);
                // Part of 0
            else
                zero ^= A.get(i);

            // Value range
            // Part of 1
            if (((i+1) & (1 << bitNo)) != 0)
                one ^= (i+1);
                // Part of 0
            else
                zero ^= (i+1);
        }

        // Count zero in array: if cnt == 2 -> zero is repeating else -> zero is missing
        int cnt = 0;
        for (Integer integer : A)
            if (integer == zero) cnt++;

        ArrayList<Integer> ans = new ArrayList<>();

        if (cnt == 2) {
            ans.add(zero);
            ans.add(one);
        }
        else {
            ans.add(one);
            ans.add(zero);
        }
        return ans;
    }
}
