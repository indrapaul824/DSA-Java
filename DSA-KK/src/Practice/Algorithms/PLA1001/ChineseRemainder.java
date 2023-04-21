package Practice.Algorithms.PLA1001;

import java.util.Scanner;

public class ChineseRemainder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = {3, 4, 5};
        int[] rem = {2, 3, 1};

        System.out.println("The suitable values for X are:");
        chRem(num, rem);
    }

    private static void chRem(int[] num, int[] rem) {
        int x = 1, n = num.length;

        while (x < 1000) {
            int i;
            for (i = 0; i < n; i++)
                if (x % num[i] != rem[i])
                    break;

            if (i == n)
                System.out.print(x + " ");

            x++;
        }
    }
}
