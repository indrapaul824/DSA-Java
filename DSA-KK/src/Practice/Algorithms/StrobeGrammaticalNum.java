package Practice.Algorithms;

import java.util.*;

public class StrobeGrammaticalNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to check:");
        String s = in.nextLine();

        System.out.println(checkSGNum(s));

        System.out.println("Enter the num of digits:");
        int n = in.nextInt();
        System.out.println(printNStrobeGrammatical(n, n));
    }

    static boolean checkSGNum(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        char t = s.charAt(0);
        if (s.length() == 1 && map.containsKey(t) && t == map.get(t))
            return true;
        else if (s.length() > 1) {
            StringBuilder S = new StringBuilder(s);
            S.reverse();
            for (int i = 0; i < S.length(); i++) {
                t = S.charAt(i);
                if (!map.containsKey(t))
                    return false;
                S.replace(i, i+1, String.valueOf(map.get(t)));
            }
            return S.toString().equals(s);
        }
        return false;
    }

    static ArrayList<String> printNStrobeGrammatical(int n, int length) {
        if (n == 0)
            return new ArrayList<>(List.of(""));
        if (n == 1)
            return new ArrayList<>(List.of("0", "1", "8"));

        ArrayList<String> middles = printNStrobeGrammatical(n - 2, length);
        ArrayList<String> res = new ArrayList<>();

        for (String mid : middles) {
            if (n != length)
                res.add("0" + mid + "0");
            res.add("1" + mid + "1");
            res.add("8" + mid + "8");
            res.add("6" + mid + "9");
            res.add("9" + mid + "6");
        }

        return res;
    }
}
