package Practice.Algorithms.SDOT;
import utils.Main.*;

public class BusFare {
    static String[] stops = {"TH", "GA", "IC", "HA", "TE", "LU", "NI", "CA"};
    static int[] dist = {800, 600, 750, 1200, 1100, 1500, 1600, 1000};
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String s = in.nextLine();
        String d = in.nextLine();
        int si = 0, sj = 0;
        for (int i = 0; i < 8; i++) {
            if (stops[i].equals(s))
                si = i;
            if (stops[i].equals(d))
                sj = i;
        }
        int di = 0;
        for (int i = si; i < sj; i++)
            di += dist[i];
        if (di < 1000)
            System.out.println("Total Price: " + 8);
        else
            System.out.println("Total Price: " + Math.ceil((double) di /100));
    }
}
