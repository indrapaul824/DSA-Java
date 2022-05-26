package Arrays.Searching.LinearS;

// Q 6 : https://leetcode.com/problems/richest-customer-wealth

public class Q6_RichestCustWealth {
    public static void main(String[] args) {
        int[][] accounts = {
                {1, 5},
                {7, 3},
                {3, 5}
        };

        System.out.println("The richest wealth is: " + maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] row : accounts) {
            int sum = 0;
            for (int n : row) {
                sum += n;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
