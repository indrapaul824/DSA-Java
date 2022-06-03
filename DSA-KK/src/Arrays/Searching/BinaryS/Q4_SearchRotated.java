package Arrays.Searching.BinaryS;

// Q 4 : Find the position of an element in a Rotated Sorted array with unknown pivot
// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class Q4_SearchRotated {
    public static void main(String[] args) {
        int[] arr = {4, 6, 9, 13, 24, 31, 48, 57, -18, -10, -5, 0, 2};
        int target = -10;

//        int[] arr = {1, 3};
//        int target = 3;

        System.out.println("Target is found at: Index " + searchRotated(arr, target));
    }

    public static int searchRotated(int[] arr, int target) {
        int min = minRotated(arr);
        if (arr[min] == target)
            return min;

        int pos = binarySearch(arr, target, 0, min-1);
        if (pos == -1)
            return binarySearch(arr, target, min, arr.length-1);
        return pos;
    }

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
