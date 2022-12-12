package Practice.Algorithms;

import java.util.*;

public class SuperASCII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = in.nextLine();

        System.out.println("Is it Super ASCII? " + superASCII(s));
        System.out.println("Is it Super ASCII? " + superASCII_SO(s));
    }


    private static boolean superASCII(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            freq.put(t, freq.getOrDefault(t, 0) + 1);
        }
        for (int i = 0; i < freq.size(); i++) {
            if (freq.get((char)(97+i)) != i+1)
                return false;
        }

        return true;
    }

    private static boolean superASCII_SO(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i += p) {
            char t = s.charAt(i);
            char c = (char) ('a' + p);
            p++;
            if (t != c || !s.substring(i, p+i).equals(String.valueOf(c).repeat(p)))
                return false;
        }

        return true;
    }
}
