package Dynamic_Programming.D6_LIS;
import java.util.*;

// https://leetcode.com/problems/longest-string-chain/

public class Q5_LongestStringChain {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        // Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPossible(words[i], words[j]) && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public boolean isPossible(String s1, String s2) {
        if (s1.length() != s2.length() + 1)
            return false;
        int i = 0, j = 0;
        while (i < s1.length()) {
            if (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            else
                i++;
        }
        return i == s1.length() && j == s2.length();
    }
}
