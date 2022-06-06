package Arrays.Searching.BinaryS;

public class Q17_SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 8, 10};
        int m = 2;

        System.out.println("The largest min sum with best split is: " + splitArray(arr, m));
    }

    public static int splitArray(int[] arr, int m) {
        int start = 0, end = 0;

        for (int i : arr) {
            start = Math.max(start, i);
            end += i;
        }

        // Binary Search

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Check for mid as potential answer
            // Calculate the number of sub-arrays the array can be split into with mid as max sum
            int sum = 0, num_arrays = 1;

            for (int num : arr) {
                if ((sum + num) > mid) {
                    // If sum exceeds, then create new sub-array
                    sum = num;
                    num_arrays++;
                }
                else
                    sum += num;
            }

            if (num_arrays > m)
                start = mid + 1;
            else
                end = mid;
        }

        return end; // since mid == start == end at the end
    }

}
