package Language;

// Default values for primitive and reference data types

public class DefaultDT {
    static boolean bool;
    static byte by;
    static char ch;
    static double d;
    static float f;
    static int i;
    static long l;
    static short sh;
    static String str;

    public static void main(String[] args) {
        System.out.println("bool = " + bool);   // false
        System.out.println("by = " + by);       // 0
        System.out.println("ch = " + ch);       // '\u0000' [This will not be displayed in the console]
        System.out.println("d = " + d);         // 0.0
        System.out.println("f = " + f);         // 0.0
        System.out.println("i = " + i);         // 0
        System.out.println("l = " + l);         // 0
        System.out.println("sh = " + sh);       // 0
        System.out.println("str = " + str);     // null
    }
}
