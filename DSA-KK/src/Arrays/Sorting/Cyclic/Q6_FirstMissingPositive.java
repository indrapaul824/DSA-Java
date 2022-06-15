package Arrays.Sorting.Cyclic;

public class Q6_FirstMissingPositive {
    public static void main(String[] args) {

    }

    public static int firstMissingPositive(int[] arr) {
        int i = 0, n = arr.length;

        while (i < n) {
            int correct = arr[i] - 1;

            if (arr[i] != arr[correct])
                swap(arr, i, correct);
            else
                i++;
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] != j+1)
                return arr[j];
        }

        return -1;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
