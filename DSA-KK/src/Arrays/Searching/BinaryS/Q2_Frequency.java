package Arrays.Searching.BinaryS;

// Q 2 : Count the number of occurrences or frequency of a target element in a sorted array
// https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/

public class Q2_Frequency {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 11;

        System.out.println(findFrequency(arr, target));
    }

    static int findFrequency(int[] arr, int target){
        int first = findOccurrence(arr, target, true), last;

        if (first != -1) {
            last = findOccurrence(arr, target, false);
            return last - first + 1;
        }

        return 0;
    }

    static int findOccurrence(int[] arr, int target, boolean firstIndex) {
        int start = 0, end = arr.length - 1, range = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target)
                start = mid + 1;
            else if (arr[mid] > target)
                end = mid - 1;
            else {
                range = mid;

                if (firstIndex)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }

        return range;
    }

}
