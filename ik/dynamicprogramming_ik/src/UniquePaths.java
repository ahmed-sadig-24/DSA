public class UniquePaths {
      static Integer unique_paths(Integer n, Integer m) {
            // Write your code here.
            int[][] grid = new int[n][m];
            final int mod = 1000000007;

            for (int r = 0; r < n; r++) {
                  for (int c = 0; c < m; c++) {
                        if (r == 0 || c == 0) {
                              grid[r][c] = 1;
                        } else {
                              grid[r][c] = grid[r][c - 1] + grid[r - 1][c];
                        }
                        grid[r][c] %= mod;
                  }
            }

            return grid[n - 1][m - 1];
      }

      public static void main(String[] args) {
            int n = 1000; // 3;
            int m = 1000; // 2;

            System.out.println(unique_paths(n , m ));
      }
}
