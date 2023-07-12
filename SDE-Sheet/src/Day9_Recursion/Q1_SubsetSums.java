package Day9_Recursion;
import java.util.*;

public class Q1_SubsetSums {
    private void solve(int i, int sum, ArrayList<Integer> subsetSum, ArrayList<Integer> arr) {
        if (i == arr.size()) {
            subsetSum.add(sum);
            return;
        }

        solve(i+1, sum, subsetSum, arr);
        solve(i+1, sum+arr.get(i), subsetSum, arr);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> subsetSum = new ArrayList<>();
        solve(0, 0, subsetSum, arr);
        return subsetSum;
    }
}
