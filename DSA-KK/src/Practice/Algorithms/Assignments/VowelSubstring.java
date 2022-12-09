package Practice.Algorithms.Assignments;

import java.util.*;

public class VowelSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = in.nextLine();
        String vowel = "aeiou";
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        int j = 5, n = s.length();

        for (int i = 0; i < n; i++) {
            char t = s.charAt(i);
            if (vowel.indexOf(t) != -1)
                set.add(s.charAt(i));
            else
                set.clear();
            if (set.size() == 5)
                count++;
        }

        System.out.println(count);
    }
}
