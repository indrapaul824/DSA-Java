package Fundamentals;

import java.util.Scanner;

public class NestedSwitch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int empID = in.nextInt();
        String dept = in.next();


        // With simple switch-case
        switch (empID) {
            case 1:
                System.out.println("Indrashis Paul");
                break;
            case 2:
                System.out.println("Ayush Saha");
                break;
            case 3:
                System.out.println("Emp Number 3");
                switch (dept) {
                    case "IT":
                        System.out.println("IT Department");
                        break;
                    case "Management":
                        System.out.println("Management Department");
                        break;
                    default:
                        System.out.println("No or invalid department provided");
                }
                break;
            default:
                System.out.println("Enter the correct EmpID");
        }

        // With both enhanced switch-case statements
        switch (empID) {
            case 1 -> System.out.println("Indrashis Paul");
            case 2 -> System.out.println("Ayush Saha");
            case 3 -> {
                System.out.println("Emp Number 3 ");
                switch (dept) {
                    case "IT" -> System.out.println("IT Department");
                    case "Management" -> System.out.println("Management Department");
                    default -> System.out.println("No or invalid department provided");
                }
            }
            default -> System.out.println("Enter the correct EmpID");
        }
    }
}
