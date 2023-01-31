package Recursion;

import utils.Main.*;

public class Q5_Fibonacci {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println(fibo(n));
    }

    private static int fibo(int n) {
        if (n <= 1)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }

}
