package Day1_Arrays_I;

public class Q3_NextPermutation {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int ind = -1, n = nums.length;

        // 1. Find breaking point
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        // 2. Find the smallest element greater than arr[ind]
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        // 3. Place the rest in sorted manner (which can be obtained by simply reversing the rest)
        reverse(nums, ind+1, n-1);
    }
}
