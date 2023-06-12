package Day2_Arrays_II;
import java.util.*;

public class Q3_MergeTwoSortedArrays {
    // GFG Solution:
    // Optimal - 1
    private static void swap(long[] arr1, long[] arr2, int i, int j) {
        long temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
    //Function to merge the arrays.
    public static void merge(long[] arr1, long[] arr2, int n, int m) {
        int left = n-1, right = 0;

        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                swap(arr1, arr2, left, right);
                left--;
                right++;
            }
            else
                break;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // Optimal - 2: GAP Method
    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    //Function to merge the arrays.
    public static void merge_optimal(long[] arr1, long[] arr2, int n, int m) {
        int len = n+m;
        int gap = (len / 2) + (len % 2); // ceil(5/2) -> 5/2( = 2) + 5%2( = 1) == 3

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            // since right would end faster
            while (right < len) {
                // left -> arr1 && right -> arr2
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }

                // left -> arr2 && right -> arr2
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }

                // left -> arr1 && right -> arr1
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right ++;
            }

            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    // Leetcode Solution:
    // Brute Force
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n >= 0) System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    // Optimal: Two-Pointer Approach
    public void merge_opti(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1, right = n - 1, ind = m + n - 1;

        while (right >= 0) {
            if (left >= 0 && nums1[left] > nums2[right])
                nums1[ind--] = nums1[left--];
            else
                nums1[ind--] = nums2[right--];
        }

    }
}
