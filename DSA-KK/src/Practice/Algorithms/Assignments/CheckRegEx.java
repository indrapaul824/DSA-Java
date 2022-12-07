package Algorithms.Assignments;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegEx {
    public static void checkRegExp(String s, String r) {
        HashMap<Character, Integer> freq = new HashMap<>();
        r = r + " ";
        char[] sArray = s.toCharArray();
        boolean check = false;

        // Storing the frequency of each element of s in freq
        for (char c : sArray)
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        // Checking
        for (int i = 0; i < r.length(); i++) {
            char t = r.charAt(i);
            if (t >= 97 && t <= 122) {
                if (r.charAt(i+1) == '+')
                    check = freq.containsKey(t) && freq.get(t) >= 1;
                else
                    check = freq.containsKey(t) && freq.get(t) == 1;
            }
            if (!check)
                break;
        }
        if (check)
            System.out.println("Matched");
        else
            System.out.println("Does not match");
    }

    static void checkRegEx(String s, String r) {
        s = repeatedChar(s);
    }

    static String repeatedChar(String s)
    {
        StringBuilder S = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            // Counting occurrences of s[i]
            int count = 1;
            while (i + 1 < s.length()
                    && s.charAt(i)
                    == s.charAt(i + 1)) {
                i++;
                count++;
            }
            if (count == 1)
                S.append(Character.toString(s.charAt(i)));
            else
                S.append(Character.toString(s.charAt(i))).append(count);
        }

        return S.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String:");
        String s = in.nextLine(); // ttteeaab
        System.out.println("Enter the RegExp:");
        String r = in.nextLine(); // t+e+a+b

        // Only for strings with simultaneous unique characters
        // Won't work for: ttteeaattb
        checkRegExp(s, r); // print -> Matched

        // Using java.util.regex
        Pattern p = Pattern.compile(r);
        Matcher m = p.matcher(s);
        if (m.matches()) {
            System.out.println("Matched");
        } else {
            System.out.println("Does not match");
        }

        repeatedChar("ttteeaattb");
    }
}
