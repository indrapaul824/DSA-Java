package Fundamentals;

import java.util.Scanner;

public class NumReverse {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = in.nextInt();
        int m = n, rev = 0;
        while (n > 0) {
            int r = n % 10;
            rev = rev * 10 + r;
            n = n / 10;
        }
        System.out.println("The reverse of " + m + " is: " + rev);
    }
}
