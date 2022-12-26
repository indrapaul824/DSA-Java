package Bit_Manipulation;

import utils.Main.*;

public class Q2_CheckOddEvenBit {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();

        if ((n & 1) == 1) {
            System.out.println("ODD");
            return;
        }
        System.out.println("EVEN");
    }
}
