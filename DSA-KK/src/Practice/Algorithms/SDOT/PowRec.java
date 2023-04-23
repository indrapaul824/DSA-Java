package Practice.Algorithms.SDOT;
import utils.Main.*;

public class PowRec {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int x = in.nextInt();
        System.out.println(power(n, x));
    }

    private static int power(int n, int x) {
        if (x == 0)
            return 1;
        return n * power(n, x-1);
    }
}
