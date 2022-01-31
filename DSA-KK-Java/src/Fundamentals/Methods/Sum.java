package Fundamentals.Methods;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        sum();
        int ans = sum2();
        System.out.println("Sum 2 is " + ans);
        int ans2 = sum3(10, 20);
        System.out.println("Sum 3 is " + ans2);
    }

    static void sum() {
        Scanner in = new Scanner(System.in);
        int a, b, sum;

        System.out.println("Enter two numbers");
        a = in.nextInt();
        b = in.nextInt();

        sum = a + b;
        System.out.println("Sum is " + sum);
    }

    static int sum2() {
        Scanner in = new Scanner(System.in);
        int a, b, sum;

        System.out.println("Enter two numbers");
        a = in.nextInt();
        b = in.nextInt();

        sum = a + b;
        return sum;
    }

    static int sum3(int a, int b) {
        return a + b;
    }

}
