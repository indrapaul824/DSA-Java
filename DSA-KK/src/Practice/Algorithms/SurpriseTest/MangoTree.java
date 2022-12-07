package Algorithms.SurpriseTest;

import java.util.Scanner;

public class MangoTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows, columns and tree:");
        int r = in.nextInt();
        int c = in.nextInt();
        int t = in.nextInt();

        if (t >= 1 && t <= r)
            System.out.println("YES");
        else if (t % r == 1)
            System.out.println("YES");
        else if (t >= (r*c - r + 1) && t <= r*c)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
