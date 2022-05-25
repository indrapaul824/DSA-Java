package Arrays.Searching.LinearS;

// Q 2: Search a specific target(int) in a given range of an Integer Array.

public class Q2_RangeSearch {
    public static void main(String[] args) {
        int[] arr = {18, 87, 12, 45, -9, 4, 28, 93, 74};
        int start = 3;
        int end = 6;
        int target = 4;

        System.out.println("The element is found at index: " + rangeSearch(arr, start, end, target));
    }

    public static int rangeSearch(int[] arr, int start, int end, int target) {
        if (arr.length == 0) {
            return -1;
        }

        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
