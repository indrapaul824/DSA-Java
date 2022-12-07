package Base;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();

        for (int i = n; i >= 1; i--) {
            for (int j = i; j < n; j++) {
                System.out.print(j + " ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
