package Fundamentals;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int res = 0;
        while (true) {
            // take operator as input
            System.out.println("Input the operator (Enter 'x' or 'X' to exit):");
            char op = in.next().trim().charAt(0);
            if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%') {
                // input two numbers
                System.out.println("Input two numbers: ");
                int num1 = in.nextInt();
                int num2  = in.nextInt();

                if (op == '+') {
                    res =  num1 + num2;
                }
                if (op == '-') {
                    res =  num1 - num2;
                }
                if (op == '*') {
                    res =  num1 * num2;
                }
                if (op == '/') {
                    if (num2 != 0) {
                        res =  num1 / num2;
                    }
                }
                if (op == '%') {
                    res =  num1 % num2;
                }
            }
            else if (op == 'x' || op == 'X') {
                break;
            }
            else {
                System.out.println("Invalid Operator!");
            }

            System.out.println("The result is: " + res);
        }
    }
}
