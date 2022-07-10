package Recursion;

// Q 1 : Sort an Array using recursion

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Q1_SortArray {
    public static void main(String[] args) {
        int[] arr = {5,1,1,2,0,0};

        ArrayList<Integer> arr_list = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());


        sortArray(arr_list);

        System.out.println(Arrays.toString(arr_list.toArray()));
    }

    static void sortArray(ArrayList<Integer> arr) {
        int n = arr.size();

        // Base Condition
        if (n <= 1)
            return;

        int temp = arr.get(arr.size()-1);

        arr.remove(arr.size()-1);

        sortArray(arr);

        insertValue(arr, temp);
    }

    static void insertValue(ArrayList<Integer> arr, int value) {
        if (arr.size() == 0 || arr.get(arr.size()-1) <= value) {
            arr.add(value);
            return;
        }

        int val = arr.get(arr.size()-1);

        arr.remove(arr.size()-1);

        insertValue(arr, value);

        arr.add(val);
    }
}
