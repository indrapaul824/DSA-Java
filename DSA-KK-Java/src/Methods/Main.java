package Methods;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Q: Take input of 2 numbs and print the sum
        Scanner in = new Scanner(System.in);
        int a, b, sum;

        System.out.println("Enter two numbers");
        a = in.nextInt();
        b = in.nextInt();

        sum = a + b;
        System.out.println("Sum is " + sum);
    }
}
