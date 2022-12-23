package Practice.Algorithms;

import java.util.Scanner;

public class BinaryPalin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = in.nextInt();

        System.out.println("Binary Equivalent: " + convertBinary(n));

        System.out.println("Is it Palindrome? " + checkPalinBM(n));
    }

    public static String convertBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n != 0) {
            binary.insert(0, (n % 2));
            n /= 2;
        }
        return binary.toString();
    }

    public static boolean checkPalin(int n) {
        int binary = Integer.parseInt(convertBinary(n));
        int b = binary;
        int rev = 0;
        while (binary > 0) {
            int r = binary % 10;
            rev = rev * 10 + r;
            binary /= 10;
        }

        return b == rev;
    }

    public static boolean checkPalinBM(int n) {
        int a = 0X0F, b = 0XF0;
        int rev = (n & a) << 4;
        rev = rev | ((n & b) >> 4);

        return rev == n;
    }

}
