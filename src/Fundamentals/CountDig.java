package Fundamentals;

import java.util.Scanner;

public class CountDig {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number:");
        int n = in.nextInt();
        int m = n;
        System.out.println("Enter digit to be counted:");
        int p = in.nextInt();

        int count = 0;
        while (n > 0) {
            int r = n % 10;
            if (r == p) {
                count++;
            }
            n = n / 10;
        }
        System.out.println("The count for " + p + " in " + m + " is: " + count);
    }
}
