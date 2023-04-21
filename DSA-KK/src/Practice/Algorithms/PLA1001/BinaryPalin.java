package Practice.Algorithms.PLA1001;

import java.util.Scanner;
import utils.Main.*;

public class BinaryPalin {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        System.out.print("Enter the number: ");
        int n = in.nextInt();

        System.out.println("Binary Equivalent: " + convertBinary(n));
        System.out.println("Palindrome? " + checkPalin(n));
        System.out.println("Palindrome? " + checkPalinBM(n));
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
        System.out.println(rev);
        return b == rev;
    }

    public static boolean checkPalinBM(int n) {
        int temp = n, rev = 0;

        while(temp > 0) {
            rev = rev << 1;
            if ((temp & 1) == 1)
                rev = rev ^ 1;
            temp = temp >> 1;
        }
        return rev == n;
    }
}
