package Arrays.Searching.LinearS;

// Q 5 : https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

public class Q5_EvenDigits {
    public static void main(String[] args) {
        int[] arr = {12,345,2,6,-7896};
        System.out.println(findNumbers(arr));
        System.out.println(findNumbers1(arr));
    }


    /* Standard solution: O(n^2)
    static int numDig(int num) {
        // Standard method
        if (num < 0)
            num *= -1;
        if (num == 0)
            return 1;
        int c = 0;
        while (num > 0) {
            c++;
            num /= 10;
        }
        return c;
    }

     */

    // Optimized digit count: O(n)
    static int numDig(int num) {
        if (num < 0)
            num *= -1;
        return (int)(Math.log10(num)) + 1;
    }

    static boolean even(int num) {
        int count = numDig(num);
        return count % 2 == 0;
    }

    public static int findNumbers(int[] nums) {
        if (nums.length <= 500) {
            int c = 0;
            for (int num : nums) {
                if (even(num))
                    c++;
            }
            return c;
        }
        return -1;
    }

    /* Using built-in functions to convert number to character array
    #: Iefficient solution: O(n^3)
    #: .toString() and .toCharArray() has a while and for loop respectively.
     */
    public static int findNumbers1(int[] nums) {
        if (nums.length <= 500) {
            int c = 0;
            for (int num : nums) {
                if (num < 0)
                    num *= -1;
                int size = Integer.toString(num).toCharArray().length;
                if (size%2 == 0)
                    c++;
            }
            return c;
        }
        return -1;
    }
}
