package Language;

// The proper way to declare a class(String) variable or a local variable

public class VarString {
    static String helloMessage;

    public static void main (String[] args) {
        // String helloMessage;
        // Declared as a local variable
        helloMessage = "Hello, World!";
        System.out.println(helloMessage);
    }

    // static String helloMessage;
    // Placing class variable declarations at the beginning of the class isn't mandatory.
}
