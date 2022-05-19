package Fundamentals.Methods;

public class Shadowing {
    static int x = 90; // Class variable

    public static void main(String[] args) {
        // Shadowing is allowed in static methods
        System.out.println(x); // 90

        int x; // Local variable
        x = 100; // Local variable shadows the class variable only on initialization
        System.out.println(x); // 100

        printX();
    }

    static void printX() {
        System.out.println(x); // 90
    }
}
