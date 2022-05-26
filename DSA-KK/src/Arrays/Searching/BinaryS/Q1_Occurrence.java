package Arrays.Searching.BinaryS;

public class Q1_Occurrence {
    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 10, 10, 18, 20};
        int target = 10;
        System.out.println("The 1st occurrence is at: " + occurFirst(arr, target));
        System.out.println("The Last occurrence is at: " + occurLast(arr, target));
    }

    public static int occurFirst(int[] arr, int target) {
        int start = 0, end = arr.length - 1, first = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                // Instead of returning mid, continue search to left
                first = mid;
                end = mid - 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return  first;
    }

    public static int occurLast(int[] arr, int target) {
        int start = 0, end = arr.length - 1, last = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                // Instead of returning mid, continue search to right
                last = mid;
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return  last;
    }
}
