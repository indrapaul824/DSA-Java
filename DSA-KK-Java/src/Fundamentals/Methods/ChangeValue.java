package Fundamentals.Methods;

import java.util.Arrays;

public class ChangeValue {
    public static void main(String[] args) {
        // create an array
        int[] array = { 1, 2, 3, 4, 5 };
        // print the array
        System.out.println("Original array: " + Arrays.toString(array));
        // change the value of the array
        changeValue(array);
        // print the array again
        System.out.println("Changed array: " + Arrays.toString(array));
    }

    private static void changeValue(int[] array) {
        array[0] = 10;
    }
}
