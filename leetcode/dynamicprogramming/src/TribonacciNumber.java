public class TribonacciNumber {
      public static int tribonacci(int n) {
            if (n == 0 || n == 1) {
                  return n;
            }

            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                  dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            return dp[n];
      }

      public static void main(String[] args) {
            int n1 = 4;
            int n2 = 25;

            System.out.println(tribonacci(n1));
            System.out.println(tribonacci(n2));
      }
}
