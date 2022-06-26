package Arrays.Sorting.S4_Cyclic;

// Amazon Question : Q 6 : Given an unsorted integer array, return the smallest missing positive integer.
// https://leetcode.com/problems/first-missing-positive/

public class Q6_FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println("The fisrt missing positive element is: " + firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] arr) {
        int i = 0, n = arr.length;

        while (i < n) {
            if (arr[i] > 0 && arr[i] < n && arr[i] != arr[arr[i] - 1])
                swap(arr, i, arr[i] - 1);
            else
                i++;
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] != j+1)
                return j+1;
        }

        return n+1;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
