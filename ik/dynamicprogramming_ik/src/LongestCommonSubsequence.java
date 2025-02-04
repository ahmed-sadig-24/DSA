public class LongestCommonSubsequence {

      static String lcs(String a, String b) {
            // Write your code here.
            int m = a.length();
            int n = b.length();

            int[][] dp = new int[m + 1][n + 1];
            for (int r = 1; r <= m; r++) {
                  for (int c = 1; c <= n; c++) {
                        if (a.charAt(r - 1) == b.charAt(c - 1)) {
                              dp[r][c] = 1 + dp[r - 1][c - 1];
                        } else {
                              dp[r][c] = Math.max(dp[r][c - 1], dp[r - 1][c]);
                        }
                  }
            }

            //backtrack
            StringBuilder result = new StringBuilder();
            int i = m;
            int j = n;
            while (i > 0 && j > 0) {
                  if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        result.append(a.charAt(i - 1));
                        i--;
                        j--;
                  } else if (dp[i - 1][j] > dp[i][j - 1]) {
                         i--;
                  } else {
                        j--;
                  }
            }

            //return result.reverse().toString();
            return result.length() == 0 ? "-1" : result.reverse().toString();
      }

      public static void main(String[] args) {
            String a = "ABCDE", b = "AECBD";

            System.out.println(lcs(a, b));
      }
}
