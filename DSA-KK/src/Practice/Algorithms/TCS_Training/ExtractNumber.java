package Practice.Algorithms.TCS_Training;

import utils.Main.*;
public class ExtractNumber {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String s = in.nextLine();
        s = s.replaceAll("[^0-9]", " ");
        s = s.trim();
        s = s.replaceAll(" + ", " ");
        if (s.equals("")) {
            System.out.println("-1");
            return;
        }
        int max = 0;
        for (String S : s.split(" ")) {
            if (!S.contains("9")) {
                max = Math.max(max, Integer.parseInt(S));
            }
        }
        System.out.println(max);
    }
}
