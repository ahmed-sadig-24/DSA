public class UniquePaths2 {
      public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
                  return 0;
            }

            int[][] dp = new int[m][n];
            dp[0][0] = 1;

            for (int c = 1; c < n; c++) {
                  dp[0][c] = obstacleGrid[0][c] == 1 ? 0 : dp[0][c - 1];
            }

            for (int r = 1; r < m; r++) {
                  dp[r][0] = obstacleGrid[r][0] == 1 ? 0 : dp[r - 1][0];
            }

            for (int r = 1; r < m; r++) {
                  for (int c = 1; c < n; c++) {
                        if (obstacleGrid[r][c] == 1) {
                              dp[r][c] = 0;
                        } else {
                              dp[r][c] = dp[r][c - 1] + dp[c][r - 1];
                        }
                  }
            }

            return dp[m - 1][n - 1];
      }

      public static void main(String[] args) {
            int[][] obstacleGrid = {
                    {0, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}
            };

            System.out.println(uniquePathsWithObstacles(obstacleGrid)); // Output: 2
      }
}
