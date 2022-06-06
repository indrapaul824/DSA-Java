package Arrays.Searching.BinaryS;

// Q 5 : Find the position of an element in a Nearly Sorted array
// https://www.geeksforgeeks.org/search-almost-sorted-array/


public class Q5_SearchNearlySorted {
    public static void main(String[] args) {
        int[] arr =  {10, 3, 40, 20, 50, 80, 70};
        int target = 40;

        System.out.println("The target is found at: Index " + searchNearlySorted(arr, target));
    }

    public static int searchNearlySorted(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == target)
                return mid;
            else if (mid-1>=start && arr[mid-1] == target)
                return mid-1;
            else if (mid+1>=end && arr[mid+1] == target)
                return mid+1;
            else if (mid-1>=start && arr[mid-1] > target)
                end = mid - 2;
            else
                start = mid + 2;
        }
        return -1;
    }
}
