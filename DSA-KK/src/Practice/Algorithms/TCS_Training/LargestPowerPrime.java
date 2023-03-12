package Practice.Algorithms.TCS_Training;
import utils.Main.*;

public class LargestPowerPrime {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n, p;
        n = in.nextInt();
        p = in.nextInt();
        System.out.println(largestPower(n, p));
    }

    private static int largestPower(int n, int p) {
        int f = 0;
        while (n > 0) {
            n /= p;
            f += n;
        }
        return f;
    }
}
