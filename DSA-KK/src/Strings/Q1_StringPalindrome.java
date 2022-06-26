package Strings;

// Check if the given string after removing all non-alphanumeric chars is palindrome or not
// https://leetcode.com/problems/valid-palindrome/

public class Q1_StringPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abc, dc, b, a"));
    }

    public static boolean isPalindrome(String s) {

        StringBuilder S = new StringBuilder();
        s = s.toLowerCase();
        int n = s.length();

        for (int i=0; i<n; i++) {
            char t = s.charAt(i);
            if ((t >= 97 && t <= 122) || (t >= 48 && t <= 57)) {
                S.append(t);
            }
        }
        // Approach 1 : To compare the string with its reverse
        // return S.toString().equals(S.reverse().toString());

        // Approach 2: Take a start and end pointer and keep on checking
        // the elements until start>end or elements mismatched
        int start = 0, end = S.length() - 1;

        while (start <= end) {
            if (S.charAt(start) == S.charAt(end)) {
                start++;
                end--;
            }
            else
                return false;
        }

        return true;
    }
}
