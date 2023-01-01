package Leetcode;

import utils.Main.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BuddyStrings {
    public static boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (n != goal.length())
            return false;
        int count = 0;
        StringBuilder sb = new StringBuilder(), gb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                sb.append(s.charAt(i));
                gb.insert(0, goal.charAt(i));
            }
        }

        if (count == 2) {
            return sb.compareTo(gb) == 0;
        }
        else if (count == 0) {
            Map<Character, Integer> d = new HashMap<Character, Integer>();
            for (int i = 0; i < n; i++) {
                if (d.containsKey(s.charAt(i)))
                    d.put(s.charAt(i), d.get(s.charAt(i)) + 1);
                else
                    d.put(s.charAt(i), 1);
                if (d.get(s.charAt(i)) > 1)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();

        String s = in.nextLine();
        String goal = in.nextLine();

        System.out.println(buddyStrings(s, goal));
    }
}
