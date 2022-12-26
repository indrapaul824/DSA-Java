package Bit_Manipulation;

import utils.Main.*;

public class Q4_CountSetBits {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println("The number of set bits from 1 to " + n + " are: " + countSetBits(n));
    }
    public static int countSetBits(int n){
        if (n == 0)
            return 0;

        int x = (int)(Math.log(n) / Math.log(2));

        return (1 << (x - 1))*x + (n - (1 << x) + 1) + countSetBits(n - (1 << x));
    }
}
