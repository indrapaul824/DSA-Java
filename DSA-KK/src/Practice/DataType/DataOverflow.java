package DataType;

// Java let's us overflow if the max value of a data type is exceeded.

public class DataOverflow {
    public static void main (String[] args) {
        int big = 0x7fffffff;  // max int value
        System.out.println("big = " + big);
        int bigger = big * 4;
        System.out.println("bigger = " + bigger);
    }
}
