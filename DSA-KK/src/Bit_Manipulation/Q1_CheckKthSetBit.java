package Bit_Manipulation;

import utils.Main.*;
public class Q1_CheckKthSetBit {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (checkKthBit(n, k))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    static boolean checkKthBit(int n, int k)
    {
        int m = 1 << k;
        return (n & m) == m;
    }
}
