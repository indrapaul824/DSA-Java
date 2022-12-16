package Recursion;

import java.util.*;

public class R2_BasicProbs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        name(1, n);
        linear_1toN_1(1, n);
        linear_1toN_2(1, n);
        linear_Nto1_1(1, n);
        linear_Nto1_2(1, n);
    }

    static void name(int i, int n) {
        if (i > n)
            return;
        System.out.println("Indra");
        name(i+1, n);
    }

    static void linear_1toN_1(int i, int n) {
        if (i > n)
            return;
        System.out.println(i);
        linear_1toN_1(i+1, n);
    }

    // Backtracking of previous recursion
    static void linear_1toN_2(int i, int n) {
        if (i > n)
            return;
        linear_1toN_2(i, n-1);
        System.out.println(n);
    }

    static void linear_Nto1_1(int i, int n) {
        if (i > n)
            return;
        linear_Nto1_1(i+1, n);
        System.out.println(i);
    }

    // Backtracking of previous recursion
    static void linear_Nto1_2(int i, int n) {
        if (i > n)
            return;
        System.out.println(n);
        linear_Nto1_2(i, n-1);
    }
}
