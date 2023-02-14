package Leetcode;

public class Subsequence {
    public static void main(String[] args) {
        String s = "";
        String t = "";
        System.out.println(isSubsequence(s, t));
    }
    public static boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            int tc = t.charAt(i);
            if (j < s.length() && tc == s.charAt(j))
                j++;
            if (j >= s.length())
                return true;
        }

        return false;
    }
}
