package Arrays.Searching.BinaryS;

public class Binary {
    public static void main(String[] args) {

        // Sorted array
        int[] arr = {-18, -10, -5, 0, 2, 4, 6, 9, 13, 24, 31, 48, 57};
        int target = 48;

        System.out.println("Target is found at: Index " + binarySearch(arr, target));
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            //Find the middle element
            // Standard method: But might (start+end) might exceed Int range for arrays with larger values
            // int mid = (start + end) / 2;

            // Using (end - start) which will not lead to a large value
            // Here, the actual outcome remains same, but values are different
            int mid = start + (end - start) / 2;

            // Checking the conditions
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // Target found
                return mid;
            }
        }
        // If target is not found
        return -1;
    }
}
