package Leetcode;
import java.util.*;

public class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        int n = pushed.length, m = popped.length;
        Stack<Integer> st = new Stack<>();

        while (i < n || j < m) {
            if (i < n && (st.isEmpty() || st.peek() != popped[j])) {
                st.push(pushed[i]);
                i++;
            }
            else if (!st.isEmpty() && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
            else if (i == n && !st.isEmpty() && st.peek() != popped[j])
                return false;
        }

        return st.isEmpty();
    }
}
