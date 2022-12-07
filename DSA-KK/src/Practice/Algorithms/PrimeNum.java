package Practice.Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = in.nextInt();
        printNPrime(n);

        System.out.print("\nEnter the number for nearest Prime: ");
        n = in.nextInt();
        nearestPrime(n);

        System.out.print("Enter the limit: ");
        n = in.nextInt();
        printPrimeSeries(n);
    }

    // Brute-Force Solution
    public static boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void printNPrime(int n) {
        int count = 0, i = 2;
        while (count < n) {
            if (isPrime(i))
                count++;
            i++;
        }
        System.out.println("The " + n + "th Prime Number is: " + (i-1));
    }

    public static void nearestPrime(int n) {
        int i = n;
        int j = n;
        while (true) {
            if (isPrime(i)) {
                System.out.println("The lower Prime number is: " + i);
                break;
            }
            i--;
        }
        while (true) {
            if (isPrime(j)) {
                System.out.println("The higher Prime number is: " + j);
                break;
            }
            j++;
        }

        if ((n - i) > (j - n))
            System.out.println("The nearest Prime Number is: " + j);
        else if ((n - i) < (j - n))
            System.out.println("The nearest Prime Number is: " + i);
        else
            System.out.println("Since the difference is same, both of the above values are nearest to " + n);
    }

    public static void printPrimeSeries(int n) {
        boolean[] prime = new boolean[n + 1];

        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i*i; j <= n; j += i)
                    prime[j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i])
                System.out.print(i + " ");
        }
    }
}
