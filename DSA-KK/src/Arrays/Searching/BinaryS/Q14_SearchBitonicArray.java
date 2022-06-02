package Arrays.Searching.BinaryS;

// Q 14 : Search for an element in a Bitonic/Mountain Array
// https://leetcode.com/problems/find-in-mountain-array

public class Q14_SearchBitonicArray {
    interface MountainArray {
        int get(int index);
        int length();
    }

    static class Mountain implements MountainArray {
        // Defining the 1D array
        private final int[] arr = {1, 2, 3, 4, 5, 3, 1};

        @Override // Defining the get() function :-> returns the element at that index
        public int get(int index) {
            return arr[index];
        }

        @Override // Defining the length() function :-> returns the size of the array
        public int length() {
            return arr.length;
        }
    }

    public static void main(String[] args) {
        // Creating an object of Mountain class which implements the get() and length()
        // functions and passing it to the functions for accessing the data
        Mountain m1 = new Mountain();
        int target = 3;

        System.out.println("The target element is at: Index " + findInMountainArray(m1, target));
    }

    public static int findInMountainArray(MountainArray arr, int target) {
        // Function that returns the index where the element is found at

        int peak = peakIndexInMountainArray(arr);

        int pos = orderAgnosticBS(arr, 0, peak-1, target, true);

        if (pos == -1) {
            pos = orderAgnosticBS(arr, peak, arr.length()-1, target, false);
        }
        return pos;
    }

    public static int peakIndexInMountainArray(MountainArray arr) {
        // Function that returns the index of the peak element in the array

        int start = 0, end = arr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) > arr.get(mid+1))
                end = mid;
            else
                start = mid + 1;
        }

        return end;
    }

    public static int orderAgnosticBS(MountainArray arr, int start, int end, int target, boolean isAsc) {
        // Function that conducts Binary Search based on the start and end values
        // provided to it and the direction of sorting of the array

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = arr.get(mid);

            if (midElement == target)
                return mid;

            if (isAsc) {
                if (midElement < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            else {
                if (midElement < target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }

        return -1;
    }
}
