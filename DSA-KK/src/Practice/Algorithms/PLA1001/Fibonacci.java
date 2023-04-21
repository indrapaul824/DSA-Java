package Practice.Algorithms.PLA1001;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = in.nextInt();
        System.out.println("The Nth fibonacci term is: " + fibo(n));
    }

    public static int fibo(int n) {
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;

        return fibo(n - 1) + fibo(n - 2);
    }
}
