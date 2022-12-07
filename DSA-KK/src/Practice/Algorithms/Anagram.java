package Practice.Algorithms;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two strings: ");
        System.out.print("1 - ");
        String a = in.nextLine();
        System.out.print("2 - ");
        String b = in.nextLine();

        if (checkAnagram(a, b))
            System.out.println("Anagram to each other");
        else
            System.out.println("NOT Anagram to each other");
    }

    public static String sortString(String s) {
        char[] chr = s.toCharArray();
        Arrays.sort(chr);
        return new String(chr);
    }

    public static boolean checkAnagram(String a, String b) {
        if (a.length() == b.length()) {
            a = sortString(a);
            b = sortString(b);

            return a.equals(b);
        }
        return false;
    }
}
