package Arrays.Searching.BinaryS;

// Q 7 : Find the smallest element greater than the target element in the Array (Ceil)

public class Q7_Ceil {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 10, 10, 19};
        int target = 5;

        System.out.println("The ceil of the target is: " + ceil(arr, target));
    }

    public static int ceil(int[] arr, int target) {

        // Edge Case: If target > the largest element in array, no ceil
        if (target > arr[arr.length - 1]) {
            return -1;
        }

        int start = 0, end = arr.length - 1, ceil = 0;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (arr[mid] == target)
                return arr[mid];
            else if (arr[mid] < target)
                start = mid + 1;
            else {
                ceil = arr[mid];
                end = mid - 1;
            }
        }

        return ceil;
    }
}
