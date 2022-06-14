package Arrays.Sorting.Cyclic;

// Amazon Question: Q 1 : Find the only missing number in an array of distinct nums in range [0, n]
// https://leetcode.com/problems/missing-number/

public class Q1_MissingNumber {
    public static void main(String[] args) {
        int[] arr = {4, 0, 3, 1};
        System.out.println("The missing num is: " + missingNum(arr));
    }

    public static int missingNum(int[] arr) {
        int i = 0, n = arr.length;

        while (i < n) {
            int correct = arr[i];

            if (correct < n && arr[i] != arr[correct])
                swap(arr, i, correct);
            else
                i++;
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] != j)
                return j;
        }

        return n;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
