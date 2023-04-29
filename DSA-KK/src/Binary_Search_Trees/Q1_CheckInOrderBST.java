package Binary_Search_Trees;
// https://practice.geeksforgeeks.org/problems/binary-search-trees/1

public class Q1_CheckInOrderBST {
    static boolean isBSTTraversal(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1])
                return false;
        }
        return true;
    }
}
