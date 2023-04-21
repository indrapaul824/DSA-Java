package Practice.Algorithms.PLA1001;

import java.util.Scanner;

public class LongestConsecutive1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = in.nextInt();
        System.out.println("The length of the longest consecutive 1's is: " + longestCons1(n));
        System.out.println("The length of the longest consecutive 1's (Bit Manipulation) is: " + longestCons1Bit(n));
    }

    // Naive: O(N)
    public static int longestCons1(int n) {
        int count = 0, max = 0;
        while (n > 0) {
            if (n % 2 == 1)
                count++;
            else
                count = 0;
            if (count > max)
                max = count;

            n /= 2;
        }

        return max;
    }


    // Bit Manipulation: O()
    public static int longestCons1Bit(int n) {
        int count = 0;

        while (n != 0) {
            n = (n & (n << 1));
            count++;
        }

        return count;
    }
}
