package Fundamentals;

import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Print and output statements

        // A new line will be inserted at the end
        System.out.println("Hello, World! This is the start of fundamentals of Java");
        // No new line will be inserted at the end
        System.out.println("I am ");
        System.out.println("Indrashis Paul");

        // Input using Scanner class
        System.out.println("Hey, how are you?");
        Scanner in = new Scanner(System.in);
        System.out.println(in.nextLine());
    }
}
