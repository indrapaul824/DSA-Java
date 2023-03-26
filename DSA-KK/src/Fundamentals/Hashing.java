package Fundamentals;

import java.util.*;

public class Hashing {
    public static void main(String[] args) {
        Hashing ob = new Hashing();
        int[] arr = {1, 2, 1, 3, 2};
        int[] queries = {1, 2, 3, 4};
        System.out.println(Arrays.toString(ob.countNum(arr, queries)));
        System.out.println(Arrays.toString(ob.countNum_Hash(arr, queries)));

        String s = "Indrashis";
        char[] query = {'i', 's', 'd', 'z', 'I'};
        System.out.println(Arrays.toString(ob.countChar_Hash(s, query)));

        int[] nums = {1,1,2,2,3,3,3,4};
        int k = 2;
        System.out.println(Arrays.toString(ob.topK(nums, k)));
    }

    // Given an array and queries -> return the number of times queries[i] appears in the array
    // TC: O(N * Q)
    // SC: O(1) - No extra space
    // Here, we are traversing the whole array for every query present.
    int[] countNum(int[] arr, int[] queries) {
        int[] count = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            for (int j : arr) {
                if (j == queries[i])
                    cnt += 1;
            }
            count[i] = cnt;
        }
        return count;
    }

    // Here, we will use hashing - by defining an array and storing all the count of elements at their index
    // by just a single pass, and we don't need to run an extra loop for each query
    // TC: O(N) + O(Q)
    // SC: O(100001) - Extra constant space array for hashing
    // But
    int[] hash = new int[1000001];
    int[] countNum_Hash(int[] arr, int[] queries) {
        int[] count = new int[queries.length];

        for (int i : arr)
            hash[i] += 1;

        for (int i = 0; i < queries.length; i++) {
            count[i] = hash[queries[i]];
        }
        return count;
    }

    // For characters
    int[] cHash = new int[256];
    int[] countChar_Hash(String s, char[] queries) {
        int[] count = new int[queries.length];

        for (int i = 0; i < s.length(); i++)
            cHash[s.charAt(i)] += 1;

        for (int i = 0; i < queries.length; i++) {
            count[i] = cHash[queries[i]];
        }
        return count;
    }

    // Top K frequent elements in Array
    public int[] topK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        int[] n = new int[k];
        for (int i = 0; i < k; i++)
            n[i] = map.get(list.get(i));
        return n;
    }
}
