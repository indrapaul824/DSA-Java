package Arrays.Sorting;

public class S5_MergeSort {
    void merge(int[] arr, int l, int m, int r)
    {
        int[] temp = new int[r-l+1];
        int left = l, right = m+1;
        int i = 0;
        while (left <= m && right <= r) {
            if (arr[left] <= arr[right]) {
                temp[i] = arr[left];
                left++;
            }
            else {
                temp[i] = arr[right];
                right++;
            }
            i++;
        }

        while (left <= m) {
            temp[i] = arr[left];
            left++;
            i++;
        }
        while (right <= r) {
            temp[i] = arr[right];
            right++;
            i++;
        }

        if (r + 1 - l >= 0) System.arraycopy(temp, 0, arr, l, r + 1 - l);
    }
    void mergeSort(int[] arr, int l, int r)
    {
        if (l == r)
            return;

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);

        merge(arr, l, mid, r);
    }
}
