package Base;

import java.util.*;

public class SeriesPrint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the limit: ");
        int n = in.nextInt();
        System.out.println("The series is: ");
        seriesPrint(n);
    }

    public static void seriesPrint(int n) {
        int sum = 6;
        for (int i = 1; i <= n; i++) {
            System.out.print(sum + " ");
            sum = sum + 5 * i;
        }
    }
}
