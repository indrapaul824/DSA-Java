package Dynamic_Programming.D5_Stocks;

public class BestTime_I {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxP = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            maxP = Math.max(prices[i] - min, maxP);
        }
        return maxP;
    }
}
