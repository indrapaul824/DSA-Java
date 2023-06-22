package Number_Theory;

import java.util.HashSet;

public class Q2_CountUniqueDigInRange {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int ans = 10, base = 9;

        for (int i = 2; i <= n; i++) {
            base *= (9 - i + 2);
            ans += base;
        }

        return ans;
    }

    public int countInGivenRange(int n, int m) {
        int cnt = 0;
        for (int i = n; i <= m; i++) {
            String s = Integer.toString(i);
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                set.add(s.charAt(j));
            }
            if (set.size() == s.length())
                cnt++;
        }

        return cnt;
    }
}
