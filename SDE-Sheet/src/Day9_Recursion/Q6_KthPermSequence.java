package Day9_Recursion;

public class Q6_KthPermSequence {
    public String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder(), st = new StringBuilder();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            s.append(i);
            fact *= i;
        }
        s.append(n);
        k--;

        while (true) {
            st.append(s.charAt(k/fact));
            s.deleteCharAt(k/fact);

            if (s.length() == 0)
                break;

            k = k % fact;
            fact = fact / s.length();
        }

        return st.toString();
    }
}
