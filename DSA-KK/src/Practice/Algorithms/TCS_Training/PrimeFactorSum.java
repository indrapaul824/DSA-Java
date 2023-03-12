package Practice.Algorithms.TCS_Training;

import utils.Main.*;
import java.util.*;

public class PrimeFactorSum {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        countPrimeFactors(n);
    }

    static void countPrimeFactors(int N)
    {

        // Stores the count of
        // prime factors
        int count = 0;

        // Stores whether a number
        // is prime or not
        boolean[] prime = new boolean[N + 1];

        // Mark all as true initially
        Arrays.fill(prime, true);

        // Sieve of Eratosthenes
        for (int p = 2; p * p <= N; p++) {
            if (prime[p]) {

                // Update all subsequent multiples
                for (int i = p * p; i <= N; i += p)
                    prime[i] = false;
            }
        }

        // Traverse in the range [2, N]
        for (int p = 2; p <= N; p++) {

            // If prime
            if (prime[p]) {

                // Increment the count
                count++;
            }
        }

        // Print the count
        System.out.print(count);
    }
}
