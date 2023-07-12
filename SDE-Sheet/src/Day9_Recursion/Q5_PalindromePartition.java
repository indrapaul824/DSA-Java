package Day9_Recursion;
import java.util.*;

public class Q5_PalindromePartition {
    private boolean isPalin(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
    private void solve(int ind, String s, List<String> ds, List<List<String>> res) {
        if (ind == s.length()) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPalin(s, ind, i)) {
                ds.add(s.substring(ind, i+1));
                solve(i+1, s, ds, res);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        solve(0, s, ds, res);
        return res;
    }
}
