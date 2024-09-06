package Arrays;

public class BuyAndSellStockL121 {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int minprice = prices[0];
        int maxProfit = 0;
        for(int i=1; i<n; i++){
            int profit = prices[i] - minprice;
            maxProfit = Math.max(profit, maxProfit);
            minprice = Math.min(minprice, prices[i]);
        }

        return maxProfit;
    }
}
