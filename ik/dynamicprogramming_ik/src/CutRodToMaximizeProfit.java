public class CutRodToMaximizeProfit {
      public static int maxProfit(int[] prices) {
            int n = prices.length;
            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                  int maxVal = Integer.MIN_VALUE;
                  for (int j = 0; j < i; j++) {
                        maxVal = Math.max(maxVal, prices[j] + dp[i - j - 1]);
                        System.out.println("dp[i -j -1]:" +  dp[i -j -1]);
                        System.out.println("i:" + i + ",j:" + j + ", maxval: " + maxVal);
                        //System.out.println();
                  }
                  dp[i] = maxVal;
                  System.out.println("i:" + i + ",dp[i]:" + dp[i]);
            }

            return dp[n];
      }

      public static void main(String[] args) {
            int[] price = {1, 5, 8, 9};
            System.out.println(maxProfit(price));
            //System.out.println(maxProfit2(price));
      }

      public static int maxProfit2(int[] prices) {
            int n = prices.length;
            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                  int maxVal = Integer.MIN_VALUE;
                  for (int j = 0; j < i; j++) {
                        maxVal = Math.max(maxVal, prices[j] + dp[i - j - 1]);
                  }

                  dp[i] = maxVal;
            }

            return dp[n];
      }

}
