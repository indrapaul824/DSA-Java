package Operators;

public class UnarySample {
    public static void main(String[] args) {
        int c = 1;
        while (c < 15) {
            System.out.print(c%2==1?"*":"#");
            c++;
        }
    }
}
