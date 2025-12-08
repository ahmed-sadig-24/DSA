package dp;

public class CoinChange2 {
      public static int change(int amount, int[] coins) {
            if (coins == null || coins.length == 0) return -1;
            if (amount < 1) return 0;

            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin: coins) {
                  for (int j = coin; j <= amount; j++) {
                        dp[j] += dp[j - coin];
                  }
            }

            return dp[amount];
      }

      public static void main(String[] args) {
            int amount = 5;
            int[] coins = {1,2,5};

            System.out.println(change(amount, coins));
      }
}
