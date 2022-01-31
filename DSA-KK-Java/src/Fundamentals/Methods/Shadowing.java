package Fundamentals.Methods;

public class Shadowing {
    static int x;
    public static void main(String[] args) {
        // Shadowing is allowed in static methods
        System.out.println(x);
    }
}
