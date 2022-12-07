package Practice.Algorithms;

import java.util.Scanner;

public class SwapNibblesByte {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        System.out.println("Swapped number is: " + swapNibbles(n));

        System.out.println(swapNibblesBits(n));
    }

    // O(1) approach
    public static String convertBinary(int n) {
        String bin = "";

        for (int i = 7; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0)
                bin = bin + "1";
            else
                bin = bin + "0";
        }

        return bin;
    }


    // O(N) approach
    public static int convertDigit(String binary) {
        int dec_value = 0;

        int base = 1;

        int len = binary.length();
        for (int i=len-1; i >= 0; i--) {
            if (binary.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }

        return dec_value;
    }

    // Naive Approach: O(N)
    public static int swapNibbles(int n) {
        String bin = convertBinary(n);
        String left = bin.substring(0, bin.length()/2);
        String right = bin.substring(bin.length()/2);
        right = right + left;

        return convertDigit(right);
    }


    // Bit Manipulation Approach: O(1)
    public static int swapNibblesBits(int n) {
        int right = n & 15;
        int left = n & (15 << 4);

        right = right << 4;
        left = left >> 4;

        return (right | left);
    }
}
