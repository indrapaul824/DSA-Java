package Fundamentals;
import java.util.Scanner;

public class Inputs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your roll no:");
        int rollNo = in.nextInt();
        System.out.println("Enter your name:");
        String name = "";
        name = in.nextLine();

        System.out.println("Your roll no is: " + rollNo);
        System.out.println("Your name is: " + name);
    }
}
