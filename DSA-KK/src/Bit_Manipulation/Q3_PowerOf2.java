package Bit_Manipulation;

import utils.Main.*;

public class Q3_PowerOf2 {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n-1) == 0;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        System.out.println("Enter the number to check:");
        int n = in.nextInt();
        System.out.println("Power of 2?: " + isPowerOfTwo(n));
    }
}
