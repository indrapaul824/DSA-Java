package Fundamentals.Methods;

import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(isPrime(n));

        for (int i = 100; i < 1000; i++) {
            if (isArmstrong(i)) {
                System.out.println(i);
            }
        }
    }

    // Print all the 3-digit Armstrong numbers
    static boolean isArmstrong(int n) {
        int sum = 0;
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit * digit * digit;
            temp /= 10;
        }
        if (sum == n) {
            return true;
        }
        return false;
    }

    // Check Prime number
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }

        return (c * c > n);
    }
}
