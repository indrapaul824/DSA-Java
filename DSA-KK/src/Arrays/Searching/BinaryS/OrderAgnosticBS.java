package Arrays.Searching.BinaryS;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        // Sorted array
        int[] arr = {-18, -10, -5, 0, 2, 4, 6, 9, 13, 24, 31, 48, 57};
        int[] arr_rev = {57, 48, 31, 24, 13, 9, 6, 4, 2, 0, -5, -10, -18};
        int target = 48;

        System.out.println("Target is found at: Index " + orderAgnosticBS(arr, target));
        System.out.println("Target is found at: Index " + orderAgnosticBS(arr_rev, target));
    }

    public static int orderAgnosticBS(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        // Find is array is sorted in asc or desc
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            //Find the middle element
            int mid = start + (end - start) / 2;

            // Target found
            if (arr[mid] == target) {
                return mid;
            }

            // Checking the conditions
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        // If target is not found
        return -1;
    }
}
