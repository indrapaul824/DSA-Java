package Base;

import java.util.Scanner;

public class SingleDigSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        System.out.println("The single digit summation result is: " + singleDigSum(n));

        System.out.println("The single digit summation result is: " + digSumDigRoot(n));
    }

    public static int singleDigSum(int n) {
        int sum = digSum(n);

        while (Integer.toString(sum).length() > 1) {
            sum = digSum(sum);
        }

        return sum;
    }

    public static int digSum(int n) {
        int sum = 0;
        while (n > 0) {
            int r = n % 10;
            sum = sum + r;
            n = n / 10;
        }
        return sum;
    }

    // Without using loops or recursion
    public static int digSumDigRoot(int n)
    {
        if (n == 0)
            return 0;
        return (n % 9 == 0) ? 9 : (n % 9);
    }
}
