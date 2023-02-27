package Leetcode;

import java.util.Arrays;

public class Merge2D {

    public static void main(String[] args) {
        int[][] nums1 = {{2, 4}, {3, 6}, {5, 5}};
        int[][] nums2 = {{1, 3}, {4, 3}};
        System.out.println(Arrays.deepToString(mergeArrays(nums1, nums2)));
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] res = new int[n+m][2];
        int i = 0, j = 0, k = 0;
        while (i < n || j < m) {
            if (i < n && j < m && nums1[i][0] == nums2[j][0]) {
                res[k][0] = nums1[i][0];
                res[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            }
            else if (i < n && (j >= m || nums1[i][0] < nums2[j][0])) {
                res[k] = nums1[i];
                i++;
            }
            else if (j < m && (i >= n || nums1[i][0] > nums2[j][0])) {
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        return res;
    }
}
