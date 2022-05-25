package Arrays.Searching.LinearS;

// Q 1: Search a specific target(char) in a String.

import java.util.Arrays;

public class Q1_StringSearch {
    public static void main(String[] args) {
        String name = "Indra";
        char target = 'r';
        System.out.println(stringSearch(name, target));
        System.out.println(stringSearch1(name, target));
    }

    public static boolean stringSearch(String str, char target) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean stringSearch1(String str, char target) {
        if (str.length() == 0) {
            return false;
        }
        System.out.println(Arrays.toString(str.toCharArray()));
        for (char ch : str.toCharArray()) {
            if (ch == target) {
                return true;
            }
        }
        return false;
    }
}
