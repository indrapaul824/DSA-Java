package Base;

import java.util.Scanner;

public class TargetPractice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a target number: ");
        int n = in.nextInt();
        System.out.println(targetPractice(n));
    }

    public static int targetPractice(int n) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numbers to reach target: ");
        int m = in.nextInt();
        int sum = m;
        int count = 1;

        while (sum < n) {
            System.out.println("Target not reached. Enter another number: ");
            m = in.nextInt();
            sum = sum + m;
            count++;
        }

        System.out.println("Target reached after the following number of inputs: ");
        return count;
    }
}
