package Arrays.Searching.BinaryS;

// Q 12 : Find the index of the peak element of an array.
// https://leetcode.com/problems/find-peak-element/

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
// |-> This solution also works for mountain array because it is a general concept
// Q 13 contains a more specific solution to them.

public class Q12_PeakIndex {
    public static void main(String[] args) {
        // Array with more tham one peaks(12, 10, 13): Anyone of them can be returned
        int[] arr = {12, 3, 10, 8, 10, 13};

        System.out.println("One of the peak element is: " + peakIndexInUnsortedArray(arr));
    }
    public static int peakIndexInUnsortedArray(int[] arr) {
        int n = arr.length - 1;

        if (n == 0)
            return n;

        int start = 0, end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && mid < n) {
                if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                    return mid;
                else if (arr[mid-1] > arr[mid])
                    end = mid - 1;
                else // if (arr[mid+1] > arr[mid])
                    start = mid + 1;
            }

            else if (mid == 0) {
                if (arr[0] > arr[1])
                    return 0;
                else
                    return 1;
            }
            else {  // if (mid == n)
                if (arr[n] > arr[n-1])
                    return n;
                else
                    return n-1;
            }
        }
        return -1;
    }
}
