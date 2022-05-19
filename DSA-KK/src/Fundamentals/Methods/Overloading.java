package Fundamentals.Methods;

public class Overloading {
    public static void main(String[] args) {
        print(10);
        print("indra");
    }

    static void print(int a) {
        System.out.println(a);
    }

    static void print(String name) {
        System.out.println(name);
    }

}
