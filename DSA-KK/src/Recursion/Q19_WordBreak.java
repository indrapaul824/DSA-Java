package Recursion;
import java.util.*;

public class Q19_WordBreak {
    private int solve(int ind, String s, Set<String> set, int[] dp) {
        if (ind == s.length())    return 1;
        if (dp[ind] != -1)    return dp[ind];

        for (int i = ind; i < s.length(); i++) {
            if (set.contains(s.substring(ind, i+1)) && solve(i+1, s, set, dp) == 1)
                return dp[i] = 1;
        }
        return dp[ind] = 0;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return solve(0, s, set, dp) == 1;
    }
}
