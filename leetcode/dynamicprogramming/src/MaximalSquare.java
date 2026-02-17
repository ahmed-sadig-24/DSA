public class MaximalSquare {

      public static int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                  return 0;
            }

            int m = matrix.length;
            int n = matrix.length;
            int maxSize = 0;

            int[][] dp = new int[m][n];
            for (int r = 0; r < m; r ++) {
                  for (int c = 0; c < n; c++) {
                        if (matrix[r][c] == '1') {
                              if (r == 0 || c == 0) {
                                    dp[r][c] = 1;
                              } else {
                                    dp[r][c] = 1 + Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]);
                              }
                        }

                        maxSize = Math.max(maxSize, dp[r][c]);
                  }
            }

            return maxSize * maxSize;
      }



      public static void main(String[] args) {
            char[][] matrix1 = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
            char[][] matrix2 = {{'0','1'},{'1','0'}};
            char[][] matrix3 = {{'0'}};

            System.out.println(maximalSquare(matrix1));
            System.out.println(maximalSquare(matrix2));
            System.out.println(maximalSquare(matrix3));
      }
}
