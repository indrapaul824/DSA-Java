package Arrays.Searching.BinaryS;

import java.util.*;

public class Q19_AggressiveCows {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n,c;
        while (t>0) {
            n = in.nextInt();
            c = in.nextInt();

            int[] stalls = new int[n];

            for (int i = 0; i < n; i++) {
                stalls[i] = in.nextInt();
            }
            System.out.println(distributeCows(stalls, n, c));
            t--;
        }
    }

    public static int distributeCows(int[] stalls, int n, int c) {
        Arrays.sort(stalls);
        int start = 0, end = stalls[n-1] - stalls[0];

        while (start < end) {
            // Compute mid value
            int mid = start + (end - start) / 2;

            // pos --> Current index of the stalls
            // num_cows --> Current number of allocated cows: initial 1, since we assume that a cow has
            // already been placed at the 0th position of indexes
            int pos = 0, num_cows = 1;

            // Calculate the number cows possible to allocate with the current min_dist/mid-value
            for (int i = 1; i < n; i++) {
                if (stalls[pos]+mid <= stalls[i]) {
                    pos = i;
                    num_cows++;
                }
            }

            // Reducing search space by eliminating redundant possibilities
            if (num_cows < c)
                // At most num_cows < c, so min_dist needs to be reduced to accomodate 'c' cows
                // OR -> since the current mid can allow at most num_cows, higher values will never
                // allow more than what it already does, so discard the right side
                end = mid - 1;

            else
                // At most num_cows >= c, so min_dist might be an answer.
                // But, we can't confirm if it's the largest min_dist. Since we are trying to find
                // the max value of mid, so we will discard the left side in this case since they
                // will always allow more cows but that will reduce the distance dist.
                start = mid + 1;
        }
        System.out.println(start+", "+end);
        return start;
    }
}
