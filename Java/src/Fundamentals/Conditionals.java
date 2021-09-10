package Fundamentals;

public class Conditionals {
    public static void main(String[] args) {
        int salary = 25400;

        // Simple if-else structure
        if(salary > 10000) {
            salary = salary + 2000;
        } else {
            salary = salary + 1000;
        }

        // Multiple if-else structure
        if (salary > 10000) {
            salary = salary + 2000;
        } else if (salary > 20000){
            salary += 3000;
        }
        else {
            salary = salary + 1000;
        }

        System.out.println(salary);
    }
}
