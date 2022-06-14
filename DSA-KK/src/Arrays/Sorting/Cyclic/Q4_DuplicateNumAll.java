package Arrays.Sorting.Cyclic;

import java.util.ArrayList;
import java.util.List;

public class Q4_DuplicateNumAll {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println("The duplicate element is: " + findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] arr) {
        int i = 0, n = arr.length;
        List<Integer> list = new ArrayList<>();

        while (i < n) {
            int correct = arr[i] - 1;

            if (arr[i] != arr[correct])
                swap(arr, i, correct);
//            else if (arr[i] == arr[correct] && i != correct) {
//                if (!list.contains(arr[i]))
//                    list.add(arr[i]);
//                i++;
//            }
            else
                i++;
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] != j+1)
                list.add(arr[j]);
        }

        return list;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
