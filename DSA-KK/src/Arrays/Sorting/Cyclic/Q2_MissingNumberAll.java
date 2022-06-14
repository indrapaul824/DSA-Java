package Arrays.Sorting.Cyclic;

// Google Question: Q 2 : Find All Numbers Disappeared in an Array of numbers ranging from [1, N]
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;
import java.util.List;

public class Q2_MissingNumberAll {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println("The missing elements are: " + findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] arr) {
        int i = 0, n = arr.length;

        while (i < n) {
            int correct = arr[i] - 1;

            if (arr[i] != arr[correct])
                swap(arr, i, correct);
            else
                i++;
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (arr[j] != (j+1))
                list.add(j+1);
        }

        return list;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
