package Arrays.Searching.LinearS;

public class Linear {
    public static void main(String[] args) {
        int[] nums = {23, 45, 1, 2, 8, 19, -3, 16, -11, 28};
        int target = 19;

        int answer = linearSearch(nums, target);
        System.out.println("The element if found at index: " + answer);
    }

    /* 1. Search in the array:
            Returns:
                Index(int), If item is found
                -1,         If item is not found
     */
    public static int linearSearch(int[] arr, int target) {
        if (arr.length == 0) {
            System.out.println("The entered array is empty!");
            return -1;
        }

        // for loop for sequential traversal
        for (int index = 0; index < arr.length; index++) {
            // Check for element at every index if it is == target
            int element = arr[index];
            if (element == target) {
                return index;
            }
        }

        // These lines will be executed if the above doesn't return, so target is not present
        System.out.println("The target element is not found in the input array!");
        return -1;
    }

    /* 2. Search in the array:
            Returns:
                Item,   If item is found
                -1,     If item is not found
     */
    public static int linearSearch1(int[] arr, int target) {
        if (arr.length == 0) {
            System.out.println("The entered array is empty!");
            return -1;
        }

        // enhanced for loop for sequential traversal
        for (int element : arr) {
            // Check for element at every index if it is == target
            if (element == target) {
                return element;
            }
        }

        // These lines will be executed if the above doesn't return, so target is not present
        System.out.println("The target element is not found in the input array!");
        return Integer.MAX_VALUE;
    }

    /* 3. Search in the array:
            Returns:
                True,      If item is found
                False,     If item is not found
     */
    public static boolean linearSearch2(int[] arr, int target) {
        if (arr.length == 0) {
            System.out.println("The entered array is empty!");
            return false;
        }

        // enhanced for loop for sequential traversal
        for (int element : arr) {
            // Check for element at every index if it is == target
            if (element == target) {
                return true;
            }
        }

        // These lines will be executed if the above doesn't return, so target is not present
        System.out.println("The target element is not found in the input array!");
        return false;
    }
}
