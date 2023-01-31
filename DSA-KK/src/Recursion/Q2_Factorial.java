package Recursion;
import utils.Main.*;

public class Q2_Factorial {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        Factorial(n, 1);
        System.out.println(Factorial(n));
    }

    // Parameterised Way
    static void Factorial(int i, int prod) {
        if (i <= 1) {
            System.out.println(prod);
            return;
        }

        Factorial(i-1, prod * i);
    }

    // Functional Way
    static int Factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return Factorial(n-1) * n;
    }
}
