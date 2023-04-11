package Leetcode;

import java.util.ArrayDeque;
import java.util.Stack;

public class RemoveStarsFromString {
    // Using Stack
    public String removeStars_st(String s) {
        var st = new ArrayDeque<Character>();
        for (char ch : s.toCharArray()) {
            if (ch != '*')
                st.push(ch);
            else
                st.poll();
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.poll());
        }

        return sb.toString();
    }

    // Using String Manipulation
    public String removeStars_str(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '*') {
                sb.deleteCharAt(sb.length()-1);
            }
            else {
                sb.append(t);
            }
        }
        return sb.toString();
    }

    // Using Two-Pointer Approach
    public String removeStars(String s) {
        char[] ch = new char[s.length()];
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '*')
                j--;
            else
                ch[j++] = t;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < j; i++)
            sb.append(ch[i]);

        return sb.toString();
    }
}
