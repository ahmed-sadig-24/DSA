import java.util.ArrayList;

public class MaximumPathSum {

      static Integer maximum_path_sum(ArrayList<ArrayList<Integer>> grid) {
            // Write your code here.
            if (grid == null || grid.size() == 0 || grid.get(0).size() == 0) {
                  return 0;
            }

            int m = grid.size();
            int n = grid.get(0).size();

            int[][] dp = new int[m][n];
            dp[0][0] = grid.get(0).get(0);

            for (int c = 1; c < n; c++) {
                  dp[0][c] = dp[0][c - 1] + grid.get(0).get(c);
            }

            for (int r = 1; r < m; r++) {
                  dp[r][0] = dp[r - 1][0] + grid.get(r).get(0);
            }

            for (int r = 1; r < m; r++) {
                  for (int c = 1; c < n; c++) {
                        dp[r][c] = Math.max(dp[r][c - 1], dp[r - 1][c])  + grid.get(r).get(c);
                  }
            }

            return dp[m - 1][n - 1];
      }

}
