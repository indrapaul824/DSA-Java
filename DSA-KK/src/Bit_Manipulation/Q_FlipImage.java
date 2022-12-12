package Bit_Manipulation;

import java.util.Arrays;

public class Q_FlipImage {
    public static void flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            // reverse this array
            for (int i = 0; i < (image[0].length + 1)/2; i++) {
                // Swap to reverse
                int temp = row[i] ^ 1;
                row[i] = row[image[0].length - i - 1] ^ 1;
                row[image[0].length - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};

        System.out.println(Arrays.deepToString(image));

        flipAndInvertImage(image);

        System.out.println(Arrays.deepToString(image));
    }
}
