package Algorithms.Assignments;

import java.util.*;
public class FindNthElement {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the position:");
        int n = in.nextInt();

        while (n != -1) {
            System.out.printf("The number at %dth position is: ", n);
            if (n % 2 == 0) {
                n = n / 2;
                if (n == 1)
                    System.out.println(1);
                else
                    System.out.println((int) Math.pow(3, (n - 1)));
            } else {
                n = (n + 1) / 2;
                if (n == 1)
                    System.out.println(1);
                else
                    System.out.println((int) Math.pow(2, (n - 1)));
            }
            System.out.println("Enter the position:");
            n = in.nextInt();
        }
    }
}
