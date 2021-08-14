package Fundamentals;
import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        // Q: Largest of the 3 numbers

        // M - 1
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        // M - 2
        max = Math.max(Math.max(a, b), c);

        System.out.println(max);
    }
}
