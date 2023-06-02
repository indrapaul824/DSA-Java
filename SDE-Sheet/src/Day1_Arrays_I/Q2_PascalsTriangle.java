package Day1_Arrays_I;
import java.util.*;

public class Q2_PascalsTriangle {
    private List<Integer> generateRow(int r) {
        int element = 1;
        List<Integer> row = new ArrayList<>();
        row.add(element);
        for (int c = 1; c < r; c++) {
            element *= r - c;
            element /= c;
            row.add(element);
        }

        return row;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int r = 1; r <= numRows; r++) {
            res.add(generateRow(r));
        }

        return res;
    }
}
