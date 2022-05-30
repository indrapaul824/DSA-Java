package Arrays.Searching.BinaryS;

// Q 9 : Find the position of an element in a sorted array of Infinite Numbers

public class Q9_InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {-18, -10, -5, 0, 2, 4, 6, 9, 13, 24, 31, 48, 57};
        int target = 2;

        System.out.println("Target is found at: Index " + InfBinarySearch(arr, target));
    }

    public static int[] posBound(int[] arr, int target) {
        int start = 0, end = 1;

        while (target > arr[end]) {
            int size = end - start;
            start = end;

            // For exponential increase in Bounding box size
            // Suitable for Infinite arrays
            // end = end + (size + 1) * 2;

            // OR simply doubling the result for smaller test cases
             end = end * 2;
        }

        return new int[]{start, end};
    }

    public static int InfBinarySearch(int[] arr, int target) {
        int[] bounds = posBound(arr, target);
        int start = bounds[0], end = bounds[1];

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else // If arr[mid] == target
                return mid;
        }

        // If element is not found
        return -1;
    }
}
