package Algorithms.SurpriseTest;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int n = in.nextInt();
        int first = 1;
        int second = (n * n) + 1;

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (j == i)
                    System.out.print((first));
                else
                    System.out.print((first) + "*");
                first++;
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("*" + second++);
            }
            System.out.println();

            second = second - 1 - ((i - 1) * 2);
        }
    }
}
