package Arrays.Searching.BinaryS;

// Q 13 : Find the peak of a Mountain Array
// https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class Q13_PeakBitonicArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 10, 8, 4, 2};

        System.out.println("The peak element is at: Index " + peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // This is the decreasing part of the array
                // The current element is a possible answer, so we will head to the left side
                // This is the reason why end != mid - 1
                end = mid;
            } else {
                // This is the Ascending part of the array
                start = mid + 1;
                // Since, arr[mid+1] > arr[mid] -> Ignore arr[mid]
            }
        }

        // Now, start == end --> Largest element of the array because of the checks
        // This is happeing due to the checks being framed in that way and no duplicate elements
        return start; // OR return end since both are equal
    }
}
