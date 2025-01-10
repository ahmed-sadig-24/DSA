public class JumpWays {

      static Long jump_ways(Integer n) {
            // Write your code here.
            if (n <= 2) {
                  return (long) n;
            }

            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                  dp[i] = dp[i - 1] + dp[i - 2];
            }

            return (long) dp[n];
      }

      public static void main(String[] args) {
            int n = 8;

            System.out.println(jump_ways(n));
            System.out.println(Long.MAX_VALUE);
      }

}
