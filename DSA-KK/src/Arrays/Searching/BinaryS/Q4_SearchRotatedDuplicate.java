package Arrays.Searching.BinaryS;
// Q 4 : Find the position of an element in a Rotated Sorted array with unknown pivot and containing duplicate elements
// Here, the previous strategies will fail because of duplicate elements
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

public class Q4_SearchRotatedDuplicate {
    public static void main(String[] args) {
        int[] arr = {4, 9, 9, 13, 24, 24, 31, 48, 57, -10, -10, -5, 0, 2};
        int target = -10;

        arr = new int[]{1,1,3};
        target = 0;

        System.out.println("Target is found: " + searchRotated(arr, target));
    }

    public static boolean searchRotated(int[] arr, int target) {
        int pivot = findPivotWithDuplicates(arr);

        if (pivot == -1)
            return binarySearch(arr, target, 0, arr.length-1);

        if (arr[pivot] == target)
            return true;
        else if (arr[0] <= target)
            return binarySearch(arr, target, 0, pivot-1);
        return binarySearch(arr, target, pivot+1, arr.length-1);
    }

    public static int findPivotWithDuplicates(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1])
                return mid;
            else if (mid > start && arr[mid] < arr[mid - 1])
                return mid - 1;

            // If elements at start, mid and end are equal --> Skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // Skip the duplicate elements, if they are not pivots
                if (start < end && arr[start] > arr[start + 1])
                    return start;
                start++;  // Skipped the duplicate at start

                if (end > start && arr[end] < arr[end - 1])
                    return end - 1;
                end--;  // Skipped the duplicate at end
            }
            // If arr[start] < arr[mid] OR if arr[start] == arr[mid] => arr[mid] > arr[end]
            // It means that, the left side is sorted, but the right is not
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end]))
                start = mid + 1;
            else // The left is not sorted
                end = mid - 1;
        }

        return -1;
    }

    public static boolean binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target)
                start = mid + 1;
            else if (arr[mid] > target)
                end = mid - 1;
            else
                return true;
        }

        return false;
    }
}
