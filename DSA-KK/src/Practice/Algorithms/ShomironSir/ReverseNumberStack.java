package Practice.Algorithms.ShomironSir;

import java.util.Stack;

public class ReverseNumberStack {
    public static void main(String[] args) {
        int n = 98743;
        int m = n;
        Stack<Integer> st = new Stack<>();
        while (m > 0) {
            st.push(m%10);
            m /= 10;
        }

        int rev = 0;
        while (!st.isEmpty()) {
            rev = rev * 10 + st.peek();
            st.pop();
        }
        System.out.println(rev);
    }
}
