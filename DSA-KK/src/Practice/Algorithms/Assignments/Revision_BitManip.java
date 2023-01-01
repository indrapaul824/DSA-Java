package Practice.Algorithms.Assignments;

import utils.Main.*;

public class Revision_BitManip {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println("Num with swapped nibbles: " + swapNibbles(n));
        System.out.println("Binary rep of num is Palindrome? " + binaryPalin(n));
        System.out.println("Longest sequence of 1's in Binary rep of num with 1 flip is: " + findLongestReq(n));
    }

    private static int findLongestReq(int n) {
        int curr = 0, prev = 0, max = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                curr++;
            else if ((n & 1) == 0) {
                prev = ((n & 2) == 0) ? 0 : curr;
                curr = 0;
            }
            n = n >> 1;
            max = Math.max(prev+curr, max);
        }

        return max+1;
    }

    private static boolean binaryPalin(int n) {
        int temp = n, rev = 0;

        while (temp > 0) {
            rev = rev << 1;
            if ((temp & 1) == 1)
                rev = rev ^ 1;
            temp = temp >> 1;
        }

        return n == rev;
    }

    private static int swapNibbles(int n) {
        return (((n & 0x0F) << 4) | ((n & 0xF0) >> 4));
    }

}
