package Recursion;

import utils.Main.*;
public class Q4_PalindromeCheck {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String s = in.nextLine();
        System.out.println(checkPalin(0, s));
    }

    static boolean checkPalin(int i, String s) {
        if (i >= s.length()-1)
            return true;
        if (s.charAt(i) != s.charAt(s.length() - i - 1))
            return false;

        return checkPalin(i+1, s);
    }
}
