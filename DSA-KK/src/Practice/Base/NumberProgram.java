package Base;

import java.util.Scanner;

public class NumberProgram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        if (numberProg(n))
            System.out.println("It is a NumberProgram number!");
        else
            System.out.println("It is not a NumberProgram number!");
    }

    public static boolean numberProg(int n) {
        String s = Integer.toString(n);

        if (s.length() == 3) {
            return (int) s.charAt(1) % 3 == 0;
        }

        return false;
    }
}
