package Strings;

import java.util.Arrays;

public class S9_Methods {
    public static void main(String[] args) {
        String name = "Indrashis Paul";

        System.out.println(name);

        // Returns the length of the array
        System.out.println(name.length());

        // Returns an array of characters from the string
        System.out.println(Arrays.toString(name.toCharArray()));

        // Gets the character at the specific index
        System.out.println(name.charAt(5));

        // Gets the index value of a Character, if present in the String
        System.out.println(name.indexOf('P'));

        // Remove the trailing spaces from front and back
        System.out.println("      Indra     ".trim());

        // Splits the array based on the RegEx provided(here: it's a space
        // and stores them in an Array
        System.out.println(Arrays.toString(name.split(" ")));
    }
}
