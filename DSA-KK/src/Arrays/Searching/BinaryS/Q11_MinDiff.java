package Arrays.Searching.BinaryS;

// Q 11 : Find the minimum difference element on a sorted array

public class Q11_MinDiff {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 13};
        int target = 12;

        System.out.println("The minimum difference element is: " + minDiffBS(arr, target));
    }

    static int minDiffBS(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while ( start <= end ) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid])
                end = mid - 1;
            else if (target > arr[mid])
                start = mid + 1;
            else
                return arr[mid];
        }

        if ((target - arr[end]) < (arr[start] - target))
            return arr[end];
        else
            return arr[start];
    }
}
