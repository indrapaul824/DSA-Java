package Recursion;

import utils.Main.*;
import java.util.*;

public class Q16_PalinPart {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String s = in.nextLine();
        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        palinPartition(0, s, ds, res);
        return res;
    }

    private static void palinPartition(int ind, String s, List<String> ds, List<List<String>> res) {
        if (ind == s.length()) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPalin(s, ind, i)) {
                ds.add(s.substring(ind, i+1));
                palinPartition(i+1, s, ds, res);
                ds.remove(ds.size()-1);
            }
        }
    }

    private static boolean isPalin(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
