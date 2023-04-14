package Dynamic_Programming.D7_MCM;
import java.util.*;

public class Q4_ParseBoolExp {

    // Recursive Approach
    public int parseBoolExpr(String expression) {
        char[] ch = expression.toCharArray();
        return parse(0, ch.length-1, 1, ch);
    }

    private static int parse(int i, int j, int isTrue, char[] ch) {
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue == 1)
                return ch[i] == 'T' ? 1 : 0;
            else
                return ch[i] == 'F' ? 1 : 0;
        }
        int ways = 0;
        for (int ind = i+1; ind <= j-1; ind+=2) {
            int LT = parse(i, ind - 1, 1, ch);
            int LF = parse(i, ind - 1, 0, ch);
            int RT = parse(ind + 1, j, 1, ch);
            int RF = parse(ind + 1, j, 0, ch);

            if (ch[ind] == '&') {
                if (isTrue == 1)
                    ways += LT * RT;
                else
                    ways += LT*RF + LF*RT + LF*RF;
            }
            else if (ch[ind] == '|') {
                if (isTrue == 1)
                    ways += LT*RF + LF*RT + LT*RT;
                else
                    ways += LF*RF;
            }
            else {
                if (isTrue == 1)
                    ways += LT*RF + LF*RT;
                else
                    ways += LF*RF + LT*RT;
            }
        }

        return ways;
    }


    // DP-1: Memoization
    public int parseBoolExpr_mem(String expression) {
        char[] ch = expression.toCharArray();
        int n = ch.length;
        int[][][] dp = new int[n][n][2];
        Arrays.stream(dp).forEach(a -> Arrays.stream(a).forEach(d -> Arrays.fill(d, -1)));
        return parse(0, n-1, 1, ch, dp);
    }

    private static int parse(int i, int j, int isTrue, char[] ch, int[][][] dp) {
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue == 1)
                return ch[i] == 'T' ? 1 : 0;
            else
                return ch[i] == 'F' ? 1 : 0;
        }

        if (dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];
        int ways = 0;
        for (int ind = i+1; ind <= j-1; ind+=2) {
            int LT = parse(i, ind - 1, 1, ch, dp);
            int LF = parse(i, ind - 1, 0, ch, dp);
            int RT = parse(ind + 1, j, 1, ch, dp);
            int RF = parse(ind + 1, j, 0, ch, dp);

            if (ch[ind] == '&') {
                if (isTrue == 1)
                    ways += (LT * RT) % 1003;
                else
                    ways += (LT*RF) % 1003 + (LF*RT) % 1003 + (LF*RF) % 1003;
            }
            else if (ch[ind] == '|') {
                if (isTrue == 1)
                    ways += (LT*RF) % 1003 + (LF*RT) % 1003 + (LT*RT) % 1003;
                else
                    ways += (LF*RF) % 1003;
            }
            else {
                if (isTrue == 1)
                    ways += (LT*RF) % 1003 + (LF*RT) % 1003;
                else
                    ways += (LF*RF) % 1003 + (LT*RT) % 1003;
            }
        }

        return dp[i][j][isTrue] = ways % 1003;
    }

    // DP-2: Tabulation
    public int parseBoolExpr_tab(String expression) {
        char[] ch = expression.toCharArray();
        int n = ch.length;
        int[][][] dp = new int[n][n][2];

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i > j) continue;
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    if (i == j) {
                        if (isTrue == 1)
                            dp[i][j][1] = ch[i] == 'T' ? 1 : 0;
                        else
                            dp[i][j][0] =  ch[i] == 'F' ? 1 : 0;
                        continue;
                    }
                    int ways = 0;
                    for (int ind = i + 1; ind <= j - 1; ind += 2) {
                        int LT = dp[i][ind - 1][1];
                        int LF = dp[i][ind - 1][0];
                        int RT = dp[ind + 1][j][1];
                        int RF = dp[ind + 1][j][0];

                        if (ch[ind] == '&') {
                            if (isTrue == 1)
                                ways += (LT * RT) % 1003;
                            else
                                ways += (LT * RF) % 1003 + (LF * RT) % 1003 + (LF * RF) % 1003;
                        } else if (ch[ind] == '|') {
                            if (isTrue == 1)
                                ways += (LT * RF) % 1003 + (LF * RT) % 1003 + (LT * RT) % 1003;
                            else
                                ways += (LF * RF) % 1003;
                        } else {
                            if (isTrue == 1)
                                ways += (LT * RF) % 1003 + (LF * RT) % 1003;
                            else
                                ways += (LF * RF) % 1003 + (LT * RT) % 1003;
                        }
                    }

                    dp[i][j][isTrue] = ways % 1003;
                }
            }
        }

        return dp[0][n-1][1];
    }
}
