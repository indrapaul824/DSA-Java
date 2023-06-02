package Day1_Arrays_1;

public class Q6_StockBuySell {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0], maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit, profit);
            minBuy = Math.min(minBuy, prices[i]);
        }

        return maxProfit;
    }
}
