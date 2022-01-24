package Fundamentals;

import java.util.Scanner;

public class SwitchCases {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fruit = in.next();

        // Using if-statements
        if (fruit.equals("Mango")) {
            System.out.println("King of fruits");
        }

        if (fruit.equals("Apple")) {
            System.out.println("A sweet red fruit");
        }

        // Using switch-case with a break statement
        switch (fruit) {
            case "Mango":
                System.out.println("King of fruits");
                break;
            case "Apple":
                System.out.println("A sweet red fruit");
                break;
            case "Orange":
                System.out.println("Round fruit");
            case "Grapes":
                System.out.println("Small fruit");
                break;
            default:
                System.out.println("Please enter a valid fruit!");
        }

        // Using enhanced switch-case with all break statements
        switch (fruit) {
            case "Mango" -> System.out.println("King of fruits");
            case "Apple" -> System.out.println("A sweet red fruit");
            case "Orange" -> System.out.println("Round fruit");
            case "Grapes" -> System.out.println("Small fruit");
            default -> System.out.println("Please enter a valid fruit!");
        }
    }
}
