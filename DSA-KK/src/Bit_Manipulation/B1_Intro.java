package Bit_Manipulation;

import utils.Main.*;

// Given a 32-bit unsigned integer num and an integer i. Perform following operations on the number -
//
// 1. Get ith bit
// 2. Set ith bit
// 3. Clear ith bit

public class B1_Intro {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int i = in.nextInt();
            bitManipulation(n, i);
            System.out.println();
        }
    }

    private static void bitManipulation(long n, long i) {
        i = i - 1;
        long pos = 1L << i;
        long set = ((n & pos) >> i);
        System.out.print(set + " ");
        long seti = (n | pos);
        System.out.print(seti + " ");
        long clear = (n & (~pos));
        System.out.print(clear);
    }
}
