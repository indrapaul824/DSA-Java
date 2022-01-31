package Fundamentals.Methods;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        fun(1, 2, 3, 4, 5);
        multiple(10, 20, "indra", "paul", "john", "jane");
    }

    static void fun(int... v) {
        System.out.println(v.length);
        System.out.println(Arrays.toString(v));
    }

    static void multiple(int a, int b, String... s) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(Arrays.toString(s));
    }
}
