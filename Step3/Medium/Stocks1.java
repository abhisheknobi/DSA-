package Step3.Medium;

public class Stocks1 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // Update minimum price
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice); // Calculate profit
            }
        }
        return maxProfit;
       
    }
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}