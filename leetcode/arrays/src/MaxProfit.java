import java.util.Arrays;

public class MaxProfit {

      public static int maxProfit(int[] prices) {
            int maxiProfit = 0;
            int minPrice = Integer.MAX_VALUE;

            for (int price : prices) {
                  minPrice = Math.min(price, minPrice);
                  int profit = price - minPrice;
                  maxiProfit = Math.max(profit, maxiProfit);
            }

            return maxiProfit;
      }

      public static void main(String[] args) {
            int[] prices = {7, 1, 5, 3, 6, 4};

            System.out.println(maxProfit(prices));
      }
}
