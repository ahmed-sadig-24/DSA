public class Search2DMatrix {
      public static boolean searchMatrix(int[][] matrix, int target) {
            int rowIndex = getPotentialRow(matrix, target);
            if(rowIndex != -1) {
                  return binarySearch(matrix, target,rowIndex);
            } else {
                  return false;
            }
      }

      private static int getPotentialRow(int[][] matrix, int target) {
            int start = 0;
            int end = matrix.length - 1;

            while (start <= end) {
                  int mid = start + (end - start) / 2;

                  if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
                        return mid;
                  } else if (matrix[mid][0] < target){
                        start = mid + 1;
                  } else {
                        end = mid - 1;
                  }
            }

            return -1;
      }

      private static boolean binarySearch(int[][] matrix, int target, int rowIndex) {
            int start = 0;
            int end = matrix.length - 1;

            while (start <= end) {
                  int mid = start + (end -start) / 2;

                  if (matrix[rowIndex][mid] == target) {
                        return true;
                  } else if (matrix[rowIndex][mid] > target) {
                        end = mid - 1;
                  } else {
                        start = mid + 1;
                  }
            }

            return false;
      }

      public static void main(String[] args) {
            int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
            int target = 300;

            System.out.println(searchMatrix(matrix, target));
      }

}
