package Arrays.Searching.BinaryS;

// Q 3 : Provided a rotated sorted array, count the number of times the original sorted array was
// rotated to achieve the input array.
// This is done by finding the index of:
//      Approach 1: The minimum element of the input array
//      Approach 2: The maximum/pivot element of the input array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class Q3_NumRotated {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println("The number of rotations in clockwise direction are: " + numRotated(arr, true));
        System.out.println("The number of rotations in anti-clockwise direction are: " + numRotated(arr, false));
    }

    static int numRotated(int[] arr, boolean clockwise) {
        // Function to return the number of times a sorted array was rotated
        int N = arr.length;
        int start = 0, end = N - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] <= arr[(mid+1) % N] && arr[mid] <= arr[(mid+N-1) % N]) {
                if (clockwise)
                    return N - mid;
                else // anti-clockwise
                    return mid;
            }
            else if (arr[mid] <= arr[end])
                end = mid - 1;
            else // if (arr[start] <= arr[mid])
                start = mid + 1;
        }

        return -1;
    }
}
