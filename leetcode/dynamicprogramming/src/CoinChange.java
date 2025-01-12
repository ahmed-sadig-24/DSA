public class CoinChange {
      public static int coinChange(int[] coins, int amount) {
            if (amount < 1) return 0;

            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                  dp[i] = Integer.MAX_VALUE;

                  for (int coin: coins) {
                        if (coin <=i && dp[i - coin] != Integer.MAX_VALUE) {
                              if (i == 4) System.out.println(dp[3]);
                              dp[i] = Math.min(dp[i], 1 +  dp[i - coin]);
                              //System.out.println("i: " + i);
                              //System.out.println("coin: " + coin);
                              //System.out.println("dp[i]: " +  dp[i]);
                              //System.out.println("dp[i - coin]: " + dp[i - coin]);
                        }
                  }
            }
            if (dp[amount] == Integer.MAX_VALUE) return -1;

            return dp[amount];
      }

      public static void main(String[] args) {
            //int[] coins = {1,2,5};
            int[] coins = {1,5,6,9};
            int amount = 11;

            System.out.println(coinChange(coins, amount));
      }
}
