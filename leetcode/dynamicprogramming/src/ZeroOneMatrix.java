import java.util.Arrays;

public class ZeroOneMatrix {
      public static int[][] updateMatrix(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;
            int[][] result = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                  for (int j = 0; j < cols; j++) {
                        result[i][j] = Integer.MAX_VALUE;
                  }
            }

            for (int i = 0; i < rows; i++) {
                  for (int j = 0; j < cols; j++) {
                        if (mat[i][j] == 0) {
                              result[i][j] = 0;
                        } else {
                              if (i > 0) {
                                    result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                              }
                              if (j > 0) {
                                    result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                              }
                        }
                  }
            }

            for (int i = rows - 1; i >= 0; i--) {
                  for (int j = cols - 1; j >= 0; j--) {
                        if (mat[i][j] != 0) {
                              if (i < rows - 1) {
                                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                              }
                              if (j < cols - 1) {
                                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                              }
                        }
                  }
            }

            return result;
      }

      public static void main(String[] args) {
            //int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
            int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};

            int[][] updatedMatrix = updateMatrix(mat);

            // Print the result
            for (int[] row : updatedMatrix) {
                  System.out.println(Arrays.toString(row));
            }
      }

      public static int[][] updateMatrix2(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;
            int[][] result = new int[rows][cols];

            //Arrays.fill(result, Integer.MAX_VALUE);
            for (int r = 0; r < rows; r++) {
                  for (int c = 0; c < cols; c++) {
                        result[r][c] = Integer.MAX_VALUE;
                  }
            }

            for (int r = 0; r < rows; r++) {
                  for (int c = 0; c < cols; c++) {
                        if (mat[r][c] == 0) {
                              result[r][c] = 0;
                        } else {
                              if (r > 0) {
                                    result[r][c] = Math.min(result[r][c], result[r - 1][c] + 1);
                              }
                              if (c > 0) {
                                    result[r][c] = Math.min(result[r][c], result[r][c - 1] + 1);
                              }
                        }
                  }
            }

            for (int r = rows - 1; r >= 0; r--) {
                  for (int c = cols - 1; c >= 0; c--) {
                        if (mat[r][c] != 0) {
                              if (r < rows - 1) {
                                    result[r][c] = Math.min(result[r][c], result[r + 1][c] + 1);
                              }
                              if (c < cols - 1) {
                                    result[r][c] = Math.min(result[r][c], result[r][c + 1] + 1);
                              }
                        }
                  }
            }

            return result;
      }
}
