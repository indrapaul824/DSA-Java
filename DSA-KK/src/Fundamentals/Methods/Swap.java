package Fundamentals.Methods;

public class Swap {
    public static void main(String[] args) {
        // Program to swap two numbers using a temporary variable
        int a = 10;
        int b = 20;
        System.out.println("Before swapping a = " + a + " and b = " + b);
        int temp = a;
        a = b;
        b = temp;
        swap(a, b);
        System.out.println("After swapping a = " + a + " and b = " + b);
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
