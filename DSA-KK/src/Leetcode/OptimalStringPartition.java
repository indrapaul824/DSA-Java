package Leetcode;
import java.util.*;

// https://leetcode.com/problems/optimal-partition-of-string/

public class OptimalStringPartition {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int n = 1;
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (set.contains(t)) {
                n++;
                set.clear();
                set.add(t);
            }
            else
                set.add(t);
        }
        return n;
    }
}
