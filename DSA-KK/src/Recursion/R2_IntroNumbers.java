package Recursion;

public class R2_IntroNumbers {
    public static void main(String[] args) {
        // A function that takes in a number and prints it
        // Print the first 5 nums with a single function call

        print1(1);

        // Prints the number from 1 to N
        Print(5);

        // Prints the numbers from N to 1
        PrintReverse(5);
    }

    // Using Recursion
    static void Print(int n) {
        if (n == 1) {  // Base Condition
            System.out.println(1);
            return;
        }

        Print(n-1);  // Hypothesis

        System.out.println(n);   //  Induction
    }


    // Prints the n numbers in reverse order using Recursion
    static void PrintReverse(int n) {
        if (n == 1) {  // Base Condition
            System.out.println(1);
            return;
        }

        System.out.println(n);  // Induction

        PrintReverse(n-1);  // Hypothesis
    }


    // Breaking down the Recursive Approach in a Simple Way using multiple functions
    static void print1(int n) {
        System.out.println(n);
        print2(2);
    }

    static void print2(int n) {
        System.out.println(n);
        print3(3);
    }

    static void print3(int n) {
        System.out.println(n);
        print4(4);
    }

    static void print4(int n) {
        System.out.println(n);
        print5(5);
    }

    static void print5(int n) {
        System.out.println(n);
    }
}
