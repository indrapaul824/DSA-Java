package Day1_Arrays_I;


public class Q5_Sort0s1s2s {
    // Better Approach
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;

        for (int i : nums) {
            if (i == 0)
                zero++;
            else if (i == 1)
                one++;
            else if (i == 2)
                two++;
        }

        for (int i = 0; i < zero; i++)
            nums[i] = 0;
        for (int i = zero; i < zero+one; i++)
            nums[i] = 1;
        for (int i = zero+one; i < nums.length; i++)
            nums[i] = 2;
    }


    // Optimal Approach: Dutch National Flag Algorithm
    public void sortColors_optimal(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                mid++;
                low++;
            }
            else if (nums[mid] == 1)
                mid++;
            else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
