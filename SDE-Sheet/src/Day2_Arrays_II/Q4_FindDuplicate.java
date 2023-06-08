package Day2_Arrays_II;

public class Q4_FindDuplicate {
    // Optimal - No modification + constant extra space
    public int findDuplicate_optimal(int[] nums) {
        int slow = nums[0], fast = nums[0];

        // Find the 1st intersection
        // Using do-while loop since we already have slow and fast at the same point initially and we need to find the next intersection
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Revert fast back and keep moving both 1 step to find 2nd intersection
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
