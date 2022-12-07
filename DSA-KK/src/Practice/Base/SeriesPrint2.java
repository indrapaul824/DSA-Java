package Base;

import java.util.Scanner;

public class SeriesPrint2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the limit: ");
        int n = in.nextInt();
        System.out.println("The series is: ");
        seriesPrint(n);
    }

    public static void seriesPrint(int n) {
        double sum = 0.5;
        double add = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(sum + " ");
            sum = sum + add;
            add = add * 3;
        }
    }
}
