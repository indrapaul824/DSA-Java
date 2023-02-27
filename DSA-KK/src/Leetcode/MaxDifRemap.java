package Leetcode;
import utils.Main.*;
public class MaxDifRemap {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = 999;
        System.out.println(minMaxDifference(n));
    }

    public static int minMaxDifference(int num) {
        String n = Integer.toString(num);
        char p = n.charAt(0);
        char q = 'a';
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) != '9') {
                q = n.charAt(i);
                break;
            }
        }
        if (q == 'a')
            return Integer.parseInt(n);
        StringBuilder max = new StringBuilder(), min = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            char t = n.charAt(i);
            if (t == q)
                max.append('9');
            else
                max.append(t);
            if (t == p)
                min.append('0');
            else
                min.append(t);
        }
        System.out.println(max + "\n" + min);
        return Integer.parseInt(max.toString()) - Integer.parseInt(min.toString());
    }
}
