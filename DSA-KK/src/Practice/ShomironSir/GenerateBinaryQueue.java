package Practice.ShomironSir;
import utils.Main.*;
import java.util.*;
public class GenerateBinaryQueue {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        Queue<String> q = new ArrayDeque<>();
        int n = in.nextInt();
        q.add("1");
        int i = 1;
        while (i++ <= n) {
            q.add(q.peek() + '0');
            q.add(q.peek() + '1');
            System.out.println(q.poll() + " ");
        }
        System.out.println(q.size());
    }
}
