package sliding_window;

public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        int[] prices = {10, 1, 5, 6, 7, 1};
        System.out.println();
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);

        }

        return maxProfit;
    }
}
