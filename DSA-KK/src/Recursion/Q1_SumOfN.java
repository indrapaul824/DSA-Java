package Recursion;

import java.util.Scanner;

public class Q1_SumOfN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        sum(n, 0);
        System.out.println(sum(n));
    }

    // Parameterized Way
    static void sum(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }

        sum(i - 1, sum + i);
    }

    // Functional Way
    static int sum(int n) {
        if (n == 0)
            return 0;

        return n + sum(n-1);
    }
}
