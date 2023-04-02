package Leetcode;

public class MaxCostSubstring {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int max = 0;
        int sum = 0;
        for (int j = 0; j < s.length(); j++) {
            char t = s.charAt(j);
            int n = chars.indexOf(t);
            if (n == -1)
                sum += (int)t - 96;
            else
                sum += vals[n];
            if (sum < 0)
                sum = 0;
            max = Math.max(max, sum);
        }

        return max;
    }
}
