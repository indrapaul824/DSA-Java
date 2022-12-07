package Language;

// Demonstrating the scope of a variable

public class VarScope {
    public static void main (String[] args) {
        int outer = 1;

        {
            int inner = 2;
            System.out.println("inner = " + inner);
            System.out.println("outer = " + outer);
        }

        int inner = 3;
        System.out.println("inner = " + inner);
        System.out.println("outer = " + outer);
    }
}
