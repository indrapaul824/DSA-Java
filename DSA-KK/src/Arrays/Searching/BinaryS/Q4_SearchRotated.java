package Arrays.Searching.BinaryS;

// Q 4 : Find the position of an element in a Rotated Sorted array with unknown pivot
// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class Q4_SearchRotated {
    public static void main(String[] args) {
        int[] arr = {4, 6, 9, 13, 24, 31, 48, 57, -18, -10, -5, 0, 2};
        int target = -10;

        System.out.println("Target is found at: Index " + searchRotated(arr, target));
    }

    public static int searchRotated(int[] arr, int target) {
        // Approach 1
        int min = minRotated(arr);
        if (arr[min] == target)
            return min;

        int pos = binarySearch(arr, target, 0, min-1);
        if (pos == -1)
            return binarySearch(arr, target, min, arr.length-1);
        return pos;

        /* Condition checks for Approach 2
        int pivot = pivotRotated(arr);

        // No pivot found: Array is not rotated
        if (pivot == -1)
            // Do normal Binary Search
            return binarySearch(arr, target, 0, arr.length-1);

        // Pivot is found: Checking conditions for 2 sorted arrays
        if (arr[pivot] == target)
            return pivot;
        else if (arr[0] <= target)
            return binarySearch(arr, target, 0, pivot-1);

        return binarySearch(arr, target, pivot+1, arr.length-1);
*/

    }


    // Approach 1: Using the min element index to bifurcate the array
    // Here, we include the 1st and Last positions which might contain the min element so the min index
    // is garunteed to return a value, even when the array is sorted and not rotated

    public static int minRotated(int[] arr) {
        int N = arr.length;
        int start = 0, end = N - 1;

        if (N == 1)
            return 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= arr[(mid + 1) % N] && arr[mid] <= arr[(mid + N - 1) % N])
                return mid;
            else if (arr[mid] <= arr[end])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return 0;
    }


    // Approach 2: Using the Max/Pivot element index to bifurcate the array
    // Here, we don't consider the boundary elements, since a Pivot can't exist in the edges of an
    // array. So, we need to use extra checks since it might return -1 if min element is present in
    // the edges. It also means that it will only return a pivot only if the array is rotated,
    // if it's a normal sorted array, -1 will be returned.
    public static int pivotRotated(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Checking 4 cases here excluding boundary elements
            if (mid < end && arr[mid] > arr[mid+1])
                return mid;
            else if (mid > start && arr[mid] < arr[mid - 1])
                return mid - 1;
            if (arr[mid] <= arr[start])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target)
                end = mid - 1;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                return mid;
        }

        return -1;
    }
}
