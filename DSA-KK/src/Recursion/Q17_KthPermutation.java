package Recursion;

// https://leetcode.com/problems/permutation-sequence
// https://practice.geeksforgeeks.org/problems/find-kth-permutation/1

public class Q17_KthPermutation {
    public String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();
        StringBuilder st = new StringBuilder();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            s.append(i);
            fact *= i;
        }
        fact /= n;
        k--;
        while(true) {
            st.append(s.charAt(k/fact));
            s.deleteCharAt(k/fact);
            if (s.length() == 0)
                break;
            k = k % fact;
            fact /= s.length();
        }
        return st.toString();
    }
}
