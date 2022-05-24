package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class A4_MultiDim {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
             1 2 3
             4 5 6
             7 8 9
         */

        // Syntax:   data_type[][] var_name = new data_type[row_size][col_size];
        //                                                    /          \
        //                                                  /             \
        //                                          compulsory         not compulsory

        int[][] arr2D = new int[3][];


        // 2-D array --> stored as Array of Arrays
        int[][] arr = {
                {1, 2, 3},   // -> Index: 0
                {4, 5, 6},   // -> Index: 1
                {7, 8, 9}    // -> Index: 2
            };

        // 2-D array with random column-size
        int[][] arr1 = {
                {1, 2, 3},   // -> Index: 0
                {4, 5},      // -> Index: 1
                {6, 7, 8, 9} // -> Index: 2
        };


        // INPUT: Using for loop for each array in the 2D array
        int[][] arr_in = new int[3][3];
        
        // for each row in the array
        for (int row = 0; row < arr_in.length; row++) {
            // for each colmun in every row
            for (int col = 0; col < arr_in[row].length; col++) {
                arr_in[row][col] = in.nextInt();
            }
        }

        // PRINT: Using the same logic as above
        // for each row in the array
        for (int row = 0; row < arr_in.length; row++) {
            // for each colmun in every row
            for (int col = 0; col < arr_in[row].length; col++) {
                System.out.print(arr_in[row][col] + " ");
            }
            System.out.println();
        }

        // Enhanced for loop | for each loop
        // for each row in the array
        for (int[] row : arr_in) {
            // for each colmun in every row
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        // Using .toString() method with enhanced for loop
        for (int[] row : arr_in) {
            System.out.println(Arrays.toString(row));
        }
    }
}
