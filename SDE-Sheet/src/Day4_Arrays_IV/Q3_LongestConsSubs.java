package Day4_Arrays_IV;
import java.util.*;

public class Q3_LongestConsSubs {
    // Better -> O(N logN + N)
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int cntCurr = 0, lastSmaller = Integer.MIN_VALUE, longest = 1;

        for (int n : nums) {
            if (n-1 == lastSmaller)
                cntCurr++;
            else if (n != lastSmaller)
                cntCurr = 1;
            lastSmaller = n;
            longest = Math.max(longest, cntCurr);
        }

        return longest;
    }

    // Optimal -> O(N)
    public int longestConsecutive_opt(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);
        int longest = 1;
        for (int n : set) {
            if (!set.contains(n-1)) {
                // n -> Possible Starting Point
                int cnt = 1;
                while (set.contains(++n))
                    cnt++;
                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,1};
        System.out.println(longestConsecutive(arr));
    }
}
