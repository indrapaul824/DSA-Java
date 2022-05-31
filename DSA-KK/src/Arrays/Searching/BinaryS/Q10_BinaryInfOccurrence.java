package Arrays.Searching.BinaryS;

// Q 10 : Find the index of first 1 in abinary infinite sorted array of 0s and 1s
// https://www.geeksforgeeks.org/find-index-first-1-infinite-sorted-array-0s-1s/

public class Q10_BinaryInfOccurrence {
    public static void main(String[] args) {

        // Let arr[] be a Binary and Infinite Sorted Array
        int[] arr = {0, 0, 1, 1, 1, 1} ;

        System.out.println("Target is found first at: Index " + occurFirstBS(arr));
    }

    static int[] posBound(int[] arr) {
        int start = 0, end = 1;

        // Replacing target with 1
        while (arr[end] < 1) {
            start = end + 1;
            end = end * 2;
        }
        return new int[]{start, end};
    }

    static int occurFirstBS(int[] arr) {
        int[] pos = posBound(arr);
        int start = pos[0], end = pos[1];
        int first = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Replacing target with 1
            if (1 < arr[mid])
                end = mid - 1;
            else if (1 > arr[mid])
                start = mid + 1;
            else { // if target == arr[mid]
                first = mid;
                end = mid - 1;
            }
        }

        return first;
    }
}
