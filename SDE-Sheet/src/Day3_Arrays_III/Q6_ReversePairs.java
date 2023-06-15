package Day3_Arrays_III;

public class Q6_ReversePairs {
    // Optimal
    int[] temp;
    private void merge(int[] arr, int s, int mid, int e) {
        int r1 = s, r2 = mid+1, j = mid + 1, w = s;

        while (r1 <= mid || r2 <= e) {
            if (r1 > mid) // r1 is exhausted
                temp[w++] = arr[r2++];
            else if (r2 > e) // r2 is exhausted
                temp[w++] = arr[r1++];
            else { // Neither exhausted
                temp[w++] = (arr[r1] >= arr[r2]) ? arr[r2++] : arr[r1++];
            }
        }

        for (int i = s; i <= e; i++)
            arr[i] = temp[i];
    }
    private int mergeSort(int[] arr, int s, int e) {
        if (s >= e)
            return 0;

        int mid = s + (e - s) / 2;
        int cnt = mergeSort(arr, s, mid) + mergeSort(arr, mid + 1, e);

        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && arr[i] > 2L * arr[j])
                j++;
            cnt += j - (mid + 1);
        }

        merge(arr, s, mid, e);
        return cnt;
    }

    public int reversePairs(int[] nums) {
        this.temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length-1);
    }
}
