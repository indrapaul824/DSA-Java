package Practice.Algorithms.SDOT;
import java.util.*;
import utils.Main.*;

public class DigitArray {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println(digitArray(n));
    }

    private static List<Integer> digitArray(int n) {
        List<Integer> digitArray = new ArrayList<>();

        while (n > 0) {
            digitArray.add(0, n%10);
            n /= 10;
        }

        return digitArray;
    }
}
