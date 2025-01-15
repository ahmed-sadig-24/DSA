public class MinimumPathSum {
      public static int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                  return 0;
            }

            int m  = grid.length;
            int n = grid[0].length;

            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];

            for (int c = 1; c < n; c++) {
                  dp[0][c] = dp[0][c - 1] + grid[0][c];
            }

            for (int r = 1; r < m; r++) {
                  dp[r][0] = dp[r - 1][0] + grid[r][0];
            }

            for (int r = 1; r < m; r++) {
                  for (int c = 1; c < n; c++) {
                        dp[r][c] = Math.min(dp[r][c - 1], dp[r - 1][c]) + grid[r][c];
                  }
            }

            return dp[m - 1][n - 1];
      }

      public static void main(String[] args) {
            int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

            System.out.println(minPathSum(grid));
      }
}