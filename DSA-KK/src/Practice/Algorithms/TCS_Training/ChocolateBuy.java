package Practice.Algorithms.TCS_Training;

import utils.Main.*;

public class ChocolateBuy {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println(canBuyChocolates(n));
    }

    private static boolean canBuyChocolates(int n) {
        if (n > 100)
            return false;
        int price = 100 - n;
        int count3 = 0, count7 = 0;
        if (price % 7 == 0) {
            count7 = price / 7;
            price = 0;
        }
        while (price % 7 != 0 && price >= 3) {
            price -= 3;
            count3++;
            if (price % 7 == 0) {
                count7 = price / 7;
                price = 0;
            }
        }
        if (price != 0)
            return false;

        System.out.println("Count 3: " + count3 + "\nCount 7: " + count7);
        return true;
    }
}
