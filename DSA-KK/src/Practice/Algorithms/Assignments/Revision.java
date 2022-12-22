package Practice.Algorithms.Assignments;

import java.util.*;

public class Revision {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = in.nextInt();

        primeSieve(n);

        System.out.println("\nThe Euler's Phi value is: " + eulersPhi(n));
    }

    // Simple Sieve Algorithm for Prime Nums
    public static void primeSieve(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);

        for (int i = 2; i*i <= n; i++) {
            if (prime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        System.out.printf("All prime numbers till %d are:%n", n);
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                System.out.print(i + " ");
        }
        System.out.println();
    }

    // Euler's Phi Function for Co-Prime Nums
    public static int eulersPhi(int n) {
        int count = 0;

        System.out.printf("The possible co-primes of %d are:%n", n);
        for (int i = 1; i < n; i++) {
            if (GCD(i, n) == 1) {
                System.out.print(i + " ");
                count++;
            }
        }

        return count;
    }

    public static int GCD(int a, int b) {
        if (a == 0)
            return b;
        return GCD(b%a, a);
    }
}
