public class DecodeWays {
      public static int numDecodings(String s) {
            int n = s.length();

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0: 1;
            for (int i = 2; i <= n; i++) {
                  int oneDigit = Integer.valueOf(s.substring(i - 1, i));
                  int twoDigits = Integer.valueOf(s.substring(i - 2, i));

                  if (oneDigit >= 1) {
                        dp[i] += dp[i - 1];
                  }

                  if (twoDigits >= 10 && twoDigits <= 26) {
                        dp[i] += dp[i - 2];
                  }
            }

            return dp[n];
      }

      public static void main(String[] args) {
            String input1 = "12";
            String input2 = "226";
            String input3 = "06";
            String input4 = "122016";

            System.out.println(numDecodings(input1));
            System.out.println(numDecodings(input2));
            System.out.println(numDecodings(input3));
            System.out.println(numDecodings(input4));
      }
}
