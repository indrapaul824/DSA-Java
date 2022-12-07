package Practice.Algorithms;

import java.util.Scanner;

public class PrimeFactorsSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();

        System.out.println("The Sum of Prime Factors is: " + sumOfPF(n));
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i*i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static int sumOfPF(int n) {
        int sum = 0;
        System.out.print("The Prime Factors are: ");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                int x = i;
                while (x <= n) {
                    if (n % x == 0) {
                        sum += i;
                        System.out.print(x + ", ");
                    }
                    x = x * i;
                }
            }
        }
        System.out.println(n);
        return sum;
    }
}
