package Practice.Algorithms.PLA1001;

import java.util.Scanner;

public class KthSetBit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = in.nextInt();
        System.out.print("Enter the bit index to check: ");
        int k = in.nextInt();

        if (checkKthBit(n, k))
            System.out.println("The bit at " + k + "th position is a SET BIT");
        else
            System.out.println("The bit at " + k + "th position is NOT a Set Bit");
    }

    public static boolean checkKthBit(int n, int k) {
        return (n & (1 << k)) != 0;
    }
}
