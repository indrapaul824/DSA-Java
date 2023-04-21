package Practice.Algorithms.PLA1001;

import java.util.Scanner;

public class EulersGCD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (GCD(i, n) == 1) {
                count++;
                System.out.println(i);
            }
        }

        System.out.println("The Euler's Phi Number is: " + count);
    }

    private static int GCD(int a, int b) {
        if (a == 0)
            return b;
        return GCD(b % a, a);
    }
}
