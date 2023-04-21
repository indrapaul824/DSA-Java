package Practice.Algorithms.PLA1001;

import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String s = in.nextLine();

        System.out.println("The reversed sentence is: \n" + reverseSentence(s));
    }

    public static String reverseSentence(String s) {
        String[] arr = s.split("\\.");
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < arr.length - 1; i++) {
            string.insert(0, arr[i]);
            string.insert(0, ".");
        }

        string.insert(0, arr[arr.length-1]);

        return string.toString();
    }
}
