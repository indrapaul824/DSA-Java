package Practice.Algorithms.TCS_Training;

import utils.Main.*;

public class CountFakePalin {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String s = in.nextLine();
        s = s.toLowerCase();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sub = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sub.append(s.charAt(j));
                if (sub.length() == 1 || canFormPalin(sub.toString())) {
                    System.out.println(sub.toString());
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static boolean canFormPalin(String s) {
        int bit_v = 0, mask = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            mask = 1 << x;
            bit_v = bit_v ^ mask;
        }
        return (bit_v & (bit_v - 1)) == 0;
    }
}
