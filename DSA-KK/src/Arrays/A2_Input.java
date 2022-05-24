package Arrays;

import java.util.*;

public class A2_Input {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Array of primitives: int
        int[] arr = new int[5];

        // INPUT 1: Manually assigning values at each index (Inefficient)
        arr[0] = 23;
        arr[1] = 45;
        arr[2] = 233;
        arr[3] = 545;
        arr[4] = 3;
        // arr = [23, 45, 233, 545, 3]

        System.out.println(arr[3]);
        // 545

        // INPUT 2: Automating input from User using for loops
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        // PRINT AN ARRAY

        // PRINT 1: Using a for loop

        // Using same for loop as above
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // Enhanced for loop | for each loop
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // PRINT 2: Using Arrays.toString() method from java.util package
        System.out.println(Arrays.toString(arr));


        // Array of objects: String

        String[] str = new String[4];

        for (int i = 0; i < str.length; i++) {
            str[i] = in.next();
        }

        System.out.println(Arrays.toString(str));
    }
}
