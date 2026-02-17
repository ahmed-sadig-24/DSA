public class DominoAndTromino {
            public static int numTilings(int n) {
                  if (n <= 2) {
                        return n;
                  }

                  int mod = 1000000007;
                  int[] dp = new int[n + 1];
                  dp[1] = 1;
                  dp[2] = 2;
                  dp[3] = 5;

                  System.out.println("Step 0: dp[1] = 1, dp[2] = 2, dp[3] = 5");

                  for (int i = 4; i <= n; i++) {
                        dp[i] = (2 * dp[i - 1] % mod + dp[i - 3] % mod) % mod;
                        System.out.println("Step " + (i - 2) + ": dp[" + i + "] = (2 * dp[" + (i - 1) + "] + dp[" + (i - 3) + "]) % mod = " + dp[i]);
                  }

                  return dp[n];
            }

            public static void main(String[] args) {
                  int n = 6;
                  System.out.println("Number of ways to tile 2×" + n + " board: " + numTilings(n));
            }
      }

