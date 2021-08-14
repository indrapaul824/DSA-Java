package Fundamentals;
import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        // Q: Print numbers from 1 to 5

        // For loop
        for (int i = 1; i<=5; i++) {
            System.out.print(i + ", ");
        }
        System.out.println("");

        // Q: Print numbers from 1 to n
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 1; i<=n; i++) {
            System.out.print(i + ", ");
        }
        System.out.println("");

        // While loop

        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }

        // do while loop
        int num = 1;
        do {
            System.out.println(num);
            num++;
        } while (num <= 5);
    }
}
