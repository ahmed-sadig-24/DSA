public class UniquePaths {
      public static int uniquePaths(int m, int n) {
            int[][] grid = new int[m][n];

            for (int r = 0; r < m; r++) {
                  for (int c = 0; c < n; c++) {
                        if (r == 0 || c == 0) {
                              grid[r][c] = 1;
                        } else  {
                              grid[r][c] = grid[r][c - 1] + grid[r - 1][c];
                        }
                  }
            }

            return grid[m - 1][n - 1];
      }

      public static void main(String[] args) {
            int m1 = 3;
            int n1 = 7;

            int m2 = 3;
            int n2 = 2;

            System.out.println(uniquePaths(m1, n1));
            System.out.println(uniquePaths(m2, n2));
      }
}
