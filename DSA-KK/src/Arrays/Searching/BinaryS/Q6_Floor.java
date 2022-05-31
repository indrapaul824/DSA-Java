package Arrays.Searching.BinaryS;

// Q 6 : Find the largest element lesser than the target element in the Array (Floor)

public class Q6_Floor {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 10, 10, 19};
        int target = 5;

        System.out.println("The ceil of the target is: " + floor(arr, target));
    }

    public static int floor(int[] arr, int target) {

        // Edge Case: If target < the smallest element in array, no floor
        if (target < arr[arr.length - 1]) {
            return -1;
        }

        int start = 0, end = arr.length - 1, floor = 0;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == target)
                return arr[mid];
            else if (arr[mid] < target) {
                floor = arr[mid];
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        return floor;
    }
}
