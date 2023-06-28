package Sliding_Window;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
// https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

import java.util.HashMap;
import java.util.Map;

public class Q3_CountAnagramOccurences {
    public int countAnagrams(String pat, String txt) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pat.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int i = 0, j = 0, k = pat.length(), cnt = map.size();

        while (j < txt.length()) {
            // Anagram computation
            char t = txt.charAt(j);
            if (map.containsKey(t)) {
                map.put(t, map.get(t) - 1);
                if (map.get(t) == 0)
                    cnt--;
            }

            // Make Window
            if (j-i+1 < k)
                j++;

            // Window formed
            else  {
                if (cnt == 0)
                    ans++;
                char p = txt.charAt(i);
                if (map.containsKey(p)) {
                    map.put(p, map.get(p) + 1);
                    if (map.get(p) == 1)
                        cnt++;
                }

                i++;
                j++;
            }
        }

        return ans;
    }
}
