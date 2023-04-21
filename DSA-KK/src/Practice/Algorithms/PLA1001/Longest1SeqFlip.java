package Practice.Algorithms.PLA1001;

import utils.Main.*;
public class Longest1SeqFlip {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println("The longest sequence of 1's after 1 flip is: " + flipBit(n));
    }

    private static int flipBit(int n) {
        int curr = 0, prev = 0, max = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                curr++;
            else if ((n & 1) == 0) {
                prev = ((n & 2) == 0) ? 0 : curr;
                curr = 0;
            }
            n >>= 1;
            max = Math.max(curr+prev, max);
        }
        return max+1;
    }
}
