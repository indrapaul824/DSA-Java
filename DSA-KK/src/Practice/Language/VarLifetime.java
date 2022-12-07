package Language;

// Demonstrating lifetime of a variable

public class VarLifetime {
    public static void main (String[] args) {
        int x;

        for (x = 0; x < 3; x++) {
            int y = -1;  // y is initialized each time the control enters the block
            System.out.println("y is: " + y); // this always prints -1
            y  = 100;
            System.out.println("y is now: " + y);
        }
    }
}
