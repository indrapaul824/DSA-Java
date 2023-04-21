package Practice.Algorithms.SDOT;
import utils.Main.*;

public class ExcelColumn {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String cell = in.next();
        System.out.println(excelColumn(cell, cell.length()-1));
    }

    public static int excelColumn(String cell, int i) {
        if (i == 0) {
            return cell.charAt(i) - 'A' + 1;
        }
        return (cell.charAt(i) - 'A' + 1) + excelColumn(cell, i-1) * 26;
    }
}
