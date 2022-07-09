package Recursion;

public class R1_Intro {
    public static void main(String[] args) {
        // Call function time only
        message();
        // Print the message 5 times without updating the function and a single function call
        // This chain of function calls is called a recursion
    }

    // Functions that prints "Hello World"
    static void message() {
        System.out.println("Hello World!");
        message1();
    }

    static void message1() {
        System.out.println("Hello World!");
        message2();
    }

    static void message2() {
        System.out.println("Hello World!");
        message3();
    }

    static void message3() {
        System.out.println("Hello World!");
        message4();
    }

    static void message4() {
        System.out.println("Hello World!");
    }
}
