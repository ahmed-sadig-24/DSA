import java.util.Arrays;

public class RotateImage {
      public static void rotate(int[][] matrix) {
            //System.out.println(matrix.length);

            int n = matrix.length;

            for (int i = 0; i < (n + 1) / 2; i++) {
                  for (int j = 0; j < n / 2; j++) {//temp = bottom left
                        int temp = matrix[n - 1 - j][i];
                        //bottom left = bottom right
                        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j -1];

                        //bottom right = top right
                        matrix[n - 1 - i][n - j -1] = matrix[j][n - 1 - i];

                        //top right = top left
                        matrix[j][n - 1 - i] = matrix[i][j];

                        //top left = temp
                        matrix[i][j] = temp;
                  }
            }
      }

      public static void main(String[] args) {
            //int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
            int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7},{15,14,12,16}};

            rotate(matrix);
            //System.out.println(Arrays.toString(matrix));

            //System.out.println(rotate(matrix));
      }
}
