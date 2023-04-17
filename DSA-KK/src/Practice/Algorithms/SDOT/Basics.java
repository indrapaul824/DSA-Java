package Practice.Algorithms.SDOT;
import java.util.Scanner;
public class Basics {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, c;
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        System.out.println(sum3(a, b, c));

        int n = in.nextInt();
        System.out.println(digSum(n));

        double p = in.nextDouble();
        System.out.println(digSum(p));
    }
    private static int digSum(int n) {
        int flag = 0;
        if (n < 0) {
            n = -n;
            flag = 1;
        }
        int sum = 0;
        while(n > 0) {
            sum += n%10;
            n /= 10;
        }
        return (flag == 1) ? -sum : sum;
    }

    private static int digSum(double n) {
        int flag = 0;
        if (n < 0) {
            n = -n;
            flag = 1;
        }
        int sum = 0;
        String s = Double.toString(n);
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                sum += c - '0';
        }
        return (flag == 1) ? -sum : sum;
    }


    private static int sum3(int a, int b, int c) {
        return a+b+c;
    }
}
