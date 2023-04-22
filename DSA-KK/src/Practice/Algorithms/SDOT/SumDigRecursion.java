package Practice.Algorithms.SDOT;
import utils.Main.*;
public class SumDigRecursion {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println(digSumRec(n));
    }

    static int digSumRec(int n) {
        if (n == 0)
            return 0;
        return n%10 + digSumRec(n/10);
    }
}
