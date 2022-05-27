package Arrays.Searching.BinaryS;

// Q 1 : Find the First and Last occurrence of an element in a Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

import java.util.Arrays;

public class Q1_Occurrence {
    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 10, 10, 18, 20};
        int target = 10;
        System.out.println("The 1st occurrence is at: " + occurFirst(arr, target));
        System.out.println("The Last occurrence is at: " + occurLast(arr, target));
        System.out.println("The 1st and last occurences are at: " + Arrays.toString(searchRange(arr, target)));
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

    public static int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        range[0] = search(nums, target, true);

        if (range[0] != -1)
            range[1] = search(nums, target, false);

        return range;
    }

    public static int search(int[] nums, int target, boolean firstIndex) {
        int start = 0, end = nums.length - 1, range = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target)
                end = mid - 1;
            else if (nums[mid] < target)
                start = mid + 1;
            else {    // if nums[mid] == target
                range = mid;
                if (firstIndex)
                    end = mid -1;
                else
                    start = mid + 1;
            }
        }
        return range;
    }
}
