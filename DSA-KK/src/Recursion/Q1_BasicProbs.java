package Recursion;

import java.util.*;

public class Q1_BasicProbs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        name(1, n);
        linear_1toN(1, n);
        linear_Nto1_1(1, n);
        linear_Nto1_2(1, n);
    }

    static void name(int i, int n) {
        if (i > n)
            return;
        System.out.println("Indra");
        name(i+1, n);
    }

    static void linear_1toN(int i, int n) {
        if (i > n)
            return;
        System.out.println(i);
        linear_1toN(i+1, n);
    }

    static void linear_Nto1_1(int i, int n) {
        if (i > n)
            return;
        linear_Nto1_1(i+1, n);
        System.out.println(i);
    }

    static void linear_Nto1_2(int i, int n) {
        if (i > n)
            return;
        System.out.println(n);
        linear_Nto1_2(i, n-1);
    }
}
