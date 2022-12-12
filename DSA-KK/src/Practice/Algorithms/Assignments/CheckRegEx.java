package Practice.Algorithms.Assignments;

import java.util.Scanner;

public class CheckRegEx {

    static String repeatedChar(String s)
    {
        StringBuilder S = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            // Counting occurrences of s[i]
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            if (count == 1)
                S.append(s.charAt(i));
            else
                S.append(s.charAt(i)).append(count);
        }

        return S.toString();
    }

    static boolean checkRepeatedChar(String s, String reg) {
        String r = repeatedChar(s);
        if (reg.length() != r.length())
            return false;

        for (int i = 0; i < reg.length(); i++) {
            char t = reg.charAt(i), c = r.charAt(i);
            if (t >= 97 && t <= 122 && t != c)
                return false;
            if (t == '+' && (int)c < 2)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String:");
        String s = in.nextLine(); // ttteeaab
        System.out.println("Enter the RegExp:");
        String r = in.nextLine(); // t+e+a+b

        System.out.println(repeatedChar(s));
        System.out.println(checkRepeatedChar(s, r));
    }
}
