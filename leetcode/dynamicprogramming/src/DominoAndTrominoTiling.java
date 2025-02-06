public class DominoAndTrominoTiling {
      public static int numTilings(int n) {
            if (n <= 2) {
                  return n;
            }

            int mod = 1000000007;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 5;
            for (int i = 4; i <= n; i++) {
                  dp[i] = (2 * dp[i] % mod + dp[i - 3] % mod) % mod;
            }

            return dp[n];
      }

      public static void main(String[] args) {
            int n1 = 3;
            int n2 = 1;

            System.out.println(numTilings(n1));
            System.out.println(numTilings(n2));
      }

}
