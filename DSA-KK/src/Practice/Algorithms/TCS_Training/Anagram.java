package Practice.Algorithms.TCS_Training;
import utils.Main.*;
import java.util.*;
public class Anagram {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String s1, s2;
        System.out.println("Enter two strings:");
        s1 = in.nextLine();
        s2 = in.nextLine();
        if (s1.length() != s2.length()) {
            System.out.println("Not Equal");
            return;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char t = s2.charAt(i);
            if (map.containsKey(t)) {
                if (map.get(t) > 0)
                    map.put(t, map.get(t) - 1);
                if (map.get(t) == 0)
                    map.remove(t);
            }
        }
        if (map.isEmpty())
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }
}
