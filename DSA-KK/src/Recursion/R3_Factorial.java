package Recursion;

public class R3_Factorial {
    public static void main(String[] args) {
        System.out.println(Factorial(3));
    }

    static int Factorial(int n) {

        if (n == 1) {
            return 1;
        }

        return Factorial(n-1) * n;

    }
}
