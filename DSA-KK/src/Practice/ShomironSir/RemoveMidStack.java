package Practice.ShomironSir;
import utils.Main.*;
import java.util.*;
public class RemoveMidStack {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        Stack<Integer> st = new Stack<>();
        int n = in.nextInt();
        while (n != -1) {
            st.push(n);
            n = in.nextInt();
        }
        removeMid(st);
        System.out.println(st);
    }

    private static void removeMid(Stack<Integer> st) {

    }

}
