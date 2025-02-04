public class LongestCommonSubsequence {
      public static int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();

            int[][] dp = new int[m + 1][n + 1];
            for (int r = 1; r <= m; r++) {
                  for (int c = 1; c <= n; c++) {
                        if (text1.charAt(r - 1) == text2.charAt(c - 1)) {
                              dp[r][c] = 1 + dp[r - 1][c - 1];
                        } else {
                              dp[r][c] = Math.max(dp[r][c - 1], dp[r - 1][c]);
                        }
                  }
            }

            return dp[m][n];
      }

      public static void main(String[] args) {
            String text1 = "abcde", text2 = "ace";
            //String text1 = "abc", text2 = "abc";
            //String text1 = "abc", text2 = "def";

            System.out.println(longestCommonSubsequence(text1, text2));
      }
}
