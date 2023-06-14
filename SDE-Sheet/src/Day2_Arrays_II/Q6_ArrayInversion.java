package Day2_Arrays_II;

public class Q6_ArrayInversion {
    public static long cnt = 0;
    private static void merge(int s, int mid, int e, long[] arr, long[] temp) {
        int r1 = s, r2 = mid+1, w = s;

        while (r1 <= mid || r2 <= e) {
            if (r1 > mid)
                temp[w++] = arr[r2++];
            else if (r2 > e)
                temp[w++] = arr[r1++];
            else {
                if (arr[r1] <= arr[r2]) {
                    temp[w++] = arr[r1++];
                }
                else {
                    temp[w++] = arr[r2++];
                    cnt += (mid - r1) + 1;
                }
            }
        }

        for (int i = s; i <= e; i++)
            arr[i] = temp[i];
    }
    private static void mergeSort(long[] arr, int s, int e, long[] temp) {
        if (s == e)
            return;
        int mid = s + (e - s) / 2;
        mergeSort(arr, s, mid, temp);
        mergeSort(arr, mid+1, e, temp);

        merge(s, mid, e, arr, temp);
    }
    public static long getInversions(long arr[], int n) {
        long[] temp = new long[n];
        mergeSort(arr, 0, n-1, temp);
        return cnt;
    }
}
