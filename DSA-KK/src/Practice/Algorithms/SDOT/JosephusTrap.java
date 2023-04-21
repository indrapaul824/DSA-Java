package Practice.Algorithms.SDOT;
import utils.Main.*;

import java.util.ArrayList;
import java.util.List;

public class JosephusTrap {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        int k = in.nextInt();
        josephusTrap(people, k, 0);
    }

    private static void josephusTrap(List<Integer> people, int k, int ind) {
        if (people.size() == 1) {
            System.out.println(people.get(0));
            return;
        }

        ind = (ind + k) % people.size();
        people.remove(ind);

        josephusTrap(people, k, ind);
    }
}
