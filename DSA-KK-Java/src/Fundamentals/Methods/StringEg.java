package Methods;

public class StringEg {
    public static void main(String[] args) {
        System.out.println(greet());

        String personalizedGreeting = myGreet("Indrashis Paul");
        System.out.println(personalizedGreeting);
    }

    static String myGreet(String greeting) {
        return "Hello, " + greeting;
    }

    static String greet() {
        String greeting = "How are you?";
        return "Hello, " + greeting;
    }
}
