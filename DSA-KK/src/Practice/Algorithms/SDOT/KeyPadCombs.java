package Practice.Algorithms.SDOT;
import utils.Main.*;
import java.util.*;

public class KeyPadCombs {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();

        System.out.println(letterCombinations(Integer.toString(n)));
    }

    private static final String[] KEYS = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

    public static List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<>();
        combination("", digits, 0, ret);
        return ret;
    }

    private static void combination(String prefix, String digits, int ind, List<String> ret) {
        if (ind >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(ind) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, ind + 1, ret);
        }
    }
}
