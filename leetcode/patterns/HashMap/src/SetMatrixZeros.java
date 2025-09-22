import java.util.HashSet;

public class SetMatrixZeros {
      public static void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();

            for (int i = 0; i < m; i++) {
                  for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == 0) {
                              rowSet.add(i);
                              colSet.add(j);
                        }
                  }
            }

            for (int r: rowSet) {
                  for (int c = 0; c < n; c++) {
                        matrix[r][c] = 0;
                  }
            }

            for (int c: colSet) {
                  for (int r = 0; r < m; r++) {
                        matrix[r][c] = 0;
                  }
            }
      }

      public static void main(String[] args) {

      }
}
