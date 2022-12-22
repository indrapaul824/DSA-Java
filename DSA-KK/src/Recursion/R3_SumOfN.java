package Recursion;

import java.util.Scanner;

public class R3_SumOfN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        sum(n, 0);
    }

    // Parameterized Way
    static void sum(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }

        sum(i - 1, sum + i);
    }
}
