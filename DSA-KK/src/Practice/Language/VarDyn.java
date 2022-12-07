package Language;

// Dynamically initializing a variable

public class VarDyn {
    public static void main (String[] args) {
        double a = 3.0, b = 4.0;

        // c is dynamically(during runtime) initialized
        double c = Math.sqrt(a * a + b * b);

        System.out.println("Hypotenuse is: " + c);
    }
}
