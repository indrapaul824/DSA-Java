package Day4_Arrays_IV;
import java.util.*;

public class Q6_LongestSubStrNoRepeat {
    // Better
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, len = 0;

        while (r < s.length()) {
            char t = s.charAt(r);

            while (set.contains(t)) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(t);
            len = Math.max(len, r-l+1);
            r++;
        }

        return len;
    }

    // Optimal: O(N)
    public int lengthOfLongestSubstring_op(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, len = 0;

        while (r < s.length()) {
            char t = s.charAt(r);

            if (map.containsKey(t) && map.get(t) >= l) {
                l = map.get(t) + 1;
            }

            map.put(t, r);
            len = Math.max(len, r-l+1);
            r++;
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
