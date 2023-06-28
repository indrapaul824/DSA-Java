package Sliding_Window;

import java.util.*;

public class Q4_SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (j < nums.length) {
            // Compute
            while (!dq.isEmpty() && nums[j] > dq.peekLast())
                dq.pollLast();
            dq.offerLast(nums[j]);

            // Make Window
            if (j-i+1 < k)
                j++;

            // Window formed
            else {
                res.add(dq.peekFirst());
                if (nums[i] == dq.peekFirst())
                    dq.pollFirst();
                i++;
                j++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
