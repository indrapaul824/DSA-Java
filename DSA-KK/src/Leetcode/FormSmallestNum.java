package Leetcode;
import java.util.*;

// https://leetcode.com/contest/problems/form-smallest-number-from-two-digit-arrays/

public class FormSmallestNum {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; i++, j++) {
            if (nums1[i] == nums2[j])
                return nums1[i];
            else if (nums1[i] > nums2[j])
                i--;
            else
                j--;
        }
        int min = Math.min(nums1[0], nums2[0]);
        int max = Math.max(nums1[0], nums2[0]);
        return min*10 + max;
    }
}
