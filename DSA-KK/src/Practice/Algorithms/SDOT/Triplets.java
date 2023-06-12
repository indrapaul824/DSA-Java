package Practice.Algorithms.SDOT;
import java.util.*;

public class Triplets {
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j != i && j < nums.length; j++) {
                for (int k = 0; k != j && k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[k]);
                        triplet.add(nums[j]);
                        triplet.add(nums[i]);
                        triplets.add(triplet);
                    }
                }
            }
        }

        triplets.sort(Comparator.comparingInt(a -> a.get(0)));
        return triplets;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        System.out.println(threeSum(arr, 10));
    }
}
