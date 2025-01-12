public class CoinChange2 {
      public static int change(int amount, int[] coins) {
            if (amount < 1) {
                  return 0;
            }

            int[] dp = new int[amount + 1];
            dp[0] = 1;

            int counter = 0;

            for (int coin: coins) {
                  for (int j = coin; j <= amount; j++) {
                        //System.out.println(counter++);
                        //System.out.println(dp[0]);
                        //System.out.println(dp[1]);
                        System.out.println("dp[j] b: j=" + j + ": dp[j]:" + dp[j] + ": dp[j-coin]:" + dp[j - coin]);
                        dp[j] += dp[j - coin];
                        System.out.println("dp[j] a: j=" + j + ": dp[j]:" + dp[j] + ": dp[j-coin]:" + dp[j - coin]);
                        //System.out.println(dp[0]);
                  }
            }

            return dp[amount];
      }

      public static void main(String[] args) {
            int amount =  2;
            //int[] coins = {1, 2, 5};
            int[] coins = {1};

            System.out.println(change(amount, coins));
      }
}
