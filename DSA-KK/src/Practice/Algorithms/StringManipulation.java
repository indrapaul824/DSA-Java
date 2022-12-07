package Practice.Algorithms;

import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String s3 = in.nextLine();
        String vowel = "aeiouAEIOU";

        for (int i = 0; i < s1.length(); i++) {
            char t = s1.charAt(i);

            if (vowel.indexOf(t) == -1)
                System.out.print("#");
            else
                System.out.print(t);
        }
        System.out.println();

        for (int i = 0; i < s2.length(); i++) {
            char t = s2.charAt(i);

            if (vowel.indexOf(t) != -1)
                System.out.print("$");
            else
                System.out.print(t);
        }
        System.out.println();

        for (int i = 0; i < s3.length(); i++) {
            char t = s3.charAt(i);

            if (t >= 97 && t <= 122) {
                t = (char)(t - 32);
            }
            System.out.print(t);
        }
    }
}
