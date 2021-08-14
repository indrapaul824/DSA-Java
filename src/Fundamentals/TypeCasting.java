package Fundamentals;

import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float num = in.nextFloat(); // Accepts float and int but not double
        System.out.println(num);

        //type casting
        int num1 = (int)67.76;
        System.out.println(num1);

        // auto type promotion in expression
        int a = 257;
        byte b = (byte)(a);
        System.out.println(b);

        byte c = 40;
        byte d = 50;
        byte e = 100;
        int f = (c * d) / e;

        int number = 'A';
        System.out.println(number);

        System.out.println(f);

        byte b1 = 42;
        char c2 = 'a';
        short s = 1024;
        int i = 789329;
        float f1 = 5.39f;
        double d1 = 0.8326518;
        double res = (f1 * b1) + (i / c2) - (d1 * s);
        System.out.println((f1 * b1) + " " + (i / c2) + " " + (d1 * s));
        System.out.println(res);

    }
}
