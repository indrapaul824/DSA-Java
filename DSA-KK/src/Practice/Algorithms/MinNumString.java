package Practice.Algorithms;

import java.util.*;

public class MinNumString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = in.nextLine();

        System.out.println(minNum(s));
    }

    private static int minNum(String s) {
        int n, min = Integer.MAX_VALUE;

        for (int i = 0; i < s.length();) {
            char t = s.charAt(i);
            if (Character.isDigit(t)) {
                int c = i+1;
                StringBuilder r = new StringBuilder("" + t);
                while (Character.isDigit(s.charAt(c))) {
                    r.append(s.charAt(c));
                    c++;
                }

                n = Integer.parseInt(r.toString());
                if (n < min)
                    min = n;
                i = c;
            }
            else
                i++;
        }

        return min;
    }
}
