package Strings;

import java.util.Arrays;

public class S3_Output {
    public static void main(String[] args) {
        // Any data type will be converted to String type when printing it to the console

        // Integer.toString() is called here
        System.out.println(56);

        // Here, the output is already a String
        System.out.println("Indra");

        // Here, its calling Object.toString() and printing a random value assigned to the object as a String
        System.out.println(new int[]{1, 2, 3, 4, 5});

        // So, here we Override the default toString() with the one from Arrays package for pretty printing the array
        System.out.println(Arrays.toString(new int[]{1, 2, 3, 4, 5}));
    }
}
