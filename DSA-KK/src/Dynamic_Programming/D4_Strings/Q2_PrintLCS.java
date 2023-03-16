package Dynamic_Programming.D4_Strings;

// https://practice.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1

import java.util.*;

public class Q2_PrintLCS {
    public void print_any_longest_common_subsequence(String s, String t)
    {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int i = n, j = m;
        StringBuilder st = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s.charAt(i-1) == t.charAt(j-1)) {
                st.insert(0, s.charAt(i-1));
                i--;
                j--;
            }
            else if (dp[i-1][j] > dp[i][j-1])
                i--;
            else
                j--;
        }

        System.out.println(st.toString());
    }

    public List<String> all_longest_common_subsequences(String s, String t)
    {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int res = dp[n][m];
        HashSet<String> set = new HashSet<>();
        StringBuilder st = new StringBuilder();
        lcs(s, t, st, 0, 0, set, res);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    private void lcs(String s, String t, StringBuilder st, int i, int j, HashSet<String> set, int res) {
        if (res == 0) {
            set.add(st + "");
            return;
        }

        for (int k = i; k < s.length(); k++) {
            for (int l = j; l < t.length(); l++) {
                if (s.charAt(k) == t.charAt(l)) {
                    st.append(s.charAt(k));
                    lcs(s, t, st, k+1, l+1, set, res-1);
                    st.deleteCharAt(st.length()-1);
                }
            }
        }
    }
}
