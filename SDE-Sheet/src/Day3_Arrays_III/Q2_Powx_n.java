package Day3_Arrays_III;

public class Q2_Powx_n {
    private double pow(double x, long n) {
        double ans = 1.0;
        while (n > 0) {
            if (n%2 == 0) {
                n /= 2;
                x *= x;
            }
            else {
                ans *= x;
                n -= 1;
            }
        }

        return ans;
    }
    public double myPow(double x, int n) {
        long N = (long) n;
        if (n < 0)
            N = -1 * N;

        if (n < 0)
            return (double)1 / pow(x, N);

        return pow(x, N);
    }
}
