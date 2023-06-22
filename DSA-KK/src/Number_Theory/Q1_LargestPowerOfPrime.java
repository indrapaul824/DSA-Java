package Number_Theory;

public class Q1_LargestPowerOfPrime {
    // Optimal: Legendre’s formula: n/p + n/p^2 + n/p^3 + ....
    static int largestPowerOfPrime(int N, int p) {
        int ans = 0;

        while (N > 0) {
            N /= p;
            ans += N;
        }

        return ans;
    }
}
