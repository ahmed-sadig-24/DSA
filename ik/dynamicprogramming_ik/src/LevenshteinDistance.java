public class LevenshteinDistance {

      static Integer levenshtein_distance(String word1, String word2) {
            // Write your code here.
            int m = word1.length();
            int n = word2.length();

            int[][] dp = new int[m + 1][n + 1];
            for (int c = 1; c <= n; c++) {
                  dp[0][c] = c;
            }
            for (int r = 1; r <= m; r++) {
                  dp[r][0] = r;
            }

            for (int r = 1; r <= m; r++) {
                  for (int c = 1; c <= n; c++) {
                        if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
                              dp[r][c] = dp[r - 1][c - 1];
                        } else {
                              int topLeft = dp[r - 1][c - 1];
                              int top = dp[r - 1][c];
                              int left = dp[r][c - 1];
                              dp[r][c] = Math.min(topLeft, Math.min(top, left)) + 1;
                        }
                  }
            }

            return dp[m][n];
      }

      public static void main(String[] args) {
            //String word1 =  "cat", word2 =  "bat";
            String word1 =  "qwe", word2 =  "q";

            System.out.println(levenshtein_distance(word1,word2));
      }

}
