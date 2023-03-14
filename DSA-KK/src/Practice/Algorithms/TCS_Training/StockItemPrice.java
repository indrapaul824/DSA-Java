package Practice.Algorithms.TCS_Training;

import utils.Main.*;

import java.util.HashMap;
import java.util.Map;

public class StockItemPrice {
    public static class Pair {
        float p;
        int s;

        Pair(float p, int s) {
            this.p = p;
            this.s = s;
        }
    }
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int[] item = {101, 102, 103, 108};
        float[] price = {42, 50, 500, 40};
        int[] stock = {10, 20, 15, 16};
        int it, quan;
        it = in.nextInt();
        quan = in.nextInt();

        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(item[i], new Pair(price[i], stock[i]));
        }

        if (map.containsKey(it)) {
            int Quan = map.get(it).s;
            if (Quan >= quan) {
                float Price = map.get(it).p;
                float totPrice = Price * quan;
                map.put(it, new Pair(Price, Quan-quan));
                System.out.println("Total Price: " + totPrice);
                System.out.println("Items left: " + (Quan-quan));
            }
            else
                System.out.println("NO STOCK");
        }
        else
            System.out.println("Invalid Item Number");
    }
}
