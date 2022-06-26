package Arrays.Sorting.S4_Cyclic;

// Amazon Question: Q 3 : Find the only duplicate number in an array with nums ranging from [1, N]
// https://leetcode.com/problems/find-the-duplicate-number/

public class Q3_DuplicateNum {
    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};
        System.out.println("The duplicate element is: " + duplicateNum(arr));
    }

    public static int duplicateNum(int[] arr) {
        int i = 0, n = arr.length;

        while (i < n) {
            int correct = arr[i] - 1;

            if (arr[i] != arr[correct])
                swap(arr, i, correct);
            else if (arr[i] == arr[correct] && i != correct)
                return arr[i];
            else
                i++;
        }

        return -1;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
