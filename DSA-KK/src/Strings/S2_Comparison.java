package Strings;

public class S2_Comparison {
    public static void main(String[] args) {
        String a = "Indra";
        String b = "Indra";

        System.out.println("Same object == : " + (a == b));
        System.out.println("Same object .equals() : " + a.equals(b));

        b = new String("Indra");

        System.out.println("\nDifferent object == : " + (a == b));
        System.out.println("Different object .equals() : " + a.equals(b));
    }
}
