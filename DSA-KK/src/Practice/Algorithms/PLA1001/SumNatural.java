package Practice.Algorithms.PLA1001;

import java.util.Scanner;

public class SumNatural {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = in.nextInt();
        System.out.println("The sum is: " + sumN(n));
    }

    public static int sumN(int n) {
        if (n == 1)
            return 1;

        return n + sumN(n - 1);
    }
}
