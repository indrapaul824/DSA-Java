package Recursion;

public class R3_SumOfN {
    public static void main(String[] args) {

    }

    // Parameterized Way
    static void sum(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }

        sum(i - 1, sum + 1);
    }
}
